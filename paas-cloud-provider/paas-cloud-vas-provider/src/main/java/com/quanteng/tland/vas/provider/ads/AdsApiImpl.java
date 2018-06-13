/**
 * 文 件 名:  AdsApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.ads;

import com.quanteng.tland.cms.pojo.ad.domain.AdsVo;
import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.api.ads.AdsApi;
import com.quanteng.tland.vas.pojo.ads.domain.AdsDto;
import com.quanteng.tland.vas.service.ads.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <Vas广告接口实现类>
 *
 * @author zping
 * @version 2018/4/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class AdsApiImpl implements AdsApi
{

	@Autowired
	private AdService adService;

	/**
	 * 查询启动页广告信息
	 *
	 * @return
	 */
	@Override
	public Result<AdsDto> findStartupPageAdsInfo ()
	{
		i ("ADS", "findStartupPageAds", LOG_TYPE_REQUEST, "begin");
		//查询CMS
		Result<AdsVo> serviceResult = adService.queryLanuchAd ();

		Result<AdsDto> result = new Result<AdsDto> ();
		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			if (null != serviceResult.getData ())
			{
				AdsDto adsDto = new AdsDto ();
				//实体转换
				BeanUtils.copyProperties (serviceResult.getData (), adsDto);
				result.setData (adsDto);
			}
		}
		else
		{
			result.setResultMessage ("findStartupPageAds CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}

		i ("ADS", "findStartupPageAds", LOG_TYPE_RESPONSE, result);
		return result;
	}
}
