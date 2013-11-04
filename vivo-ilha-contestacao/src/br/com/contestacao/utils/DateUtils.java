package br.com.contestacao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateUtils {

	private static final String FORMATO_DATA_PADRAO = "dd/MM/yyyy";

	private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

	private DateUtils() {
	}

	public static String formatar(Date data) {
		return formatar(data, FORMATO_DATA_PADRAO);
	}

	public static String formatar(Date data, String mascara) {
		if (data == null || mascara == null || mascara.trim().isEmpty()) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(mascara, LOCALE_PT_BR);

		return sdf.format(data);
	}
}
