/**
 * 文 件 名:  QryNotInRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/10
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <查询不在应用分类下的应用信息>
 *
 * @author zhengbinggui
 * @version 2017/8/10
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QryAppNotInCatalogRequest extends BasePageRequest
{
	/**
	 * 分类编号
	 */
	private String catalogId;
	/**
	 * 应用名称
	 */
	private String appName;

	/**
	 * 分类关系类型 1 : 首页广告  2 : 分类页广告  3：首页应用   4 ： 热门分类类型  5 : 应用类型  6 : 轮播广告类型
	 */
	private Integer type;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QryAppNotInCatalogRequest{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", type=").append (type);
		sb.append ('}');
		return sb.toString ();
	}
}