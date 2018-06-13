/**
 * 文 件 名:  BundleResource
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/3 0003
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.bundle;

import com.quanteng.tland.cms.pojo.bundle.domain.BundleVo;
import com.quanteng.tland.cms.pojo.bundle.request.CreateBundleRequest;
import com.quanteng.tland.cms.pojo.bundle.request.ModifyBundleRequest;
import com.quanteng.tland.cms.pojo.bundle.request.QueryBundleConditionRequest;
import com.quanteng.tland.cms.pojo.bundle.response.QueryBundleConditionResponse;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <套餐信息管理资源接口>
 *
 * @author zping
 * @version 2018/5/3 0003
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/bundle")
public interface BundleResource
{

	/**
	 * 创建套餐
	 *
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result createBundle (@RequestBody CreateBundleRequest createBundleRequest);

	/**
	 * 修改套餐
	 *
	 * @return
	 */
	@RequestMapping (value = "/modify", method = RequestMethod.PUT)
	Result modifyBundle (@RequestBody ModifyBundleRequest modifyBundleRequest);

	/**
	 * 根据套餐编号查询套餐信息 供平台使用
	 *
	 * @param bundleId
	 * @return
	 */
	@RequestMapping (value = "/manage/id/{bundleId}", method = RequestMethod.GET)
	Result<BundleVo> findBundleById (@PathVariable ("bundleId") String bundleId);

	/**
	 * 根据套餐编号查询套餐信息 供客户端使用
	 *
	 * @param bundleId
	 * @return
	 */
	@RequestMapping (value = "/portal/id/{bundleId}", method = RequestMethod.GET)
	Result<BundleVo> queryBundleById (@PathVariable ("bundleId") String bundleId);

	/**
	 * 多条件查询套餐信息
	 *
	 * @param queryBundleConditionRequest
	 * @return
	 */
	@RequestMapping (value = "/queryBundlesByCondition", method = RequestMethod.POST)
	Result<List<BundleVo>> queryBundlesByCondition (
			@RequestBody QueryBundleConditionRequest queryBundleConditionRequest);

	/**
	 * 删除套餐信息
	 *
	 * @param bundleId
	 * @return
	 */
	@RequestMapping (value = "/{bundleId}", method = RequestMethod.DELETE)
	Result<String> deleteBundle (@PathVariable ("bundleId") String bundleId);
}
