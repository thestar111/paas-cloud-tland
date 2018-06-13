/**
 * 文 件 名:  CatalogFallbackFactory
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.catalog;

import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.cms.pojo.catalog.request.*;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AppMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessageVo;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.service.catalogrelation.CatalogRelationFallbackFactory;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author LJun
 * @version 2018/5/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class CatalogFallbackFactory implements FallbackFactory<CatalogService>
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (CatalogRelationFallbackFactory.class);

	@Override
	public CatalogService create (Throwable throwable)
	{
		LOGGER.error (String.format ("Catalog Service Not Available : %s", throwable.getMessage ()));
		return new CatalogService ()
		{
			/**
			 * 添加栏目信息
			 * @param addCatalogRequest
			 * @return
			 */
			@Override
			public Result<String> add (AddCatalogRequest addCatalogRequest)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 修改栏目信息
			 * @param updateCatalogRequest
			 * @return
			 */
			@Override
			public Result<String> udpate (UpdateCatalogRequest updateCatalogRequest)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 多条件查询栏目信息
			 * @param queryCatalogRequest
			 * @return
			 */
			@Override
			public Result<List<CatalogVo>> queryByCondition (QueryCatalogRequest queryCatalogRequest)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 根据ID查询栏目信息 供平台使用
			 * @param catalogId
			 * @return
			 */
			@Override
			public Result<CatalogVo> findCatalogById (String catalogId)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 根据ID查询栏目信息 供客户端使用
			 * @param catalogId
			 * @return
			 */
			@Override
			public Result<CatalogVo> qryCatalogById (String catalogId)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 根据ID删除栏目信息
			 * @param catalogId
			 * @return
			 */
			@Override
			public Result<String> delete (String catalogId)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 根据栏目名称查询栏目信息
			 * @param queryCatalogInNameRequest
			 * @return
			 */
			@Override
			public Result<List<CatalogVo>> queryCatalogByNames (QueryCatalogInNameRequest queryCatalogInNameRequest)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 查询一级二级栏目分类信息
			 * @return
			 */
			@Override
			public Result<List<CatalogMessageVo>> queryCatalogInfo ()
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 查询二级栏目分类信息
			 * @param catalogId
			 * @return
			 */
			@Override
			public Result<List<CatalogMessage<AppMessage>>> querySubCatalogInfo (String catalogId)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 根据二级栏目编号查询应用信息
			 * @param catalogId
			 * @param start
			 * @param size
			 * @return
			 */
			@Override
			public Result<CatalogMessage<AppMessage>> queryAppsBySubCatalog (String catalogId, Integer start,
					Integer size)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 根据栏目id查询该栏目下的子栏目
			 *
			 * @param catalogId
			 * @param start
			 * @param size
			 * @return
			 */
			@Override
			public Result<List<CatalogVo>> querySubCatalogByCatalogId (String catalogId, Integer start, Integer size)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 更新普通栏目排序优先级字段 供market的普通栏目排序
			 *
			 * @param modifySubCatalogOrderNumRequest
			 * @return
			 */
			@Override
			public Result modifySubCatalogOrderNum (ModifySubCatalogOrderNumRequest modifySubCatalogOrderNumRequest)
			{
				return new Result ().failure ("Catalog Service not Available");
			}

			/**
			 * 置顶栏目 供market的普通栏目排序
			 *
			 * @param modifyCatalogOrderNumToTopRequest
			 * @return
			 */
			@Override
			public Result modifySubCatalogOrderNumToTop (
					ModifyCatalogOrderNumToTopRequest modifyCatalogOrderNumToTopRequest)
			{
				return new Result ().failure ("Catalog Service not Available");
			}
		};
	}
}
