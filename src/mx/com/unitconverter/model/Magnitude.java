package mx.com.unitconverter.model;

public abstract class Magnitude {
	
	private String type;
	private String symbol;
	private String name;
	private double value;
	
	public Magnitude(String symbol, String name, String type) {
		this.symbol = symbol;
		this.name = name;
		this.type = type;
	}
	
	public Magnitude(double value, String symbol, String name, String type) {
		this.value = value;
		this.symbol = symbol;
		this.name = name;
		this.type = type;
	}
	
	public Magnitude(double value, Magnitude magnitude) {
		this.value = value;
		this.name = magnitude.getName();
		this.symbol = magnitude.getSymbol();
		this.type = magnitude.getType();
	}
	
	public abstract Double convertTo(Magnitude toMagnitude) throws Exception;
	
	public Double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getValue() + " " + this.getSymbol();
	}

}
