/**
 * 文 件 名:  CreateRecommandRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/1/24 0024
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.recommand.request;

import com.quanteng.tland.cms.pojo.recommand.domain.RecommandVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/1/24 0024
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CreateRecommandRequest extends BaseRequest
{

	/**
	 * 推荐实体信息
	 */
	private RecommandVo recommand;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CreateRecommandRequest{");
		sb.append ("recommand=").append (recommand);
		sb.append ('}');
		return sb.toString ();
	}
}
