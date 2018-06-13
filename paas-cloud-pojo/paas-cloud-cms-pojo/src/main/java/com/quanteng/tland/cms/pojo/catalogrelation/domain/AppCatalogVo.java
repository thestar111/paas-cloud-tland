/**
 * 文 件 名:  AppCatalogVo
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
 * <栏目下配置的应用实体信息>
 *
 * @author zping
 * @version 2018/6/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AppCatalogVo extends AppMessage
{
	/**
	 * 栏目配置表主键
	 * 只有查询HOT tag栏目下的广告时使用
	 */
	private String id;
	/**
	 * 应用位置
	 */
	private Integer order;
	/**
	 * 分类
	 */
	private String catalogId;
	/**
	 * 分类名称
	 */
	private String catalogName;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AppCatalogVo{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", order=").append (order);
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
