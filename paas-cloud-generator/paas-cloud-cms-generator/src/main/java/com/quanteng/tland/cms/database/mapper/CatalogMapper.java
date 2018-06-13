/**
 * 文 件 名:  CatalogMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Catalog;
import com.quanteng.tland.cms.database.entity.CatalogAppRela;
import com.quanteng.tland.cms.database.entity.CatalogLang;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <栏目管理Mapper>
 *
 * @author zping
 * @version 2017/7/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface CatalogMapper
{
	/**
	 * 添加栏目
	 *
	 * @param catalog
	 */
	int add (Catalog catalog);

	/**
	 * 添加栏目多语言信息
	 *
	 * @param catalogLangs
	 * @return
	 */
	int addCatalogLang (List<CatalogLang> catalogLangs);

	/**
	 * 修改栏目
	 *
	 * @param catalog
	 */
	int update (Catalog catalog);

	/**
	 * 修改栏目多语言信息
	 *
	 * @param catalogLangs
	 * @return
	 */
	int modifyCatalogLang (List<CatalogLang> catalogLangs);

	/**
	 * 查询栏目分类列表
	 *
	 * @return
	 */
	List<Catalog> queryListByCondition (Map<String, Object> params);

	/**
	 * 查询栏目分类总数
	 *
	 * @return
	 */
	int queryCountByCondition (Map<String, Object> params);

	/**
	 * 查询栏目信息  供平台使用
	 *
	 * @param catalogId
	 * @return
	 */
	Catalog findCatalogById (String catalogId);

	/**
	 * 根据栏目编号查询栏目多语言信息
	 *
	 * @param catalogId
	 * @return
	 */
	List<CatalogLang> findLangByCatalogId (String catalogId);

	/**
	 * 查询栏目信息 供客户端使用
	 *
	 * @param catalogId
	 * @return
	 */
	Catalog queryCatalogById (@Param ("catalogId") String catalogId, @Param ("language") String language);

	/**
	 * 根据id删除栏目
	 *
	 * @tags @param catalogId
	 * @tags @return
	 * return Result
	 */
	int delete (String catalogId);

	/**
	 * 根据id删除栏目多语言信息
	 *
	 * @tags @param catalogId
	 * @tags @return
	 * return Result
	 */
	int deleteCatalogLang (String catalogId);

	/**
	 * 删除栏目时删除栏目下配置信息
	 *
	 * @param catalogId
	 */
	void deleteCatalogRelation (String catalogId);

	/**
	 * 根据名字查询，In查询
	 *
	 * @param names
	 * @return
	 */
	List<Catalog> queryCatalogByName (@Param ("list") List<String> names, @Param ("language") String language);

	/**
	 * 获取在当前排序位之后的所有栏目id
	 *
	 * @param catalogType 栏目类型
	 * @param orderNum    序号
	 * @return
	 */
	List<String> getColumnByAfterOrder (@Param ("catalogType") String catalogType, @Param ("orderNum") String orderNum);

	/**
	 * 查询父栏目信息
	 *
	 * @param language
	 * @return
	 */
	List<Catalog> queryParentCatalog (String language);

	/**
	 * 根据父栏目编号查询子栏目信息
	 *
	 * @param language
	 * @return
	 */
	List<Catalog> querySubCatalogByParentId (@Param ("catalogId") String catalogId,
			@Param ("language") String language);

	/**
	 * 根据普通二级栏目编号查询应用信息
	 *
	 * @param catalogId
	 * @param language
	 * @param start
	 * @param size
	 * @return
	 */
	List<CatalogAppRela> queryAppsByAppCatalogId (@Param ("catalogId") String catalogId,
			@Param ("language") String language, @Param ("start") Integer start, @Param ("size") Integer size);

	/**
	 * 根据应用栏目编号查询应用总数
	 *
	 * @param catalogId
	 * @param language
	 * @return
	 */
	int queryAppsCountByAppCatalogId (@Param ("catalogId") String catalogId, @Param ("language") String language);

	/**
	 * 根据栏目类型查询该类型下序号最大值
	 *
	 * @param catalogType
	 * @return
	 */
	int queryMaxOrderNumByCatalogType (@Param ("catalogType") String catalogType, @Param ("nodeType") Integer nodeType);

	/**
	 * 根据栏目id查询该栏目下的子栏目
	 *
	 * @param params
	 * @return
	 */
	List<Catalog> querySubCatalogByCatalogId (Map<String, Object> params);

	/**
	 * 根据栏目id查询该栏目下的子栏目总数
	 *
	 * @param params
	 * @return
	 */
	int querySubCatalogCountByCatalogId (Map<String, Object> params);

	/**
	 * 更新普通栏目排序优先级字段 供market的普通栏目排序
	 *
	 * @param catalogs
	 */
	int modifyCatalogOrderNum (List<Catalog> catalogs);

	/**
	 * 获取当前栏目信息，通过catalogId 供market的普通栏目置顶
	 *
	 * @param catalogId
	 * @return
	 */
	Catalog getOrderNumByCatalogId (String catalogId);

	/**
	 * 获取前置子栏目数据 供market的普通栏目置顶
	 *
	 * @param catalogId
	 * @param orderNum
	 * @param nodeType
	 * @return
	 */
	List<Catalog> queryBeforeSubcatalog (@Param ("catalogId") String catalogId, @Param ("orderNum") Integer orderNum,
			@Param ("nodeType") Integer nodeType);
}
