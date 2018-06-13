/**
 * 文 件 名:  TargetRelationVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/28 0028
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * <目标关系实体VO对象>
 *
 * @author zping
 * @version 2018/5/28 0028
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class TargetRelationVo<T> extends CatalogRelationVo
{
	/**
	 * 目标实体对象信息(广告、应用、栏目)
	 */
	private T target;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("TargetRelationVo{");
		sb.append ("target=").append (target);
		sb.append ('}');
		return sb.toString ();
	}
}
