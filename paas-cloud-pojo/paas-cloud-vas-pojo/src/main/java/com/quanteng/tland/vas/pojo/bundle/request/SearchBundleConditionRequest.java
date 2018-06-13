/**
 * 文 件 名:  SearchBundleConditionRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.bundle.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 多条件查询套餐信息请求>
 *
 * @author LJun
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class SearchBundleConditionRequest extends BasePageRequest
{
	/**
	 * 套餐名称
	 */
	private String bundleName;
	/**
	 * 套餐类型
	 */
	private String bundleType;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("SearchBundleConditionRequest{");
		sb.append ("bundleName='").append (bundleName).append ('\'');
		sb.append (", bundleType='").append (bundleType).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
