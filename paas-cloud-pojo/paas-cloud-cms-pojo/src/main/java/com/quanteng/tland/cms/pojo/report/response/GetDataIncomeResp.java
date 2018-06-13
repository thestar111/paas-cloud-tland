/**
 * 文 件 名:  GetDataIncomeResp
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/1/11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.report.response;

import com.quanteng.tland.cms.pojo.report.domain.DataIncomeDto;
import com.quanteng.tland.common.domain.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 查询imcome列表返回
 *
 * @author LJun
 * @version 2018/1/11
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class GetDataIncomeResp extends Result
{
	/**
	 * income实体
	 **/
	private List<DataIncomeDto> dataIncomeDtoList;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetDataIncomeResp{");
		sb.append ("dataIncomeDtoList=").append (dataIncomeDtoList);
		sb.append ('}');
		return sb.toString ();
	}
}
