/**
 * 文 件 名:  UserResourceApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.api.user;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.user.pojo.user.UserVo;
import com.quanteng.tland.user.pojo.user.domain.AppInfoVo;
import com.quanteng.tland.user.pojo.user.request.GetDownloadRecordRequest;
import com.quanteng.tland.user.pojo.user.request.QueryUserDownloadRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <用户模块接口定义>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/user")
public interface UserResourceApi
{
	/**
	 * 用户添加
	 *
	 * @param userVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping (value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	Result add (@RequestBody UserVo userVo) throws Exception;

	/**
	 * 查询用户下载历史记录(分区表)
	 *
	 * @param getDownloadRecordRequest
	 * @return
	 */
	@RequestMapping (value = "/getDownloadRecord", method = RequestMethod.POST)
	Result<List<AppInfoVo>> getDownloadRecord (@RequestBody GetDownloadRecordRequest getDownloadRecordRequest);

	/**
	 * 获取用户下载地址
	 *
	 * @param queryUserDownloadRequest
	 * @return
	 */
	@RequestMapping (value = "/getUserDownloadUrl", method = RequestMethod.POST)
	Result<String> queryUserDownloadUrl (@RequestBody QueryUserDownloadRequest queryUserDownloadRequest);

}
