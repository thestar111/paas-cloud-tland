/**
 * 文 件 名:  CatalogResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/2 0002
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.catalog;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanteng.tland.cms.api.catalog.CatalogResource;
import com.quanteng.tland.cms.database.entity.Catalog;
import com.quanteng.tland.cms.database.entity.CatalogAppRela;
import com.quanteng.tland.cms.database.entity.CatalogLang;
import com.quanteng.tland.cms.database.mapper.CatalogMapper;
import com.quanteng.tland.cms.database.mapper.CatalogRelationMapper;
import com.quanteng.tland.cms.pojo.app.domain.AppsVo;
import com.quanteng.tland.cms.pojo.catalog.domain.CatalogLangVo;
import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.cms.pojo.catalog.request.*;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AppMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessageVo;
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

import static com.quanteng.tland.common.cons.Constants.Cons.*;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <栏目资源接口实现>
 *
 * @author zping
 * @version 2018/5/2 0002
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class CatalogResourceImpl implements CatalogResource
{

	/**
	 * 目录信息Mapper
	 */
	@Autowired
	private CatalogMapper catalogMapper;

	@Autowired
	private CatalogRelationMapper catalogRelationMapper;

	/**
	 * 添加栏目信息
	 *
	 * @param addCatalogRequest
	 * @return
	 */
	@Override
	public Result<String> add (@RequestBody AddCatalogRequest addCatalogRequest)
	{
		if (null == addCatalogRequest || null == addCatalogRequest.getCatalog ())
		{
			return new Result<> ().failure ("illega params.");
		}
		i ("CATALOG", "add", LOG_TYPE_REQUEST, addCatalogRequest);

		CatalogVo catalogVo = addCatalogRequest.getCatalog ();
		Catalog catalog = new Catalog ();
		BeanUtils.copyProperties (catalogVo, catalog);

		//先根据栏目类型查询该类型下序号最大值
		int maxOrderNum = catalogMapper
				.queryMaxOrderNumByCatalogType (catalog.getCatalogType (), catalog.getNodeType ());
		catalog.setOrderNum (maxOrderNum + 1);
		int flag = catalogMapper.add (catalog);

		if (0 < flag)
		{
			List<CatalogLangVo> catalogLangVos = catalogVo.getCatalogLangVos ();
			List<CatalogLang> catalogLangs = null;
			if (! CollectionUtils.isEmpty (catalogLangVos))
			{
				catalogLangs = Lists.newArrayList ();
				CatalogLang catalogLang = null;
				for (CatalogLangVo catalogLangVo : catalogLangVos)
				{
					catalogLang = new CatalogLang ();
					BeanUtils.copyProperties (catalogLangVo, catalogLang);
					catalogLangs.add (catalogLang);
				}
				flag = catalogMapper.addCatalogLang (catalogLangs);
				if (0 < flag)
				{
					return new Result<> ().success ();
				}
				else
				{
					return new Result<> ().failure ("add catalog failed.");
				}
			}
			else
			{
				return new Result<> ().success ();
			}
		}
		else
		{
			return new Result<> ().failure ("add catalog failed.");
		}
	}

	/**
	 * 修改栏目信息
	 *
	 * @param updateCatalogRequest
	 * @return
	 */
	@Override
	public Result<String> udpate (@RequestBody UpdateCatalogRequest updateCatalogRequest)
	{
		if (null == updateCatalogRequest || null == updateCatalogRequest.getCatalogs ())
		{
			return new Result<> ().failure ("illega params.");
		}
		d ("CATALOG", "udpate", LOG_TYPE_REQUEST, updateCatalogRequest);
		CatalogVo catalogVo = updateCatalogRequest.getCatalogs ();
		Catalog catalog = new Catalog ();
		BeanUtils.copyProperties (catalogVo, catalog);
		int flag = catalogMapper.update (catalog);
		if (0 < flag)
		{
			List<CatalogLangVo> catalogLangVos = catalogVo.getCatalogLangVos ();
			List<CatalogLang> catalogLangs = null;
			if (! CollectionUtils.isEmpty (catalogLangVos))
			{
				catalogLangs = Lists.newArrayList ();
				CatalogLang catalogLang = null;
				for (CatalogLangVo catalogLangVo : catalogLangVos)
				{
					catalogLang = new CatalogLang ();
					BeanUtils.copyProperties (catalogLangVo, catalogLang);
					catalogLangs.add (catalogLang);
				}
				flag = catalogMapper.modifyCatalogLang (catalogLangs);
				if (0 < flag)
				{
					return new Result<> ().success ();
				}
				else
				{
					return new Result<> ().failure ("modify cataloglang failed.");
				}
			}
			else
			{
				return new Result<> ().failure ("modify catalog failed.");
			}
		}
		else
		{
			return new Result<> ().failure ("modify catalog failed.");
		}
	}

	/**
	 * 多条件查询栏目信息
	 *
	 * @param queryCatalogRequest
	 * @return
	 */
	@Override
	public Result<List<CatalogVo>> queryByCondition (@RequestBody QueryCatalogRequest queryCatalogRequest)
	{
		Result<List<CatalogVo>> result = new Result<> ();
		Map<String, Object> params = Maps.newHashMap ();
		if (! StringUtils.isEmpty (queryCatalogRequest.getCatalogName ()))
		{
			params.put ("catalogName", queryCatalogRequest.getCatalogName ());
		}

		if (! StringUtils.isEmpty (queryCatalogRequest.getType ()))
		{
			params.put ("type", queryCatalogRequest.getType ());
		}
		if (null != queryCatalogRequest.getNodeType ())
		{
			params.put ("nodeType", queryCatalogRequest.getNodeType ());
		}

		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		params.put (DATA_PAGE_START, (queryCatalogRequest.getPageIndex () - 1) * queryCatalogRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, queryCatalogRequest.getPageSize ());
		d ("CATALOG", "queryByCondition", LOG_TYPE_REQUEST, queryCatalogRequest);
		List<Catalog> catalogs = catalogMapper.queryListByCondition (params);
		List<CatalogVo> catalogVos = null;
		if (! CollectionUtils.isEmpty (catalogs))
		{
			catalogVos = Lists.newArrayList ();
			CatalogVo catalogVo = null;
			for (Catalog catalog : catalogs)
			{
				catalogVo = new CatalogVo ();
				BeanUtils.copyProperties (catalog, catalogVo);
				catalogVos.add (catalogVo);
			}
			result.setData (catalogVos);
			result.setTotalCount (catalogMapper.queryCountByCondition (params));
		}
		return result;
	}

	/**
	 * 根据ID查询栏目信息 供平台使用
	 *
	 * @param catalogId
	 * @return
	 */
	@Override
	public Result<CatalogVo> findCatalogById (@PathVariable ("catalog") String catalogId)
	{
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<> ().failure ("catalog illega params.");
		}
		d ("CATALOG", "findCatalogById", LOG_TYPE_REQUEST, catalogId);
		Catalog catalog = catalogMapper.findCatalogById (catalogId);

		if (null != catalog)
		{
			CatalogVo catalogVo = new CatalogVo ();
			BeanUtils.copyProperties (catalog, catalogVo);
			List<CatalogLang> catalogLangs = catalogMapper.findLangByCatalogId (catalogId);
			List<CatalogLangVo> catalogLangVos = null;
			if (! CollectionUtils.isEmpty (catalogLangs))
			{
				catalogLangVos = Lists.newArrayList ();
				CatalogLangVo catalogLangVo = null;
				for (CatalogLang catalogLang : catalogLangs)
				{
					catalogLangVo = new CatalogLangVo ();
					BeanUtils.copyProperties (catalogLang, catalogLangVo);
					catalogLangVos.add (catalogLangVo);
				}
				catalogVo.setCatalogLangVos (catalogLangVos);
			}
			return new Result<> ().success (catalogVo);
		}
		else
		{
			return new Result<> ().success ("catalog not exist.");
		}
	}

	/**
	 * 根据ID查询栏目信息 供客户端使用
	 *
	 * @param catalogId
	 * @return
	 */
	@Override
	public Result<CatalogVo> qryCatalogById (@PathVariable ("catalog") String catalogId)
	{
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<> ().failure ("catalog illega params.");
		}
		d ("CATALOG", "qryCatalogById", LOG_TYPE_REQUEST, catalogId);
		Catalog catalog = catalogMapper.queryCatalogById (catalogId, Language.getLanguage ());

		if (null != catalog)
		{
			CatalogVo catalogVo = new CatalogVo ();
			BeanUtils.copyProperties (catalog, catalogVo);
			return new Result<> ().success (catalogVo);
		}
		else
		{
			return new Result<> ().success ("catalog not exist.");
		}
	}

	/**
	 * 根据ID删除栏目信息
	 *
	 * @param catalogId
	 * @return
	 */
	@Override
	public Result<String> delete (@PathVariable ("catalog") String catalogId)
	{
		i ("CATALOG", "delete", LOG_TYPE_REQUEST, catalogId);
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<> ().failure ("catalog illega params.");
		}
		//删除栏目关联关系
		catalogMapper.deleteCatalogRelation (catalogId);
		//删除栏目信息
		int flag = catalogMapper.delete (catalogId);

		if (0 < flag)
		{
			//删除栏目多语言信息
			int flagLang = catalogMapper.deleteCatalogLang (catalogId);

			if (0 < flagLang)
			{
				List<String> targetIds = Lists.newArrayList ();
				targetIds.add (catalogId);
				//删除配置关系
				catalogRelationMapper.removeRelation (targetIds);
				return new Result<String> ().success ();
			}
			else
			{
				return new Result<String> ().failure ("delete catalogLang failed.");
			}
		}
		else
		{
			return new Result<String> ().failure ("delete catalog failed.");
		}
	}

	/**
	 * 根据栏目名称查询栏目信息
	 *
	 * @param queryCatalogInNameRequest
	 * @return
	 */
	@Override
	public Result<List<CatalogVo>> queryCatalogByNames (
			@RequestBody QueryCatalogInNameRequest queryCatalogInNameRequest)
	{
		if (null == queryCatalogInNameRequest || CollectionUtils.isEmpty (queryCatalogInNameRequest.getNames ()))
		{
			return new Result<String> ().failure ("illega params.");
		}
		d ("CATALOG", "queryCatalogByNames", LOG_TYPE_REQUEST, queryCatalogInNameRequest);
		List<Catalog> catalogs = catalogMapper
				.queryCatalogByName (queryCatalogInNameRequest.getNames (), Language.getLanguage ());
		List<CatalogVo> catalogVos = null;
		if (! CollectionUtils.isEmpty (catalogs))
		{
			catalogVos = Lists.newArrayList ();
			CatalogVo catalogVo = null;
			for (Catalog catalog : catalogs)
			{
				catalogVo = new CatalogVo ();
				BeanUtils.copyProperties (catalog, catalogVo);
				catalogVos.add (catalogVo);
			}
		}
		return new Result<> ().success (catalogVos);
	}

	/**
	 * 查询一级栏目和二级栏目分类信息
	 *
	 * @return
	 */
	@Override
	public Result<List<CatalogMessageVo>> queryCatalogInfo ()
	{
		List<CatalogMessageVo> catalogMessageVos = null;
		List<Catalog> catalogs = catalogMapper.queryParentCatalog (Language.getLanguage ());
		i ("CATALOG", "queryCatalogInfo", "PARENTCATALOG", catalogs);
		if (! CollectionUtils.isEmpty (catalogs))
		{
			catalogMessageVos = Lists.newArrayList ();
			CatalogMessageVo catalogMessageVo = null;
			CatalogMessageVo subCatalogMessageVo = null;
			List<CatalogMessageVo> subCatalogMessageVos = null;
			for (Catalog catalog : catalogs)
			{
				catalogMessageVo = new CatalogMessageVo ();
				catalogMessageVo.setCatalogIcon (catalog.getCatalogIcon ());
				catalogMessageVo.setCatalogId (catalog.getCatalogId ());
				catalogMessageVo.setCatalogName (catalog.getCatalogName ());
				catalogMessageVo.setPosition (catalog.getOrderNum ());
				catalogMessageVo.setNodeType (catalog.getNodeType ());
				catalogMessageVo.setProgagandaImg (catalog.getProgagandaImg ());
				List<Catalog> subCatalogs = catalogMapper
						.querySubCatalogByParentId (catalog.getCatalogId (), Language.getLanguage ());
				if (! CollectionUtils.isEmpty (subCatalogs))
				{
					subCatalogMessageVos = Lists.newArrayList ();
					for (Catalog subCatalog : subCatalogs)
					{
						subCatalogMessageVo = new CatalogMessageVo ();
						subCatalogMessageVo.setCatalogName (subCatalog.getCatalogName ());
						subCatalogMessageVo.setCatalogId (subCatalog.getCatalogId ());
						subCatalogMessageVo.setOrder (subCatalog.getOrderNum ());
						subCatalogMessageVo.setCatalogIcon (subCatalog.getCatalogIcon ());
						subCatalogMessageVo.setNodeType (subCatalog.getNodeType ());
						subCatalogMessageVo.setProgagandaImg (subCatalog.getProgagandaImg ());
						subCatalogMessageVos.add (subCatalogMessageVo);
					}
					catalogMessageVo.setSubCatalog (subCatalogMessageVos);
				}
				catalogMessageVos.add (catalogMessageVo);
			}
		}
		i ("CATALOG", "queryCatalogInfo", LOG_TYPE_RESPONSE, catalogMessageVos);
		return new Result<> ().success (catalogMessageVos);
	}

	/**
	 * 根据一级栏目编号查询二级栏目及应用信息
	 *
	 * @return
	 */
	@Override
	public Result<List<CatalogMessage<AppMessage>>> querySubCatalogInfo (@PathVariable ("catalogId") String catalogId)
	{
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<> ().failure ("catalog id is empty.");
		}

		i ("CATALOG", "querySubCatalogInfo", LOG_TYPE_REQUEST, catalogId);
		List<Catalog> subCatalogs = catalogMapper.querySubCatalogByParentId (catalogId, Language.getLanguage ());
		List<CatalogMessage<AppMessage>> catalogMessages = null;
		if (! CollectionUtils.isEmpty (subCatalogs))
		{
			catalogMessages = Lists.newArrayList ();
			CatalogMessage<AppMessage> catalogMessage = null;
			List<AppMessage> appMessages = null;
			AppMessage appMessage = null;

			for (Catalog subCatalog : subCatalogs)
			{
				catalogMessage = new CatalogMessage<> ();
				catalogMessage.setCatalogName (subCatalog.getCatalogName ());
				catalogMessage.setCatalogId (subCatalog.getCatalogId ());
				catalogMessage.setPosition (subCatalog.getOrderNum ());
				catalogMessage.setCatalogIcon (subCatalog.getCatalogIcon ());
				catalogMessage.setProgagandaImg (subCatalog.getProgagandaImg ());
				List<CatalogAppRela> catalogAppRelas = catalogMapper
						.queryAppsByAppCatalogId (subCatalog.getCatalogId (), Language.getLanguage (), 0, 4);
				if (! CollectionUtils.isEmpty (catalogAppRelas))
				{
					appMessages = Lists.newArrayList ();
					for (CatalogAppRela catalogAppRela : catalogAppRelas)
					{
						appMessage = new AppMessage ();
						BeanUtils.copyProperties (catalogAppRela, appMessage);
						appMessages.add (appMessage);
					}
					catalogMessage.setTarget (appMessages);
				}
				catalogMessages.add (catalogMessage);
			}
			i ("CATALOG", "querySubCatalogInfo", LOG_TYPE_RESPONSE, catalogMessages);
		}
		return new Result<> ().success (catalogMessages);
	}

	/**
	 * 根据二级栏目编号查询下面的应用信息
	 *
	 * @param catalogId
	 * @param start
	 * @param size
	 * @return
	 */
	@Override
	public Result<CatalogMessage<AppMessage>> queryAppsBySubCatalog (@PathVariable ("catalogId") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size)
	{
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<List<AppsVo>> ().failure ("catalogId is Illega params");
		}
		List<CatalogAppRela> catalogAppRelas = catalogMapper
				.queryAppsByAppCatalogId (catalogId, Language.getLanguage (), (start - 1) * size, size);
		Result<CatalogMessage<AppMessage>> result = new Result<> ();
		CatalogMessage<AppMessage> catalogMessage = null;
		List<AppMessage> appMessages = null;
		if (! CollectionUtils.isEmpty (catalogAppRelas))
		{
			catalogMessage = new CatalogMessage<> ();
			appMessages = Lists.newArrayList ();
			AppMessage appMessage = null;
			for (CatalogAppRela catalogAppRela : catalogAppRelas)
			{
				appMessage = new AppMessage ();
				BeanUtils.copyProperties (catalogAppRela, appMessage);
				appMessages.add (appMessage);
			}
			catalogMessage.setCatalogName (catalogAppRelas.get (0).getCatalogName ());
			catalogMessage.setCatalogId (catalogAppRelas.get (0).getCatalogId ());
			catalogMessage.setProgagandaImg (catalogAppRelas.get (0).getProgagandaImg ());
			catalogMessage.setCatalogIcon (catalogAppRelas.get (0).getCatalogIcon ());
			catalogMessage.setTarget (appMessages);
			result.setTotalCount (catalogMapper.queryAppsCountByAppCatalogId (catalogId, Language.getLanguage ()));
		}
		result.success (catalogMessage);
		return result;
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
	public Result<List<CatalogVo>> querySubCatalogByCatalogId (@PathVariable ("catalogId") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size)
	{
		i ("CATALOG", "querySubCatalogByCatalogId", LOG_TYPE_REQUEST, catalogId);
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<> ().failure ("catalogId is null");
		}
		Map<String, Object> params = Maps.newHashMap ();
		params.put ("parentCatalogId", catalogId);
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		params.put (DATA_PAGE_START, (start - 1) * size);
		params.put (DATA_PAGE_SIZE, size);

		//查询数据库
		List<Catalog> catalogs = catalogMapper.querySubCatalogByCatalogId (params);
		//定义返回结果集
		Result<List<CatalogVo>> result = new Result<List<CatalogVo>> ();
		if (! CollectionUtils.isEmpty (catalogs))
		{
			List<CatalogVo> catalogVos = Lists.newArrayList ();
			CatalogVo catalogVo = null;
			for (Catalog catalog : catalogs)
			{
				catalogVo = new CatalogVo ();
				BeanUtils.copyProperties (catalog, catalogVo);
				catalogVos.add (catalogVo);
			}
			result.setData (catalogVos);
			result.setTotalCount (catalogMapper.querySubCatalogCountByCatalogId (params));
		}

		i ("CATALOG", "querySubCatalogByCatalogId", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 更新普通栏目排序优先级字段 供market的普通栏目排序
	 *
	 * @param modifySubCatalogOrderNumRequest
	 * @return
	 */
	@Override
	public Result modifySubCatalogOrderNum (
			@RequestBody ModifySubCatalogOrderNumRequest modifySubCatalogOrderNumRequest)
	{
		if (null == modifySubCatalogOrderNumRequest || CollectionUtils
				.isEmpty (modifySubCatalogOrderNumRequest.getCatalogVos ()))
		{
			return new Result<> ().failure ("illega params.");
		}
		List<CatalogVo> catalogVos = modifySubCatalogOrderNumRequest.getCatalogVos ();
		List<Catalog> catalogs = Lists.newArrayList ();
		Catalog catalog = null;
		for (CatalogVo catalogVo : catalogVos)
		{
			catalog = new Catalog ();
			BeanUtils.copyProperties (catalogVo, catalog);
			catalogs.add (catalog);
		}

		i ("CATALOG", "modifySubCatalogOrderNum", LOG_TYPE_REQUEST, modifySubCatalogOrderNumRequest);
		int flag = catalogMapper.modifyCatalogOrderNum (catalogs);
		i ("CATALOG", "querySubCatalogByCatalogId", LOG_TYPE_RESPONSE, flag);

		if (0 < flag)
		{
			return new Result<String> ().success ();
		}
		else
		{
			return new Result<String> ().failure ("batch modify catalog orderNum failed.");
		}

	}

	/**
	 * 置顶栏目 供market的普通栏目排序
	 *
	 * @param modifyCatalogOrderNumToTopRequest
	 * @return
	 */
	@Override
	public Result modifySubCatalogOrderNumToTop (
			@RequestBody ModifyCatalogOrderNumToTopRequest modifyCatalogOrderNumToTopRequest)
	{
		if (null == modifyCatalogOrderNumToTopRequest)
		{
			return new Result ().failure ("illega params, request is null");
		}

		if (StringUtils.isEmpty (modifyCatalogOrderNumToTopRequest.getCatalogId ()))
		{
			return new Result ().failure ("illega params, CatalogId is null");
		}

		if (null == modifyCatalogOrderNumToTopRequest.getNoteType ())
		{
			return new Result ().failure ("illega params, NoteType is null");
		}

		i ("CATALOG", "modifySubCatalogOrderNumToTop", LOG_TYPE_REQUEST, modifyCatalogOrderNumToTopRequest);
		Catalog catalogTemp = catalogMapper.getOrderNumByCatalogId (modifyCatalogOrderNumToTopRequest.getCatalogId ());
		i ("CATALOG", "modifySubCatalogOrderNumToTop", "CURRENT_POSITION", catalogTemp);
		if (null == catalogTemp || null == catalogTemp.getOrderNum ())
		{
			return new Result ().failure ("modify subCatalog orderNum failed.");
		}

		List<Catalog> catalogs = catalogMapper
				.queryBeforeSubcatalog (catalogTemp.getParentCatalogId (), catalogTemp.getOrderNum () - 1,
						modifyCatalogOrderNumToTopRequest.getNoteType ());
		i ("CATALOG", "modifySubCatalogOrderNumToTop", "BEFORE_POSITION", catalogs);
		if (! CollectionUtils.isEmpty (catalogs))
		{
			for (Catalog catalog : catalogs)
			{
				catalog.setOrderNum (catalog.getOrderNum () + 1);
			}
			Catalog catalog = new Catalog ();
			catalog.setOrderNum (1);
			catalog.setCatalogId (modifyCatalogOrderNumToTopRequest.getCatalogId ());
			catalog.setNodeType (modifyCatalogOrderNumToTopRequest.getNoteType ());
			catalogs.add (catalog);
			i ("CATALOG", "modifySubCatalogOrderNumToTop", "BATCH_MODIFY", catalogs);
			int flag = catalogMapper.modifyCatalogOrderNum (catalogs);
			i ("CATALOG", "modifySubCatalogOrderNumToTop", LOG_TYPE_RESPONSE, flag);
			if (0 < flag)
			{
				return new Result<String> ().success ();
			}
			else
			{
				return new Result<String> ().failure ("batch modify subCatalog orderNum failed.");
			}
		}
		else
		{
			return new Result ().failure ("top failed.");
		}
	}
}
