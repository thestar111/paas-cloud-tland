/**
 * 文 件 名:  ModifySubCatalogOrderNumRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/6/4
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalog.request;

import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <普通栏目排序请求>
 *
 * @author LJun
 * @version 2018/6/4
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class ModifySubCatalogOrderNumRequest extends BaseRequest
{

	/**
	 * 普通栏目关系orderNum批量修改
	 */
	private List<CatalogVo> catalogVos;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ModifySubCatalogOrderNumRequest{");
		sb.append ("catalogVos=").append (catalogVos);
		sb.append ('}');
		return sb.toString ();
	}
}
