/**
 * 文 件 名:  BatchDeleteBundleAppOrCatalogRelationByIdRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <批量删除套餐应用或栏目关系请求实体>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BatchDeleteBundleAppOrCatalogRelationByIdRequest extends BaseRequest
{
	/**
	 * 关系id列表
	 */
	private List<String> ids;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("BatchDeleteBundleAppOrCatalogRelationByIdRequest{");
		sb.append ("ids=").append (ids);
		sb.append ('}');
		return sb.toString ();
	}
}