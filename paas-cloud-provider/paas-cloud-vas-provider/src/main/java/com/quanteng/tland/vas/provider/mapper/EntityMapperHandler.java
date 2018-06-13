/**
 * 文 件 名:  EntityMapperHandler
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.mapper;

import com.quanteng.tland.cms.pojo.catalogrelation.domain.AdsMessage;
import com.quanteng.tland.user.pojo.user.UserVo;
import com.quanteng.tland.vas.pojo.ads.domain.AdsDto;
import com.quanteng.tland.vas.pojo.user.domain.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Mapper
public interface EntityMapperHandler
{
	/**
	 * 映射实体实例
	 */
	EntityMapperHandler INSTANCE = Mappers.getMapper (EntityMapperHandler.class);

	/**
	 * VO转实体对象
	 *
	 * @param userDto
	 * @return
	 */
	@Mapping (target = "accountName", source = "userName")
	UserVo voToEntity (UserDto userDto);

	/**
	 * 将cms的广告类型映射到vas的广告类型
	 * @param adsMessage
	 * @return
	 */
	@Mapping (target = "type", source = "advertisementType")
	AdsDto changetAdsDto (AdsMessage adsMessage);
}
