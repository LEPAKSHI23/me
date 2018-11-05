package com.capgemini.mps.exception;

public class MobilePurchaseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	
	public MobilePurchaseException() {
		status = "Mobile Purchase Exception";
	}

	@Override
	public String toString() {
		return "MobilePurchaseException [status=" + status + "]";
	}

	public MobilePurchaseException(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
