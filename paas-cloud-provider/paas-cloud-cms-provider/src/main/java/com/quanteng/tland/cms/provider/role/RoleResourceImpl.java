/**
 * 文 件 名:  RoleResourceImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.role;

import com.google.common.collect.Lists;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.role.RoleResource;
import com.quanteng.tland.cms.database.entity.Role;
import com.quanteng.tland.cms.database.mapper.RoleMapper;
import com.quanteng.tland.cms.pojo.admin.domain.AdminVo;
import com.quanteng.tland.cms.pojo.role.domain.RoleVo;
import com.quanteng.tland.cms.pojo.role.request.AddRoleRequest;
import com.quanteng.tland.cms.pojo.role.request.QueryRoleByConditionRequest;
import com.quanteng.tland.cms.pojo.role.request.UpdateRoleRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_SIZE;
import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_START;
import static com.quanteng.tland.common.log.TlandLogger.LOG_TYPE_REQUEST;
import static com.quanteng.tland.common.log.TlandLogger.i;

/**
 * <角色资源接口实现>
 *
 * @author zhengbinggui
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class RoleResourceImpl implements RoleResource
{
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 添加角色
	 *
	 * @param addRoleRequest
	 * @return
	 */
	@Override
	public Result add (@RequestBody AddRoleRequest addRoleRequest)
	{
		if (null == addRoleRequest || null == addRoleRequest.getRoleVo ())
		{
			return new Result ().failure ("illega params");
		}

		i ("ROLE", "add", LOG_TYPE_REQUEST, addRoleRequest);

		Role role = new Role ();
		String roleId = GenerateSequenceID.getSeqID ();
		BeanUtils.copyProperties (addRoleRequest.getRoleVo (), role);
		role.setRoleId (roleId);
		int flag = roleMapper.add (role);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("add role failed.");
		}
	}

	/**
	 * 多条件查询角色信息
	 *
	 * @param queryRoleByConditionRequest
	 * @return
	 */
	@Override
	public Result<List<RoleVo>> queryByCondition (@RequestBody QueryRoleByConditionRequest queryRoleByConditionRequest)
	{
		if (null == queryRoleByConditionRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("ROLE", "queryByCondition", LOG_TYPE_REQUEST, queryRoleByConditionRequest);

		Result<List<RoleVo>> result = new Result<> ();
		Map<String, Object> params = new HashMap<> ();

		if (! StringUtils.isEmpty (queryRoleByConditionRequest.getRoleId ()))
		{
			params.put ("roleId", queryRoleByConditionRequest.getRoleId ());
		}
		if (! StringUtils.isEmpty (queryRoleByConditionRequest.getParentRoleId ()))
		{
			params.put ("parentRoleId", queryRoleByConditionRequest.getParentRoleId ());
		}
		if (! StringUtils.isEmpty (queryRoleByConditionRequest.getRoleName ()))
		{
			params.put ("roleName", queryRoleByConditionRequest.getRoleName ());
		}
		if (! StringUtils.isEmpty (queryRoleByConditionRequest.getRoleType ()))
		{
			params.put ("roleType", queryRoleByConditionRequest.getRoleType ());
		}
		if (null != queryRoleByConditionRequest.getPageIndex () && null != queryRoleByConditionRequest.getPageSize ())
		{
			params.put (DATA_PAGE_START,
					(queryRoleByConditionRequest.getPageIndex () - 1) * queryRoleByConditionRequest.getPageSize ());
			params.put (DATA_PAGE_SIZE, queryRoleByConditionRequest.getPageSize ());
		}

		List<Role> roles = roleMapper.queryByCondition (params);

		if (! CollectionUtils.isEmpty (roles))
		{
			List<RoleVo> roleVos = Lists.newArrayList ();
			roles.forEach (role -> {
				RoleVo roleVo = new RoleVo ();
				BeanUtils.copyProperties (role, roleVo);
				roleVos.add (roleVo);
			});
			result.setData (roleVos);
			result.setTotalCount (roleMapper.countByCondition (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 修改角色信息
	 *
	 * @param updateRoleRequest
	 * @return
	 */
	@Override
	public Result update (@RequestBody UpdateRoleRequest updateRoleRequest)
	{
		if (null == updateRoleRequest || null == updateRoleRequest.getRoleVo ())
		{
			return new Result ().failure ("illega params");
		}

		if (StringUtils.isEmpty (updateRoleRequest.getRoleVo ().getRoleId ()))
		{
			return new Result ().failure ("roleId illega params");
		}

		i ("ROLE", "update", LOG_TYPE_REQUEST, updateRoleRequest);

		Role role = new Role ();
		BeanUtils.copyProperties (updateRoleRequest.getRoleVo (), role);
		int flag = roleMapper.update (role);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("update role failed.");
		}
	}

	/**
	 * 通过roleId查询角色信息
	 *
	 * @param roleId
	 * @return
	 */
	@Override
	public Result<RoleVo> findById (@PathVariable ("roleId") String roleId)
	{
		if (StringUtils.isEmpty (roleId))
		{
			return new Result ().failure ("illega params");
		}

		Result<RoleVo> result = new Result<> ();

		Role role = roleMapper.findById (roleId);
		RoleVo roleVo = new RoleVo ();
		BeanUtils.copyProperties (role, roleVo);
		result.success (roleVo);
		return result;
	}
}
