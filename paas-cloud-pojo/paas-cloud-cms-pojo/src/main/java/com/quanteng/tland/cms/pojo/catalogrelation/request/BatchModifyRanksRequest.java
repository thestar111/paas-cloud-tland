/**
 * 文 件 名:  BatchUpdateRanksRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/22
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
 * <批量修改栏目关系排序顺序>
 *
 * @author chenJian
 * @version 2017/8/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class BatchModifyRanksRequest extends BaseRequest
{
	/**
	 * 栏目关系批量修改
	 */
	private List<CatalogRelationVo> catalogRelations;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BatchUpdateRanksRequest{");
		sb.append ("catalogRelations=").append (catalogRelations);
		sb.append ('}');
		return sb.toString ();
	}
}