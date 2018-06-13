/**
 * 文 件 名:  AdminResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.admin;

import com.quanteng.tland.cms.pojo.admin.domain.AdminVo;
import com.quanteng.tland.cms.pojo.admin.request.*;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <管理员资源接口>
 *
 * @author huangsongbo
 * @version 2017/8/8
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/admin")
public interface AdminResource
{

	/**
	 * 添加管理员信息
	 *
	 * @param addAdminRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result add (@RequestBody AddAdminRequest addAdminRequest);

	/**
	 * 修改管理员信息
	 *
	 * @param updateAdminRequest
	 * @return
	 */
	@RequestMapping (value = "/update", method = RequestMethod.PUT)
	Result update (@RequestBody UpdateAdminRequest updateAdminRequest);

	/**
	 * 多条件查询员工信息
	 *
	 * @param queryAdminByConditionRequest
	 * @return
	 */
	@RequestMapping (value = "/queryByCondition", method = RequestMethod.POST)
	Result<List<AdminVo>> queryByCondition (@RequestBody QueryAdminByConditionRequest queryAdminByConditionRequest);

	/**
	 * 根据帐号查询
	 *
	 * @param adminAccount
	 * @return
	 */
	@RequestMapping (value = "/account/{account}", method = RequestMethod.GET)
	Result<AdminVo> findByAccount (@PathVariable ("account") String adminAccount);

	/**
	 * 根据 id 移除该管理员
	 *
	 * @param adminId
	 * @return
	 */
	@RequestMapping (value = "/id/{adminId}", method = RequestMethod.DELETE)
	Result<String> removeAdmin (@PathVariable ("adminId") String adminId);

	/**
	 * 修改用户密码
	 *
	 * @param modifyPasswordReq
	 * @return
	 */
	@RequestMapping (value = "/modifyPwd", method = RequestMethod.PUT)
	Result<String> modifyPwd (@RequestBody ModifyPasswordReq modifyPasswordReq);
}