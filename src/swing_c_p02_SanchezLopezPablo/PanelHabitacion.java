/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - PanelHabitacion.java
 * 24 nov 2022 - 11:10:33
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelHabitacion.
 *
 * @author usuario
 */
public class PanelHabitacion extends JPanel implements ActionListener, ChangeListener, FocusListener {
	
	/** The lsuit. */
	private JLabel lhabitacion, lhabitaciones, ledad,limporte ,lsimple, ldoble, lsuit;
	
	/** The opciones hab. */
	public static JComboBox<String> opcionesHab;
	
	/** The img 3. */
	private ImageRes img1, img2, img3;
	
	/** The ninios. */
	public static JCheckBox ninios;
	
	/** The edad N. */
	public static JSpinner Shab, edadN;
	
	/** The panel ninios. */
	private JPanel panelNinios;
	
	/** The tf importe. */
	public static JTextField tfExtras, tfImporte;
	
	/** The c 3. */
	private Color c1, c2, c3;
	
	
	/**
	 * Instantiates a new panel habitacion.
	 */
	public PanelHabitacion() {
		this.iniciarComponentes();
	}

	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {
		lhabitacion = new JLabel("Tipo de habitacion ");
		lhabitaciones = new JLabel("Nº de habitaciones ");
		ledad = new JLabel("Edad de los niños ");
		limporte = new JLabel("Importe: ");
		
		ninios = new JCheckBox("¿Niños? ");
		
		
		Shab = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
		
		String[] opciones = {"Simple", "Doble", "Suite"};
		opcionesHab = new JComboBox<String>(opciones);
		
		//Declaramos las imagenes
		img1 = new ImageRes("recursos/simple.jpg", 0 , 0); 
		img2 = new ImageRes("recursos/doble.jpg", 0 , 0);
		img3 = new ImageRes("recursos/suite.jpg", 0 , 0);
		
		img1.setAncho(img1.getAncho()/8);
		img1.setLargo(img1.getLargo()/8);
		
		img2.setAncho(img2.getAncho()/4);
		img2.setLargo(img2.getLargo()/4);
		
		c1 = new Color(86, 126, 221);
		c2 = new Color(86, 167, 221);
		c3 = new Color(117, 225, 233);
		
		ninios.setBackground(c1);
		
		//Añadimos las imagenes al label
		lsimple = new JLabel(img1.devolverImagen());
		ldoble = new JLabel(img2.devolverImagen());
		lsuit = new JLabel(img3.devolverImagen());
		
		ldoble.setVisible(false);
		lsuit.setVisible(false);
		
		panelNinios = new JPanel();
		panelNinios.setVisible(false);
		
		edadN = new JSpinner(new SpinnerNumberModel(0, 0, 14, 1));
		
		tfExtras = new JTextField();
		tfExtras.setEnabled(false);
		tfImporte = new JTextField();
		
		//Listeners
		opcionesHab.addActionListener(this);
		ninios.addActionListener(this);
		edadN.addChangeListener(this);
		tfImporte.addFocusListener(this);
		
		
		Box cajaH3 = Box.createHorizontalBox();
		cajaH3.add(ledad);
		cajaH3.add(edadN);
		
		Box cajaH4 = Box.createHorizontalBox();
		cajaH4.add(limporte);
		cajaH4.add(tfImporte);
		
		Box cajaV = Box.createVerticalBox();
		cajaV.add(cajaH3);
		cajaV.add(Box.createHorizontalStrut(10));
		cajaV.add(tfExtras);
		cajaV.add(Box.createVerticalStrut(10));
		
		
		
		Box cajaH = Box.createHorizontalBox();
		cajaH.add(lhabitacion);
		cajaH.add(opcionesHab);
		
		Box cajaH2 = Box.createHorizontalBox();
		cajaH2.add(lhabitaciones);
		cajaH2.add(Shab);
		
		Box cajaV2 = Box.createVerticalBox();
		cajaV2.add(cajaH);
		cajaV2.add(Box.createVerticalStrut(10));
		cajaV2.add(lsimple);
		cajaV2.add(ldoble);
		cajaV2.add(lsuit);
		cajaV2.add(Box.createVerticalStrut(10));
		cajaV2.add(cajaH2);
		cajaV2.add(ninios);
		cajaV2.add(cajaH4);
		
		this.add(cajaV2);
		panelNinios.add(cajaV);
		panelNinios.setBackground(c1);
		panelNinios.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(c2, 2), "Niños"));
		this.add(panelNinios);
		this.setBackground(c1);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(c3, 2), "Datos de la habitacion"));
		
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object trigger = e.getSource();
		if (trigger == opcionesHab) {
			String opcion = (String) opcionesHab.getSelectedItem();
			muestraImagen(opcion);
		}
		if (trigger == ninios) {
			if (ninios.isSelected()) {
				panelNinios.setVisible(true);
			} else {
				panelNinios.setVisible(false);
			}
		}
		
	}

	/**
	 * Muestra imagen.
	 *
	 * @param opcion the opcion
	 */
	private void muestraImagen(String opcion) {
		switch (opcion) {
			case "Simple":
				lsimple.setVisible(true);
				ldoble.setVisible(false);
				lsuit.setVisible(false);
				break;
			case "Doble":
				lsimple.setVisible(false);
				ldoble.setVisible(true);
				lsuit.setVisible(false);
				break;
			case "Suite":
				lsimple.setVisible(false);
				ldoble.setVisible(false);
				lsuit.setVisible(true);
				break;
		}
		
	}

	

	/**
	 * Comprobar edad.
	 *
	 * @param edad the edad
	 * @return Tipo de cama para la habitacion
	 */
	private String comprobarEdad(int edad) {
		switch (edad) {
			case 0: case 1: case 2: case 3:
				return "Cuna";
		case 4: case 5: case 6: case 7: case 8: case 9: case 10:
				return "Cama supletoria pequeña";
		case 11: case 12: case 13: case 14:
				return "Cama supletoria normal";
			default:
				return "Selecciona una edad";
		}
		
	}


	/**
	 * State changed.
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		Object trigger = e.getSource();
		if (trigger == edadN) {
			int edad = (int) edadN.getValue();
			tfExtras.setText(comprobarEdad(edad));
		}
		
	}

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		Object trigger = e.getSource();
		if (trigger == tfImporte) {
			tfImporte.setText(calculoImporte());
		}
		
	}

	/**
	 * Calculo importe.
	 *
	 * @return the string
	 */
	private String calculoImporte() {
		int numeroDias = Integer.parseInt(PanelDatos.tfNumdias.getText());
		String tipoHabitacion = (String) opcionesHab.getSelectedItem();
		int totalImporte;
		int precioHabitacion = 0;
		
		switch (tipoHabitacion) {
			case "Simple":
				precioHabitacion = 50;
				break;
			case "Doble":
				precioHabitacion = 75;
				break;
			case "Suite":
				precioHabitacion = 125;
				break;
		}
		
		if (ninios.isSelected()) {
			totalImporte = (precioHabitacion + 20) * numeroDias;
		} else {
			totalImporte = precioHabitacion * numeroDias;
		}
		return Integer.toString(totalImporte);
	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
