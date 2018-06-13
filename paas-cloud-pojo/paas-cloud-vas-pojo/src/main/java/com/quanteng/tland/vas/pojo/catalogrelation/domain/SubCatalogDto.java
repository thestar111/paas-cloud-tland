/**
 * 文 件 名:  SubCatalogDto
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * <子栏目传输对象>
 *
 * @author zping
 * @version 2018/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class SubCatalogDto extends CatalogDto
{
	/**
	 * 序号
	 */
	private Integer order;
	/**
	 * 宣传图地址
	 */
	private String progagandaImg;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("SubCatalogDto{");
		sb.append ("order=").append (order);
		sb.append (", progagandaImg='").append (progagandaImg).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
