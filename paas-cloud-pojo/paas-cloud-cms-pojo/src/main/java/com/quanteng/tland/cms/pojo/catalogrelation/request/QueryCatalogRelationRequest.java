/**
 * 文 件 名:  QueryCatalogRelationRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/28 0028
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <查询栏目关系请求实体VO对象>
 *
 * @author zping
 * @version 2018/5/28 0028
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryCatalogRelationRequest extends BasePageRequest
{
	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 关系类型 1 : 首页广告  2 : 分类页广告  3：首页应用   4 ： 热门分类类型  5 : 应用类型  6 : 轮播广告类型
	 */
	private Integer type;
	/**
	 * 根据名称查询
	 */
	private String name;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryCatalogRelationRequest{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", type=").append (type);
		sb.append (", name='").append (name).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
