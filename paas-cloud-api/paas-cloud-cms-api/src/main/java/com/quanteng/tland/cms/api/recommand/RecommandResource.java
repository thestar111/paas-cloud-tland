/**
 * 文 件 名:  RecommandResource
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/1/24 0024
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.recommand;

import com.quanteng.tland.cms.pojo.recommand.domain.RecommandVo;
import com.quanteng.tland.cms.pojo.recommand.request.CreateRecommandRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <游戏推荐信息资源接口>
 *
 * @author zping
 * @version 2018/1/24 0024
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/recommand")
public interface RecommandResource
{

	/**
	 * 删除推荐实体信息
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping (value = "/delete/{id}", method = RequestMethod.DELETE)
	Result<String> deleteRecommand (@PathVariable ("id") Integer id);

	/**
	 * 添加推荐实体信息
	 *
	 * @param createRecommandRequest
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result<String> addRecommand (@RequestBody CreateRecommandRequest createRecommandRequest);

	/**
	 * 查询推荐实体信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/get", method = RequestMethod.GET)
	Result<RecommandVo> queryRecommand ();
}
