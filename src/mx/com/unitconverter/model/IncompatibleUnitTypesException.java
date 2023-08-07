package mx.com.unitconverter.model;

public class IncompatibleUnitTypesException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncompatibleUnitTypesException(String message) {
        super(message);
    }

    public IncompatibleUnitTypesException(){
        super();
    }

}
