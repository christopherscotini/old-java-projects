package br.com.utmanager.view.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * @author ffranco
 * 
 *         Para alterar o gabarito para este coment�rio do tipo gerado v� para Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o
 *         de C�digos&gt;C�digo e Coment�rios
 */
public final class GlobalUtils {

	static final String DEFAULT_INPUT_NUMMER_DECIMAL_SEPARATOR = ",";

	static final String DEFAULT_INPUT_NUMBER_GROUP_SEPARATOR = ".";

	static final boolean DEFAULT_INPUT_NUMBER_SELECT_ALLTEXT = true;
	
    static final Locale PT_BR = new Locale("pt", "BR");
    
    static final String DECIMAL_PATTERN = "#,##0.00";

	private GlobalUtils() {
		// Classes de utilidades n�o devem possuir um construtor p�blico.
	}

	public static String formatarCampoDeValorMonetario(Double valorini) {

		return formatNumber(valorini, 2, ",", true);

	}

	public static String formatNumber(double value, int decimals, String decimalSeparator, boolean showGroups) {

		String valueCopy = new DecimalFormat("0.00").format(value);
		valueCopy = replaceAll(valueCopy, ".", decimalSeparator);
		return formatNumber(valueCopy, decimals, decimalSeparator, showGroups);
	}

	public static String formatNumber(String value, int decimals, String decimalSeparator, boolean showGroups) {

		String ret = value;
		String integerNumbers;
		String decimalNumbers;
		int position = 0;

		if (Long.parseLong(replaceAll(replaceAll(ret, ".", ""), ",", "")) == 0) {
			if (decimals == 0) {
				return "0";
			} else {
				return "0" + decimalSeparator + preencherZerosADireita("", decimals);
			}
		}

		ret = replaceAll(ret, ".", "");
		if (decimals == 0) {
			return ret;
		}

		if (ret.indexOf(decimalSeparator) == -1) {
			integerNumbers = ret.substring(0, ret.length());
			decimalNumbers = preencherZerosADireita("", decimals);
		} else {
			integerNumbers = ret.substring(0, ret.indexOf(decimalSeparator));
			decimalNumbers = preencherZerosADireita(ret.substring(ret.indexOf(decimalSeparator) + 1, ret.length()),
							decimals).substring(0, decimals);
		}
		ret = integerNumbers + decimalSeparator + decimalNumbers;

		// ret = roundNumber(ret, decimals, decimalSeparator);

		if (ret.indexOf(decimalSeparator) == -1) {
			integerNumbers = ret.substring(0, ret.length());
			decimalNumbers = preencherZerosADireita("", decimals);
		} else {
			integerNumbers = ret.substring(0, ret.indexOf(decimalSeparator));
			if (integerNumbers.equals("")) {
				integerNumbers = "0";
			}

			decimalNumbers = preencherZerosADireita(ret.substring(ret.indexOf(decimalSeparator) + 1, ret.length()),
							decimals);
		}

		int count = 0;
		for (position = integerNumbers.length(); position > 0; position--) {
			if (count == 3) {
				integerNumbers = integerNumbers.substring(0, position) + DEFAULT_INPUT_NUMBER_GROUP_SEPARATOR
								+ integerNumbers.substring(position, integerNumbers.length());
				count = 1;
				position--;
			}
			count += 1;
		}
		ret = integerNumbers + decimalSeparator + decimalNumbers;

		// Complets the String
		// if (showGroups) {
		//
		// }

		return ret;
	}

	/*
	 * completa um valor com zeros a Direita at� completar o tamanho m�ximo
	 */
	public static String preencherZerosADireita(String valor, int tamanhoMaximo) {
		return insereCaracterADireita(valor, "0", tamanhoMaximo);
	}

	public static String retirarZerosAEsquerda(String valor) {

		StringBuffer recebeValor = new StringBuffer(valor);

		while (recebeValor.toString().startsWith("0")) {

			String remover = "0";

			int pos = recebeValor.indexOf(remover);

			recebeValor.delete(pos, pos + remover.length());

		}

		return recebeValor.toString();
	}

	/**
	 * Preenche a string com o caracter passado
	 * 
	 * @param str
	 *            String a ser modificada
	 * @param caracter
	 *            caracer a ser apendado na string
	 * @param tamanho
	 *            maximo da string apos a insercao
	 * @return string preenchida com os caracters out/2010
	 */
	public static String insereCaracterADireita(String str, String caracter, int tamanho) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < tamanho - str.length(); i++) {
			sb.append(caracter);
		}
		return sb.toString();
	}

	/* Preenche o campo passado com 0 a esquerda at� o tamanho maximo. */
	public static String preencherZerosAEsquerda(String campo, int tamanhoMaximo) {
		StringBuilder sb = new StringBuilder(addZero(campo, tamanhoMaximo));
		return sb.toString();

	}

	public static String replaceAll(String sourceText, String find, String replacement) {
		String value = sourceText;
		while (value.indexOf(find) != -1) {
			value = value.replace(find, replacement);
		}
		return value;
	}

	private static String addZero(String vr, int size) {
		StringBuilder resultado = new StringBuilder();
		int vrLength = vr.length();
		if (vrLength <= size) {
			int dif = size - vrLength;
			for (int i = 0; i < dif; i++) {
				resultado.append("0");
			}
			return resultado.append(vr).toString();
		} else {
			return vr;
			// throw new IllegalArgumentException("Valor maior que o intervalo informado.");
		}
	}

	public static String verificaStringNula(String str) {
		if (str == null) {
			return "";
		} else {
			return StringUtils.trim(str, ' ');
		}

	}
	
	public static Integer verificaStringNulaInteger(String str) {
		if (str == null || "".equals(str)) {
			return 0;
		} else {
			return Integer.valueOf(StringUtils.trim(str, ' '));
		}
	}
	
	public static Long verificaStringNulaLong(String str) {
		if (str == null || "".equals(str)) {
			return new Long(0);
		} else {
			return Long.valueOf(StringUtils.trim(str, ' '));
		}
	}
	
	public static Long verificaStringCpfCnpjToLong(String str) {
		if (str == null || "".equals(str)) {
			return new Long(0);
		} else {
			str = str.replace(".", "");
			str = str.replace("-", "");
			return Long.valueOf(StringUtils.trim(str, ' '));
		}
	}

	public static int verificaIntegerNulo(Integer nro) {
		if (nro == null) {
			return 0;
		} else {
			return nro.intValue();
		}

	}

	public static boolean isIntegerNUll(Integer nro) {
		if (nro == null) {
			return true;
		}
		
		return false;

	}

	public static BigDecimal verificaBigDecimalNulo(BigDecimal nro) {
		if (nro == null) {
			return BigDecimal.ZERO;
		} else {
			return nro;
		}
	}

	public static boolean isBigDecimalNull(BigDecimal nro) {
		if (nro == null) {
			return true;
		} 
		
		return false;
	}

	public static long verificaLongNulo(Long nro) {
		if (nro == null) {
			return 0l;
		} else {
			return nro.longValue();
		}
	}
	
	public static boolean isLongNull(Long nro) {
		if (nro == null) {
			return true;
		} 
		
		return false;
	}

	public static String extrairNumerosString(String string) {
		
		return string.replaceAll("[^0-9]*", "");
	}

    public static BigDecimal formatValoresToBigDecimal(String valor) {
        if (valor != null) {
            DecimalFormat format = (DecimalFormat) NumberFormat.getNumberInstance(PT_BR);
            format.applyPattern(DECIMAL_PATTERN);
            BigDecimal valorBD = new BigDecimal(valor);

            return valorBD;
        }
        return null;
    }

    public static String formatarNumRgString(Long numRg){
		
		if(numRg == null || numRg.toString().trim().length() != 9 ){
			
			return "";
		}
		
		String numRgFormatado = numRg.toString();		
		String tmp = "";
		
		for (int i = 0; i < numRgFormatado.length(); i++) {
			if(i == 2 || i == 5){
				tmp+=".";
				tmp+=numRgFormatado.charAt(i);
			}else
				if(i == (numRgFormatado.length() -1)){
					tmp+="-";
					tmp+=numRgFormatado.charAt(i);
				}else
					tmp+=numRgFormatado.charAt(i);
		}
		numRgFormatado = tmp;
		return numRgFormatado;
	}	

    
    public static <E> boolean isListNullOrEmpty(List<E> lista){
		if(lista == null){
			return true;
		}else{
			if(lista.isEmpty()){
				return true;
			}else{
				return false;
			}
		}
    }

    public static boolean isValorNullOrZero(BigDecimal valor) {
		return valor == null || BigDecimal.ZERO.compareTo(valor) == 0;
	}
    
}



