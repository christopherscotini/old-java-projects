package br.com.portal.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;

public final class CpfUtils {

	private CpfUtils() {
		super();
	}

	public static long parseLong(String cpf) {
		return Long.parseLong(cpf.trim().replaceAll("\\.", "").replaceAll("\\-", ""));
	}

	public static String parseString(long cpf) {
		String numeros = String.format("%11d", cpf);
		StringBuilder cpfFormatado = new StringBuilder();
		cpfFormatado.append(numeros.substring(0, 3));
		cpfFormatado.append(".");
		cpfFormatado.append(numeros.substring(3, 6));
		cpfFormatado.append(".");
		cpfFormatado.append(numeros.substring(6, 9));
		cpfFormatado.append("-");
		cpfFormatado.append(numeros.substring(9, 11));
		return cpfFormatado.toString();
	}

	public static boolean isValido(String cpf) {
		if (cpf == null || cpf.trim().equals("")) {
			return false;
		}

		Pattern pattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
		Matcher matcher = pattern.matcher(cpf);
		if (!matcher.matches()) {
			return false;
		}

		String cpfNumeros = cpf.trim().replaceAll("\\.", "").replaceAll("\\-", "");

		if (!validarRepeticoes(cpfNumeros)) {
			return false;
		}

		int digitosPrimeiroVerificador = 9;
		long primeiroDigito = calcularDigitoVerificador(cpfNumeros, digitosPrimeiroVerificador);
		if (primeiroDigito != Long.parseLong(cpfNumeros.substring(digitosPrimeiroVerificador, digitosPrimeiroVerificador + 1))) {
			return false;
		}

		int digitosSegundoVerificador = 10;
		long segundoDigito = calcularDigitoVerificador(cpfNumeros, digitosSegundoVerificador);
		if (segundoDigito != Long.parseLong(cpfNumeros.substring(digitosSegundoVerificador, digitosSegundoVerificador + 1))) {
			return false;
		}

		return true;
	}

	/**
	 * Valida as repeticoes: 111.111.111-11, 222.222.222-22
	 * @param cpfNumeros
	 * @return
	 */
	private static boolean validarRepeticoes(String cpfNumeros) {
		for (int i = 0; i < 10; i++) {
			if (cpfNumeros.equals(Strings.repeat("" + i, 11))) {
				return false;
			}
		}
		return true;
	}

	private static long calcularDigitoVerificador(String cpf, int qtdeDigitos) {
		String cpfCalculo = cpf.substring(0, qtdeDigitos);

		long soma = 0;
		int multiplicador = qtdeDigitos + 1;
		for (int i = 0; i < cpfCalculo.length(); i++) {
			soma = soma + (multiplicador * Long.parseLong(cpfCalculo.substring(i, i + 1)));
			multiplicador = multiplicador - 1;
		}

		long digitoVerificador;
		long resto = soma % 11;
		if (resto == 0 || resto == 10) {
			digitoVerificador = 0;
		} else {
			digitoVerificador = 11 - resto;
		}

		return digitoVerificador;
	}
}
