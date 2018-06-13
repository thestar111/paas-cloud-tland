/**
 * 文 件 名:  BundleApi
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.bundle;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.pojo.bundle.domain.BundleDto;
import com.quanteng.tland.vas.pojo.bundle.request.SearchBundleByIdRequest;
import com.quanteng.tland.vas.pojo.bundle.request.SearchBundleConditionRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <定义套餐类接口>
 *
 * @author LJun
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/bundle")
public interface BundleApi
{
	/**
	 * 根据套餐编号查询套餐信息 供客户端使用
	 *
	 * @param searchBundleByIdRequest
	 * @return
	 */
	@POST
	@Path ("/findBundleById")
	@Produces (MediaType.APPLICATION_JSON)
	Result<BundleDto> findBundleById (SearchBundleByIdRequest searchBundleByIdRequest);

	/**
	 * 查询套餐信息
	 * 供客户端用户查询套餐信息
	 *
	 * @return
	 */
	@GET
	@Path ("/query")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<BundleDto>> queryBundlesList ();
}
