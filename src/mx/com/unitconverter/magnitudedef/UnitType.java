package mx.com.unitconverter.magnitudedef;

import java.util.HashMap;
import java.util.stream.Stream;

public enum UnitType {

	// Length Units
	KILOMETER("km", "kilómetro", MagnitudeType.LENGTH, UnitSystem.INTERNATIONAL),
	METER("m", "metro", MagnitudeType.LENGTH, UnitSystem.INTERNATIONAL),
	CENTIMETER("cm", "centímetro", MagnitudeType.LENGTH, UnitSystem.INTERNATIONAL),
	MILIMETER("mm", "milímetro", MagnitudeType.LENGTH, UnitSystem.INTERNATIONAL),
	MICROMETER("µm", "micrómetro", MagnitudeType.LENGTH, UnitSystem.INTERNATIONAL),
	NANOMETER("nm", "nanómetro", MagnitudeType.LENGTH, UnitSystem.INTERNATIONAL),
	
	MILE("mi", "milla",   MagnitudeType.LENGTH, UnitSystem.ENGLISH),
	YARD("yd", "yarda",   MagnitudeType.LENGTH, UnitSystem.ENGLISH),
	FOOT("ft", "pie",     MagnitudeType.LENGTH, UnitSystem.ENGLISH),
	INCH("in", "pulgada", MagnitudeType.LENGTH, UnitSystem.ENGLISH),
	
	// Mass Units
	TON("T", "tonelada", MagnitudeType.MASS, UnitSystem.METRIC),
	KILOGRAM("kg", "kilogramo", MagnitudeType.MASS, UnitSystem.INTERNATIONAL),
	GRAM("g", "gramo", MagnitudeType.MASS, UnitSystem.INTERNATIONAL),
	MILIGRAM("mg", "miligramo", MagnitudeType.MASS, UnitSystem.INTERNATIONAL),
	MICROGRAM("µg", "microgramo", MagnitudeType.MASS, UnitSystem.INTERNATIONAL),
	
	POUND("lb", "libra", MagnitudeType.MASS, UnitSystem.ENGLISH),
	OUNCE("oz", "onza",  MagnitudeType.MASS, UnitSystem.ENGLISH),
	
	// Volume Units
	LITER("l", "litro", MagnitudeType.VOLUME, UnitSystem.METRIC),
	MILILITER("ml", "mililitro", MagnitudeType.VOLUME, UnitSystem.METRIC),
	CUBIC_METER("m³", "metro cúbico", MagnitudeType.VOLUME, UnitSystem.INTERNATIONAL),
	
	GALLON("gal", "galón estadounidense", 				MagnitudeType.VOLUME, UnitSystem.ENGLISH),
	FLUID_OUNCE("fl oz", "onza líquida estadounidense", MagnitudeType.VOLUME, UnitSystem.ENGLISH),
	
	// Temperature Units
	CELSIUS("° C", "grados centígrados", MagnitudeType.TEMPERATURE, UnitSystem.METRIC),
	KELVIN("K", "kelvin", MagnitudeType.TEMPERATURE, UnitSystem.INTERNATIONAL),
	FAHRENHEIT("° F", "grados Fahrenheit", MagnitudeType.TEMPERATURE, UnitSystem.ENGLISH);
	
	
	private final String symbol;
	private final String name;
	private final String type;
	private final String system;
	
	private static HashMap<String, HashMap<String, Double>> conversionRate;
	
	static {
		conversionRate = new HashMap<>();
		
		conversionRate.put(UnitType.METER.getName(), new HashMap<>());
		conversionRate.get(UnitType.METER.getName()).put(UnitType.KILOMETER.getName(), 0.001);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.METER.getName(), 1D);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.CENTIMETER.getName(), 100D);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.MILIMETER.getName(), 1000D);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.MICROMETER.getName(), 1e6);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.NANOMETER.getName(), 1e9);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.INCH.getName(), 1 / 0.0254);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.FOOT.getName(), (1/0.0254)/12);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.YARD.getName(), (1/0.0254)/36);
		conversionRate.get(UnitType.METER.getName()).put(UnitType.MILE.getName(), (1/0.0254)/63360);

		
		conversionRate.put(UnitType.KILOGRAM.getName(), new HashMap<>());
		conversionRate.get(UnitType.KILOGRAM.getName()).put(UnitType.TON.getName(), 0.001);
		conversionRate.get(UnitType.KILOGRAM.getName()).put(UnitType.KILOGRAM.getName(), 1D);
		conversionRate.get(UnitType.KILOGRAM.getName()).put(UnitType.GRAM.getName(), 1000D);
		conversionRate.get(UnitType.KILOGRAM.getName()).put(UnitType.MILIGRAM.getName(), 1e6);
		conversionRate.get(UnitType.KILOGRAM.getName()).put(UnitType.MICROGRAM.getName(), 1e9);
		conversionRate.get(UnitType.KILOGRAM.getName()).put(UnitType.POUND.getName(), 2.20462);
		conversionRate.get(UnitType.KILOGRAM.getName()).put(UnitType.OUNCE.getName(), 16 * 2.20462);
		
		conversionRate.put(UnitType.CUBIC_METER.getName(), new HashMap<>());
		conversionRate.get(UnitType.CUBIC_METER.getName()).put(UnitType.LITER.getName(), 1000D);
		conversionRate.get(UnitType.CUBIC_METER.getName()).put(UnitType.CUBIC_METER.getName(), 1D);
		conversionRate.get(UnitType.CUBIC_METER.getName()).put(UnitType.MILILITER.getName(), 1e6);
		conversionRate.get(UnitType.CUBIC_METER.getName()).put(UnitType.FLUID_OUNCE.getName(), 33814D);
		conversionRate.get(UnitType.CUBIC_METER.getName()).put(UnitType.GALLON.getName(), 33814/128D);
		
		conversionRate.put(UnitType.KELVIN.getName(), new HashMap<>());
		conversionRate.get(UnitType.KELVIN.getName()).put(UnitType.KELVIN.getName(), 1D);
		conversionRate.get(UnitType.KELVIN.getName()).put(UnitType.CELSIUS.getName(), 1D);
		conversionRate.get(UnitType.KELVIN.getName()).put(UnitType.FAHRENHEIT.getName(), 1.8);
		
		conversionRate.put(UnitType.CELSIUS.getName(), new HashMap<>());
		conversionRate.get(UnitType.CELSIUS.getName()).put(UnitType.KELVIN.getName(), 1D);
		conversionRate.get(UnitType.CELSIUS.getName()).put(UnitType.CELSIUS.getName(), 1D);
		conversionRate.get(UnitType.CELSIUS.getName()).put(UnitType.FAHRENHEIT.getName(), 1.8);
		
		conversionRate.put(UnitType.FAHRENHEIT.getName(), new HashMap<>());
		conversionRate.get(UnitType.FAHRENHEIT.getName()).put(UnitType.KELVIN.getName(), 5/9D);
		conversionRate.get(UnitType.FAHRENHEIT.getName()).put(UnitType.CELSIUS.getName(), 5/9D);
		conversionRate.get(UnitType.FAHRENHEIT.getName()).put(UnitType.FAHRENHEIT.getName(), 1D);
		
	}
	
	private static HashMap<String, HashMap<String, Double>> tempConversionOffset;
	
	static {
		
		tempConversionOffset = new HashMap<>();
		
		tempConversionOffset.put(UnitType.KELVIN.getName(), new HashMap<>());
		tempConversionOffset.get(UnitType.KELVIN.getName()).put(UnitType.KELVIN.getName(), 0D);
		tempConversionOffset.get(UnitType.KELVIN.getName()).put(UnitType.CELSIUS.getName(), -273.15);
		tempConversionOffset.get(UnitType.KELVIN.getName()).put(UnitType.FAHRENHEIT.getName(), -459.67);
		
		tempConversionOffset.put(UnitType.CELSIUS.getName(), new HashMap<>());
		tempConversionOffset.get(UnitType.CELSIUS.getName()).put(UnitType.KELVIN.getName(), 273.15);
		tempConversionOffset.get(UnitType.CELSIUS.getName()).put(UnitType.CELSIUS.getName(), 0D);
		tempConversionOffset.get(UnitType.CELSIUS.getName()).put(UnitType.FAHRENHEIT.getName(), 32D);
		
		tempConversionOffset.put(UnitType.FAHRENHEIT.getName(), new HashMap<>());
		tempConversionOffset.get(UnitType.FAHRENHEIT.getName()).put(UnitType.KELVIN.getName(), -32*5/9+273.15);
		tempConversionOffset.get(UnitType.FAHRENHEIT.getName()).put(UnitType.CELSIUS.getName(), -32*5/9D);
		tempConversionOffset.get(UnitType.FAHRENHEIT.getName()).put(UnitType.FAHRENHEIT.getName(), 0D);		
		
	}
	
	private static HashMap<String, String> basicSIUnit;
	
	static {
		basicSIUnit = new HashMap<>();
		basicSIUnit.put(MagnitudeType.LENGTH.toString(), UnitType.METER.getName());
		basicSIUnit.put(MagnitudeType.MASS.toString(), UnitType.KILOGRAM.getName());
		basicSIUnit.put(MagnitudeType.VOLUME.toString(), UnitType.CUBIC_METER.getName());
	}
	
	private UnitType(final String symbol, final String name, final MagnitudeType type, final UnitSystem system) {
		this.symbol = symbol;
		this.name = name;
		this.type = type.toString();
		this.system = system.toString();
	}


	public static Stream<UnitType> stream() {
		return Stream.of(UnitType.values());
	}
	
	public static UnitType getUnitByName(String name) {
		for(UnitType unit : UnitType.values())
			if (unit.getName() == name)
				return unit;
		return null;
	}
	
	public static Double getConversionRate(String unit1, String unit2) {
		return conversionRate.get(unit1).get(unit2);
	}
	
	public static Double getTempConversionOffset(String unit1, String unit2) {
		return tempConversionOffset.get(unit1).get(unit2);
	}

	public static String getBasicSIUnit(String magnitudeType) {
		return basicSIUnit.get(magnitudeType);
	}

	public String getType() {
		return type;
	}


	public String getSystem() {
		return system;
	}



	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}
	
}
