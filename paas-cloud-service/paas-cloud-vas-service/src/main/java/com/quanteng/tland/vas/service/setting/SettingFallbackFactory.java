/**
 * 文 件 名:  SettingFallbackFactory
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.setting;

import com.quanteng.tland.cms.pojo.setting.domain.ConfigBeanVo;
import com.quanteng.tland.cms.pojo.setting.domain.LocalVo;
import com.quanteng.tland.cms.pojo.setting.domain.PackageInfoVo;
import com.quanteng.tland.cms.pojo.setting.request.AddLocalRequest;
import com.quanteng.tland.cms.pojo.setting.request.ModSysParamReq;
import com.quanteng.tland.cms.pojo.setting.request.UpdateLocalRequest;
import com.quanteng.tland.common.domain.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.quanteng.tland.common.log.TlandLogger.e;

/**
 * <定义配置Api服务降级实现>
 *
 * @author zhengbinggui
 * @version 2018/5/18
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class SettingFallbackFactory implements FallbackFactory<SettingService>
{
	@Override
	public SettingService create (Throwable throwable)
	{

		return new SettingService ()
		{
			/**
			 * 根据configKey查询套餐信息
			 *
			 * @param configKey
			 * @return
			 */
			@Override
			public Result<PackageInfoVo> queryPackageConfigValue (String configKey)
			{
				return null;
			}

			/**
			 * 根据configKey查询配置信息
			 *
			 * @param configKey
			 * @return
			 */
			@Override
			public Result<List<ConfigBeanVo>> queryConfigValue (String configKey)
			{
				return null;
			}

			/**
			 * 修改配置信息
			 *
			 * @param modSysParamReq
			 */
			@Override
			public Result modifySysParam (ModSysParamReq modSysParamReq)
			{
				return null;
			}

			/**
			 * 添加国际语言
			 *
			 * @param addLocalRequest
			 * @return
			 */
			@Override
			public Result addLocal (AddLocalRequest addLocalRequest)
			{
				return null;
			}

			/**
			 * 删除国际语言
			 *
			 * @param localId
			 * @return
			 */
			@Override
			public Result deleteLocal (String localId)
			{
				return null;
			}

			/**
			 * 修改国际语言
			 *
			 * @param updateLocalRequest
			 * @return
			 */
			@Override
			public Result updateLocal (UpdateLocalRequest updateLocalRequest)
			{
				return null;
			}

			/**
			 * 根据id查国际语言
			 *
			 * @param localId
			 * @return
			 */
			@Override
			public Result<LocalVo> findLocalById (String localId)
			{
				return null;
			}

			/**
			 * 查询全部国际语言
			 *
			 * @return
			 */
			@Override
			public Result<List<LocalVo>> queryLocal ()
			{
				e ("SETTING", "queryLocal", "Cms Service Not Available");
				return new Result ().failure ("Setting Service not Available");
			}
		};
	}
}
