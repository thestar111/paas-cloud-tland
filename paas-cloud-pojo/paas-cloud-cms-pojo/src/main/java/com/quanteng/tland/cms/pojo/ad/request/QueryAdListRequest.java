/**
 * 文 件 名:  QueryAdListRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.ad.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <查询广告列表请求>
 *
 * @author LJun
 * @version 2018/5/29
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryAdListRequest extends BasePageRequest
{
	/**
	 * 广告名称
	 */
	private  String advertisementName;


	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryAdListRequest{");
		sb.append ("advertisementName='").append (advertisementName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
