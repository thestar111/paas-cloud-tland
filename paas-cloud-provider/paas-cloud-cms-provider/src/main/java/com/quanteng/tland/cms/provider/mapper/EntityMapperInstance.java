/**
 * 文 件 名:  EntityMapperInstance
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.mapper;

import com.quanteng.tland.cms.database.entity.AppLang;
import com.quanteng.tland.cms.pojo.app.domain.AppLangVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <实体VO映射对象Mapper>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Mapper
public interface EntityMapperInstance
{
	/**
	 * 映射实体实例
	 */
	EntityMapperInstance INSTANCE = Mappers.getMapper (EntityMapperInstance.class);

	/**
	 * VO转实体对象
	 *
	 * @param appLangVo
	 * @return
	 */
	AppLang appLangToEntity (AppLangVo appLangVo);

	/**
	 * 实体转VO对象
	 *
	 * @param appLang
	 * @return
	 */
	AppLangVo appLangToVO (AppLang appLang);

}
