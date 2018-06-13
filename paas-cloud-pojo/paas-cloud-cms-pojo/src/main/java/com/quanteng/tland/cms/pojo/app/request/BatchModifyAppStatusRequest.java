/**
 * 文 件 名:  BatchModifyAppStatusRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/25
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.app.request;

import com.quanteng.tland.cms.pojo.app.domain.AppModel;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <修改应用状态请求>
 *
 * @author LJun
 * @version 2018/5/25
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class BatchModifyAppStatusRequest extends BaseRequest
{
	/**
	 * 应用列表
	 */
	private List<AppModel> appModels;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BatchModifyAppStatusRequest{");
		sb.append ("appModels=").append (appModels);
		sb.append ('}');
		return sb.toString ();
	}
}
