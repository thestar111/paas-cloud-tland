/**
 * 文 件 名:  AddColumnAppRelaInfoRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/10
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.request;

import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogRelationVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zhengbinggui
 * @version 2017/8/10
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CreateCatalogRelationRequest extends BaseRequest
{

	/**
	 * 栏目关系对象
	 */
	private List<CatalogRelationVo> catalogRelations;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CreateCatalogRelationRequest{");
		sb.append ("catalogRelation=").append (catalogRelations);
		sb.append ('}');
		return sb.toString ();
	}
}