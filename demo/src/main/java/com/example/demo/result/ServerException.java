package com.example.demo.result;

public class ServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServerException(String msg, Throwable t) {
		super(msg, t);
	}

	public ServerException(String msg) {
		super(msg);
	}

	public ServerException() {
	}
}
