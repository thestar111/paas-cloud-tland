/**
 * 文 件 名:  AppMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.App;
import com.quanteng.tland.cms.database.entity.AppLang;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <应用管理MAPPER>
 *
 * @author zping
 * @version 2017/7/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface AppMapper
{
	/**
	 * 添加应用信息
	 *
	 * @param app
	 */
	int add (App app);

	/**
	 * 添加应用多语言信息
	 *
	 * @param appLangs
	 */
	int addAppLang (List<AppLang> appLangs);

	/**
	 * 修改应用信息
	 *
	 * @param app
	 */
	int modify (App app);

	/**
	 * 修改应用多语言信息
	 *
	 * @param appLangs
	 */
	int modifyAppLang (List<AppLang> appLangs);

	/**
	 * 查询应用列表
	 *
	 * @return
	 */
	List<App> queryListByCondition (Map<String, Object> params);

	/**
	 * 查询应用列表总数
	 *
	 * @return
	 */
	Integer queryCountByCondition (Map<String, Object> params);

	/**
	 * 查询 营销栏目下的应用信息
	 *
	 * @param catalogId
	 * @param language
	 * @param start
	 * @param size
	 * @return
	 */
	List<App> queryByPromotionCatalogId (@Param ("catalogId") String catalogId, @Param ("language") String language,
			@Param ("start") Integer start, @Param ("size") Integer size);

	/**
	 * 查询 普通栏目下的应用信息
	 *
	 * @param catalogId
	 * @param language
	 * @param start
	 * @param size
	 * @return
	 */
	List<App> queryAppByNormalCatalog (@Param ("catalogId") String catalogId, @Param ("language") String language,
			@Param ("start") Integer start, @Param ("size") Integer size);

	/**
	 * 统计 营销栏目下app总数
	 *
	 * @param catalogId
	 * @return
	 */
	int queryCountByPromotionColumnId (String catalogId);

	/**
	 * 普通栏目统计
	 *
	 * @return
	 */
	int queryCountByColumnId (String catalogId);

	/**
	 * 查询应用信息 供平台使用
	 *
	 * @param appId
	 * @return
	 */
	App queryById (String appId);

	/**
	 * 查询应用信息 供平台使用
	 *
	 * @param appId
	 * @return
	 */
	List<AppLang> queryAppLangById (String appId);

	/**
	 * 查询应用信息 供客户端使用
	 *
	 * @param appId
	 * @return
	 */
	App findById (@Param ("appId") String appId, @Param ("language") String language);

	/**
	 * 根据应用编号删除app
	 *
	 * @tags @return
	 * return Result
	 */
	int delete (String appId);

	/**
	 * 根据应用编号删除app多语言信息
	 *
	 * @tags @return
	 * return Result
	 */
	int deleteAppLang (String appId);

	/**
	 * 统计普通栏目或营销栏目是否有关联应用
	 *
	 * @param catalogId
	 * @return
	 */
	Integer queryColumnAppRelationCount (String catalogId);

	/**
	 * 更新app下载次数
	 *
	 * @param appId
	 * @return
	 */
	Integer modifyDownloadTimes (String appId);

	/**
	 * 查询HOT下的应用信息作为游戏推荐
	 *
	 * @param catalogName
	 * @param language
	 * @return
	 */
	List<App> queryHotApp (@Param ("catalogName") String catalogName, @Param ("language") String language);

	/**
	 * 查询游戏推荐应用信息
	 *
	 * @param appId
	 * @param language
	 * @return
	 */
	List<App> queryRecommandApp (@Param ("appId") String appId, @Param ("catalogId") String catalogId,  @Param ("language") String language);

	/**
	 * 批量修改应用状态
	 * @param params
	 * @return
	 */
	int modifyAppStatus(Map<String, Object> params);
}
