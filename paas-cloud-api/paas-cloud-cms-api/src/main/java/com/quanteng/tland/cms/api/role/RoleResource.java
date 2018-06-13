/**
 * 文 件 名:  RoleResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.role;

import com.quanteng.tland.cms.pojo.role.domain.RoleVo;
import com.quanteng.tland.cms.pojo.role.request.AddRoleRequest;
import com.quanteng.tland.cms.pojo.role.request.QueryRoleByConditionRequest;
import com.quanteng.tland.cms.pojo.role.request.UpdateRoleRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <角色资源接口>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/role")
public interface RoleResource
{
	/**
	 * 添加角色
	 *
	 * @param addRoleRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result add (@RequestBody AddRoleRequest addRoleRequest);

	/**
	 * 多条件查询角色信息
	 *
	 * @param queryRoleByConditionRequest
	 * @return
	 */
	@RequestMapping (value = "/queryByCondition", method = RequestMethod.POST)
	Result<List<RoleVo>> queryByCondition (@RequestBody QueryRoleByConditionRequest queryRoleByConditionRequest);

	/**
	 * 修改角色信息
	 *
	 * @param updateRoleRequest
	 * @return
	 */
	@RequestMapping (value = "/update", method = RequestMethod.PUT)
	Result update (@RequestBody UpdateRoleRequest updateRoleRequest);

	/**
	 * 通过roleId查询角色信息
	 *
	 * @param roleId
	 * @return
	 */
	@RequestMapping (value = "/roleId/{roleId}", method = RequestMethod.GET)
	Result<RoleVo> findById (@PathVariable ("roleId") String roleId);
}