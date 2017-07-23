package com.capgemini.shop.service.exception;

/**
 * Exception for avoid null objects
 * 
 * @author RWEYCHAN
 *
 */
public class UnknownObjectRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5672338599002092515L;

	/**
	 * Object was not found and is null.
	 * 
	 * @param message
	 *            What kind of object wasn't found
	 */
	public UnknownObjectRequestException(String message) {
		super(message);

	}
}
