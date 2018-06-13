/**
 * 文 件 名:  CatalogAdsRela
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/16 0016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <栏目广告关系信息>
 *
 * @author zping
 * @version 2018/5/16 0016
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogAdsRela extends BaseObject
{
	/**
	 * 广告编号
	 */
	private String advertisementId;
	/**
	 * 广告名称
	 */
	private String advertisementName;
	/**
	 * 广告链接地址
	 */
	private String advertisementUrl;
	/**
	 * 广告图片URL地址
	 */
	private String imgUrl;
	/**
	 * 广告类型：(1：外链  2：应用   3：栏目)
	 */
	private Integer advertisementType;
	/**
	 * 广告对应编号
	 */
	private String targetId;
	/**
	 * 广告位置
	 */
	private Integer order;
	/**
	 * 分类编号
	 */
	private String catalogId;
	/**
	 * 分类名称
	 */
	private String catalogName;
	/**
	 * 分类ICON地址
	 */
	private String catalogIcon;
	/**
	 * 分类关系类型
	 */
	private Integer type;
	/**
	 * 栏目位置
	 */
	private Integer position;

	/**
	 * 栏目配置表主键
	 * 只有查询HOT tag栏目下的广告时使用
	 */
	private String id;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogAdsRela{");
		sb.append ("advertisementId='").append (advertisementId).append ('\'');
		sb.append (", advertisementName='").append (advertisementName).append ('\'');
		sb.append (", advertisementUrl='").append (advertisementUrl).append ('\'');
		sb.append (", imgUrl='").append (imgUrl).append ('\'');
		sb.append (", advertisementType=").append (advertisementType);
		sb.append (", targetId='").append (targetId).append ('\'');
		sb.append (", order=").append (order);
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogIcon='").append (catalogIcon).append ('\'');
		sb.append (", type=").append (type);
		sb.append (", position=").append (position);
		sb.append (", id='").append (id).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
