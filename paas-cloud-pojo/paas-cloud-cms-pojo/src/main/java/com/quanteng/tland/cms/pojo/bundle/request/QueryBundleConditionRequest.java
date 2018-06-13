/**
 * 文 件 名:  QueryBundleConditionRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundle.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryBundleConditionRequest extends BasePageRequest
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
		final StringBuilder sb = new StringBuilder ("QueryBundleConditionRequest{");
		sb.append ("bundleName='").append (bundleName).append ('\'');
		sb.append (", bundleType='").append (bundleType).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
