package com.asianrapid.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class RuntimeException extends java.lang.RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7885349819959650538L;

	// 默认错误代码
	public static final Integer GENERIC = 1000000;

	public static final Logger logger = LoggerFactory.getLogger(RuntimeException.class);

	// 错误代码 
	private Integer errorCode;
	public RuntimeException(Integer errorCode, Throwable cause) {
		this(errorCode, null, cause);
	}

	public RuntimeException(String message,
	 Throwable cause) { // 利用通用错误代码 
		this(GENERIC, message, cause); 
	} 
	public RuntimeException(Integer errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		logger.error(message, cause);
	}

	public Integer getErrorCode() {
		return errorCode;
	}
}
