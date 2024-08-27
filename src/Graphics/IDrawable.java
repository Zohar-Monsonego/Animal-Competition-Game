package Graphics;

import java.awt.Graphics;


/**
 * The {@code IDrawable} interface specifies methods for loading and drawing images.
 * 
 * This interface includes:
 * - A constant {@link #PICTURE_PATH} for the default path where images are stored.
 * - A method {@link #loadImage(String)} to load an image from a given path.
 * - A method {@link #drawObject(Graphics)} to draw the loaded image onto a {@link Graphics} context.
 */
public interface IDrawable {
	
	/**
     * Default path for storing images.
     */
	public final static String PICTURE_PATH = "src//Images";
	
	/**
     * Loads an image from the specified file path.
     * 
     * @param nm The path to the image file.
     */
	public void loadImage(String nm);
	
	/**
     * Draws the loaded image onto the provided {@link Graphics} context.
     * 
     * @param g The {@link Graphics} object to draw the image onto.
     */
	public void drawObject(Graphics g);

}
