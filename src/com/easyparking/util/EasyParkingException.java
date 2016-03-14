package com.easyparking.util;

public class EasyParkingException extends java.lang.Exception {

	private static final long serialVersionUID = -4581740387522086879L;

	public EasyParkingException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public EasyParkingException(Throwable cause)
	{
		super(cause);
	}
	
	public EasyParkingException(String message)
	{
		super(message);
	}
}
