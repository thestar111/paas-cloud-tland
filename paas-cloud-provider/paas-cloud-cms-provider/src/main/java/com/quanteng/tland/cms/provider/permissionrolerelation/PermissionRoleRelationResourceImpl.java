/**
 * 文 件 名:  PermissionRoleRelationResourceImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.permissionrolerelation;

import com.google.common.collect.Lists;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.permissionrolerelation.PermissionRoleRelationResource;
import com.quanteng.tland.cms.database.entity.PermissionRoleRelation;
import com.quanteng.tland.cms.database.mapper.PermissionRoleRelationMapper;
import com.quanteng.tland.cms.pojo.permissionrolerelation.domain.PermissionRoleRelationVo;
import com.quanteng.tland.cms.pojo.permissionrolerelation.request.AddPermissionRoleRelationRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.quanteng.tland.common.log.TlandLogger.LOG_TYPE_REQUEST;
import static com.quanteng.tland.common.log.TlandLogger.i;

/**
 * <角色权限关联关系资源接口实现>
 *
 * @author zhengbinggui
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class PermissionRoleRelationResourceImpl implements PermissionRoleRelationResource
{
	@Autowired
	private PermissionRoleRelationMapper permissionRoleRelationMapper;

	/**
	 * 添加角色权限关联关系
	 *
	 * @param addPermissionRoleRelationRequest
	 * @return
	 */
	@Override
	public Result add (@RequestBody AddPermissionRoleRelationRequest addPermissionRoleRelationRequest)
	{
		if (null == addPermissionRoleRelationRequest || null == addPermissionRoleRelationRequest
				.getPermissionRoleRelationVo ())
		{
			return new Result ().failure ("illega params");
		}

		i ("PERMISSIONROLERELATION", "add", LOG_TYPE_REQUEST, addPermissionRoleRelationRequest);

		PermissionRoleRelation permissionRoleRelation = new PermissionRoleRelation ();
		String id = GenerateSequenceID.getSeqID ();
		BeanUtils.copyProperties (addPermissionRoleRelationRequest.getPermissionRoleRelationVo (),
				permissionRoleRelation);
		permissionRoleRelation.setId (id);
		int flag = permissionRoleRelationMapper.add (permissionRoleRelation);
		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("add permissionRoleRelation failed.");
		}
	}

	/**
	 * 根据角色查询角色权限关联关系
	 *
	 * @param roleId
	 * @return
	 */
	@Override
	public Result<List<PermissionRoleRelationVo>> queryByRoleId (@PathVariable ("roleId") String roleId)
	{
		if (StringUtils.isEmpty (roleId))
		{
			return new Result ().failure ("illega params");
		}

		Result<List<PermissionRoleRelationVo>> result = new Result<> ();
		List<PermissionRoleRelation> permissionRoleRelations = permissionRoleRelationMapper.queryByRoleId (roleId);

		if (! CollectionUtils.isEmpty (permissionRoleRelations))
		{
			List<PermissionRoleRelationVo> permissionRoleRelationVos = Lists.newArrayList ();
			permissionRoleRelations.forEach (permissionRoleRelation -> {
				PermissionRoleRelationVo permissionRoleRelationVo = new PermissionRoleRelationVo ();
				BeanUtils.copyProperties (permissionRoleRelation, permissionRoleRelationVo);
				permissionRoleRelationVos.add (permissionRoleRelationVo);
			});
			result.setData (permissionRoleRelationVos);
		}
		result.success ();
		return result;
	}
}
