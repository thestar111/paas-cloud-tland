/**
 * 文 件 名:  AdminRoleRelationResourceImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.adminrolerelation;

import com.google.common.collect.Lists;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.adminrolerelation.AdminRoleRelationResource;
import com.quanteng.tland.cms.database.entity.AdminRoleRelation;
import com.quanteng.tland.cms.database.mapper.AdminRoleRelationMapper;
import com.quanteng.tland.cms.pojo.adminrolerelation.domain.AdminRoleRelationVo;
import com.quanteng.tland.cms.pojo.adminrolerelation.request.AddAdminRoleRelationRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.quanteng.tland.common.log.TlandLogger.LOG_TYPE_REQUEST;
import static com.quanteng.tland.common.log.TlandLogger.i;

import java.util.List;

/**
 * <管理员角色关联关系资源接口实现>
 *
 * @author zhengbinggui
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class AdminRoleRelationResourceImpl implements AdminRoleRelationResource
{
	@Autowired
	private AdminRoleRelationMapper adminRoleRelationMapper;

	/**
	 * 添加管理员角色关系
	 *
	 * @param addAdminRoleRelationRequest
	 * @return
	 */
	@Override
	public Result add (@RequestBody AddAdminRoleRelationRequest addAdminRoleRelationRequest)
	{
		if (null == addAdminRoleRelationRequest || null == addAdminRoleRelationRequest.getAdminRoleRelationVo ())
		{
			return new Result ().failure ("illega params");
		}

		i ("ADMINROLERELATION", "add", LOG_TYPE_REQUEST, addAdminRoleRelationRequest);

		AdminRoleRelation adminRoleRelation = new AdminRoleRelation ();
		String id = GenerateSequenceID.getSeqID ();
		BeanUtils.copyProperties (addAdminRoleRelationRequest.getAdminRoleRelationVo (), adminRoleRelation);
		adminRoleRelation.setId (id);
		int flag = adminRoleRelationMapper.add (adminRoleRelation);
		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("add adminRoleRelation failed.");
		}
	}

	/**
	 * 根据管理员编号查询管理员角色关系
	 *
	 * @param adminId
	 * @return
	 */
	@Override
	public Result<List<AdminRoleRelationVo>> find (@PathVariable ("adminId") String adminId)
	{
		if (StringUtils.isEmpty (adminId))
		{
			return new Result ().failure ("illega params");
		}

		Result<List<AdminRoleRelationVo>> result = new Result<> ();

		List<AdminRoleRelation> adminRoleRelations = adminRoleRelationMapper.findByAdminId (adminId);

		if (! CollectionUtils.isEmpty (adminRoleRelations))
		{
			List<AdminRoleRelationVo> adminRoleRelationVos = Lists.newArrayList ();
			adminRoleRelations.forEach (adminRoleRelation -> {
				AdminRoleRelationVo adminRoleRelationVo = new AdminRoleRelationVo ();
				BeanUtils.copyProperties (adminRoleRelation, adminRoleRelationVo);
				adminRoleRelationVos.add (adminRoleRelationVo);
			});
			result.setData (adminRoleRelationVos);
		}
		result.success ();
		return result;
	}
}
