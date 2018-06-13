/**
 * 文 件 名:  AuthorizationTokenProvider
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/16 0016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway.provider;

import com.quanteng.tland.api.gateway.configuration.TokenConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * <Token生成器>
 *
 * @author zping
 * @version 2018/4/16 0016
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class AuthorizationTokenProvider
{

	private final TokenConfiguration tokenConfiguration;

	@Autowired
	public AuthorizationTokenProvider (TokenConfiguration tokenConfiguration)
	{
		this.tokenConfiguration = tokenConfiguration;
	}

	/**
	 * 生成Token
	 *
	 * @param claims  Payload的私有声明，可以自定义存放一些需要验证的信息
	 * @param subject 主体信息 JSON字符串
	 * @return
	 */
	public String createAccessToken (Map<String, Object> claims, String subject)
	{
		//获取当前时间
		LocalDateTime currentTime = LocalDateTime.now ();
		String token = Jwts.builder ().setClaims (claims).setIssuer (tokenConfiguration.getIssuer ())
				//签发时间
				.setIssuedAt (Date.from (currentTime.atZone (ZoneId.systemDefault ()).toInstant ()))
				//过期时间(分钟)
				.setExpiration (Date.from (currentTime.plusMinutes (tokenConfiguration.getExpirationTime ())
						.atZone (ZoneId.systemDefault ()).toInstant ()))
				//设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
				//.setId (UUID.randomUUID ().toString ().replace ("-", ""))
				//sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志
				.setSubject (subject)
				//利用私钥签名
				.signWith (SignatureAlgorithm.HS512, tokenConfiguration.getSigningKey ())
				//开发压缩为XXXXX.XXXXXXXX.XXXXXXXX格式
				.compact ();
		return token;
	}

	/**
	 * 刷新 RefreshToken
	 *
	 * @param claims  Payload的私有声明，可以自定义存放一些需要验证的信息
	 * @param subject 主体信息 JSON字符串
	 * @return
	 */
	public String createRefreshToken (Map<String, Object> claims, String subject)
	{
		//获取当前时间
		LocalDateTime currentTime = LocalDateTime.now ();
		String token = Jwts.builder ().setClaims (claims).setIssuer (tokenConfiguration.getIssuer ())
				.setId (UUID.randomUUID ().toString ().replace ("-", ""))
				//签发时间
				.setIssuedAt (Date.from (currentTime.atZone (ZoneId.systemDefault ()).toInstant ()))
				//过期时间
				.setExpiration (Date.from (currentTime.plusMinutes (tokenConfiguration.getRefreshExpTime ())
						.atZone (ZoneId.systemDefault ()).toInstant ()))
				//设置主体
				.setSubject (subject)
				//签名
				.signWith (SignatureAlgorithm.HS512, tokenConfiguration.getSigningKey ())
				//压缩
				.compact ();
		return token;
	}

	/**
	 * 解密Token
	 *
	 * @param token token加密字符串
	 * @return
	 * @throws Exception
	 */
	public Claims parseToken (String token) throws Exception
	{
		//签名秘钥，和生成的签名的秘钥一模一样
		//SecretKey key = tokenConfiguration.getSigningKey ();
		//得到DefaultJwtParser
		Claims claims = Jwts.parser ()
				//设置签名的秘钥
				.setSigningKey (tokenConfiguration.getSigningKey ())
				//设置需要解析的jwt
				.parseClaimsJws (token).getBody ();
		return claims;
	}
}
