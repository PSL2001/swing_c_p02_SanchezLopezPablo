/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - Fecha.java
 * 23 nov 2022 - 9:43:12
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author usuario
 *
 */
public class Fecha {
	private String formato;
	
	public Fecha() {
		
	}
	
	public Fecha(String format) {
		this.formato = format;
	}
	
	/**
	 * Devolver fecha.
	 *
	 * @param formato the formato
	 * @return Fecha Formateada con el string enviado
	 */
	public String devolverFecha() {
		// TODO Auto-generated method stub
		SimpleDateFormat dtf = new SimpleDateFormat(this.formato);
		Calendar calendar = Calendar.getInstance();
		Date dateObj = calendar.getTime();
		return dtf.format(dateObj);
	}
	
	public String devolverFechaManiana() {
		SimpleDateFormat dtf = new SimpleDateFormat(this.formato);
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.DATE, 1);
		Date dateObj = fecha.getTime();
		return dtf.format(dateObj);
	}
	
	public long obtenerDiferencia(String fecha1, String fecha2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(this.formato);
		long diferencia = 0;
		
		Date fechaMenor;
		Date fechaMayor;
		try {
			fechaMenor = dateFormat.parse(fecha1);
			fechaMayor = dateFormat.parse(fecha2);
			
			//Obtenemos la diferencia de dias
			long tiempoms = fechaMayor.getTime() - fechaMenor.getTime();
			diferencia = TimeUnit.DAYS.convert(tiempoms, TimeUnit.MILLISECONDS);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diferencia;
	}
}
