/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - PanelHabitacion.java
 * 24 nov 2022 - 11:10:33
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

/**
 * @author usuario
 *
 */
public class PanelHabitacion extends JPanel implements ActionListener, FocusListener {
	private JLabel lhabitacion, lhabitaciones, ledad,limporte ,lsimple, ldoble, lsuit;
	private JComboBox<String> opcionesHab;
	private ImageRes img1, img2, img3;
	private JCheckBox ninios;
	private JSpinner Shab, edadN;
	private JPanel panelNinios;
	private JTextField tfExtras, tfImporte;
	
	
	public PanelHabitacion() {
		this.iniciarComponentes();
	}

	/**
	 * 
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
		tfImporte.setEnabled(false);
		
		//Listeners
		opcionesHab.addActionListener(this);
		ninios.addActionListener(this);
		tfExtras.addFocusListener(this);
		
		
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
		cajaV.add(cajaH4);
		
		
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
		
		this.add(cajaV2);
		panelNinios.add(cajaV);
		this.add(panelNinios);
		
	}

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
	 * @param selectedItem
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

	@Override
	public void focusGained(FocusEvent e) {
		Object trigger = e.getSource();
		if (trigger == tfExtras) {
			int edad = (int) edadN.getValue();
			comprobarEdad(edad);
		}
		
	}

	/**
	 * @param edad
	 */
	private void comprobarEdad(int edad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
