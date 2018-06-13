package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <栏目应用对应关系实体对象>
 *
 * @author weiwenfeng
 * @version 2017年7月14日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogAppRela extends BaseObject
{
	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 栏目名称
	 */
	private String catalogName;
	/**
	 * 栏目ICON地址
	 */
	private String catalogIcon;
	/**
	 * 应用编号
	 */
	private String appId;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * 星级
	 */
	private String appRate;
	/**
	 * 版本号
	 */
	private String appVersion;
	/**
	 * 应用图标
	 */
	private String appIcon;
	/**
	 * 应用图标
	 */
	private String appIconThumb;
	/**
	 * 下载次数
	 */
	private String appDownload;
	/**
	 * 对应栏目关系下的order_Num（target为应用时有效）
	 **/
	private Integer order;
	/**
	 * app 大小
	 **/
	private String appSize;
	/**
	 * 栏目关系类型
	 **/
	private Integer type;
	/**
	 * 对应栏目关系下的order_Num（target为栏目时有效）
	 */
	private Integer position;
	/**
	 * 栏目分类宣传图
	 */
	private String progagandaImg;

	/**
	 * 应用的分类ID
	 */
	private String appCatalogId;
	/**
	 * 应用的分类名称
	 */
	private String appCatalogName;
	/**
	 * 开发者
	 */
	private String developer;
	/**
	 * 栏目应用关联关系业务编号（catalogRealtion表主键）
	 */
	private String id;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogAppRela{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogIcon='").append (catalogIcon).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", appRate='").append (appRate).append ('\'');
		sb.append (", appVersion='").append (appVersion).append ('\'');
		sb.append (", appIcon='").append (appIcon).append ('\'');
		sb.append (", appIconThumb='").append (appIconThumb).append ('\'');
		sb.append (", appDownload='").append (appDownload).append ('\'');
		sb.append (", order=").append (order);
		sb.append (", appSize='").append (appSize).append ('\'');
		sb.append (", type=").append (type);
		sb.append (", position=").append (position);
		sb.append (", progagandaImg='").append (progagandaImg).append ('\'');
		sb.append (", appCatalogId='").append (appCatalogId).append ('\'');
		sb.append (", appCatalogName='").append (appCatalogName).append ('\'');
		sb.append (", developer='").append (developer).append ('\'');
		sb.append (", id='").append (id).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
