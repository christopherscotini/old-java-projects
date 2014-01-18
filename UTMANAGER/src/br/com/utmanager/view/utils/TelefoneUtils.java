package br.com.utmanager.view.utils;

public class TelefoneUtils extends AbstractUtils{
	
	public static String parseString(Long numTelefoneCelular){
    	String numTelefoneString = numTelefoneCelular.toString();

    	if(numTelefoneCelular == null || (numTelefoneString.trim().length() != 10 && numTelefoneString.trim().length() != 11)){
    		return "";
    	}
    	
    	if(numTelefoneString.length() > 10){
    		formataNumCelular(numTelefoneString);
    	}else{
    		formataNumTelefonePadrao(numTelefoneString);
    	}
    	
		return numTelefoneString;

    }
	
	public static Long parseLong(String telefone){
		try{
			return (Long) parseNumber(telefone);
    	}catch(NullPointerException np){
    		return null;
    	}
	}
	
	private static void formataNumTelefonePadrao(String str) {
		str = parseString(PHONE_PATTERN, str);
	}

	private static void formataNumCelular(String str) {
		str = parseString(CELL9_PATTERN, str);
	}

}
