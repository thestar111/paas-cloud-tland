/**
 * 文 件 名:  PromotionApi
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.promotion;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.pojo.promotion.domain.CatalogPromotionDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <定义首页营销接口api>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/promotion")
public interface PromotionApi
{
	/**
	 * 查询首页展示信息
	 *
	 * @return
	 */
	@GET
	@Path ("/index")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<CatalogPromotionDto>> queryPromotionIndex ();
}
