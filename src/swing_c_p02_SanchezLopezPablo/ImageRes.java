/**
 * swing_c_p02_SanchezLopezPablo - swing_c_p02_SanchezLopezPablo - ImageRes.java
 * 22 nov 2022 - 9:50:00
 * @author Pablo Sánchez López
 */
package swing_c_p02_SanchezLopezPablo;

import java.awt.Image;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageRes.
 *
 * @author usuario
 */
public class ImageRes {
	/** The recurso. */
	private ImageIcon recurso;
	
	/** The ancho. */
	private int ancho;
	
	/** The largo. */
	private int largo;
	

	/**
	 * Instantiates a new image res.
	 *
	 * @param recurso the recurso
	 * @param ancho   the ancho
	 * @param largo   the largo
	 */
	public ImageRes(String recurso, int ancho, int largo) {
		this.recurso = new ImageIcon(getClass().getResource(recurso));
		this.ancho = (ancho == 0) ? this.getAncho() : ancho;
		this.largo = (largo == 0) ? this.getLargo() : largo;
	}
	
	/**
	 * Devolver imagen.
	 *
	 * @return the image icon
	 */
	public ImageIcon devolverImagen() {
		//Primero crea una ImageIcon usando la resolucion de la misma imagen
		ImageIcon imagenSinRes = this.recurso;
		//De esta crea una Image usando getImage()
		Image imagenImage = imagenSinRes.getImage();
		// Creamos otra imagen pero esta vez usamos getScaledinstance usando el ancho y largo que se nos ha pasado
		Image imageRes = imagenImage.getScaledInstance(this.ancho, this.largo ,Image.SCALE_SMOOTH);
		//Creamos una nueva imageIcon con la nueva resolucion
		ImageIcon imageIconRes = new ImageIcon(imageRes);
		//Y la devolvemos
		return imageIconRes;
	}
	
	/**
	 * Gets the recurso.
	 *
	 * @return the recurso
	 */
	public ImageIcon getRecurso() {
		return recurso;
	}

	/**
	 * Sets the recurso.
	 *
	 * @param recurso the recurso to set
	 */
	public void setRecurso(ImageIcon recurso) {
		this.recurso = recurso;
	}

	/**
	 * Gets the ancho.
	 *
	 * @return the ancho
	 */
	public int getAncho() {
		ImageIcon imagen = this.recurso;
		return imagen.getIconWidth();
	}

	/**
	 * Sets the ancho.
	 *
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * Gets the largo.
	 *
	 * @return the largo
	 */
	public int getLargo() {
		ImageIcon imagen = this.recurso;
		return imagen.getIconHeight();
	}

	/**
	 * Sets the largo.
	 *
	 * @param largo the largo to set
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}
}
