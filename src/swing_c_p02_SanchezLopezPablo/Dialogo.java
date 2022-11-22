/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - Dialogo.java
 * 21 nov 2022 - 10:12:20
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.BorderLayout;

import javax.swing.JDialog;

/**
 * @author usuario
 *
 */
public class Dialogo extends JDialog {
	private PanelTitulo titulo;
	
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
		titulo = new PanelTitulo();
		this.add(titulo, BorderLayout.NORTH);
	}

}
