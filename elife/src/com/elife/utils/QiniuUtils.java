package com.elife.utils;

import com.qiniu.util.Auth;

/**
 * @author 任创权
 * 编写时间  2016-6-2 下午7:40:54
 * TODO ---
 *
 */
public class QiniuUtils {
	public static String getToken() {
		// 密钥配置
		Auth auth = Auth.create(ParamUtils.ACCESS_KEY, ParamUtils.SECRET_KEY);
		String token = auth.uploadToken(ParamUtils.bucketname);
		return token;
	}

}
