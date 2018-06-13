/**
 * 文 件 名:  CatalogRelationApi
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.catalogrelation;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.pojo.ads.domain.AdsDto;
import com.quanteng.tland.vas.pojo.app.domain.AppBasicDto;
import com.quanteng.tland.vas.pojo.app.domain.AppDto;
import com.quanteng.tland.vas.pojo.catalogrelation.domain.CatalogDto;
import com.quanteng.tland.vas.pojo.catalogrelation.domain.NormalCatalogDto;
import com.quanteng.tland.vas.pojo.catalogrelation.domain.ParentCatalogDto;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QueryAppByCatalogTypeRequest;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QueryPromotionAdsByTypeRequest;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QuerySubCatalogByIdRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <栏目应用关系接口>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/catalogRelation")
public interface CatalogRelationApi
{
	/**
	 * 栏目分类列表查询
	 * 供APP端查询分类页展示信息，此信息在运营管理系统端可以配置一级栏目二级栏目之间的关系，并设置好二级栏目排序位置等
	 *
	 * @return
	 */
	@GET
	@Path ("/queryCatalog")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<ParentCatalogDto>> queryCatalogList ();

	/**
	 * 根据栏目编号查询子栏目信息
	 * 供二级栏目查询应用信息
	 *
	 * @return
	 */
	@POST
	@Path ("/querySubCatalog")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<NormalCatalogDto<AppBasicDto>>> querySubCatalog (QuerySubCatalogByIdRequest querySubCatalogById);

	/**
	 * 根据应用栏目分类查询栏目信息
	 * 供客户端查询应用信息，根据栏目营销类型：(TOP, NEW, HOT 属于应用栏目信息)
	 *
	 * @returnquerySubCatalog
	 */
	@POST
	@Path ("/queryCatalogsByType")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<CatalogDto>> queryCatalogsByType (QueryAppByCatalogTypeRequest queryAppByCatalogTypeRequest);

	/**
	 * 查询营销广告信息
	 * 供客户端查询可配置的不同页面下的营销广告信息
	 */
	@POST
	@Path ("/queryPromotionAdsByType")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<AdsDto>> queryPromotionAdsByType (QueryPromotionAdsByTypeRequest queryPromotionAdsByTypeRequest);

	/**
	 * 获取HOT热门推荐应用栏目分类信息(HOT TAG)
	 * 供客户端根据应用名称搜索应用接口
	 *
	 * @return
	 */
	@GET
	@Path ("/queryHotTag")
	@Produces (MediaType.APPLICATION_JSON)
	Result<ParentCatalogDto> queryHotTag ();
}
