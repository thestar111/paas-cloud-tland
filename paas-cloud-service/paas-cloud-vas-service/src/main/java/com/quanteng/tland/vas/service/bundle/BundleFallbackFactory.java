/**
 * 文 件 名:  BundleFallbackFactory
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.bundle;

import com.quanteng.tland.cms.pojo.bundle.domain.BundleVo;
import com.quanteng.tland.cms.pojo.bundle.request.CreateBundleRequest;
import com.quanteng.tland.cms.pojo.bundle.request.ModifyBundleRequest;
import com.quanteng.tland.cms.pojo.bundle.request.QueryBundleConditionRequest;
import com.quanteng.tland.common.domain.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <套餐服务熔断降级>
 *
 * @author LJun
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class BundleFallbackFactory implements FallbackFactory<BundleServcie>
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (BundleFallbackFactory.class);

	@Override
	public BundleServcie create (Throwable throwable)
	{
		LOGGER.error (String.format ("Cms Service Not Avialable : %s", throwable.getMessage ()));
		return new BundleServcie ()
		{
			/**
			 *  创建套餐
			 * @param createBundleRequest
			 * @return
			 */
			@Override
			public Result<String> createBundle (CreateBundleRequest createBundleRequest)
			{
				return null;
			}

			/**
			 * 修改套餐
			 * @param modifyBundleRequest
			 * @return
			 */
			@Override
			public Result<String> modifyBundle (ModifyBundleRequest modifyBundleRequest)
			{
				return null;
			}

			/**
			 * 根据套餐编号查询套餐信息 供平台使用
			 * @param bundleId
			 * @return
			 */
			@Override
			public Result<BundleVo> findBundleById (String bundleId)
			{
				return new Result ().failure ("Cms Service not avialiable");
			}

			/**
			 * 根据套餐编号查询套餐信息 供客户端使用
			 * @param bundleId
			 * @return
			 */
			@Override
			public Result<BundleVo> queryBundleById (String bundleId)
			{
				return new Result ().failure ("Cms Service not avialiable");
			}

			/**
			 * 多条件查询套餐信息
			 * @param queryBundleConditionRequest
			 * @return
			 */
			@Override
			public Result<List<BundleVo>> queryBundlesByCondition (
					QueryBundleConditionRequest queryBundleConditionRequest)
			{
				return null;
			}

			/**
			 *  删除套餐信息
			 * @param bundleId
			 * @return
			 */
			@Override
			public Result<String> deleteBundle (String bundleId)
			{
				return null;
			}
		};
	}
}
