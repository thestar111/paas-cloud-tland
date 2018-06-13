/**
 * 文 件 名:  BatchModifyAppStatusResponse
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/25
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.app.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <批量修改应用状态返回>
 *
 * @author LJun
 * @version 2018/5/25
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BatchModifyAppStatusResponse implements Serializable
{

	/**
	 * 操作成功列表
	 */
	private List<String> successList;
	/**
	 * 操作失败列表
	 */
	private List<String> faildList;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BatchModifyAppStatusResponse{");
		sb.append ("successList=").append (successList);
		sb.append (", faildList=").append (faildList);
		sb.append ('}');
		return sb.toString ();
	}
}
