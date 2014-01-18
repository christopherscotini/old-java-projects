package br.com.utmanager.view.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils extends AbstractUtils{

	/**
	 * Converte Data para string no formato definido na mascara.
	 * 
	 * @param data
	 *            Data a Ser formatada
	 * @param mascara
	 *            Mascara a ser aplicada na mascara: Ex: dd.MM.yyyy
	 * @return data formatada
	 */

	public static String parseString(Date data, String pattern) {

		String dataFormatada;
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		dataFormatada = df.format(data);

		return dataFormatada;
	}

	
	// Devolve a data passada como Long no formato de mascara
	// ex: 26/01/2011, yyyyMMdd -> 20110126
	public static Long converterDataLong(Date data, String mascara) {

		String dt = parseString(data, mascara);

		return Long.parseLong(dt);

	}

	// Retorna o dia da data em formato String
	public static String extrairParteData(Date data, int calendarPart) {
		Calendar date = dateToCalendar(data);

		if (data != null) {
			if(Calendar.DATE == calendarPart)
				return GlobalUtils.preencherZerosAEsquerda(String.valueOf(date.get(Calendar.DATE)), 2);
			else 
				if(Calendar.MONTH == calendarPart)
					return GlobalUtils.preencherZerosAEsquerda(String.valueOf(date.get(Calendar.MONTH) + 1), 2);
				else
					if(Calendar.YEAR == calendarPart)
						return String.valueOf(date.get(Calendar.YEAR));
		} 
		
		return "";
	}


	/**
	 * Concatena dia(Integer), m�s(Integer) e ano (Integer) e tem como retono uma String.
	 * 
	 * @param dia
	 *            Deve ser passado o dia em inteiro para a formata��o
	 * @param mes
	 *            Deve ser passado o m�s em inteiro para a formata��o
	 * @param ano
	 *            Deve ser passado o ano em inteiro para a formata��o
	 * @param formatacao
	 *            Deve ser passado a String que ser� utilizada como formata��o da data
	 * @return data formatada em String
	 */

	public static String concatenaDatas(Integer dia, Integer mes, Integer ano, String formatacao) {

		if (dia == null || mes == null || ano == null) {
			return "";

		} else {

			String diaString = GlobalUtils.preencherZerosAEsquerda(String.valueOf(dia), 2);
			String mesString = GlobalUtils.preencherZerosAEsquerda(String.valueOf(mes), 2);
			String anoString = GlobalUtils.preencherZerosAEsquerda(String.valueOf(ano), 4);

			StringBuilder concatena = new StringBuilder(diaString);

			concatena.append(mesString);
			concatena.append(anoString);

			concatena.insert(2, formatacao);
			concatena.insert(5, formatacao);

			return String.valueOf(concatena);
		}
	}
	
	 public static int diferencaDiasDatas(Date dt1, Date dt2) {  
	      long differenceMilliSeconds = dt2.getTime() - dt1.getTime();     

	      return (int)(differenceMilliSeconds/1000/60/60/24);      
	    }  
	    
	    public static int diferencaDiasDatasFuncDias360(Date dtInicial, Date dtFinal){

			Calendar c1 = dateToCalendar(dtInicial);
			Calendar c2 = dateToCalendar(dtFinal);
			
			if(c1.get(Calendar.DAY_OF_MONTH) > 30){
				c1.set(Calendar.DAY_OF_MONTH, 30);
			}
			
			if(c2.get(Calendar.DAY_OF_MONTH) > 30){
				c2.set(Calendar.DAY_OF_MONTH, 30);
			}
			
			int difMes = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
			int difAno = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			difMes = difMes + (12 * difAno);
			
			if (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)) {
				c1.set(Calendar.MONTH, 8);
				c2.set(Calendar.MONTH, 8);
			} else {
				c1.set(Calendar.MONTH, 8);
				c2.set(Calendar.MONTH, 9);
			}
			
			return c2.get(Calendar.DAY_OF_MONTH) - c1.get(Calendar.DAY_OF_MONTH) + (30 * difMes);
		 
		}
		
		public static Calendar dateToCalendar(Date date){ 
			if(date == null){
				return null;
			}else{
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				return cal;
			}
		}

}
