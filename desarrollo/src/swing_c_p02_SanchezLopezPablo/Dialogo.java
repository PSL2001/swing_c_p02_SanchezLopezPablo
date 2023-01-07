/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - Dialogo.java
 * 21 nov 2022 - 10:12:20
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

// TODO: Auto-generated Javadoc
/**
 * The Class Dialogo.
 *
 * @author usuario
 */
public class Dialogo extends JDialog implements ActionListener {
	
	/** The scroll paneles. */
	private JScrollPane scrollPaneles;
	
	/** The titulo. */
	private PanelTitulo titulo;
	
	/** The datos. */
	private PanelDatos datos;
	
	/** The habitacion. */
	private PanelHabitacion habitacion;
	
	/** The ficha. */
	private PanelFicha ficha;
	
	/** The guardar. */
	private JButton imprimir, nuevo, guardar;
	
	/**
	 * Instantiates a new dialogo.
	 *
	 * @param v the v
	 * @param modal the modal
	 * @param ancho the ancho
	 * @param alto the alto
	 */
	public Dialogo(Ventana v, boolean modal, int ancho, int alto) {
		super(v, modal);
		this.setTitle("Alta Reservas");
		this.setSize(ancho, alto);
		this.iniciarComponentes();
		
	}

	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {
		scrollPaneles = new JScrollPane(); 
		titulo = new PanelTitulo();
		datos = new PanelDatos();
		habitacion = new PanelHabitacion();
		ficha = new PanelFicha();
		imprimir = new JButton("Imprimir");
		nuevo = new JButton("Nuevo");
		guardar = new JButton("Guardar");
		
		Box cajaV = Box.createVerticalBox();
		cajaV.add(datos);
		cajaV.add(habitacion);
		
		Box cajaH = Box.createHorizontalBox();
		cajaH.add(imprimir);
		cajaH.add(Box.createHorizontalStrut(10));
		cajaH.add(guardar);
		cajaH.add(Box.createHorizontalStrut(10));
		cajaH.add(nuevo);
		
		//Listeners
		imprimir.addActionListener(this);
		nuevo.addActionListener(this);
		guardar.addActionListener(this);
		
		
		/*Definimos las propiedades del JSCrollPanel*/
		scrollPaneles.setAutoscrolls(true);//indicamos que se creen automaticamente los scroll
	    this.getContentPane().add(scrollPaneles);
//		scrollPaneles.setViewportView();//agregamos el panel al scroll 
		
		this.add(titulo, BorderLayout.NORTH);
		this.add(cajaV, BorderLayout.CENTER);
		this.add(ficha, BorderLayout.EAST);
		this.add(cajaH, BorderLayout.SOUTH);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Detectamos el trigger y llamamos a la funcion correspondiente
		Object trigger = e.getSource();
		if (trigger == imprimir) {
			mostrarDatos();
		}
		
		if (trigger == nuevo) {
			borrar();
		}
		
		if (trigger == guardar) {
			guardar();
		}
		
	}

	/**
	 *  Comprueba que los datos no estan vacios y si no lo.
	 */
	private void guardar() {
		String nombre = (PanelDatos.tfnombre.getText().isEmpty() ||  PanelDatos.tfapellidos.getText().isEmpty()) ? null : PanelDatos.tfnombre.getText() + " " + PanelDatos.tfapellidos.getText();
		String dni = (PanelDatos.ftfDni.getText().trim().isEmpty()) ? null : PanelDatos.ftfDni.getText();
		String telefono = (PanelDatos.ftfTelefono.getText().trim().isEmpty()) ? null : PanelDatos.ftfTelefono.getText();
		String fechaEntrada = (PanelDatos.ftfFechaEntrada.getText().trim().isEmpty()) ? null : PanelDatos.ftfFechaEntrada.getText();
		String fechaSalida = (PanelDatos.ftfFechaSalida.getText().trim().isEmpty()) ? null : PanelDatos.ftfFechaSalida.getText();
		String numeroDias = (PanelDatos.tfNumdias.getText().trim().isEmpty()) ? null : PanelDatos.tfNumdias.getText();
		
		if (nombre == null || telefono == null || fechaEntrada == null || fechaSalida == null || numeroDias == null || dni == null) {
			JOptionPane.showMessageDialog(this, "Uno o mas campos están vacios");
		} else {
			JOptionPane.showMessageDialog(this, "Guardado");
		}
		
	}

	/**
	 * Funcion que borra los textos.
	 */
	private void borrar() {
		PanelFicha.textArea1.setText("");
		PanelDatos.tfnombre.setText("");
		PanelDatos.tfapellidos.setText("");
		PanelDatos.ftfDni.setText("");
		PanelDatos.ftfTelefono.setText("");
		PanelDatos.ftfFechaSalida.setText("");
		PanelDatos.tfNumdias.setText("");
		
		
		PanelDatos.tfnombre.requestFocus();
		
	}

	/**
	 * detecta que no esten vacios y si no lo están los muestra en el tab correspondiente.
	 */
	private void mostrarDatos() {
		String nombre = (PanelDatos.tfnombre.getText().isEmpty() ||  PanelDatos.tfapellidos.getText().isEmpty()) ? null : PanelDatos.tfnombre.getText() + " " + PanelDatos.tfapellidos.getText();
		String dni = (PanelDatos.ftfDni.getText().trim().isEmpty()) ? null : PanelDatos.ftfDni.getText();
		String telefono = (PanelDatos.ftfTelefono.getText().trim().isEmpty()) ? null : PanelDatos.ftfTelefono.getText();
		String fechaEntrada = (PanelDatos.ftfFechaEntrada.getText().trim().isEmpty()) ? null : PanelDatos.ftfFechaEntrada.getText();
		String fechaSalida = (PanelDatos.ftfFechaSalida.getText().trim().isEmpty()) ? null : PanelDatos.ftfFechaSalida.getText();
		String numeroDias = (PanelDatos.tfNumdias.getText().trim().isEmpty()) ? null : PanelDatos.tfNumdias.getText();
		
		if (nombre == null || telefono == null || fechaEntrada == null || fechaSalida == null || numeroDias == null || dni == null) {
			JOptionPane.showMessageDialog(this, "Uno o mas campos están vacios");
		} else {
			String texto = "Nombre y Apellidos: " + nombre + "\nDni: " + dni
			 + "\nTelefono: " + telefono + "\nFecha de Entrada: " + fechaEntrada + "\nFecha de Salida: " + fechaSalida
			 + "\nNumero de Dias: " + numeroDias;
			PanelFicha.textArea1.setText(texto);
			
			String texto2 = "Tipo de habitacion y numero de habitaciones: " + PanelHabitacion.opcionesHab.getSelectedItem() + " " + PanelHabitacion.Shab.getValue()
			+ "\n¿Niños? " + PanelHabitacion.ninios.isSelected();
			if (PanelHabitacion.ninios.isSelected()) {
				texto2 += "\nEdad de los niños: " + PanelHabitacion.edadN.getValue();
			} else {
				texto2 += "\n";
			}
			
			PanelFicha.textArea2.setText(texto2);
		}
	}

}
