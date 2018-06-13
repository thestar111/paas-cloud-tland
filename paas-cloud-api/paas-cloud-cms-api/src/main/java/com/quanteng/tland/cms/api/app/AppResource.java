/**
 * 文 件 名:  AppResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.app;

import com.quanteng.tland.cms.pojo.app.domain.AppsVo;
import com.quanteng.tland.cms.pojo.app.request.*;
import com.quanteng.tland.cms.pojo.app.response.BatchModifyAppStatusResponse;
import com.quanteng.tland.cms.pojo.app.response.QueryAppListResponse;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author huangsongbo
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/app")
public interface AppResource
{

	/**
	 * 添加游戏
	 *
	 * @param addAppRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result add (@RequestBody AddAppRequest addAppRequest);

	/**
	 * 更新游戏
	 *
	 * @param modifyAppRequest
	 * @return
	 */
	@RequestMapping (value = "/modify", method = RequestMethod.PUT)
	Result modify (@RequestBody ModifyAppRequest modifyAppRequest);

	/**
	 * 多条件查询
	 *
	 * @param queryAppRequest
	 * @return
	 */
	@RequestMapping (value = "/queryByCondition", method = RequestMethod.POST)
	Result<List<AppsVo>> queryList (@RequestBody QueryAppRequest queryAppRequest);

	/**
	 * 根据营销分类编号查询
	 *
	 * @param catalogId
	 * @param start
	 * @param size
	 * @return
	 */
	@RequestMapping (value = "/promotion/{catalog}/{start}/{size}", method = RequestMethod.GET)
	Result<List<AppsVo>> queryByPromotionCatalogId (@PathVariable ("catalog") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size);

	/**
	 * 根据游戏普通分类，状态查询
	 *
	 * @param catalogId
	 * @param start
	 * @param size
	 * @return
	 */
	@RequestMapping (value = "/normal/{catalog}/{start}/{size}", method = RequestMethod.GET)
	Result<List<AppsVo>> queryAppByNormalCatalog (@PathVariable ("catalog") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size);

	/**
	 * 根据ID查询应用 供平台使用
	 *
	 * @param appId
	 * @return
	 */
	@RequestMapping (value = "/manage/id/{appId}", method = RequestMethod.GET)
	Result<AppsVo> queryAppById (@PathVariable ("appId") String appId);

	/**
	 * 根据ID查询应用  供客户端使用
	 *
	 * @param appId
	 * @return
	 */
	@RequestMapping (value = "/portal/id/{appId}", method = RequestMethod.GET)
	Result<AppsVo> findAppById (@PathVariable ("appId") String appId);

	/**
	 * 根据appId删除应用
	 *
	 * @param appId
	 * @return
	 */
	@RequestMapping (value = "/{appId}", method = RequestMethod.DELETE)
	Result delete (@PathVariable ("appId") String appId);

	/**
	 * 查询普通栏目下的应用总数
	 *
	 * @param appColumn
	 * @return
	 */
	@RequestMapping (value = "/{column}/count", method = RequestMethod.GET)
	Result<Integer> qryCountByColumn (@PathVariable ("column") String appColumn);

	/**
	 * 更新app 下载次数
	 *
	 * @param appId
	 * @return
	 */
	@RequestMapping (value = "/{appId}", method = RequestMethod.PUT)
	Result upgradeDownloadTimes (@PathVariable ("appId") String appId);

	/**
	 * 猜你喜欢，推荐对应的游戏信息
	 *
	 * @param queryAppRequest
	 * @return
	 */
	@RequestMapping (value = "/guessAppRecommand", method = RequestMethod.POST)
	Result<List<AppsVo>> guessAppRecommand (@RequestBody QueryAppRequest queryAppRequest);

	/**
	 * 批量修改应用状态
	 * 供平台使用
	 * @param batchModifyAppStatusRequest
	 * @return
	 */
	@RequestMapping (value = "/batchModifyAppStatus", method = RequestMethod.PUT)
	Result<BatchModifyAppStatusResponse> batchModifyAppStatus (@RequestBody BatchModifyAppStatusRequest batchModifyAppStatusRequest);
}