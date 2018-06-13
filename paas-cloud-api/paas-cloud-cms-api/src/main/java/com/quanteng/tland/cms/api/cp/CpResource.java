/**
 * 文 件 名:  CpResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.cp;

import com.quanteng.tland.cms.pojo.cp.domain.CpInfoVo;
import com.quanteng.tland.cms.pojo.cp.request.*;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <CP资源接口>
 *
 * @author huangsongbo
 * @version 2017/8/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/partner")
public interface CpResource
{
	/**
	 * 添加CP信息
	 *
	 * @param createPartnerRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result<String> addPartner (@RequestBody CreatePartnerRequest createPartnerRequest);

	/**
	 * 修改CP信息
	 *
	 * @param modifyPartnerRequest
	 * @return
	 */
	@RequestMapping (value = "/modify", method = RequestMethod.PUT)
	Result<String> modifyPartner (@RequestBody ModifyPartnerRequest modifyPartnerRequest);

	/**
	 * 修改CP状态信息
	 *
	 * @param modifyPartnerStatusRequest
	 * @return
	 */
	@RequestMapping (value = "/changeStatus", method = RequestMethod.PUT)
	Result<String> modifyPartnerStatus (@RequestBody ModifyPartnerStatusRequest modifyPartnerStatusRequest);

	/**
	 * 查询cp列表
	 *
	 * @param queryCpConditionRequest
	 * @return
	 */
	@RequestMapping (value = "/list", method = RequestMethod.POST)
	Result<List<CpInfoVo>> queryCpByCondition (@RequestBody QueryCpConditionRequest queryCpConditionRequest);

	/**
	 * 查询CP信息 供平台使用
	 *
	 * @param cpId
	 * @return
	 */
	@RequestMapping (value = "/id/{cpId}", method = RequestMethod.GET)
	Result<CpInfoVo> queryCpInfoById (@PathVariable ("cpId") String cpId);

	/**
	 * 根据Id删除cp 供平台使用
	 *
	 * @param cpId
	 * @return
	 */
	@RequestMapping (value = "/delete/id/{cpId}", method = RequestMethod.DELETE)
	Result deleteCpInfoById (@PathVariable ("cpId") String cpId);

	/**
	 * 重置密码
	 * @param resetPwdRequest
	 * @return
	 */
	@RequestMapping (value = "/resetPwd", method = RequestMethod.PUT)
	Result resetPwd (@RequestBody  ResetPwdRequest resetPwdRequest);

	/**
	 *  修改密码
	 * @param modifyCpPwdRequest
	 * @return
	 */
	@RequestMapping (value = "/modifyPwd", method = RequestMethod.PUT)
	Result modifyPwd (@RequestBody  ModifyCpPwdRequest modifyCpPwdRequest);
}