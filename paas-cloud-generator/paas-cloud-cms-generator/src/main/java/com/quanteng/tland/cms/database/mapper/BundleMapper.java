/**
 * 文 件 名:  BundleMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/3 0003
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Bundle;
import com.quanteng.tland.cms.database.entity.BundleLang;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <套餐信息MAPPER>
 *
 * @author zping
 * @version 2018/5/3 0003
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface BundleMapper
{
	/**
	 * 添加套餐信息
	 *
	 * @param bundle
	 * @return
	 */
	int createBundle (Bundle bundle);

	/**
	 * 添加套餐多语言信息
	 *
	 * @param bundles
	 * @return
	 */
	int addBundleLang (List<BundleLang> bundles);

	/**
	 * 修改套餐信息
	 *
	 * @param bundle
	 * @return
	 */
	int modifyBundle (Bundle bundle);

	/**
	 * 修改套餐多语言信息
	 *
	 * @param bundles
	 * @return
	 */
	int modifyBundleLang (List<BundleLang> bundles);

	/**
	 * 删除套餐信息
	 *
	 * @param bundleId
	 * @return
	 */
	int deleteBundle (String bundleId);

	/**
	 * 删除套餐信息
	 *
	 * @param bundleId
	 * @return
	 */
	int deleteBundleLang (String bundleId);

	/**
	 * 查询套餐信息 供平台使用
	 *
	 * @param bundleId
	 * @return
	 */
	Bundle findPackageById (String bundleId);

	/**
	 * 查询套餐多语言信息 供平台使用
	 *
	 * @param bundleId
	 * @return
	 */
	List<BundleLang> findPackageLangById (String bundleId);

	/**
	 * 查询套餐信息 供客户端使用
	 *
	 * @param bundleId
	 * @param language
	 * @return
	 */
	Bundle queryPackageById (@Param ("bundleId") String bundleId, @Param ("language") String language);

	/**
	 * 多条件查询套餐信息
	 *
	 * @param params
	 * @return
	 */
	List<Bundle> queryBundlesByCondition (Map<String, Object> params);

	/**
	 * 多条件查询套餐信息总数
	 *
	 * @param params
	 * @return
	 */
	int queryBundlesCountByCondition (Map<String, Object> params);
}
