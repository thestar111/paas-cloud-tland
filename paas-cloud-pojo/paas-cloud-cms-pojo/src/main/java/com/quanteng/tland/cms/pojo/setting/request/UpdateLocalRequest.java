/**
 * 文 件 名:  UpdateLocalRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.setting.request;

import com.quanteng.tland.cms.pojo.setting.domain.LocalVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <修改国际语言>
 *
 * @author zhengbinggui
 * @version 2018/5/18
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class UpdateLocalRequest extends BaseRequest
{
	/**
	 * 国际语言信息
	 */
	private LocalVo localVo;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("UpdateLocalRequest{");
		sb.append ("localVo=").append (localVo);
		sb.append ('}');
		return sb.toString ();
	}
}
