/**
 * 文 件 名:  RankMode
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/25
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <应用排序模型>
 *
 * @author chenJian
 * @version 2017/8/25
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class RankMode extends BaseObject
{
	/**
	 * 业务编号
	 */
	private String pushId;
	/**
	 * 序号
	 */
	private Integer orderNum;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("RankMode{");
		sb.append ("pushId='").append (pushId).append ('\'');
		sb.append (", orderNum=").append (orderNum);
		sb.append ('}');
		return sb.toString ();
	}
}