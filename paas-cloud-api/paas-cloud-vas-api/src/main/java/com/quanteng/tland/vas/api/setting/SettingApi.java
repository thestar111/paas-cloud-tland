/**
 * 文 件 名:  SettingApi
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.setting;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.pojo.setting.domain.LocalLanguage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <定义配置Api>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/syseting")
public interface SettingApi
{
	/**
	 * 国际化支持多语言查询
	 * 供客户端查询平台支持的国际化语言查询
	 *
	 * @return
	 */
	@GET
	@Path ("/local")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<LocalLanguage>> queryLocalLanguage ();
}
