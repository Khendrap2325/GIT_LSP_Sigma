package org.howard.edu.lsp.assignment4;

/**
 * Class for set operation errors
 */
public class IntegerSetException extends Exception {

	
	private static final long serialVersionUID = 1L;
	/**
	 * IntegerSetException where errors in set operations occur
	 * @param message description of why the exception was thrown
	 */
	public IntegerSetException(String message) {
	super(message);
}
}
