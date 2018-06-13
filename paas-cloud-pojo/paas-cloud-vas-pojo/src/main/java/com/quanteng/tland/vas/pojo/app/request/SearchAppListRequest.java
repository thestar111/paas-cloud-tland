/**
 * 文 件 名:  SearchAppListRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.app.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <多条件查询app列表请求>
 *
 * @author LJun
 * @version 2018/5/11
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class SearchAppListRequest extends BaseRequest
{
	/**
	 * 应用名
	 */
	private String appName;

	/**
	 * 应用英文名
	 */
	private String englishName;
	/**
	 * 应用状态
	 */
	private String appStatus;
	/**
	 * 栏目ID
	 */
	private String columnId;
	/**
	 * 合作伙伴ID
	 */
	private String cpId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("SearchAppListRequest{");
		sb.append ("appName='").append (appName).append ('\'');
		sb.append (", englishName='").append (englishName).append ('\'');
		sb.append (", appStatus='").append (appStatus).append ('\'');
		sb.append (", columnId='").append (columnId).append ('\'');
		sb.append (", cpId='").append (cpId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
