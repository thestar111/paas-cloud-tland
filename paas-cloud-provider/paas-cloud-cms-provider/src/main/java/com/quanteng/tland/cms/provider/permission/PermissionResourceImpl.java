/**
 * 文 件 名:  PermissionResourceImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.permission;

import com.google.common.collect.Lists;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.permission.PermissionResource;
import com.quanteng.tland.cms.database.entity.Permission;
import com.quanteng.tland.cms.database.mapper.PermissionMapper;
import com.quanteng.tland.cms.pojo.permission.domain.PermissionVo;
import com.quanteng.tland.cms.pojo.permission.request.AddPermissionRequest;
import com.quanteng.tland.cms.pojo.permission.request.QueryPermissionByConditionRequest;
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
 * <权限资源接口实现>
 *
 * @author zhengbinggui
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class PermissionResourceImpl implements PermissionResource
{
	@Autowired
	private PermissionMapper permissionMapper;

	/**
	 * 添加权限信息
	 *
	 * @param addPermissionRequest
	 * @return
	 */
	@Override
	public Result add (@RequestBody AddPermissionRequest addPermissionRequest)
	{
		if (null == addPermissionRequest || null == addPermissionRequest.getPermissionVo ())
		{
			return new Result ().failure ("illega params");
		}

		i ("PERMISSION", "add", LOG_TYPE_REQUEST, addPermissionRequest);

		Permission permission = new Permission ();
		String permissionId = GenerateSequenceID.getSeqID ();
		BeanUtils.copyProperties (addPermissionRequest.getPermissionVo (), permission);
		permission.setPermissionId (permissionId);
		int flag = permissionMapper.add (permission);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("add permission failed.");
		}
	}

	/**
	 * 多条件查询权限信息
	 *
	 * @param queryPermissionByConditionRequest
	 * @return
	 */
	@Override
	public Result<List<PermissionVo>> queryByCondition (
			@RequestBody QueryPermissionByConditionRequest queryPermissionByConditionRequest)
	{
		if (null == queryPermissionByConditionRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("PERMISSION", "queryByCondition", LOG_TYPE_REQUEST, queryPermissionByConditionRequest);

		Result<List<PermissionVo>> result = new Result<> ();

		Map<String, Object> params = new HashMap<> ();
		if (! StringUtils.isEmpty (queryPermissionByConditionRequest.getMenuId ()))
		{
			params.put ("menuId", queryPermissionByConditionRequest.getMenuId ());
		}
		if (! StringUtils.isEmpty (queryPermissionByConditionRequest.getPermissionFlag ()))
		{
			params.put ("permissionFlag", queryPermissionByConditionRequest.getPermissionFlag ());
		}
		if (! StringUtils.isEmpty (queryPermissionByConditionRequest.getPermissionName ()))
		{
			params.put ("permissionName", queryPermissionByConditionRequest.getPermissionName ());
		}
		if (null != queryPermissionByConditionRequest.getPageIndex () && null != queryPermissionByConditionRequest.getPageSize ())
		{
			params.put (DATA_PAGE_START,
					(queryPermissionByConditionRequest.getPageIndex () - 1) * queryPermissionByConditionRequest.getPageSize ());
			params.put (DATA_PAGE_SIZE, queryPermissionByConditionRequest.getPageSize ());
		}

		List<Permission> permissions = permissionMapper.queryByCondition (params);

		if (! CollectionUtils.isEmpty (permissions))
		{
			List<PermissionVo> permissionVos = Lists.newArrayList ();
			permissions.forEach (permission -> {
				PermissionVo permissionVo = new PermissionVo ();
				BeanUtils.copyProperties (permission, permissionVo);
				permissionVos.add (permissionVo);
			});
			result.setData (permissionVos);
			result.setTotalCount (permissionMapper.countByCondition (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 根据权限编号查询权限信息
	 *
	 * @param permissionId
	 * @return
	 */
	@Override
	public Result<PermissionVo> findPermissionById (@PathVariable ("permissionId") String permissionId)
	{
		if (StringUtils.isEmpty (permissionId))
		{
			return new Result ().failure ("illega params");
		}

		Result<PermissionVo> result = new Result<> ();

		Permission permission = permissionMapper.findById (permissionId);

		PermissionVo permissionVo = new PermissionVo ();
		BeanUtils.copyProperties (permission, permissionVo);

		result.success (permissionVo);
		return result;
	}
}
