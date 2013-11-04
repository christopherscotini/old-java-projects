package br.com.contestacao.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public final class NumberUtils {

	private static final Locale LOCALE_PT_BR = new Locale("pt", "BR"); 

	private static final String MASCARA_DECIMAL_PADRAO = "#,##0.00";

	private NumberUtils(){
	}

	public static String formatar(Number numero) {
		return formatar(numero, MASCARA_DECIMAL_PADRAO);
	}

	private static String formatar(Number numero, String pattern) {
		if (numero == null) {
			return "";
		}

		DecimalFormat formatter = getNumberFormatBrasil();
		formatter.applyPattern(pattern);
		return formatter.format(numero);
	}

	public static BigDecimal converter(String numero) throws ParseException {
		if (numero == null || numero.trim().isEmpty()) {
			return null;
		}

		DecimalFormat formatter = getNumberFormatBrasil();
		formatter.applyPattern(MASCARA_DECIMAL_PADRAO);
		formatter.setParseBigDecimal(true);

		return (BigDecimal) formatter.parse(numero);
	}

	private static DecimalFormat getNumberFormatBrasil() {
		return (DecimalFormat) NumberFormat.getNumberInstance(LOCALE_PT_BR);
	}
}
