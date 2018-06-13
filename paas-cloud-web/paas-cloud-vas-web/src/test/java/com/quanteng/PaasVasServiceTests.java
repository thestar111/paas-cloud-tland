/**
 * 文 件 名:  PaasVasServiceTests
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/23 0023
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/23 0023
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

import com.quanteng.tland.vas.provider.component.AuthorizationTokenProvider;
import com.quanteng.tland.vas.web.boot.VasServiceApplication;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
@SpringBootTest (classes = VasServiceApplication.class)
public class PaasVasServiceTests
{

	@Autowired
	private AuthorizationTokenProvider authorizationTokenProvider;

	@Test
	public void contextLoads () throws Exception
	{
		/*String json = "{\n" + "  \"resultCode\": \"0\",\n" + "  \"resultMessage\": \"success\",\n" + "  \"meta\": {\n"
				+ "    \"success\": true,\n" + "    \"message\": \"ok\"\n" + "  },\n" + "  \"data\": [\n" + "    {\n"
				+ "      \"catalogId\": \"2017082500105512001349506525\",\n" + "      \"catalogName\": \"Driver\",\n"
				+ "      \"catalogIcon\": \"http://www.baidu.com\",\n" + "      \"type\": 1,\n"
				+ "      \"position\": 1,\n" + "      \"target\": [\n" + "        {\n"
				+ "          \"advertisementId\": \"2018042700102761001606511315\",\n"
				+ "          \"advertisementName\": \"tencent app\",\n"
				+ "          \"advertisementUrl\": \"http://www.baidu.com\",\n"
				+ "          \"imgUrl\": \"http://www.baidu.com\",\n" + "          \"type\": 2,\n"
				+ "          \"targetId\": \"2018042800101632001846392523\",\n" + "          \"order\": 2\n"
				+ "        }\n" + "      ]\n" + "    },\n" + "    {\n"
				+ "      \"catalogId\": \"2018050200108127001719054262\",\n" + "      \"catalogName\": \"MARKET\",\n"
				+ "      \"catalogIcon\": \"http://www.baidu.com\",\n" + "      \"type\": 1,\n"
				+ "      \"position\": 1,\n" + "      \"target\": [\n" + "        {\n"
				+ "          \"advertisementId\": \"2018042700106965001603201281\",\n"
				+ "          \"advertisementName\": \"catalog\",\n"
				+ "          \"advertisementUrl\": \"http://www.baidu.com\",\n"
				+ "          \"imgUrl\": \"http://www.baidu.com\",\n" + "          \"type\": 3,\n"
				+ "          \"targetId\": \"2017082500105512001349506525\",\n" + "          \"order\": 3\n"
				+ "        }\n" + "      ]\n" + "    },\n" + "    {\n"
				+ "      \"catalogId\": \"2018050200108127001719054283\",\n" + "      \"catalogName\": \"HOTMuzi_2\",\n"
				+ "      \"catalogIcon\": \"http://www.baidu.com\",\n" + "      \"type\": 3,\n"
				+ "      \"position\": 2,\n" + "      \"target\": [\n" + "        {\n"
				+ "          \"appId\": \"2018042800108681001852089784\",\n"
				+ "          \"appName\": \"Everyday S game Muzi\",\n" + "          \"appRate\": \"1\",\n"
				+ "          \"appVersion\": \"1.10\",\n" + "          \"appIcon\": \"http://www.baidu.com\",\n"
				+ "          \"appIconThumb\": \"http://www.baidu.com\",\n" + "          \"appSize\": \"43\",\n"
				+ "          \"appDownload\": \"123\",\n" + "          \"order\": 1\n" + "        }\n" + "      ]\n"
				+ "    }\n" + "  ],\n" + "  \"totalCount\": 0\n" + "}";

		ObjectMapper objectMapper = new ObjectMapper ();

		try
		{
			Result<List<CatalogMessage>> serviceResult = objectMapper.readValue (json, Result.class);
			System.out.println (serviceResult.toString ());
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}*/

		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyNTQxNTExMzk5MTIiLCJpc3MiOiJRVUFOVEVOR0BUTEFORCIsImV4cCI6MTUyNjk5NDgzNiwiaWF0IjoxNTI2OTg3NjM2fQ.Jg59mrZ86zzMZFpi83E5WoYbgODswF-0Qu8qda09wAD7U4IbogaFh0hj7WgS-BlzLRc9g3OeP50c7I9zlEGMxQ";

		Claims claims = authorizationTokenProvider.parseToken (token);
		System.out.println (claims.getSubject ());
	}
}
