/**
 * 文 件 名:  GetColumnAppToMoveReq
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/25
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <修改当前栏目关系置顶>
 *
 * @author chenJian
 * @version 2017/8/25
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ModifyRelationToTopRequest extends BaseRequest
{
	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 当前置顶栏目关系业务编号
	 */
	private String id;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ModifyRelationToTopRequest{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", pushId='").append (id).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}