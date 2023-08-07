package mx.com.unitconverter.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import mx.com.unitconverter.magnitudedef.MagnitudeType;
import mx.com.unitconverter.magnitudedef.UnitType;

public class MeasurementUnit extends Magnitude {

	private String system;
	
	public MeasurementUnit(UnitType unit) {
		super(unit.getSymbol(), unit.getName(), unit.getType());
		this.system = unit.getSystem();
	}
	
	public MeasurementUnit(double value, UnitType unit) {
		super(value, unit.getSymbol(), unit.getName(), unit.getType());
		this.system = unit.getSystem();
	}
	
	public String getSystem() {
		return system;
	}

	@Override
	public Double convertTo(Magnitude toUnit) throws IncompatibleUnitTypesException {
		if (this.getType() != toUnit.getType())
			throw new IncompatibleUnitTypesException("Error: Tipo de unidad incompatible");
		
		if (this.getType() == MagnitudeType.TEMPERATURE.toString()) {
			Double convertToUnit = this.getValue() * UnitType.getConversionRate(this.getName(), toUnit.getName()) 
					+ UnitType.getTempConversionOffset(this.getName(), toUnit.getName());
			BigDecimal roundedCoversion = new BigDecimal(convertToUnit).setScale(2, RoundingMode.HALF_UP);
			return roundedCoversion.doubleValue();
		}
		
		String basicUnit = UnitType.getBasicSIUnit(this.getType());
		Double convertToBasicSIUnit = this.getValue() / UnitType.getConversionRate(basicUnit, this.getName());
		Double convertToUnit = convertToBasicSIUnit * UnitType.getConversionRate(basicUnit, toUnit.getName());
		BigDecimal roundedConversion = new BigDecimal(convertToUnit).setScale(4, RoundingMode.HALF_UP);
		return roundedConversion.doubleValue();
	}
	
}
