package fr.diginamic.exceptions;

public class TechnicalException extends RuntimeException {

	/** serialVersionUID : long */
	private static final long serialVersionUID = 5685191747579249704L;

	public TechnicalException(String msg, Throwable e) {
		super(msg, e);

	}

}
