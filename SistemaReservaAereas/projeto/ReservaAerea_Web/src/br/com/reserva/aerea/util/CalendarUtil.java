package br.com.reserva.aerea.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarUtil {

	private static final String FORMATO_PADRAO_DATA = "dd/MM/yyyy HH:mm";

	/**
	 * Formata string do padrão dd/MM/yyyy HH:mm para formato Calendar.
	 * 
	 * @param date
	 *            - String no formato dd/MM/yyyy HH:mm
	 * @return Calendar
	 */
	public static Calendar parseStringToCalendar(String date) {
		Calendar cal = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_PADRAO_DATA);
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}
	/**
	 * Metodo responsavel por converter um objeto calendar para o tipo String
	 * no padrão dd/MM/yyyy HH:mm
	 * 
	 * @param date - tipo calendar a ser convertido
	 * @return String no formato dd/MM/yyyy HH:mm
	 */
	public static String parseCalendarToString(Calendar date){
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_PADRAO_DATA);
		return sdf.format(date.getTime());
	}

}
