package br.com.utmanager.view.utils;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public abstract class AbstractUtils {

	protected final static String CEP_PATTERN = "#####-###";
	protected final static String CPF_PATTERN = "###.###.###-##";
	protected final static String CNPJ_PATTERN = "##.###.###/####-##";

	protected final static String CELL9_PATTERN = "(##) #####-####";
	protected final static String PHONE_PATTERN = "(##) ####-####";

	
	protected static String parseString(String pattern, Object value) throws NullPointerException{
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
	
	protected static Number parseNumber (String str) throws NullPointerException{
		str = str.replaceAll("[^0-9]*", "");
		return (Number) Long.parseLong(str);
	}
	
}
