/**
 * 文 件 名:  Language
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/27 0027
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.common.thread;

/**
 * <语言环境本地变量>
 *
 * @author zping
 * @version 2018/4/27 0027
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Language
{
	/**
	 * 语言环境选项
	 */
	private static final ThreadLocal<String> languageEnv = new ThreadLocal<String> ();

	/**
	 * 获取语言环境
	 *
	 * @return
	 */
	public static String getLanguage ()
	{
		return languageEnv.get ();
	}

	/**
	 * 设置语言环境
	 *
	 * @param language
	 */
	public static void setLanguage (String language)
	{
		languageEnv.set (language);
	}
}
