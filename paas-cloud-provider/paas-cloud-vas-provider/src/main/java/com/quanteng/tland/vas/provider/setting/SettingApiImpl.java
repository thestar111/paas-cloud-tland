/**
 * 文 件 名:  SettingApiImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.setting;

import com.google.common.collect.Lists;
import com.quanteng.tland.cms.pojo.setting.domain.LocalVo;
import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.api.setting.SettingApi;
import com.quanteng.tland.vas.pojo.setting.domain.LocalLanguage;
import com.quanteng.tland.vas.service.setting.SettingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <定义配置Api实现类>
 *
 * @author zhengbinggui
 * @version 2018/5/18
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class SettingApiImpl implements SettingApi
{
	@Autowired
	private SettingService settingService;

	/**
	 * 国际化支持多语言查询
	 * 供客户端查询平台支持的国际化语言查询
	 *
	 * @return
	 */
	@Override
	public Result<List<LocalLanguage>> queryLocalLanguage ()
	{
		Result<List<LocalLanguage>> result = new Result<> ();

		Result<List<LocalVo>> serviceResult = settingService.queryLocal ();

		if (null != serviceResult && Constants.ResultCode.SUCCESS.equals (serviceResult.getResultCode ()))
		{
			List<LocalVo> localVos = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (localVos))
			{
				List<LocalLanguage> localLanguages = Lists.newArrayList ();
				for (LocalVo localVo : localVos)
				{
					LocalLanguage localLanguage = new LocalLanguage ();
					BeanUtils.copyProperties (localVo, localLanguage);
					localLanguages.add (localLanguage);
				}
				result.setData (localLanguages);
			}
			result.success ();
		}
		else
		{
			result.failure (null == serviceResult ? "Query local language failed" : serviceResult.getResultMessage ());
		}

		return result;
	}
}
