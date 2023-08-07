package mx.com.unitconverter.model;

public class NullExchangeRateException extends NullPointerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NullExchangeRateException(String message) {
		super(message);
	}
	
	public NullExchangeRateException() {
		super();
	}

}
