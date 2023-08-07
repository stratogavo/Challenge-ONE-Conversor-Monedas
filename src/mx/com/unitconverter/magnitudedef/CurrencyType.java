package mx.com.unitconverter.magnitudedef;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Stream;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public enum CurrencyType {
	
	USD("USD", Currency.getInstance("USD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MXN("MXN", Currency.getInstance("MXN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	EUR("EUR", Currency.getInstance("EUR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	GBP("GBP", Currency.getInstance("GBP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	JPY("JPY", Currency.getInstance("JPY").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KRW("KRW", Currency.getInstance("KRW").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CNY("CNY", Currency.getInstance("CNY").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BRL("BRL", Currency.getInstance("BRL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	COP("COP", Currency.getInstance("COP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CLP("CLP", Currency.getInstance("CLP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ARS("ARS", Currency.getInstance("ARS").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	PEN("PEN", Currency.getInstance("PEN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CHF("CHF", Currency.getInstance("CHF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CAD("CAD", Currency.getInstance("CAD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	AUD("AUD", Currency.getInstance("AUD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	NZD("NZD", Currency.getInstance("NZD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	AFN("AFN", Currency.getInstance("AFN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ALL("ALL", Currency.getInstance("ALL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	AMD("AMD", Currency.getInstance("AMD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	AED("AED", Currency.getInstance("AED").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ANG("ANG", Currency.getInstance("ANG").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	AOA("AOA", Currency.getInstance("AOA").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	AWG("AWG", Currency.getInstance("AWG").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	AZN("AZN", Currency.getInstance("AZN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BAM("BAM", Currency.getInstance("BAM").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BBD("BBD", Currency.getInstance("BBD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BDT("BDT", Currency.getInstance("BDT").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BGN("BGN", Currency.getInstance("BGN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BHD("BHD", Currency.getInstance("BHD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BIF("BIF", Currency.getInstance("BIF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BMD("BMD", Currency.getInstance("BMD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BND("BND", Currency.getInstance("BND").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BOB("BOB", Currency.getInstance("BOB").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BSD("BSD", Currency.getInstance("BSD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BTN("BTN", Currency.getInstance("BTN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BWP("BWP", Currency.getInstance("BWP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BYN("BYN", Currency.getInstance("BYN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	BZD("BZD", Currency.getInstance("BZD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CDF("CDF", Currency.getInstance("CDF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CRC("CRC", Currency.getInstance("CRC").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CUP("CUP", Currency.getInstance("CUP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CVE("CVE", Currency.getInstance("CVE").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	CZK("CZK", Currency.getInstance("CZK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	DJF("DJF", Currency.getInstance("DJF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	DKK("DKK", Currency.getInstance("DKK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	DOP("DOP", Currency.getInstance("DOP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	DZD("DZD", Currency.getInstance("DZD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	EGP("EGP", Currency.getInstance("EGP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ERN("ERN", Currency.getInstance("ERN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ETB("ETB", Currency.getInstance("ETB").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	FJD("FJD", Currency.getInstance("FJD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	FKP("FKP", Currency.getInstance("FKP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	FOK("FOK", "corona feroesa", MagnitudeType.CURRENCY),
	GEL("GEL", Currency.getInstance("GEL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	GGP("GGP", "libra de Guernesey", MagnitudeType.CURRENCY),
	GHS("GHS", Currency.getInstance("GHS").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	GIP("GIP", Currency.getInstance("GIP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	GMD("GMD", Currency.getInstance("GMD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	GNF("GNF", Currency.getInstance("GNF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	GTQ("GTQ", Currency.getInstance("GTQ").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	GYD("GYD", Currency.getInstance("GYD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	HKD("HKD", Currency.getInstance("HKD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	HNL("HNL", Currency.getInstance("HNL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	HRK("HRK", Currency.getInstance("HRK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	HTG("HTG", Currency.getInstance("HTG").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	HUF("HUF", Currency.getInstance("HUF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	IDR("IDR", Currency.getInstance("IDR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ILS("ILS", Currency.getInstance("ILS").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	IMP("IMP", "libra manesa", MagnitudeType.CURRENCY),
	INR("INR", Currency.getInstance("INR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	IQD("IQD", Currency.getInstance("IQD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	IRR("IRR", Currency.getInstance("IRR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ISK("ISK", Currency.getInstance("ISK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	JEP("JEP", "libra de Jersey", MagnitudeType.CURRENCY),
	JMD("JMD", Currency.getInstance("JMD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	JOD("JOD", Currency.getInstance("JOD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KES("KES", Currency.getInstance("KES").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KGS("KGS", Currency.getInstance("KGS").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KHR("KHR", Currency.getInstance("KHR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KID("KID", "dolar de Kribati", MagnitudeType.CURRENCY),
	KMF("KMF", Currency.getInstance("KMF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KWD("KWD", Currency.getInstance("KWD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KYD("KYD", Currency.getInstance("KYD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	KZT("KZT", Currency.getInstance("KZT").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	LAK("LAK", Currency.getInstance("LAK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	LBP("LBP", Currency.getInstance("LBP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	LKR("LKR", Currency.getInstance("LKR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	LRD("LRD", Currency.getInstance("LRD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	LSL("LSL", Currency.getInstance("LSL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	LYD("LYD", Currency.getInstance("LYD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MAD("MAD", Currency.getInstance("MAD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MDL("MDL", Currency.getInstance("MDL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MGA("MGA", Currency.getInstance("MGA").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MKD("MKD", Currency.getInstance("MKD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MMK("MMK", Currency.getInstance("MMK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MNT("MNT", Currency.getInstance("MNT").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MOP("MOP", Currency.getInstance("MOP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MRU("MRU", Currency.getInstance("MRU").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MUR("MUR", Currency.getInstance("MUR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MVR("MVR", Currency.getInstance("MVR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MWK("MWK", Currency.getInstance("MWK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MYR("MYR", Currency.getInstance("MYR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	MZN("MZN", Currency.getInstance("MZN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	NAD("NAD", Currency.getInstance("NAD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	NGN("NGN", Currency.getInstance("NGN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	NIO("NIO", Currency.getInstance("NIO").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	NOK("NOK", Currency.getInstance("NOK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	NPR("NPR", Currency.getInstance("NPR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	OMR("OMR", Currency.getInstance("OMR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	PAB("PAB", Currency.getInstance("PAB").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	PGK("PGK", Currency.getInstance("PGK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	PHP("PHP", Currency.getInstance("PHP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	PKR("PKR", Currency.getInstance("PKR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	PLN("PLN", Currency.getInstance("PLN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	PYG("PYG", Currency.getInstance("PYG").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	QAR("QAR", Currency.getInstance("QAR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	RON("RON", Currency.getInstance("RON").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	RSD("RSD", Currency.getInstance("RSD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	RUB("RUB", Currency.getInstance("RUB").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	RWF("RWF", Currency.getInstance("RWF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SAR("SAR", Currency.getInstance("SAR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SBD("SBD", Currency.getInstance("SBD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SCR("SCR", Currency.getInstance("SCR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SDG("SDG", Currency.getInstance("SDG").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SEK("SEK", Currency.getInstance("SEK").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SGD("SGD", Currency.getInstance("SGD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SHP("SHP", Currency.getInstance("SHP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SLE("FKP", Currency.getInstance("FKP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SLL("SLL", Currency.getInstance("SLL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SOS("SOS", Currency.getInstance("SOS").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SRD("SRD", Currency.getInstance("SRD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SSP("SSP", Currency.getInstance("SSP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	STN("STN", Currency.getInstance("STN").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SYP("SYP", Currency.getInstance("SYP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	SZL("SZL", Currency.getInstance("SZL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	THB("THB", Currency.getInstance("THB").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TMT("TMT", Currency.getInstance("TMT").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TND("TND", Currency.getInstance("TND").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TOP("TOP", Currency.getInstance("TOP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TRY("TRY", Currency.getInstance("TRY").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TTD("TTD", Currency.getInstance("TTD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TVD("FKP", Currency.getInstance("FKP").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TWD("TWD", Currency.getInstance("TWD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	TZS("TZS", Currency.getInstance("TZS").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	UAH("UAH", Currency.getInstance("UAH").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	UGX("UGX", Currency.getInstance("UGX").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	UYU("UYU", Currency.getInstance("UYU").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	UZS("UZS", Currency.getInstance("UZS").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	VES("VES", Currency.getInstance("VES").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	VND("VND", Currency.getInstance("VND").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	VUV("VUV", Currency.getInstance("VUV").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	WST("WST", Currency.getInstance("WST").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	XAF("XAF", Currency.getInstance("XAF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	XCD("XCD", Currency.getInstance("XCD").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	XDR("XDR", Currency.getInstance("XDR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	XOF("XOF", Currency.getInstance("XOF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	XPF("XPF", Currency.getInstance("XPF").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	YER("YER", Currency.getInstance("YER").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ZAR("ZAR", Currency.getInstance("ZAR").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ZMW("ZMW", Currency.getInstance("ZMW").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY),
	ZWL("ZWL", Currency.getInstance("ZWL").getDisplayName(Locale.of("es")), MagnitudeType.CURRENCY);

	private final String symbol;
	private final String name;
	private final String type;
	
	private static HashMap<String, Double> exchangeUSDRates = new HashMap<>();
	
	static {
		
		initUSDRatesFromAPI();
	
	}

	private CurrencyType(final String symbol, final String name, MagnitudeType type) {
		this.symbol = symbol;
		this.name = name;
		this.type = type.toString();
	}
	
	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public static Double getExchangeUSDRates(String toCurrency) {
		return exchangeUSDRates.get(toCurrency);
	}
	
	public static Stream<CurrencyType> stream() {
		return Stream.of(CurrencyType.values());
	}
	
	public static CurrencyType getCurrencyByName(String name) {
		for(CurrencyType currency : CurrencyType.values())
			if (currency.getName() == name)
				return currency;
		return null;
	}
		
	private static boolean initUSDRatesFromAPI() {
		try {
			// Setting URL
			String urlExchangeAPI = "https://v6.exchangerate-api.com/v6/774889ac5a1bfe766616ae47/latest/USD";
			//String urlExchangeAPI = "https://v6.exchangerate-api.com/v6/74889ac5a1bfe766616ae47/latest/USD";
			// Making Request
			URL url = new URI(urlExchangeAPI).toURL();
			HttpURLConnection requestAPIConnection = (HttpURLConnection) url.openConnection();
			requestAPIConnection.connect();
			// Convert to JSON
			JsonObject JsonRequest =  JsonParser.parseReader(
					new InputStreamReader((InputStream) requestAPIConnection.getContent())).getAsJsonObject();
			// Accessing and converting JsonObject to HashMap
			// String requestResult = JsonRequest.get("result").getAsString();
			JsonObject requestRates = JsonRequest.get("conversion_rates").getAsJsonObject();
			Set<String> currencySet = requestRates.keySet();
			// Storing rates for each currency in the HashMap
			currencySet.forEach(currencyName -> 
				CurrencyType.exchangeUSDRates.put(currencyName, requestRates.get(currencyName).getAsDouble()));
			return true;
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
