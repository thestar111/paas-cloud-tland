/**
 * 文 件 名:  SettingsResourceImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.setting;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.setting.SettingsResource;
import com.quanteng.tland.cms.database.entity.Bundle;
import com.quanteng.tland.cms.database.entity.Local;
import com.quanteng.tland.cms.database.entity.SysConfig;
import com.quanteng.tland.cms.database.mapper.LocalMapper;
import com.quanteng.tland.cms.database.mapper.SysSettingsMapper;
import com.quanteng.tland.cms.pojo.setting.domain.ConfigBeanVo;
import com.quanteng.tland.cms.pojo.setting.domain.LocalVo;
import com.quanteng.tland.cms.pojo.setting.domain.PackageInfoVo;
import com.quanteng.tland.cms.pojo.setting.request.AddLocalRequest;
import com.quanteng.tland.cms.pojo.setting.request.ModSysParamReq;
import com.quanteng.tland.cms.pojo.setting.request.UpdateLocalRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <系统设置接口实现类>
 *
 * @author LJun
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class SettingsResourceImpl implements SettingsResource
{
	@Autowired
	private SysSettingsMapper settingsMapper;

	@Autowired
	private LocalMapper localMapper;

	/**
	 * 根据configKey查询套餐信息
	 *
	 * @param configKey
	 * @return
	 */
	@Override
	public Result<PackageInfoVo> queryPackageConfigValue (@PathVariable ("configKey") String configKey)
	{
		i ("SETTING", "queryPackage", LOG_TYPE_REQUEST, configKey);
		Bundle bundle = settingsMapper.queryPackageConfigValue (configKey);
		PackageInfoVo packageInfoVo = null;
		if (! StringUtils.isEmpty (bundle))
		{
			packageInfoVo = new PackageInfoVo ();
			BeanUtils.copyProperties (bundle, packageInfoVo);

		}
		i ("SETTING", "queryPackage", LOG_TYPE_RESPONSE, packageInfoVo);
		return new Result<> ().success (packageInfoVo);
	}

	/**
	 * 根据configKey查询配置信息
	 *
	 * @param configKey
	 * @return
	 */
	@Override
	public Result<List<ConfigBeanVo>> queryConfigValue (@PathVariable ("configKey") String configKey)
	{
		i ("SETTING", "queryConfigValue", LOG_TYPE_REQUEST, configKey);
		Map<String, Object> params = Maps.newHashMap ();
		params.put ("configKey", configKey);
		List<SysConfig> sysConfigList = settingsMapper.queryConfigValue (params);

		Result<List<ConfigBeanVo>> result = new Result<List<ConfigBeanVo>> ();
		List<ConfigBeanVo> configBeanVoList = Lists.newArrayList ();
		if (! CollectionUtils.isEmpty (sysConfigList))
		{
			sysConfigList.forEach (sysConfig -> {
				ConfigBeanVo configBeanVo = new ConfigBeanVo ();
				BeanUtils.copyProperties (sysConfig, configBeanVo);
				configBeanVoList.add (configBeanVo);
			});
			result.setData (configBeanVoList);
		}

		i ("SETTING", "queryPackage", LOG_TYPE_RESPONSE, configBeanVoList);
		result.success ();
		return result;
	}

	/**
	 * 修改配置信息
	 *
	 * @param modSysParamReq
	 * @return
	 */
	@Override
	public Result modifySysParam (@RequestBody ModSysParamReq modSysParamReq)
	{
		i ("SETTING", "modifySysParam", LOG_TYPE_REQUEST, modSysParamReq);
		if (null == modSysParamReq)
		{
			return new Result ().failure ("modifySysParam illega params");
		}

		Map<String, Object> params = Maps.newHashMap ();
		params.put ("configKey", modSysParamReq.getConfigKey ());
		params.put ("configValue", modSysParamReq.getConfigValue ());
		int flag = settingsMapper.modifyConfigValue (params);

		Result result = new Result ();
		if (0 < flag)
		{
			result.success ();
		}
		i ("SETTING", "modifySysParam", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 添加国际语言
	 *
	 * @param addLocalRequest
	 * @return
	 */
	@Override
	public Result addLocal (@RequestBody AddLocalRequest addLocalRequest)
	{
		if (null == addLocalRequest && null == addLocalRequest.getLocalVo ())
		{
			return new Result ().failure ("illega params");
		}

		i ("SETTING", "addLocal", LOG_TYPE_REQUEST, addLocalRequest);

		Local local = new Local ();
		BeanUtils.copyProperties (addLocalRequest.getLocalVo (), local);

		int flag = localMapper.add (local);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("add local failed.");
		}
	}

	/**
	 * 删除国际语言
	 *
	 * @param localId
	 * @return
	 */
	@Override
	public Result deleteLocal (@PathVariable ("localId") String localId)
	{
		if (StringUtils.isEmpty (localId))
		{
			return new Result ().failure ("id illega params");
		}

		int flag = localMapper.delete (localId);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("delete local failed.");
		}
	}

	/**
	 * 修改国际语言
	 *
	 * @param updateLocalRequest
	 * @return
	 */
	@Override
	public Result updateLocal (@RequestBody UpdateLocalRequest updateLocalRequest)
	{
		if (null == updateLocalRequest && null == updateLocalRequest.getLocalVo ())
		{
			return new Result ().failure ("illega params");
		}

		if (StringUtils.isEmpty (updateLocalRequest.getLocalVo ().getLocalId ()))
		{
			return new Result ().failure ("localId illega params");
		}

		i ("SETTING", "updateLocal", LOG_TYPE_REQUEST, updateLocalRequest);

		Local local = new Local ();
		BeanUtils.copyProperties (updateLocalRequest.getLocalVo (), local);

		int flag = localMapper.update (local);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("update local failed.");
		}
	}

	/**
	 * 根据id查国际语言
	 *
	 * @param localId
	 * @return
	 */
	@Override
	public Result<LocalVo> findLocalById (@PathVariable ("localId") String localId)
	{
		if (StringUtils.isEmpty (localId))
		{
			return new Result ().failure ("id illega params");
		}

		Result<LocalVo> result = new Result<> ();

		Local local = localMapper.findById (localId);
		LocalVo localVo = new LocalVo ();
		BeanUtils.copyProperties (local, localVo);
		result.success (localVo);
		return result;
	}

	/**
	 * 查询全部国际语言
	 *
	 * @return
	 */
	@Override
	public Result<List<LocalVo>> queryLocal ()
	{
		Result<List<LocalVo>> result = new Result<> ();

		List<Local> locals = localMapper.query ();

		if (! CollectionUtils.isEmpty (locals))
		{
			List<LocalVo> localVos = Lists.newArrayList ();
			locals.forEach (local -> {
				LocalVo localVo = new LocalVo ();
				BeanUtils.copyProperties (local, localVo);
				localVos.add (localVo);
			});
			result.setData (localVos);
		}
		result.success ();
		return result;
	}
}
