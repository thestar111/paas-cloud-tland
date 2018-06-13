/**
 * 文 件 名:  AppApi
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   LJun
 * 修改时间:  2018/5/11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.app;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.pojo.app.domain.AppBasicDto;
import com.quanteng.tland.vas.pojo.app.domain.AppDto;
import com.quanteng.tland.vas.pojo.app.request.FindAppByIdRequest;
import com.quanteng.tland.vas.pojo.app.request.SearchAppByNameRequest;
import com.quanteng.tland.vas.pojo.catalogrelation.domain.CatalogDto;
import com.quanteng.tland.vas.pojo.catalogrelation.domain.NormalCatalogDto;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QueryAppByCatalogIdRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <App接口定义>
 *
 * @author LJun
 * @version 2018/5/11
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/app")
public interface AppApi
{

	/**
	 * 根据栏目编号查询应用信息(不包括栏目分类下的二级栏目分类)
	 * 供客户端查询首页配置的栏目分类，栏目推荐页的TOP，NEW，HOT这些营销栏目下的应用信息查询
	 *
	 * @param queryAppByCatalogIdRequest
	 * @return
	 */
	@POST
	@Path ("/queryAppByCatalogId")
	@Produces (MediaType.APPLICATION_JSON)
	Result<NormalCatalogDto<AppBasicDto>> queryAppByCatalogId (QueryAppByCatalogIdRequest queryAppByCatalogIdRequest);

	/**
	 * 根据二级栏目编号查询应用信息(只供二级栏目分类下的栏目分类编号查询)
	 * 供客户端查询二级栏目分类查询该栏目下的应用信息
	 *
	 * @param queryAppByCatalogIdRequest
	 * @return
	 */
	@POST
	@Path ("/queryAppBySubCatalogId")
	@Produces (MediaType.APPLICATION_JSON)
	Result<NormalCatalogDto<AppBasicDto>> queryAppBySubCatalogId (QueryAppByCatalogIdRequest queryAppByCatalogIdRequest);

	/**
	 * 根据应用名称搜索
	 * 供客户端根据应用名称搜索应用接口
	 *
	 * @param searchAppByNameRequest
	 * @return
	 */
	@POST
	@Path ("/search")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<AppBasicDto>> queryAppByName (SearchAppByNameRequest searchAppByNameRequest);

	/**
	 * 应用信息查询 	供客户端查询APP应用信息
	 *
	 * @param findAppByIdRequest
	 * @return
	 */
	@POST
	@Path ("/queryAppById")
	@Produces (MediaType.APPLICATION_JSON)
	Result<AppDto> findAppById (FindAppByIdRequest findAppByIdRequest);
}
