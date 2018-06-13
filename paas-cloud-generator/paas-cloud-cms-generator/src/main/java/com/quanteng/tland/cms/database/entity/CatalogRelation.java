/**
 * 文 件 名:  CatalogRelation
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/7 0007
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/7 0007
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogRelation extends BaseObject
{
	/**
	 * 业务编号
	 */
	private String id;
	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 关系目标编号
	 */
	private String targetId;
	/**
	 * 顺序
	 */
	private Integer orderNum;
	/**
	 * 分类关系类型 1 : 首页广告  2 : 分类页广告  3：首页应用   4 ： 热门分类类型  5 : 应用类型
	 */
	private Integer type;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogRelation{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", catalogid='").append (catalogId).append ('\'');
		sb.append (", targetId='").append (targetId).append ('\'');
		sb.append (", orderNum=").append (orderNum);
		sb.append ('}');
		return sb.toString ();
	}
}
