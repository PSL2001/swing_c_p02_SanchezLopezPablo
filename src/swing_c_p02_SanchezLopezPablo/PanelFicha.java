/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - PanelFicha.java
 * 26 nov 2022 - 19:54:41
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelFicha.
 *
 * @author Usuario
 */
public class PanelFicha extends JTabbedPane {
	
	/** The panel habitacion. */
	private JPanel panelDatos, panelHabitacion;
	
	/** The label 2. */
	private JLabel label1, label2;
	
	/** The area de texto. */
	public static JTextArea textArea1, textArea2;
	
	/** The c 3. */
	private Color c1, c2, c3;
	
	/**
	 * Instantiates a new panel ficha.
	 */
	public PanelFicha() {
		componentesPanel1();
		componentesPanel2();
		
		c1 = new Color(86, 126, 221);
		c2 = new Color(86, 167, 221);
		c3 = new Color(117, 225, 233);
		
		this.addTab("Datos del Cliente", panelDatos);
		this.addTab("Datos de la Habitacion", panelHabitacion);
		
		panelDatos.setBackground(c1);
		panelHabitacion.setBackground(c1);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(c3, 2), "Ficha de Datos"));
	}
	
	/**
	 * Componentes panel 2.
	 */
	private void componentesPanel2() {
		panelHabitacion = new JPanel();
		label2 = new JLabel("Datos de la Habitacion: ");
		String texto = "Tipo de habitacion y numero de habitaciones: " + PanelHabitacion.opcionesHab.getSelectedItem() + " " + PanelHabitacion.Shab.getValue()
		+ "\n¿Niños? " + PanelHabitacion.ninios.isSelected();
		if (PanelHabitacion.ninios.isSelected()) {
			texto += "\nEdad de los niños: " + PanelHabitacion.edadN.getValue();
		} else {
			texto += "\n";
		}
		textArea2 = new JTextArea();
		textArea2.setText(texto);
		this.add(panelHabitacion);
		panelHabitacion.add(textArea2);
	}
	
	/**
	 * Componentes panel 1.
	 */
	private void componentesPanel1() {
		panelDatos = new JPanel();
		label1 = new JLabel("Datos del Cliente");
		String texto = "Nombre y Apellidos: " + PanelDatos.tfnombre.getText() + " " + PanelDatos.tfapellidos.getText() + "\nDni: " + PanelDatos.ftfDni.getText()
		 + "\nTelefono: " + PanelDatos.ftfTelefono.getText() + "\nFecha de Entrada: " + PanelDatos.ftfFechaEntrada.getText() + "\nFecha de Salida: " + PanelDatos.ftfFechaSalida.getText()
		 + "\nNumero de Dias: " + PanelDatos.tfNumdias.getText();
		textArea1 = new JTextArea();
		textArea1.setText(texto);
		panelDatos.add(textArea1);
		this.add(panelDatos);
		
	}

}
