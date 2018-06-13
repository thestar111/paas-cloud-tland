/**
 * 文 件 名:  AdResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.ad;

import com.quanteng.tland.cms.pojo.ad.domain.AdsVo;
import com.quanteng.tland.cms.pojo.ad.request.AddAdsRequest;
import com.quanteng.tland.cms.pojo.ad.request.QueryAdListRequest;
import com.quanteng.tland.cms.pojo.ad.request.UpdateAdsRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 广告接口实现类
 *
 * @author huangsongbo
 * @version 2017/8/8
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@RequestMapping ("/cms/ads")
public interface AdResource
{
	/**
	 * 添加广告信息
	 *
	 * @param addAdsRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result add (@RequestBody AddAdsRequest addAdsRequest);

	/**
	 * 广告信息修改
	 *
	 * @param updateAdsRequest
	 * @return
	 */
	@RequestMapping (value = "/update", method = RequestMethod.PUT)
	Result update (@RequestBody UpdateAdsRequest updateAdsRequest);

	/**
	 * 根据广告ID查询 供平台使用
	 *
	 * @param adId
	 * @return
	 */
	@RequestMapping (value = "/manage/{id}", method = RequestMethod.GET)
	Result<AdsVo> queryAdById (@PathVariable ("id") String adId);

	/**
	 * 根据广告ID查询 供客户端使用
	 *
	 * @param adId
	 * @return
	 */
	@RequestMapping (value = "/client/{id}", method = RequestMethod.GET)
	Result<AdsVo> findAdById (@PathVariable ("id") String adId);

	/**
	 * 根据广告名称查询
	 *
	 * @param queryAdListRequest
	 * @return
	 */
	@RequestMapping (value = "/queryAdList", method = RequestMethod.POST)
	Result<List<AdsVo>> queryAdList (@RequestBody QueryAdListRequest queryAdListRequest);

	/**
	 * 根据广告id删除
	 *
	 * @param adId
	 * @return
	 */
	@RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
	Result delete (@PathVariable ("id") String adId);

	/**
	 * 查询客户端启动页广告信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/lanuch", method = RequestMethod.GET)
	Result<AdsVo> queryLanuchAd ();
}