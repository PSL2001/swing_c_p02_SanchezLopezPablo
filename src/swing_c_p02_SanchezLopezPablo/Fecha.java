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

// TODO: Auto-generated Javadoc
/**
 * The Class Fecha.
 *
 * @author usuario
 */
public class Fecha {
	
	/** The formato. */
	private String formato;
	
	/** The fecha. */
	private String fecha;
	
	/**
	 * Instantiates a new fecha.
	 */
	public Fecha() {
		
	}
	
	/**
	 * Instantiates a new fecha.
	 *
	 * @param format the format
	 */
	public Fecha(String format) {
		this.formato = format;
	}
	
	/**
	 * Instantiates a new fecha.
	 *
	 * @param format the format
	 * @param fecha the fecha
	 */
	public Fecha(String format, String fecha) {
		this.formato = format;
		this.setFecha(fecha);
	}

	/**
	 * Devolver fecha.
	 *
	 * @return Fecha Formateada con el string enviado
	 */
	public String devolverFecha() {
		// TODO Auto-generated method stub
		SimpleDateFormat dtf = new SimpleDateFormat(this.formato);
		Calendar calendar = Calendar.getInstance();
		Date dateObj = calendar.getTime();
		return dtf.format(dateObj);
	}
	
	/**
	 * Devolver fecha maniana.
	 *
	 * @param fecha the fecha
	 * @return the string
	 */
	public String devolverFechaManiana(String fecha) {
		SimpleDateFormat dtf = new SimpleDateFormat(this.formato);
		Date fechaParse;
		Date maniana = null;
		try {
			fechaParse = dtf.parse(fecha);
			maniana = new Date(fechaParse.getTime() + TimeUnit.DAYS.toMillis(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtf.format(maniana);
	}
	
	/**
	 * Obtener diferencia.
	 *
	 * @param fecha1 the fecha 1
	 * @param fecha2 the fecha 2
	 * @return the long
	 */
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

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public String getFecha() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(this.formato);
		Date fechaNueva = null;
		try {
			 fechaNueva = dateFormat.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateFormat.format(fechaNueva);
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
