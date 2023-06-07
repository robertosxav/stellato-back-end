package com.stellato.exceptions;

public class StellatoException extends RuntimeException{

	private static final long serialVersionUID = -409889946864421783L;

	public StellatoException(String message, Throwable cause) {
		super(message, cause);
	}

	public StellatoException(String message) {
		super(message);
	}
	
}
