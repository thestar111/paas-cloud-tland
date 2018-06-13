/**
 * 文 件 名:  CatalogAppRelationVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/6/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/6/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogAppRelationVo extends AppMessage
{
	/**
	 * 栏目应用关联关系业务编号（catalogRealtion表主键）
	 */
	private String id;
	/**
	 * 应用位置
	 */
	private Integer order;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogAppRelationVo{");
		sb.append ("id='").append (id).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
