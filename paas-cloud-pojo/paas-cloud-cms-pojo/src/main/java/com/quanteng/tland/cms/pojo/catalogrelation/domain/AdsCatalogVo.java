/**
 * 文 件 名:  AdsCatalogVo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/6/6
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * <栏目下配置广告的实体信息>
 *
 * @author LJun
 * @version 2018/6/6
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdsCatalogVo extends AdsMessage
{
	/**
	 * 栏目配置表主键
	 * 只有查询HOT tag栏目下的广告时使用
	 */
	private String id;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AdsCatalogVo{");
		sb.append ("id='").append (id).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
