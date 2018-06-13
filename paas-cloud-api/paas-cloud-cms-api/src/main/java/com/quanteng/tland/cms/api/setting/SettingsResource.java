/**
 * 文 件 名:  SettingsResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/8/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.setting;

import com.quanteng.tland.cms.pojo.setting.domain.ConfigBeanVo;
import com.quanteng.tland.cms.pojo.setting.domain.LocalVo;
import com.quanteng.tland.cms.pojo.setting.domain.PackageInfoVo;
import com.quanteng.tland.cms.pojo.setting.request.AddLocalRequest;
import com.quanteng.tland.cms.pojo.setting.request.ModSysParamReq;
import com.quanteng.tland.cms.pojo.setting.request.UpdateLocalRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <定义系统配置接口>
 *
 * @author LJun
 * @version 2017/8/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/setting")
public interface SettingsResource
{
	/**
	 * 根据configKey查询套餐信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/package/{configKey}", method = RequestMethod.GET)
	Result<PackageInfoVo> queryPackageConfigValue (@PathVariable ("configKey") String configKey);

	/**
	 * 根据configKey查询配置信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/config/{configKey}", method = RequestMethod.GET)
	Result<List<ConfigBeanVo>> queryConfigValue (@PathVariable ("configKey") String configKey);

	/**
	 * 修改配置信息
	 *
	 * @param
	 */
	@RequestMapping (value = "/modifySysParam", method = RequestMethod.PUT)
	Result modifySysParam (@RequestBody ModSysParamReq modSysParamReq);

	/**
	 * 添加国际语言
	 *
	 * @return
	 */
	@RequestMapping (value = "/addLocal", method = RequestMethod.POST)
	Result addLocal (@RequestBody AddLocalRequest addLocalRequest);

	/**
	 * 删除国际语言
	 *
	 * @param localId
	 * @return
	 */
	@RequestMapping (value = "/deleteLocal/{localId}", method = RequestMethod.DELETE)
	Result deleteLocal (@PathVariable ("localId") String localId);

	/**
	 * 修改国际语言
	 *
	 * @param updateLocalRequest
	 * @return
	 */
	@RequestMapping (value = "/updateLocal", method = RequestMethod.PUT)
	Result updateLocal (@RequestBody UpdateLocalRequest updateLocalRequest);

	/**
	 * 根据id查国际语言
	 *
	 * @param localId
	 * @return
	 */
	@RequestMapping (value = "/findLocalById/{localId}", method = RequestMethod.GET)
	Result<LocalVo> findLocalById (@PathVariable ("localId") String localId);

	/**
	 * 查询全部国际语言
	 *
	 * @return
	 */
	@RequestMapping (value = "/queryLocal", method = RequestMethod.GET)
	Result<List<LocalVo>> queryLocal ();
}
