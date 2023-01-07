/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - PanelDatos.java
 * 22 nov 2022 - 10:01:14
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelDatos.
 *
 * @author usuario
 */
public class PanelDatos extends JPanel implements FocusListener {
	
	/** The ldias. */
	private JLabel lnombre, lapellidos, ldni, ltelefono, lfechaEntrada, lfechaSalida, ldias;
	
	/** The tfapellidos. */
	public static JTextField tfnombre, tfapellidos;
	
	/** The tf numdias. */
	public static JTextField tfNumdias;
	
	/** The ftf fecha salida. */
	public static JFormattedTextField ftfDni, ftfTelefono, ftfFechaEntrada, ftfFechaSalida;
	
	/** The mf fecha. */
	private MaskFormatter mfDni, mfTelefono, mfFecha;
	
	/** The c 3. */
	private Color c1, c2, c3;
	
	/**
	 * Instantiates a new panel datos.
	 */
	public PanelDatos() {
		this.iniciarComponentes();
		this.setLayout(new GridLayout(1, 1, 1, 1));
	}

	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {
		lnombre = new JLabel("Nombre: "); 
		lapellidos = new JLabel("Apellidos: ");
		ldni = new JLabel("Dni: ");
		ltelefono = new JLabel("Telefono: ");
		lfechaEntrada = new JLabel("Fecha de Entrada: ");
		lfechaSalida = new JLabel("Fecha de Salida: ");
		ldias = new JLabel("Numero de días");
		
		tfnombre = new JTextField(); 
		tfapellidos = new JTextField();
		tfNumdias = new JTextField();
		
		c1 = new Color(86, 126, 221);
		c2 = new Color(86, 167, 221);
		c3 = new Color(117, 225, 233);
		
		
		
		try {
			//DNI son 8 numeros + 1 Letra en mayuscula 
			mfDni = new MaskFormatter("########U");
			//Telefono son 9 numeros
			mfTelefono = new MaskFormatter("#########");
			//Las fechas segirán un formato dd/mm/aaaa
			mfFecha = new MaskFormatter("##/##/####");
			
			ftfDni = new JFormattedTextField(mfDni); 
			ftfTelefono = new JFormattedTextField(mfTelefono);
			ftfFechaEntrada = new JFormattedTextField(mfFecha);
			ftfFechaSalida = new JFormattedTextField(mfFecha);
			
			ftfFechaSalida.addFocusListener(this);
			
			ftfFechaEntrada.setText(new Fecha("dd/MM/yyyy").devolverFecha());
			ftfFechaEntrada.setEnabled(false);
			ftfFechaSalida.setText(new Fecha("dd/MM/yyyy").devolverFechaManiana(ftfFechaEntrada.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long diferencia = new Fecha("dd/MM/yyyy").obtenerDiferencia(ftfFechaEntrada.getText(), ftfFechaSalida.getText());
		tfNumdias.setText(Long.toString(diferencia));
		
		
		
		Box cajaV = Box.createVerticalBox();
		Box cajaH = Box.createHorizontalBox();
		
		cajaH.add(lnombre);
		cajaH.add(tfnombre);
		
		cajaV.add(cajaH);
		cajaV.add(Box.createVerticalStrut(10));
		
		Box cajaH2 = Box.createHorizontalBox();
		cajaH2.add(lapellidos);
		cajaH2.add(tfapellidos);
		
		cajaV.add(cajaH2);
		cajaV.add(Box.createVerticalStrut(10));
		
		Box cajaH3 = Box.createHorizontalBox();
		cajaH3.add(ldni);
		cajaH3.add(ftfDni);
		
		cajaV.add(cajaH3);
		cajaV.add(Box.createVerticalStrut(10));
		
		Box cajaH4 = Box.createHorizontalBox();
		cajaH4.add(ltelefono);
		cajaH4.add(ftfTelefono);
		
		cajaV.add(cajaH4);
		cajaV.add(Box.createVerticalStrut(10));
		
		Box cajaH5 = Box.createHorizontalBox();
		cajaH5.add(lfechaEntrada);
		cajaH5.add(ftfFechaEntrada);
		
		cajaV.add(cajaH5);
		cajaV.add(Box.createVerticalStrut(10));
		
		Box cajaH6 = Box.createHorizontalBox();
		cajaH6.add(lfechaSalida);
		cajaH6.add(ftfFechaSalida);
		
		cajaV.add(cajaH6);
		cajaV.add(Box.createVerticalStrut(10));
		
		Box cajaH7 = Box.createHorizontalBox();
		cajaH7.add(ldias);
		cajaH7.add(tfNumdias);
		
		cajaV.add(cajaH7);
		cajaV.add(Box.createVerticalStrut(10));
		
//		this.add(lnombre);
//		this.add(tfnombre);
//		this.add(lapellidos);
//		this.add(tfapellidos);
//		this.add(ldni);
//		this.add(ftfDni);
//		this.add(ltelefono);
//		this.add(ftfTelefono);
//		this.add(lfechaEntrada);
//		this.add(ftfFechaEntrada);
//		this.add(lfechaSalida);
//		this.add(ftfFechaSalida);
//		this.add(ldias);
//		this.add(tfNumdias);
		
		this.setBackground(c1);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(c3, 2), "Datos a introducir"));
		this.add(cajaV);
		
	}

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		
		
	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		Object trigger = e.getSource();
		if (trigger == ftfFechaSalida) {
			Fecha fecha = new Fecha("dd/MM/yyyy", ftfFechaEntrada.getText());

			long diferencia = new Fecha("dd/MM/yyyy").obtenerDiferencia(fecha.getFecha(), ftfFechaSalida.getText());
			tfNumdias.setText(Long.toString(diferencia));
		}
		
	}
}
