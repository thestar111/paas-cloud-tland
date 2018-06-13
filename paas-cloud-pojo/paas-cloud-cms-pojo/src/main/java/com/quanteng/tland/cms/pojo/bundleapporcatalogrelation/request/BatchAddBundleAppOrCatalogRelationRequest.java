/**
 * 文 件 名:  BatchAddBundleAppOrCatalogRelationRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.request;

import com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.domain.BundleAppOrCatalogRelationVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <批量新增套餐应用或栏目关系请求实体>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BatchAddBundleAppOrCatalogRelationRequest implements Serializable
{
	/**
	 * 套餐应用或栏目关系列表
	 */
	private List<BundleAppOrCatalogRelationVo> bundleAppOrCatalogRelationVos;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("BatchAddBundleAppOrCatalogRelationRequest{");
		sb.append ("bundleAppOrCatalogRelationVos=").append (bundleAppOrCatalogRelationVos);
		sb.append ('}');
		return sb.toString ();
	}
}