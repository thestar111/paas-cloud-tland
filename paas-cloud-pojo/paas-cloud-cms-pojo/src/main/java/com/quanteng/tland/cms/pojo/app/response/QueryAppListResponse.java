/**
 * 文 件 名:  QueryAppListResponse
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.app.response;

import com.quanteng.tland.cms.pojo.app.domain.AppsVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author huangsongbo
 * @version 2017/8/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryAppListResponse
{
	private List<AppsVo> appsList;

	private int totalCount;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryAppListResponse{");
		sb.append ("appsList=").append (appsList);
		sb.append (", totalCount=").append (totalCount);
		sb.append ('}');
		return sb.toString ();
	}
}
