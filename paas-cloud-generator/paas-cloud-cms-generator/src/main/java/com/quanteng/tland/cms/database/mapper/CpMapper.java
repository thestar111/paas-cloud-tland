/**
 * 文 件 名:  AdminMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Cp;
import com.quanteng.tland.cms.database.entity.CpLang;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <合作伙伴实体>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface CpMapper
{

	/**
	 * 添加CP信息
	 *
	 * @param cp
	 * @return
	 */
	int add (Cp cp);

	/**
	 * 添加CP多语言信息
	 *
	 * @param cpLangs
	 * @return
	 */
	int addCpLang (List<CpLang> cpLangs);

	/**
	 * 修改CP信息
	 *
	 * @param cp
	 * @return
	 */
	int modify (Cp cp);

	/**
	 * 修改CP信息
	 *
	 * @param cpLangs
	 * @return
	 */
	int modifyCpLang (List<CpLang> cpLangs);

	/**
	 * 修改CP状态信息
	 *
	 * @param status
	 * @param cpIds
	 * @return
	 */
	int modifyCpStatus (@Param ("status") String status, @Param ("cpIds") List<String> cpIds);

	/**
	 * 根据状态查询CP信息
	 *
	 * @param cpStatus
	 * @param language
	 * @return
	 */
	List<Cp> queryCpInfos (@Param ("status") String cpStatus, @Param ("language") String language);

	/**
	 * 多条件查询CP信息
	 *
	 * @param params
	 * @return
	 */
	List<Cp> queryCpByCondition (Map<String, Object> params);

	/**
	 * 多条件查询CP信息总数
	 *
	 * @param params
	 * @return
	 */
	int queryCountByCondition (Map<String, Object> params);

	/**
	 * 根据cpId查询  供平台查询
	 *
	 * @param cpId
	 * @return
	 */
	Cp queryCpInfoById (String cpId);

	/**
	 * 根据cpId查询多语言信息  供平台查询
	 *
	 * @param cpId
	 * @return
	 */
	List<CpLang> queryCpLangById (String cpId);

	/**
	 * 根据cpId删除Cp  供平台查询
	 *
	 * @param cpId
	 * @return
	 */
	int deleteCpById (String cpId);

	/**
	 * 根据cpId删除Cp多语言 供平台查询
	 *
	 * @param cpId
	 * @return
	 */
	int deleteCpLangById (String cpId);

	/**
	 * 重置密码
	 *
	 * @param params
	 * @return
	 */
	int modifyPwd (Map<String, Object> params);
}
