/**
 * 文 件 名:  PermissionResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.permission;

import com.quanteng.tland.cms.pojo.permission.domain.PermissionVo;
import com.quanteng.tland.cms.pojo.permission.request.AddPermissionRequest;
import com.quanteng.tland.cms.pojo.permission.request.QueryPermissionByConditionRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <权限资源接口>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/permission")
public interface PermissionResource
{

	/**
	 * 添加权限信息
	 *
	 * @param addPermissionRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result add (@RequestBody AddPermissionRequest addPermissionRequest);

	/**
	 * 多条件查询权限信息
	 *
	 * @param queryPermissionByConditionRequest
	 * @return
	 */
	@RequestMapping (value = "/queryByCondition", method = RequestMethod.POST)
	Result<List<PermissionVo>> queryByCondition (@RequestBody QueryPermissionByConditionRequest queryPermissionByConditionRequest);

	/**
	 * 根据权限编号查询权限信息
	 *
	 * @param permissionId
	 * @return
	 */
	@RequestMapping (value = "/id/{permissionId}", method = RequestMethod.GET)
	Result<PermissionVo> findPermissionById (@PathVariable ("permissionId") String permissionId);
}