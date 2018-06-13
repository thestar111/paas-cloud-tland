package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <广告>
 *
 * @author weiwenfeng
 * @version 2017年7月14日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Ad extends BaseObject
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
	 * 广告链接
	 */
	private String advertisementUrl;

	/**
	 * 广告图片
	 */
	private String imgUrl;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 广告状态(0 : 禁用  1：有效)
	 */
	private String isValid;

	/**
	 * 广告类型(1：外链  2：应用   3：栏目  4：启动页广告)
	 */
	private String advertisementType;

	/**
	 * 目标编号
	 */
	private String targetId;

	/**
	 * 备注
	 */
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Ad{");
		sb.append ("advertisementId='").append (advertisementId).append ('\'');
		sb.append (", advertisementName='").append (advertisementName).append ('\'');
		sb.append (", advertisementUrl='").append (advertisementUrl).append ('\'');
		sb.append (", imgUrl='").append (imgUrl).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", isValid='").append (isValid).append ('\'');
		sb.append (", advertisementType='").append (advertisementType).append ('\'');
		sb.append (", targetId='").append (targetId).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
