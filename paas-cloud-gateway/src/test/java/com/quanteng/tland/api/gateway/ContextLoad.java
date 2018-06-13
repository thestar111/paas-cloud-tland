/**
 * 文 件 名:  ContextLoad
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/6/1 0001
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway;

import com.quanten.core.utils.Coder;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/6/1 0001
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ContextLoad
{
	public static void main (String[] args) throws Exception
	{
		long timestamp = System.currentTimeMillis ();
		System.out.println (timestamp);
		System.out.println (Coder.encryptBASE64 (
				Coder.encryptMD5 (("c9b98cf884d641beaa03756beb067ce0" + timestamp + "c9b98cf884d641beaa03756beb067ce0")
						.getBytes ())));
	}
}
