package br.com.portal.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;

public final class CnpjUtils {

	private CnpjUtils() {
		super();
	}

	public static boolean isValido(String cnpj) {
		if (cnpj == null || cnpj.trim().equals("")) {
			return false;
		}

		Pattern pattern = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");
		Matcher matcher = pattern.matcher(cnpj);
		if (!matcher.matches()) {
			return false;
		}

		String cnpjNumeros = cnpj.trim().replaceAll("\\.|/|\\-", "");
		
		if(cnpjNumeros.length() != 14){
			return false;
		}
		
		if (!validarRepeticoes(cnpjNumeros)) {
			return false;
		}

		int digitosPrimeiroVerificador = 12;
		long primeiroDigito = calcularDigitoVerificador(cnpjNumeros, digitosPrimeiroVerificador);
		if (primeiroDigito != Long.parseLong(cnpjNumeros.substring(digitosPrimeiroVerificador, digitosPrimeiroVerificador + 1))) {
			return false;
		}

		int digitosSegundoVerificador = 13;
		long segundoDigito = calcularDigitoVerificador(cnpjNumeros, digitosSegundoVerificador);
		if (segundoDigito != Long.parseLong(cnpjNumeros.substring(digitosSegundoVerificador, digitosSegundoVerificador + 1))) {
			return false;
		}

		return true;
	}

	/**
	 * Valida as repeticoes: 11.111.111/1111-11, 22.222.222/2222-22
	 * @param cnpjNumeros
	 * @return
	 */
	private static boolean validarRepeticoes(String cnpjNumeros) {
		for (int i = 0; i < 13; i++) {
			if (cnpjNumeros.equals(Strings.repeat("" + i, 14))) {
				return false;
			}
		}
		return true;
	}

	private static long calcularDigitoVerificador(String cnpj, int qtdeDigitos) {
		String cpfCalculo = cnpj.substring(0, qtdeDigitos);

		long soma = 0;
		int multiplicador = 2;
		for (int i = qtdeDigitos - 1; i >= 0; i--) {
			soma = soma + (multiplicador * Long.parseLong(cpfCalculo.substring(i, i + 1)));
			multiplicador = multiplicador + 1;
			if (multiplicador == 10) {
				multiplicador = 2;
			}
		}

		long digitoVerificador;
		long resto = soma % 11;
		if (resto == 0 || resto == 1) {
			digitoVerificador = 0;
		} else {
			digitoVerificador = 11 - resto;
		}

		return digitoVerificador;
	}
}
