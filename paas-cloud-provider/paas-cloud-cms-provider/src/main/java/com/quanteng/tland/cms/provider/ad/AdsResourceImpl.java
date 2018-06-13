/**
 * 文 件 名:  AdsResourceIMpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.ad;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.ad.AdResource;
import com.quanteng.tland.cms.database.entity.Ad;
import com.quanteng.tland.cms.database.entity.AdLang;
import com.quanteng.tland.cms.database.mapper.AdMapper;
import com.quanteng.tland.cms.database.mapper.CatalogRelationMapper;
import com.quanteng.tland.cms.pojo.ad.domain.AdsLangVo;
import com.quanteng.tland.cms.pojo.ad.domain.AdsVo;
import com.quanteng.tland.cms.pojo.ad.request.AddAdsRequest;
import com.quanteng.tland.cms.pojo.ad.request.QueryAdListRequest;
import com.quanteng.tland.cms.pojo.ad.request.UpdateAdsRequest;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.thread.Language;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.DATA_LOCAL_LANGUAGE;
import static com.quanteng.tland.common.log.TlandLogger.LOG_TYPE_REQUEST;
import static com.quanteng.tland.common.log.TlandLogger.LOG_TYPE_RESPONSE;
import static com.quanteng.tland.common.log.TlandLogger.i;

/**
 * <广告资源接口实现>
 *
 * @author zping
 * @version 2018/4/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class AdsResourceImpl implements AdResource
{

	@Autowired
	private AdMapper adMapper;

	@Autowired
	private CatalogRelationMapper catalogRelationMapper;

	/**
	 * 添加广告信息
	 *
	 * @param addAdsRequest
	 * @return
	 */
	@Override
	public Result add (@RequestBody AddAdsRequest addAdsRequest)
	{
		 i("ADS", "add", LOG_TYPE_REQUEST, addAdsRequest);
		if (null == addAdsRequest || null == addAdsRequest.getAds ())
		{
			return new Result ().failure ("illega params");
		}

		Ad ad = new Ad ();
		BeanUtils.copyProperties (addAdsRequest.getAds (), ad);
		int flag = adMapper.add (ad);
		if (0 < flag)
		{
			List<AdsLangVo> adsLangVo = addAdsRequest.getAds ().getAdsLangs ();
			if (! CollectionUtils.isEmpty (adsLangVo))
			{
				List<AdLang> adLangs = Lists.newArrayList ();
				adsLangVo.forEach (adsLang -> {
					AdLang adLang = new AdLang ();
					BeanUtils.copyProperties (adsLang, adLang);
					adLangs.add (adLang);
				});
				flag = adMapper.addLang (adLangs);
				if (0 < flag)
				{
					return new Result ().success ();
				}
				else
				{
					return new Result ().failure ("add ad failed.");
				}
			}
			else
			{
				return new Result ().success ();
			}
		}
		else
		{
			return new Result ().failure ("add ad failed.");
		}
	}

	/**
	 * 广告信息修改
	 *
	 * @param updateAdsRequest
	 * @return
	 */
	@Override
	public Result update (@RequestBody UpdateAdsRequest updateAdsRequest)
	{
		if (null == updateAdsRequest || null == updateAdsRequest.getAds ())
		{
			return new Result ().failure ("illega params");
		}

		if (StringUtils.isEmpty (updateAdsRequest.getAds ().getAdvertisementId ()))
		{
			return new Result ().failure ("adid illega params");
		}

		i ("ADS", "update", LOG_TYPE_REQUEST, updateAdsRequest);

		Ad ad = new Ad ();
		BeanUtils.copyProperties (updateAdsRequest.getAds (), ad);
		int flag = adMapper.update (ad);

		if (0 < flag)
		{
			List<AdsLangVo> adsLangVos = updateAdsRequest.getAds ().getAdsLangs ();
			if (! CollectionUtils.isEmpty (adsLangVos))
			{
				List<AdLang> adLangs = Lists.newArrayList ();
				AdLang adLang = null;
				for (AdsLangVo adsLangVo : adsLangVos)
				{
					adLang = new AdLang ();
					BeanUtils.copyProperties (adsLangVo, adLang);
					adLangs.add (adLang);
				}
				flag = adMapper.updateAdLang (adLangs);
				if (0 < flag)
				{
					return new Result ().success ();
				}
				else
				{
					return new Result ().failure ("modify ad failed.");
				}
			}
			else
			{
				return new Result ().success ();
			}
		}
		else
		{
			return new Result ().failure ("modify ad failed.");
		}
	}

	/**
	 * 根据广告ID查询 供平台使用
	 *
	 * @param adId
	 * @return
	 */
	@Override
	public Result<AdsVo> queryAdById (@PathVariable ("id") String adId)
	{
		if (StringUtils.isEmpty (adId))
		{
			return new Result ().failure ("illega params");
		}
		i ("AD","queryAdById",LOG_TYPE_REQUEST,adId);
		AdsVo adsVo = null;
		//管理平台使用
		Ad ad = adMapper.queryAdById (adId);
		//定义返回结果集
		Result<AdsVo> result = new Result<> ();
		if (null != ad)
		{
			adsVo = new AdsVo ();
			BeanUtils.copyProperties (ad, adsVo);
			List<AdLang> adLangs = adMapper.queryAdLangById (adId);
			if (! CollectionUtils.isEmpty (adLangs))
			{
				List<AdsLangVo> adsLangVos = Lists.newArrayList ();
				adLangs.forEach (adsLang -> {
					AdsLangVo adsLangVo = new AdsLangVo ();
					BeanUtils.copyProperties (adsLang, adsLangVo);
					adsLangVos.add (adsLangVo);
				});
				adsVo.setAdsLangs (adsLangVos);
			}
		}
		result.success (adsVo);
		i ("ADS", "findAdById", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据广告ID查询 供客户端使用
	 *
	 * @param adId
	 * @return
	 */
	@Override
	public Result<AdsVo> findAdById (@PathVariable ("id") String adId)
	{
		i ("AD","findAdById",LOG_TYPE_REQUEST,adId);
		String language = Language.getLanguage ();
		if (StringUtils.isEmpty (adId))
		{
			return new Result ().failure ("illega params");
		}
		//客户端使用
		Ad ad = adMapper.findById (adId, language);
		//定义返回结果集
		Result<AdsVo> result = new Result<> ();
		AdsVo adsVo = new AdsVo ();
		BeanUtils.copyProperties (ad, adsVo);
		result.success (adsVo);
		i ("ADS", "findAdById", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据广告名称查询 支持多语言查询
	 * @param queryAdListRequest
	 * @return
	 */
	@Override
	public Result<List<AdsVo>> queryAdList(@RequestBody QueryAdListRequest queryAdListRequest)
	{
		if (null == queryAdListRequest)
		{
			return new Result ().failure ("queryAdListRequest illega params");
		}
		i ("AD","queryAdList",LOG_TYPE_REQUEST,queryAdListRequest);

		Map<String, Object> params = Maps.newHashMap ();
		if (!StringUtils.isEmpty (queryAdListRequest.getAdvertisementName ()))
		{
			params.put ("advertisementName", queryAdListRequest.getAdvertisementName ());
		}
		params.put ("start", (queryAdListRequest.getPageIndex ()-1)*queryAdListRequest.getPageSize ());
		params.put ("size", queryAdListRequest.getPageSize ());
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		//定义返回结果集
		Result<List<AdsVo>> result = new Result<List<AdsVo>> ();
		List<Ad> ads = adMapper.queryList (params);
		if (! CollectionUtils.isEmpty (ads))
		{
			List<AdsVo> adsVos = Lists.newArrayList ();
			ads.forEach (ad -> {
				AdsVo adsVo = new AdsVo ();
				BeanUtils.copyProperties (ad, adsVo);
				adsVos.add (adsVo);
			});
			result.setData (adsVos);
			result.setTotalCount (adMapper.qeruyCount (params));
		}
		result.success ();
		i ("AD", "queryAdList", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据广告id删除
	 *
	 * @param adId
	 * @return
	 */
	@Override
	public Result delete (@PathVariable ("id") String adId)
	{
		i ("AD","delete",LOG_TYPE_REQUEST,adId);
		if (StringUtils.isEmpty (adId))
		{
			return new Result ().failure ("id illega params");
		}

		//删除广告信息
		int flag = adMapper.delete (adId);

		if (0 < flag)
		{
			//删除广告多语言信息
			flag = adMapper.deleteAdLang (adId);
			if (0 < flag)
			{
				List<String> targetIds= Lists.newArrayList ();
				targetIds.add (adId);
				//删除配置关系
				catalogRelationMapper.removeRelation (targetIds);
				return new Result ().success ();
			}
			else
			{
				return new Result ().failure ("delete ad failed.");
			}
		}
		else
		{
			return new Result ().failure ("delete ad failed.");
		}
	}

	/**
	 * 查询客户端启动页广告信息
	 *
	 * @return
	 */
	@Override
	public Result<AdsVo> queryLanuchAd ()
	{

		i ("ADS", "queryLanuchAd", LOG_TYPE_REQUEST, "");
		Ad ad = adMapper.queryLanuchAd ();
		i ("ADS", "queryLanuchAd", LOG_TYPE_RESPONSE, ad);
		Result<AdsVo> result = new Result<> ();
		AdsVo adsVo = null;
		if (null != ad)
		{
			adsVo = new AdsVo ();
			BeanUtils.copyProperties (ad, adsVo);
			result.setData (adsVo);
		}
		else
		{
			result.setResultMessage ("Ads not exist.");
		}
		return result;
	}
}
