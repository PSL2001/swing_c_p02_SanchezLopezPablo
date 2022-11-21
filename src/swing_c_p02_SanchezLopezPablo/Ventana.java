/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - Ventana.java
 * 21 nov 2022 - 9:25:34
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

/**
 * @author usuario
 *
 */
public class Ventana extends JFrame implements ActionListener {
	private Toolkit pantalla;
	private JMenuBar menu;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, areserva, breserva, acerca;
	private JButton btnAreserva, btnBreserva; 
	
	public Ventana() {
		super("Gestión Hotel Al-Ándalus");
		this.centrarPantalla();
		this.insertarImagen(getClass().getResource("recursos/icono.png"));
		this.setLayout(new FlowLayout());
		this.iniciarComponentes();
	}

	/**
	 * 
	 */
	private void iniciarComponentes() {
		//Primero creamos el menu
		menu = new JMenuBar();
		
		//Creamos los componentes principales del menu
		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		ayuda = new JMenu("Ayuda");
		
		//Creamos los subcomponentes para cada menu
		salir = new JMenuItem("Salir");
		areserva = new JMenuItem("Alta Reservas");
		breserva = new JMenuItem("Baja Reservas");
		acerca = new JMenuItem("Acerca de...");
		
		//Añadimos las opciones a los menus
		archivo.add(salir);
		registro.add(areserva);
		registro.add(breserva);
		ayuda.add(acerca);
		
		//Y añadimos a la barra
		menu.add(archivo);
		menu.add(registro);
		menu.add(ayuda);
		
		//Por ultimo añadimos la barra en la ventana
		this.setJMenuBar(menu);
		
		
		//Añadimos los botones
		btnAreserva = new JButton("Alta Reservas"); 
		btnBreserva = new JButton("Baja Reservas");
		
		this.add(btnAreserva);
		this.add(btnBreserva);
	}

	/**
	 * @param url 
	 * 
	 */
	private void insertarImagen(URL url) {
		//Obtenemos la imagen que pasamos por parametro
		Image icono = pantalla.getImage(url);
		//Y la añadimos como icono
		this.setIconImage(icono);
	}

	/**
	 * 
	 */
	private void centrarPantalla() {
		//Obtenemos la pantalla con ToolKit
		pantalla = Toolkit.getDefaultToolkit();
		//Obtenemos la resolucion
		Dimension tamanio = pantalla.getScreenSize();
		//Obtenemos el ancho y el alto de la pantalla y los guardamos
		int ancho = tamanio.width;
		int alto = tamanio.height;
		//Para tener el tamaño de la ventana a la mitad, usamos setSize y dividimos el ancho y el alto entre 2
		this.setSize(ancho/2, alto/2);
		//Y para centrar lo dividimos entre 4 con setLocation
		this.setLocation(ancho/4, alto/4);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
