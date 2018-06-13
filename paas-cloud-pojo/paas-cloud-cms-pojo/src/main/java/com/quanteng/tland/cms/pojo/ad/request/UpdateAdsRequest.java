/**
 * 文 件 名:  UpdateAdsRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Administrator
 * 修改时间:  2017/8/8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.ad.request;

import com.quanteng.tland.cms.pojo.ad.domain.AdsVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author Administrator
 * @version 2017/8/8
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class UpdateAdsRequest extends BaseRequest
{
	private AdsVo ads;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("UpdateAdsRequest{");
		sb.append ("ads=").append (ads);
		sb.append ('}');
		return sb.toString ();
	}
}
