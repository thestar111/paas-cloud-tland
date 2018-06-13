/**
 * 文 件 名:  NormalCatalogDto
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

import java.util.List;

/**
 * <二级栏目应用信息>
 *
 * @author zping
 * @version 2018/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class NormalCatalogDto<T> extends CatalogDto
{
	/**
	 * 宣传图
	 */
	private String progagandaImg;
	/**
	 * 排序位置
	 */
	private Integer position;
	/**
	 * 栏目类型为非叶子节点时的下一节点信息
	 */
	private List<T> target;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("IndexCatalogDto{");
		sb.append ("progagandaImg=").append (progagandaImg);
		sb.append (", position=").append (position);
		sb.append (", target=").append (target);
		sb.append ('}');
		return sb.toString ();
	}
}
