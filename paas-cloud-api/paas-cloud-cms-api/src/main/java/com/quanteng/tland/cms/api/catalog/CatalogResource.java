/**
 * 文 件 名:  CatalogResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.catalog;

import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.cms.pojo.catalog.request.*;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AppMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessageVo;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <栏目资源信息>
 *
 * @author huangsongbo
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/catalog")
public interface CatalogResource
{

	/**
	 * 添加栏目信息
	 *
	 * @param addCatalogRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result<String> add (@RequestBody AddCatalogRequest addCatalogRequest);

	/**
	 * 修改栏目信息
	 *
	 * @param updateCatalogRequest
	 * @return
	 */
	@RequestMapping (value = "/modify", method = RequestMethod.PUT)
	Result<String> udpate (@RequestBody UpdateCatalogRequest updateCatalogRequest);

	/**
	 * 多条件查询栏目信息
	 *
	 * @param queryCatalogRequest
	 * @return
	 */
	@RequestMapping (value = "/queryByCondition", method = RequestMethod.POST)
	Result<List<CatalogVo>> queryByCondition (@RequestBody QueryCatalogRequest queryCatalogRequest);

	/**
	 * 根据ID查询栏目信息 供平台使用
	 *
	 * @param catalogId
	 * @return
	 */
	@RequestMapping (value = "/manage/id/{catalog}", method = RequestMethod.GET)
	Result<CatalogVo> findCatalogById (@PathVariable ("catalog") String catalogId);

	/**
	 * 根据ID查询栏目信息 供客户端使用
	 *
	 * @param catalogId
	 * @return
	 */
	@RequestMapping (value = "/portal/id/{catalog}", method = RequestMethod.GET)
	Result<CatalogVo> qryCatalogById (@PathVariable ("catalog") String catalogId);

	/**
	 * 根据ID删除栏目信息
	 *
	 * @param catalogId
	 * @return
	 */
	@RequestMapping (value = "/{catalog}", method = RequestMethod.DELETE)
	Result<String> delete (@PathVariable ("catalog") String catalogId);

	/**
	 * 根据栏目名称查询栏目信息
	 *
	 * @param queryCatalogInNameRequest
	 * @return
	 */
	@RequestMapping (value = "/queryCatalogsByNames", method = RequestMethod.POST)
	Result<List<CatalogVo>> queryCatalogByNames (@RequestBody QueryCatalogInNameRequest queryCatalogInNameRequest);

	/**
	 * 查询一级二级栏目分类信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/queryCatalog", method = RequestMethod.GET)
	Result<List<CatalogMessageVo>> queryCatalogInfo ();

	/**
	 * 根据一级栏目编号查询二级栏目分类信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/querySubCatalog/{catalogId}", method = RequestMethod.GET)
	Result<List<CatalogMessage<AppMessage>>> querySubCatalogInfo (@PathVariable ("catalogId") String catalogId);

	/**
	 * 根据二级栏目编号查询下面的应用信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/queryAppsBySubCatalog/{catalogId}/{start}/{size}", method = RequestMethod.GET)
	Result<CatalogMessage<AppMessage>> queryAppsBySubCatalog (@PathVariable ("catalogId") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size);

	/**
	 * 根据栏目id查询该栏目下的子栏目
	 *
	 * @param catalogId
	 * @param start
	 * @param size
	 * @return
	 */
	@RequestMapping (value = "/querySubCatalogByCatalogId/{catalogId}/{start}/{size}", method = RequestMethod.GET)
	Result<List<CatalogVo>> querySubCatalogByCatalogId (@PathVariable ("catalogId") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size);

	/**
	 * 更新普通栏目排序优先级字段 供market的普通栏目排序
	 *
	 * @param modifySubCatalogOrderNumRequest
	 * @return
	 */
	@RequestMapping (value = "/getSubCatalogToMove", method = RequestMethod.PUT)
	Result modifySubCatalogOrderNum (@RequestBody ModifySubCatalogOrderNumRequest modifySubCatalogOrderNumRequest);

	/**
	 * 置顶栏目 供market的普通栏目排序
	 *
	 * @param modifyCatalogOrderNumToTopRequest
	 * @return
	 */
	@RequestMapping (value = "/getSubCatalogToTop", method = RequestMethod.PUT)
	Result modifySubCatalogOrderNumToTop (
			@RequestBody ModifyCatalogOrderNumToTopRequest modifyCatalogOrderNumToTopRequest);
}
