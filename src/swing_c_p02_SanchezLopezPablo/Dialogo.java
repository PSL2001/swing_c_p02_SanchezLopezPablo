/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - Dialogo.java
 * 21 nov 2022 - 10:12:20
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import javax.swing.JDialog;

/**
 * @author usuario
 *
 */
public class Dialogo extends JDialog {
	
	public Dialogo(Ventana v, boolean modal) {
		super(v, modal);
		this.setSize(v.getSize());
		this.setLocation(v.getLocation());
	}

}
