package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Ad;
import com.quanteng.tland.cms.database.entity.AdLang;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <广告MAPPER>
 *
 * @author weiwenfeng
 * @version 2017年7月14日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface AdMapper
{
	/**
	 * 增加广告
	 *
	 * @tags return void
	 */
	int add (Ad ad);

	/**
	 * 增加广告多语言
	 *
	 * @tags return void
	 */
	int addLang (List<AdLang> adLangs);

	/**
	 * 修改广告
	 *
	 * @tags @param ad
	 * return void
	 */
	int update (Ad ad);

	/**
	 * 修改广告多语言
	 *
	 * @tags @param ad
	 * return void
	 */
	int updateAdLang (List<AdLang> adLangs);

	/**
	 * 根据广告Id查询广告 供管理平台使用
	 *
	 * @tags @param adId
	 * @tags @return
	 * return Ad
	 */
	Ad queryAdById (String advertisementId);

	/**
	 * 根据广告Id查询广告语言信息 供管理平台使用
	 *
	 * @tags @param adId
	 * @tags @return
	 * return Ad
	 */
	List<AdLang> queryAdLangById (String advertisementId);

	/**
	 * 根据广告Id查询广告 供客户端使用
	 *
	 * @tags @param advertisementId
	 * @tags @param language
	 * @tags @return
	 * return Ad
	 */
	Ad findById (@Param ("advertisementId") String advertisementId, @Param ("local") String language);

	/**
	 * 查询所有广告
	 *
	 * @tags @return
	 * return List<Ad>
	 */
	List<Ad> queryList (Map<String, Object> params);

	/**
	 * 删除一条广告信息
	 *
	 * @tags @param adId
	 * return void
	 */
	int delete (String advertisementId);

	/**
	 * 删除一条广告多语言信息
	 *
	 * @tags @param adId
	 * return void
	 */
	int deleteAdLang (String advertisementId);

	/**
	 * 查询总数
	 *
	 * @param params
	 * @return
	 */
	int qeruyCount (Map<String, Object> params);

	/**
	 * 查询启动页广告
	 *
	 * @return
	 */
	Ad queryLanuchAd ();
}
