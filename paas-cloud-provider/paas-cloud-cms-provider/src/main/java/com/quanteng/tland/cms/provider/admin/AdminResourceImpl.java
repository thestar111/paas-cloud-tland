/**
 * 文 件 名:  AdminResourceImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.admin;

import com.google.common.collect.Lists;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.admin.AdminResource;
import com.quanteng.tland.cms.database.entity.Admin;
import com.quanteng.tland.cms.database.mapper.AdminMapper;
import com.quanteng.tland.cms.pojo.admin.domain.AdminVo;
import com.quanteng.tland.cms.pojo.admin.request.AddAdminRequest;
import com.quanteng.tland.cms.pojo.admin.request.ModifyPasswordReq;
import com.quanteng.tland.cms.pojo.admin.request.QueryAdminByConditionRequest;
import com.quanteng.tland.cms.pojo.admin.request.UpdateAdminRequest;
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
 * <管理员资源接口实现>
 *
 * @author zhengbinggui
 * @version 2018/5/11
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class AdminResourceImpl implements AdminResource
{
	@Autowired
	private AdminMapper adminMapper;

	/**
	 * 添加管理员信息
	 *
	 * @param addAdminRequest
	 * @return
	 */
	@Override
	public Result add (@RequestBody AddAdminRequest addAdminRequest)
	{
		if (null == addAdminRequest || null == addAdminRequest.getAdminVo ())
		{
			return new Result ().failure ("illega params");
		}

		i ("ADMIN", "add", LOG_TYPE_REQUEST, addAdminRequest);

		Admin admin = new Admin ();
		String adminId = GenerateSequenceID.getSeqID ();
		BeanUtils.copyProperties (addAdminRequest.getAdminVo (), admin);
		admin.setAdminId (adminId);
		int flag = adminMapper.add (admin);
		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("add admin failed.");
		}
	}

	/**
	 * 修改管理员信息
	 *
	 * @param updateAdminRequest
	 * @return
	 */
	@Override
	public Result update (@RequestBody UpdateAdminRequest updateAdminRequest)
	{
		if (null == updateAdminRequest || null == updateAdminRequest.getAdminVo ())
		{
			return new Result ().failure ("illega params");
		}

		if (StringUtils.isEmpty (updateAdminRequest.getAdminVo ().getAdminId ()))
		{
			return new Result ().failure ("adminId illega params");
		}

		i ("ADMIN", "update", LOG_TYPE_REQUEST, updateAdminRequest);

		Admin admin = new Admin ();
		BeanUtils.copyProperties (updateAdminRequest.getAdminVo (), admin);
		int flag = adminMapper.modify (admin);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("update admin failed.");
		}
	}

	/**
	 * 多条件查询员工信息
	 *
	 * @param queryAdminByConditionRequest
	 * @return
	 */
	@Override
	public Result<List<AdminVo>> queryByCondition (
			@RequestBody QueryAdminByConditionRequest queryAdminByConditionRequest)
	{
		if (null == queryAdminByConditionRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("ADMIN", "queryByCondition", LOG_TYPE_REQUEST, queryAdminByConditionRequest);

		Result<List<AdminVo>> result = new Result<> ();

		Map<String, Object> params = new HashMap<> ();

		if (! StringUtils.isEmpty (queryAdminByConditionRequest.getAdminName ()))
		{
			params.put ("adminName", queryAdminByConditionRequest.getAdminName ());
		}
		if (! StringUtils.isEmpty (queryAdminByConditionRequest.getEnglishName ()))
		{
			params.put ("englishName", queryAdminByConditionRequest.getEnglishName ());
		}
		if (! StringUtils.isEmpty (queryAdminByConditionRequest.getUserType ()))
		{
			params.put ("userType", queryAdminByConditionRequest.getUserType ());
		}
		if (null != queryAdminByConditionRequest.getPageIndex () && null != queryAdminByConditionRequest.getPageSize ())
		{
			params.put (DATA_PAGE_START,
					(queryAdminByConditionRequest.getPageIndex () - 1) * queryAdminByConditionRequest.getPageSize ());
			params.put (DATA_PAGE_SIZE, queryAdminByConditionRequest.getPageSize ());
		}

		List<Admin> admins = adminMapper.queryList (params);

		if (! CollectionUtils.isEmpty (admins))
		{
			List<AdminVo> adminVos = Lists.newArrayList ();
			admins.forEach (admin -> {
				AdminVo adminVo = new AdminVo ();
				BeanUtils.copyProperties (admin, adminVo);
				adminVos.add (adminVo);
			});
			result.setData (adminVos);
			result.setTotalCount (adminMapper.queryCount (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 根据帐号查询
	 *
	 * @param adminAccount
	 * @return
	 */
	@Override
	public Result<AdminVo> findByAccount (@PathVariable ("account") String adminAccount)
	{
		if (StringUtils.isEmpty (adminAccount))
		{
			return new Result ().failure ("illega params");
		}
		Result<AdminVo> result = new Result<> ();

		Admin admin = adminMapper.findAdminByAccount (adminAccount);
		AdminVo adminVo = new AdminVo ();
		BeanUtils.copyProperties (admin, adminVo);
		result.success (adminVo);
		return result;
	}

	/**
	 * 根据 id 移除该管理员
	 *
	 * @param adminId
	 * @return
	 */
	@Override
	public Result<String> removeAdmin (@PathVariable ("adminId") String adminId)
	{
		if (StringUtils.isEmpty (adminId))
		{
			return new Result ().failure ("id illega params");
		}

		int flag = adminMapper.removeAdmin (adminId);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("delete admin failed.");
		}
	}

	/**
	 * 修改用户密码
	 *
	 * @param modifyPasswordReq
	 * @return
	 */
	@Override
	public Result<String> modifyPwd (@RequestBody ModifyPasswordReq modifyPasswordReq)
	{
		if (null == modifyPasswordReq)
		{
			return new Result ().failure ("illega params");
		}

		i ("ADMIN", "modifyPwd", LOG_TYPE_REQUEST, modifyPasswordReq);

		int flag = adminMapper.modifyAdminPassword (modifyPasswordReq.getAdminId (), modifyPasswordReq.getPassword (),
				modifyPasswordReq.getOldPassword ());

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("update admin failed.");
		}
	}
}
