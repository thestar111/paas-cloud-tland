/**
 * 文 件 名:  AdminRoleRelationResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.adminrolerelation;

import com.quanteng.tland.cms.pojo.adminrolerelation.domain.AdminRoleRelationVo;
import com.quanteng.tland.cms.pojo.adminrolerelation.request.AddAdminRoleRelationRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <管理员角色关联关系资源接口>
 *
 * @author huangsongbo
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/adminRoleRelation")
public interface AdminRoleRelationResource
{

	/**
	 * 添加管理员角色关系
	 *
	 * @param addAdminRoleRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result add (@RequestBody AddAdminRoleRelationRequest addAdminRoleRelationRequest);

	/**
	 * 根据管理员编号查询管理员角色关系
	 *
	 * @param adminId
	 * @return
	 */
	@RequestMapping (value = "/adminId/{adminId}", method = RequestMethod.GET)
	Result<List<AdminRoleRelationVo>> find (@PathVariable ("adminId") String adminId);
}
