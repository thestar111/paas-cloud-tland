/**
 * 文 件 名:  QueryPromotionAdsByTypeRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.catalogrelation.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <查询营销广告信息请求>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryPromotionAdsByTypeRequest extends BaseRequest
{
	/**
	 * 分类关系类型 1 : 首页广告  2 : 分类页广告  3：首页应用  4：分类  5 ： 推荐营销类型"
	 */
	private Integer type;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("QueryPromotionAdsByTypeRequest{");
		sb.append ("type='").append (type).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
