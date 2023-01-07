/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - PanelTitulo.java
 * 22 nov 2022 - 10:02:37
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelTitulo.
 *
 * @author usuario
 */
public class PanelTitulo extends JPanel {
	
	/** The logo. */
	private ImageRes logo;
	
	/** The limagen. */
	private JLabel nombreHotel, limagen;
	
	/** The c 3. */
	private Color c1, c2, c3;
	
	/**
	 * Instantiates a new panel titulo.
	 */
	public PanelTitulo() {
		this.iniciarComponentes();
	}

	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {
		logo = new ImageRes("recursos/icono.png", 0 , 0);
		logo.setAncho(logo.getAncho()/4);
		logo.setLargo(logo.getLargo()/4);
		
		limagen = new JLabel(logo.devolverImagen(), SwingConstants.CENTER);
		nombreHotel = new JLabel("Hoteles Al-Andalus", SwingConstants.CENTER);
		
		c1 = new Color(86, 126, 221);
		c2 = new Color(86, 167, 221);
		c3 = new Color(117, 225, 233);
		
		nombreHotel.setForeground(c2);
		nombreHotel.setFont(new Font("Arial", Font.BOLD, 30));
		
		this.setBackground(c1);
		this.setBorder(BorderFactory.createLineBorder(c3, 3));
		this.add(limagen);
		this.add(nombreHotel);
	}
}
