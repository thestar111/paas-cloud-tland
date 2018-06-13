/**
 * 文 件 名:  SearchBundleByIdRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.bundle.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 根据Id查询套餐信息请求
 *
 * @author LJun
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class SearchBundleByIdRequest extends BaseRequest
{
	/**
	 * 套餐Id
	 */
	private  String bundleId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("SearchBundleByIdRequest{");
		sb.append ("bundleId='").append (bundleId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
