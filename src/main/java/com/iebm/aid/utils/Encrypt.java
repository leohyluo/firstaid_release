package com.iebm.aid.utils;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.crypto.Cipher;

import org.springframework.beans.factory.FactoryBean;

import com.iebm.aid.pojo.vo.TokenVo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @ClassName: Encrypt 
 * @Description: 数据库用户名加解密 
 * @author HuZongJian
 * @date 2013年11月8日 下午2:17:36 
 *
 */
public class Encrypt  implements FactoryBean<Object> {

	private Properties properties;

	public Object getObject() throws Exception {
		return getProperties();
	}

	public Class<Properties> getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public Properties getProperties() {
		return properties;
	}

	


	/**
	 * 加密
	 * @param needEncrypt
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String eCode(String needEncrypt) {
		byte result[] = null;
		try {
			Cipher enCipher = Cipher.getInstance("DES");
			javax.crypto.SecretKey key = EncryptKey.loadKey();
			enCipher.init(1, key);
			result = enCipher.doFinal(needEncrypt.getBytes());
			BASE64Encoder base64Encoder = new BASE64Encoder();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			base64Encoder.encode(result, bos);
			result = bos.toByteArray();
		} catch (Exception e) {
			throw new IllegalStateException(
					"System doesn't support DES algorithm.");
		}
		return new String(result);
	}

	/**
	 * 解密
	 * @param result
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String dCode(byte result[]) {
		String s = null;
		try {
			Cipher deCipher = Cipher.getInstance("DES");
			deCipher.init(2, EncryptKey.loadKey());
			BASE64Decoder base64Decoder = new BASE64Decoder();
			result = base64Decoder.decodeBuffer(new String(result));
			byte strByte[] = deCipher.doFinal(result);
			s = new String(strByte);
		} catch (Exception e) {
			throw new IllegalStateException(
					"System doesn't support DES algorithm.");
		}
		return s;
	}
	
	public static TokenVo toTokenVo(String token) throws Exception {
		//token=用户id(5位,不足的在前面补0)+账号+8位随机数+医院编码(后8位),然后用MD5进行加密
		String originalText = dCode(token.getBytes());
		int len = originalText.length();
		//前5位为用户id
		String userIdStr = originalText.substring(0, 5);
		String userId = String.valueOf(Integer.parseInt(userIdStr));
		String randomNo = originalText.substring(len - 8);
		String userName = originalText.substring(5, len - 8);
		
		TokenVo tokenVo = new TokenVo();
		tokenVo.setUserId(userId);
		tokenVo.setRandomNo(randomNo);
		tokenVo.setUserName(userName);
		return tokenVo;
	}
	
	public static String getToken(TokenVo vo) {
		//token=用户id(5位,不足的在前面补0)+账号+8位随机数,然后用MD5进行加密
		String userId = StringUtils.autoGenericCode(vo.getUserId(), 5);
		String userName = vo.getUserName();
		String randomNo = vo.getRandomNo();
		
		String token = userId + userName + randomNo;
		token = Encrypt.eCode(token);
		return token;
	}
	
	/*public static void main(String[] args) {
		Encrypt thiz = new Encrypt();
		String content = "lq9wbd7qVyM=";
		String decrStr = thiz.dCode(content.getBytes());
		System.out.println("解密后:"+decrStr);
		
		String originalContent = "gmws";
		String encrStr = thiz.eCode(originalContent);
		System.out.println("加密后"+encrStr);
	}*/
	
}
