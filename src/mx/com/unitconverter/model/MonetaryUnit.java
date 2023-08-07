package mx.com.unitconverter.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import mx.com.unitconverter.magnitudedef.CurrencyType;
import mx.com.unitconverter.magnitudedef.MagnitudeType;

public class MonetaryUnit extends Magnitude {
	
	
	public MonetaryUnit(CurrencyType currency) {
		super(currency.getSymbol(), currency.getName(), MagnitudeType.CURRENCY.toString());
	}

	public MonetaryUnit(double value, CurrencyType currency) {
		super(value, currency.getSymbol(), currency.getName(), MagnitudeType.CURRENCY.toString());
	}

	@Override
	public Double convertTo(Magnitude toCurrency) throws NullExchangeRateException {
		Double fromCurrencyUSDRate = CurrencyType.getExchangeUSDRates(this.getSymbol());
		
		Double toCurrencyUSDRate = CurrencyType.getExchangeUSDRates(toCurrency.getSymbol());
		if (fromCurrencyUSDRate == null || toCurrencyUSDRate == null)
			throw new NullExchangeRateException("Error: No se pueden obtener tasas de cambio");
		
		Double convertToCurrency = this.getValue() * toCurrencyUSDRate / fromCurrencyUSDRate;
		BigDecimal roundedConversion = new BigDecimal(convertToCurrency).setScale(4, RoundingMode.HALF_UP);
		return roundedConversion.doubleValue();
	}

}
