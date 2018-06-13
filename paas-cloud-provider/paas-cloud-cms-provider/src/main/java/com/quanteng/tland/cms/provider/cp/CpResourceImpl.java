/**
 * 文 件 名:  CpResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.cp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanteng.tland.cms.api.cp.CpResource;
import com.quanteng.tland.cms.database.entity.Cp;
import com.quanteng.tland.cms.database.entity.CpLang;
import com.quanteng.tland.cms.database.mapper.CpMapper;
import com.quanteng.tland.cms.pojo.cp.domain.CpInfoLangVo;
import com.quanteng.tland.cms.pojo.cp.domain.CpInfoVo;
import com.quanteng.tland.cms.pojo.cp.request.*;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.thread.Language;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.*;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <CP资源接口实现>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class CpResourceImpl implements CpResource
{

	@Autowired
	private CpMapper cpMapper;

	/**
	 * 添加CP信息
	 *
	 * @param createPartnerRequest
	 * @return
	 */
	@Override
	public Result<String> addPartner (@RequestBody CreatePartnerRequest createPartnerRequest)
	{
		i ("CP", "addPartner", LOG_TYPE_REQUEST, createPartnerRequest);
		if (null == createPartnerRequest || null == createPartnerRequest.getCpInfo ())
		{
			return new Result<> ().failure ("add cp failed.");
		}
		Cp cp = new Cp ();
		BeanUtils.copyProperties (createPartnerRequest.getCpInfo (), cp);
		int flag = cpMapper.add (cp);
		i ("CP", "addPartner : addCp", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			List<CpInfoLangVo> cpInfoLangVos = createPartnerRequest.getCpInfo ().getCpInfoLangs ();
			if (! CollectionUtils.isEmpty (cpInfoLangVos))
			{
				List<CpLang> cpLangs = Lists.newArrayList ();
				CpLang cpLang = null;
				for (CpInfoLangVo cpInfoLangVo : cpInfoLangVos)
				{
					cpLang = new CpLang ();
					BeanUtils.copyProperties (cpInfoLangVo, cpLang);
					cpLangs.add (cpLang);
				}
				flag = cpMapper.addCpLang (cpLangs);
				i ("CP", "addPartner : addCpLang", LOG_TYPE_RESPONSE, flag);
				if (0 < flag)
				{
					return new Result<> ().success ();
				}
				else
				{
					return new Result<> ().failure ("add cp failed.");
				}
			}
			else
			{
				return new Result<> ().success ();
			}
		}
		else
		{
			return new Result<> ().failure ("add cp failed.");
		}
	}

	/**
	 * 修改CP信息
	 *
	 * @param modifyPartnerRequest
	 * @return
	 */
	@Override
	public Result<String> modifyPartner (@RequestBody ModifyPartnerRequest modifyPartnerRequest)
	{
		i ("CP", "modifyPartner", LOG_TYPE_REQUEST, modifyPartnerRequest);
		if (null == modifyPartnerRequest || null == modifyPartnerRequest.getCpInfo ())
		{
			return new Result<> ().failure ("modify cp failed.");
		}
		Cp cp = new Cp ();
		BeanUtils.copyProperties (modifyPartnerRequest.getCpInfo (), cp);
		int flag = cpMapper.modify (cp);
		i ("CP", "modifyPartner : modify", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			List<CpInfoLangVo> cpInfoLangVos = modifyPartnerRequest.getCpInfo ().getCpInfoLangs ();
			if (! CollectionUtils.isEmpty (cpInfoLangVos))
			{
				List<CpLang> cpLangs = Lists.newArrayList ();
				CpLang cpLang = null;
				for (CpInfoLangVo cpInfoLangVo : cpInfoLangVos)
				{
					cpLang = new CpLang ();
					BeanUtils.copyProperties (cpInfoLangVo, cpLang);
					cpLangs.add (cpLang);
				}
				flag = cpMapper.modifyCpLang (cpLangs);
				i ("CP", "modifyPartner : modifyCpLang", LOG_TYPE_RESPONSE, flag);
				if (0 < flag)
				{
					return new Result<> ().success ();
				}
				else
				{
					return new Result<> ().failure ("modify cp failed.");
				}
			}
			else
			{
				return new Result<> ().success ();
			}
		}
		else
		{
			return new Result<> ().failure ("modify cp failed.");
		}
	}

	/**
	 * 修改CP状态信息
	 *
	 * @param modifyPartnerStatusRequest
	 * @return
	 */
	@Override
	public Result<String> modifyPartnerStatus (@RequestBody ModifyPartnerStatusRequest modifyPartnerStatusRequest)
	{
		if (null == modifyPartnerStatusRequest || CollectionUtils.isEmpty (modifyPartnerStatusRequest.getPartnerIds ()))
		{
			return new Result<> ().failure ("id illega params.");
		}

		if (StringUtils.isEmpty (modifyPartnerStatusRequest.getStatus ()))
		{
			return new Result<> ().failure ("status illega params.");
		}
		i ("CP", "modifyPartnerStatus", LOG_TYPE_REQUEST, modifyPartnerStatusRequest);
		int flag = cpMapper
				.modifyCpStatus (modifyPartnerStatusRequest.getStatus (), modifyPartnerStatusRequest.getPartnerIds ());
		i ("CP", "modifyPartnerStatus", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("change cp status failed.");
		}
	}

	/**
	 * 查询cp列表
	 *
	 * @param queryCpConditionRequest
	 * @return
	 */
	@Override
	public Result<List<CpInfoVo>> queryCpByCondition (@RequestBody QueryCpConditionRequest queryCpConditionRequest)
	{
		i ("CP", "queryCpByCondition", LOG_TYPE_REQUEST, queryCpConditionRequest);
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (queryCpConditionRequest.getCpName ()))
		{
			params.put ("cpName", queryCpConditionRequest.getCpName ());
		}

		if (! StringUtils.isEmpty (queryCpConditionRequest.getStatus ()))
		{
			params.put ("status", queryCpConditionRequest.getStatus ());
		}

		if (null != queryCpConditionRequest.getType ())
		{
			params.put ("type", queryCpConditionRequest.getType ());
		}

		params.put (DATA_PAGE_START,
				(queryCpConditionRequest.getPageIndex () - 1) * queryCpConditionRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, queryCpConditionRequest.getPageSize ());
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		i ("CP", "queryCpByCondition", LOG_TYPE_REQUEST, params);
		List<Cp> cps = cpMapper.queryCpByCondition (params);
		i ("CP", "queryCpByCondition", LOG_TYPE_RESPONSE, cps);

		Result<List<CpInfoVo>> result = new Result<List<CpInfoVo>> ();
		List<CpInfoVo> cpInfoVos = null;
		if (! CollectionUtils.isEmpty (cps))
		{
			cpInfoVos = Lists.newArrayList ();
			CpInfoVo cpInfoVo = null;
			for (Cp cp : cps)
			{
				cpInfoVo = new CpInfoVo ();
				BeanUtils.copyProperties (cp, cpInfoVo);
				cpInfoVos.add (cpInfoVo);
			}
			result.setData (cpInfoVos);
			result.setTotalCount (cpMapper.queryCountByCondition (params));
		}

		i ("CP", "queryCpByCondition", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 查询CP信息 供平台使用
	 *
	 * @param cpId
	 * @return
	 */
	@Override
	public Result<CpInfoVo> queryCpInfoById (@PathVariable ("cpId") String cpId)
	{
		i ("CP", "queryCpInfoById", LOG_TYPE_REQUEST, cpId);

		if (StringUtils.isEmpty (cpId))
		{
			return new Result<CpInfoVo> ().failure ("cpId illega params");
		}
		Cp cp = cpMapper.queryCpInfoById (cpId);
		i ("CP", "queryCpInfoById", LOG_TYPE_RESPONSE, cp);
		CpInfoVo cpInfoVo = null;
		if (null != cp)
		{
			cpInfoVo = new CpInfoVo ();
			BeanUtils.copyProperties (cp, cpInfoVo);
			List<CpLang> cpLangs = cpMapper.queryCpLangById (cpId);
			i ("CP", "queryCpInfoById", LOG_TYPE_RESPONSE, cpLangs);
			if (! CollectionUtils.isEmpty (cpLangs))
			{
				List<CpInfoLangVo> cpInfoLangVos = Lists.newArrayList ();
				CpInfoLangVo cpInfoLangVo = null;
				for (CpLang cpLang : cpLangs)
				{
					cpInfoLangVo = new CpInfoLangVo ();
					BeanUtils.copyProperties (cpLang, cpInfoLangVo);
					cpInfoLangVos.add (cpInfoLangVo);
				}
				cpInfoVo.setCpInfoLangs (cpInfoLangVos);
			}
		}
		return new Result<> ().success (cpInfoVo);
	}

	/**
	 * 根据Id删除cp 供平台使用
	 *
	 * @param cpId
	 * @return
	 */
	@Override
	public Result deleteCpInfoById (@PathVariable ("cpId") String cpId)
	{
		i ("CP", "deleteCpInfoById", LOG_TYPE_REQUEST, cpId);
		if (StringUtils.isEmpty (cpId))
		{
			return new Result<CpInfoVo> ().failure ("cpId is null");
		}

		int falg = cpMapper.deleteCpById (cpId);
		//定义返回结果集
		Result result = new Result ();
		if (0 < falg)
		{
			int langFalg = cpMapper.deleteCpLangById (cpId);
			if (0 < langFalg)
			{
				result.setResultMessage ("delete success");
			}
			else
			{
				result.setResultCode (Constants.ResultCode.FAILED);
				result.setResultMessage ("delete CpLang fail");
			}

		}
		else
		{
			result.setResultCode (Constants.ResultCode.FAILED);
			result.setResultMessage ("delete Cp fail");
		}
		i ("CP", "deleteCpInfoById", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 重置密码
	 *
	 * @param resetPwdRequest
	 * @return
	 */
	@Override
	public Result resetPwd (@RequestBody ResetPwdRequest resetPwdRequest)
	{
		i ("CP", "resetPwd", LOG_TYPE_REQUEST, resetPwdRequest);
		if (null == resetPwdRequest)
		{
			return new Result<> ().failure ("resetPwdRequest is null.");
		}
		if (StringUtils.isEmpty (resetPwdRequest.getCpId ()))
		{
			return new Result<> ().failure ("CpId is null.");
		}
		if (StringUtils.isEmpty (resetPwdRequest.getPassword ()))
		{
			return new Result<> ().failure ("Password is null.");
		}

		Map<String, Object> params = Maps.newHashMap ();
		params.put ("cpId", resetPwdRequest.getCpId ());
		params.put ("newPassword", resetPwdRequest.getPassword ());
		i ("CP", "resetPwd", LOG_TYPE_REQUEST, params);
		int flag = cpMapper.modifyPwd (params);
		i ("CP", "resetPwd", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("resetPwd failed.");
		}
	}

	/**
	 * 修改密码
	 *
	 * @param modifyCpPwdRequest
	 * @return
	 */
	@Override
	public Result modifyPwd (@RequestBody ModifyCpPwdRequest modifyCpPwdRequest)
	{
		i ("CP", "modifyPwd", LOG_TYPE_REQUEST, modifyCpPwdRequest);
		if (null == modifyCpPwdRequest)
		{
			return new Result<> ().failure ("modifyCpPwdRequest is null.");
		}
		if (StringUtils.isEmpty (modifyCpPwdRequest.getCpId ()))
		{
			return new Result<> ().failure ("CpId is null.");
		}
		if (StringUtils.isEmpty (modifyCpPwdRequest.getPassword ()))
		{
			return new Result<> ().failure ("Password is null.");
		}
		if (StringUtils.isEmpty (modifyCpPwdRequest.getNewPassword ()))
		{
			return new Result<> ().failure ("NewPassword is null.");
		}

		Map<String, Object> params = Maps.newHashMap ();
		params.put ("cpId", modifyCpPwdRequest.getCpId ());
		params.put ("password", modifyCpPwdRequest.getPassword ());
		params.put ("newPassword", modifyCpPwdRequest.getNewPassword ());
		i ("CP", "modifyPwd", LOG_TYPE_REQUEST, params);
		int flag = cpMapper.modifyPwd (params);
		i ("CP", "modifyPwd", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("modifyPwd failed.");
		}
	}
}
