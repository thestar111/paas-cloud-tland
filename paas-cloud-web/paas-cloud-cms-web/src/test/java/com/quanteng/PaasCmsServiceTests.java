/**
 * 文 件 名:  PaasCmsServiceTests
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/23 0023
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng;

import com.google.common.collect.Lists;
import com.quanteng.tland.cms.database.entity.AdLang;
import com.quanteng.tland.cms.database.mapper.AdMapper;
import com.quanteng.tland.cms.web.boot.CmsServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/23 0023
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RunWith (SpringRunner.class)
@SpringBootTest (classes = CmsServiceApplication.class)
public class PaasCmsServiceTests
{

	@Autowired
	private AdMapper adMapper;

	@Test
	public void contextLoads ()
	{
		List<AdLang> adLangs = Lists.newArrayList ();
		AdLang adLang = new AdLang ();
		adLang.setAdvertisementId ("24589");
		adLang.setAdvertisementName ("飞车游戏广告");
		adLang.setId (3);
		adLang.setMemo ("飞车游戏广告链接");
		adLang.setLocal ("zh_CN");
		adLangs.add (adLang);

		AdLang adLang2 = new AdLang ();
		adLang.setAdvertisementId ("24589");
		adLang.setAdvertisementName ("QQ 飞车");
		adLang.setId (4);
		adLang.setMemo ("QQ 飞车广告链接");
		adLang.setLocal ("zh_CN");
		adLangs.add (adLang2);
		//int falg = adMapper.updateAdLang (adLangs);
		//System.out.println (falg);
	}
}
