package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Animals.Animal;
import Animals.Orientation;
import Mobility.Location;
import Mobility.Point;


/**
 * The Drawable class implements the IDrawable interface and provides functionality
 * to load and draw images for an animal based on its orientation.
 */
public class Drawable implements IDrawable{
	BufferedImage img1,img2,img3,img4;
	Point location;
	int size;
	Orientation orien;

	/**
	 * Constructs a {@code Drawable} object with the specified parameters.
	 * 
	 * @param loc The location of the drawable object as a {@link Point}.
	 * @param s The size of the drawable object.
	 * @param o The orientation of the drawable object as an {@link Orientation} enum.
	 */
	public Drawable(Point loc, int s, Orientation o) {
		this.location = loc;
		this.size = s;
		this.orien = o;
	}
	
	
	 /**
     * Loads images from the specified file paths.
     * 
     * @param img1_path path to the image for the EAST orientation
     * @param img2_path path to the image for the SOUTH orientation
     * @param img3_path path to the image for the WEST orientation
     * @param img4_path path to the image for the NORTH orientation
     */
	public void loadImage(String img1_path,String img2_path,String img3_path,String img4_path) {
		try {
			img1 = ImageIO.read(new File(img1_path));
			img2 = ImageIO.read(new File(img2_path));
			img3 = ImageIO.read(new File(img3_path));
			img4 = ImageIO.read(new File(img4_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
     * Loads a single image from the specified file path.
     * 
     * @param img1_path path to the image
     */
	public void loadImage(String img1_path) {
		try {
			img1 = ImageIO.read(new File(img1_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	/**
     * Draws the image of the animal based on its orientation.
     * 
     * @param g the Graphics object to draw on
     */
	public void drawObject(Graphics g) {
		switch(this.orien) {
        case EAST:
            g.drawImage(img1, this.location.getX(),this.location.getY(), this.size, this.size,null);
            break;
        case SOUTH:
            g.drawImage(img2, this.location.getX(),this.location.getY(), this.size, this.size,null);
            break;
        case WEST:
            g.drawImage(img3, this.location.getX(),this.location.getY(), this.size, this.size,null);
            break;
        case NORTH:
            g.drawImage(img4,  this.location.getX(),this.location.getY(), this.size, this.size,null);
            break;
        default:
            break;
		}
	
	}
	
	
	
	
	/**
     * Returns the image for the EAST orientation.
     * 
     * @return the image for the EAST orientation
     */
	public BufferedImage getImg1() {
		return this.img1;
	}
	
	/**
     * Returns the image for the SOUTH orientation.
     * 
     * @return the image for the SOUTH orientation
     */
	public BufferedImage getImg2() {
		return this.img2;
	}
	
	
	/**
     * Returns the image for the WEST orientation.
     * 
     * @return the image for the WEST orientation
     */
	public BufferedImage getImg3() {
		return this.img3;
	}
	
	 /**
     * Returns the image for the NORTH orientation.
     * 
     * @return the image for the NORTH orientation
     */
	public BufferedImage getImg4() {
		return this.img4;
	}
	
}
