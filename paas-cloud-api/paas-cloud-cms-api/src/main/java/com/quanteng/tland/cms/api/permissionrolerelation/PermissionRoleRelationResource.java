/**
 * 文 件 名:  PermissionRoleRelationResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.permissionrolerelation;

import com.quanteng.tland.cms.pojo.permissionrolerelation.domain.PermissionRoleRelationVo;
import com.quanteng.tland.cms.pojo.permissionrolerelation.request.AddPermissionRoleRelationRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <角色权限关联关系资源接口>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/permissionRoleRelation")
public interface PermissionRoleRelationResource
{
	/**
	 * 添加角色权限关联关系
	 *
	 * @param addPermissionRoleRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result add (@RequestBody AddPermissionRoleRelationRequest addPermissionRoleRelationRequest);

	/**
	 * 根据角色查询权限
	 *
	 * @param roleId
	 * @return
	 */
	@RequestMapping (value = "/roleId/{roleId}", method = RequestMethod.GET)
	Result<List<PermissionRoleRelationVo>> queryByRoleId (@PathVariable ("roleId") String roleId);
}