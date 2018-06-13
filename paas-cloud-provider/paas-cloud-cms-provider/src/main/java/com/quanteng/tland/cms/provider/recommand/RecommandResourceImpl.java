/**
 * 文 件 名:  RecommandResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.recommand;

import com.quanteng.tland.cms.api.recommand.RecommandResource;
import com.quanteng.tland.cms.database.entity.Recommand;
import com.quanteng.tland.cms.database.mapper.RecommandMapper;
import com.quanteng.tland.cms.pojo.recommand.domain.RecommandVo;
import com.quanteng.tland.cms.pojo.recommand.request.CreateRecommandRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class RecommandResourceImpl implements RecommandResource
{

	@Autowired
	private RecommandMapper recommandMapper;

	/**
	 * 删除推荐实体信息
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Result<String> deleteRecommand (@PathVariable ("id") Integer id)
	{
		if (null == id)
		{
			return new Result<> ().failure ("id illega params.");
		}
		i ("RECOMMAND", "deleteRecommand", LOG_TYPE_REQUEST, id);
		int flag = recommandMapper.delete (id);
		i ("RECOMMAND", "deleteRecommand", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("delete recommand failed.");
		}
	}

	/**
	 * 添加推荐实体信息
	 *
	 * @param createRecommandRequest
	 * @return
	 */
	@Override
	public Result<String> addRecommand (@RequestBody CreateRecommandRequest createRecommandRequest)
	{
		if (null == createRecommandRequest || null == createRecommandRequest.getRecommand ())
		{
			return new Result<> ().failure ("illega params.");
		}
		i ("RECOMMAND", "addRecommand", LOG_TYPE_REQUEST, createRecommandRequest);
		Recommand recommand = new Recommand ();
		BeanUtils.copyProperties (createRecommandRequest.getRecommand (), recommand);
		int flag = recommandMapper.addRecommand (recommand);
		i ("RECOMMAND", "addRecommand", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("add recommand failed.");
		}
	}

	/**
	 * 查询推荐实体信息
	 *
	 * @return
	 */
	@Override
	public Result<RecommandVo> queryRecommand ()
	{
		i ("RECOMMAND", "queryRecommand", LOG_TYPE_REQUEST, "begin");
		Recommand recommand = recommandMapper.queryRecommand ();
		i ("RECOMMAND", "queryRecommand", LOG_TYPE_RESPONSE, recommand);
		RecommandVo recommandVo = null;
		if (null != recommand)
		{
			recommandVo = new RecommandVo ();
			BeanUtils.copyProperties (recommand, recommandVo);
			return new Result<> ().success (recommandVo);
		}
		else
		{
			Result<RecommandVo> result = new Result<> ().success (recommandVo);
			result.setResultMessage ("recommand not exist.");
			return result;
		}
	}
}
