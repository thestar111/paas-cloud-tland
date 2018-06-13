/**
 * 文 件 名:  QueryBundleConditionResponse
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundle.response;

import com.quanteng.tland.cms.pojo.bundle.domain.BundleVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
public class QueryBundleConditionResponse
{
	/**
	 * 套餐信息
	 */
	private List<BundleVo> bundles;
	/**
	 * 总数
	 */
	private int total;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryBundleConditionResponse{");
		sb.append ("bundles=").append (bundles);
		sb.append (", total=").append (total);
		sb.append ('}');
		return sb.toString ();
	}
}
