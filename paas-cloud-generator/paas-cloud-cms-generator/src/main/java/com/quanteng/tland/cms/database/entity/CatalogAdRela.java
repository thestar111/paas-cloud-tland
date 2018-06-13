package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <栏目广告对应关系实体对象>
 *
 * @author weiwenfeng
 * @version 2017年7月14日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogAdRela extends BaseObject
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
	 * 广告名称
	 */
	private String adName;
	/**
	 * 广告地址
	 */
	private String adUrl;
	/**
	 * 广告图片地址
	 */
	private String imgUrl;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogAdRela{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", adName='").append (adName).append ('\'');
		sb.append (", adUrl='").append (adUrl).append ('\'');
		sb.append (", imgUrl='").append (imgUrl).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
