/**
 * 文 件 名:  AddAdminRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.admin.request;

import com.quanteng.tland.cms.pojo.admin.domain.AdminVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <添加管理员信息请求实体>
 *
 * @author huangsongbo
 * @version 2017/8/8
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AddAdminRequest extends BaseRequest
{
	/**
	 * 管理员信息
	 */
	private AdminVo adminVo;

	@Override
	public String toString ()
	{
		return "AddAdminRequest{" + "adminVo=" + adminVo + '}';
	}
}
