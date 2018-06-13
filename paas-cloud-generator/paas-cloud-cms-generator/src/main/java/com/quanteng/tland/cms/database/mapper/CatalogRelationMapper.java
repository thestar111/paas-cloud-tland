package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <栏目通用关系MAPPER>
 *
 * @author weiwenfeng
 * @version 2017年7月14日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface CatalogRelationMapper
{
	/**
	 * 查询栏目应用关联关系
	 *
	 * @tags @return
	 * return ColumnAppRela
	 */
	List<CatalogAppRela> queryAppByCatalogId (Map<String, Object> params);

	/**
	 * 查询不在栏目应用关联关系内的app
	 *
	 * @tags @return
	 * return ColumnAppRela
	 */
	List<CatalogAppRela> queryAppNotInCatalogId (Map<String, Object> params);

	/**
	 * 查询栏目Id下对应的app总数
	 *
	 * @tags @param params
	 * @tags @return
	 * return int
	 */
	int queryAppCountByCatalogId (Map<String, Object> params);

	/**
	 * 查询不在栏目Id下的app总数
	 *
	 * @tags @param params
	 * @tags @return
	 * return int
	 */
	int queryAppCountNotInCatalogId (Map<String, Object> params);

	/**
	 * 配置栏目和关系
	 *
	 * @tags @param columnAppRela
	 * return void
	 */
	int addCatalogRelation (List<CatalogRelation> catalogRelations);

	/**
	 * 获取最大排序值
	 *
	 * @return
	 */
	int getMaxRankPriority (String catalogId);

	/**
	 * 更新栏目关系排序优先级字段
	 *
	 * @param catalogRelations
	 */
	int modifyCatalogRelationRank (List<CatalogRelation> catalogRelations);

	/**
	 * 当删除应用的时候，删除栏目和应用的关联关系
	 *
	 * @param targetId
	 * @return
	 */
	int delCatalogRelation (String targetId);

	/**
	 * 根据编号查询分类编号
	 *
	 * @param pushId
	 * @return
	 */
	String queryCatalogIdById (String pushId);

	/**
	 * 根据营销栏目编号和目标关系编号删除对应关系
	 *
	 * @tags @param params
	 * return void
	 */
	int deleteCatalogRelaById (@Param ("catalogId") String catalogId, @Param ("targetId") String targetId);

	/**
	 * 获取前置关系应用数据
	 *
	 * @param catalogId
	 * @param orderNum
	 * @return
	 */
	List<CatalogRelation> queryBeforeTargetRelation (@Param ("catalogId") String catalogId,
			@Param ("orderNum") Integer orderNum);

	/**
	 * 获取当前排序位置，通过pushId
	 *
	 * @param pushId
	 * @return
	 */
	Integer getOrderNumById (String pushId);

	/**
	 * 查询指定栏目类型的相对应的
	 *
	 * @param param
	 * @return
	 */
	List<CatalogAppRela> queryAppsByCatalogIdAndType (Map<String, Object> param);

	/**
	 * 删除营销栏目时，删除关联关系
	 *
	 * @param catalogId
	 */
	void deleteByCatalog (String catalogId);

	/**
	 * 根据营销类型查询首页营销栏目编号
	 *
	 * @return
	 */
	List<String> queryPromotionCatalogId (Integer type);

	/**
	 * 根据栏目编号查询广告
	 *
	 * @param params
	 * @return
	 */
	List<CatalogAdsRela> queryPromotionAdByCatalogId (Map<String, Object> params);

	/**
	 * 根据类型查询营销广告
	 *
	 * @param params
	 * @return
	 */
	List<CatalogAdsRela> queryPromotionAdByType (Map<String, Object> params);

	/**
	 * 根据栏目编号查询栏目下的热门标签
	 *
	 * @param catalogId
	 * @param language
	 * @return
	 */
	List<Catalog> queryHotTagsByCatalogId (@Param ("catalogId") String catalogId, @Param ("language") String language);

	/**
	 * 查询热门标签信息
	 *
	 * @param language
	 * @return
	 */
	Catalog queryHotCatalogTag (String language);

	/**
	 * 查询栏目关系类型
	 *
	 * @param catalogId
	 * @return
	 */
	Integer queryTypeByCatalogId (String catalogId);

	/**
	 * 查询栏目广告关系类型数据 market栏目广告配置查询
	 *
	 * @param params
	 * @return
	 */
	List<CatalogAdsRela> queryAdsByCatalogId (Map<String, Object> params);

	/**
	 * 查询栏目广告关系总数
	 *
	 * @param params
	 * @return
	 */
	int queryAdsCountByCatalogId (Map<String, Object> params);

	/**
	 * 根据栏目编号查询关系栏目信息
	 *
	 * @param params
	 * @return
	 */
	List<ParentCatalog> queryCatalogByCatalogId (Map<String, Object> params);

	/**
	 * 查询不存在栏目中的广告信息
	 *
	 * @param params
	 * @return
	 */
	List<Ad> queryAdsNotInCatalog (Map<String, Object> params);

	/**
	 * 查询不存在栏目中的广告总数信息
	 *
	 * @param params
	 * @return
	 */
	int queryAdsCountNotInCatalog (Map<String, Object> params);

	/**
	 * 查询栏目不在栏目下的信息
	 *
	 * @param params
	 * @return
	 */
	List<Catalog> queryCatalogNotInCatalog (Map<String, Object> params);

	/**
	 * 查询栏目不在栏目下的总数
	 *
	 * @param params
	 * @return
	 */
	int queryCatalogCountNotInCatalog (Map<String, Object> params);

	/**
	 * 查询栏目下的orderNum最大值
	 *
	 * @param catalogId
	 * @return
	 */
	int queryMaxOrderByCatalogId (@Param ("catalogId") String catalogId);

	/**
	 * 根据栏目Id查询关联应用 供market应用栏目和营销栏目的配置查询
	 *
	 * @tags @return
	 * return ColumnAppRela
	 */
	List<CatalogAppRela> queryConfigAppByCatalogId (Map<String, Object> params);

	/**
	 * 根据栏目Id查询关联应用总数 供market应用栏目和营销栏目的配置查询
	 *
	 * @tags @param params
	 * @tags @return
	 * return int
	 */
	int queryConfigAppCountByCatalogId (Map<String, Object> params);

	/**
	 * 删除广告、栏目或应用下线时删除其配置的关联关系
	 *
	 * @param targetIds
	 */
	void removeRelation (List<String> targetIds);

	/**
	 * 查询应用栏目下应用配置信息
	 *
	 * @param params
	 * @return
	 */
	List<CatalogAppRela> queryAppByAppCatalogId (Map<String, Object> params);
}
