/**
 * 文 件 名:  AdsApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.ads;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.pojo.ads.domain.AdsDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <定义Vas广告接口>
 *
 * @author zping
 * @version 2018/4/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/ads")
public interface AdsApi
{
	/**
	 * 查询启动页广告信息
	 *
	 * @return
	 */
	@GET
	@Path ("/lanuch")
	@Produces (MediaType.APPLICATION_JSON)
	Result<AdsDto> findStartupPageAdsInfo ();

}
