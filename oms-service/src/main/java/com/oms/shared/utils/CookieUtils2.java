package com.oms.shared.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * Cookie 工具类
 *
 */
public final class CookieUtils2 {

	static final Logger logger = LoggerFactory.getLogger(CookieUtils2.class);

	/**
	 * 得到Cookie的值, 不编码
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		return getCookieValue(request, cookieName, "");
	}

	/**
	 * 得到Cookie的值,
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
		Cookie[] cookieList = request.getCookies();
		if (cookieList == null || cookieName == null){
			return null;			
		}
		String retValue = null;
		try {
			for (int i = 0; i < cookieList.length; i++) {
				if (cookieList[i].getName().equals(cookieName)) {
					if (encodeString != null && encodeString.length() > 0) {
						retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
					} else {
						retValue = cookieList[i].getValue();
					}
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("Cookie Decode Error.", e);
		}
		return retValue;
	}

	public static CookieBuilder newBuilder(HttpServletRequest request, HttpServletResponse response){
		return new CookieBuilder(request, response);
	}
	public static class CookieBuilder {
		private HttpServletRequest request;
		private HttpServletResponse response;
		private Integer cookieMaxAge;
		private String encodeString;
		private boolean httpOnly;

		public CookieBuilder(HttpServletRequest request, HttpServletResponse response) {
			this.request = request;
			this.response = response;
		}

		public CookieBuilder cookieMaxAge(int cookieMaxAge){
			this.cookieMaxAge = cookieMaxAge;
			return this;
		}

		public CookieBuilder encodeString(String encodeString){
			this.encodeString = encodeString;
			return this;
		}

		public CookieBuilder httpOnly(){
			this.httpOnly = true;
			return this;
		}

		public void build(String cookieName, String cookieValue){
			try {
				if(StringUtils.isBlank(encodeString)) {
					encodeString = "utf-8";
				}

				if (cookieValue == null) {
					cookieValue = "";
				} else {
					cookieValue = URLEncoder.encode(cookieValue, encodeString);
				}
				Cookie cookie = new Cookie(cookieName, cookieValue);
				if (cookieMaxAge!=null&&cookieMaxAge > 0)
					cookie.setMaxAge(cookieMaxAge);
				if (null != request)// 设置域名的cookie
					cookie.setDomain(getDomainName(request));
				cookie.setPath("/");

				cookie.setHttpOnly(httpOnly);
				response.addCookie(cookie);
			} catch (Exception e) {
				logger.error("Cookie Encode Error.", e);
			}
		}
		/**
		 * 得到cookie的域名
		 */
		private String getDomainName(HttpServletRequest request) {
			String domainName = null;

			String serverName = request.getRequestURL().toString();
			if (serverName == null || serverName.equals("")) {
				domainName = "";
			} else {
				serverName = serverName.toLowerCase();
				serverName = serverName.substring(7);
				final int end = serverName.indexOf("/");
				serverName = serverName.substring(0, end);
				final String[] domains = serverName.split("\\.");
				int len = domains.length;
				if (len > 3) {
					// www.xxx.com.cn
					domainName = domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
				} else if (len <= 3 && len > 1) {
					// xxx.com or xxx.cn
					domainName = domains[len - 2] + "." + domains[len - 1];
				} else {
					domainName = serverName;
				}
			}

			if (domainName != null && domainName.indexOf(":") > 0) {
				String[] ary = domainName.split("\\:");
				domainName = ary[0];
			}
			return domainName;
		}
	}
}
