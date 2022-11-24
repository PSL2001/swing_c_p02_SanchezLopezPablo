/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - Dialogo.java
 * 21 nov 2022 - 10:12:20
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

/**
 * @author usuario
 *
 */
public class Dialogo extends JDialog {
	private JScrollPane scrollPaneles;
	private PanelTitulo titulo;
	private PanelDatos datos;
	private PanelHabitacion habitacion;
	
	public Dialogo(Ventana v, boolean modal, int ancho, int alto) {
		super(v, modal);
		this.setTitle("Alta Reservas");
		this.setSize(ancho, alto);
		this.iniciarComponentes();
		
	}

	/**
	 * 
	 */
	private void iniciarComponentes() {
		scrollPaneles = new JScrollPane(); 
		titulo = new PanelTitulo();
		datos = new PanelDatos();
		habitacion = new PanelHabitacion();
		
		Box cajaV = Box.createVerticalBox();
		cajaV.add(datos);
		cajaV.add(habitacion);
		
		/*Definimos las propiedades del JSCrollPanel*/
		scrollPaneles.setAutoscrolls(true);//indicamos que se creen automaticamente los scroll
	    this.getContentPane().add(scrollPaneles);
//		scrollPaneles.setViewportView();//agregamos el panel al scroll 
		
		this.add(titulo, BorderLayout.NORTH);
		this.add(cajaV, BorderLayout.CENTER);
	}

}
