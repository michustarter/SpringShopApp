package com.capgemini.shop.service.exception;

/**
 * @author RWEYCHAN Exception for invalid input parameters of service methods
 */
public class InvalidServiceParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2451180463283396862L;

	/**
	 * Wrong method parameters
	 * 
	 * @param message
	 *            Message of the particular exception
	 */
	public InvalidServiceParameterException(String message) {
		super(message);
	}

}
