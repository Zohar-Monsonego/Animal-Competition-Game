package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;
import Olympics.Medal;


/**
 * The class represents a dolphin, the class expands the class: WaterlAnimal.
 * The field in the class:
 * - water_type - What water does the dolphin live in.
 */
public class Dolphin extends WaterAnimal{
	
	
	/**
	 * The sound the dolphin makes.
	 */
	private static final String SOUND = "Click Click";
	private WaterType water_type;
	private static final String PATH_IMG = "src//Images/dolphin1.png";
	
	
	/**
	 * A default constructor that creates an object of type Dolphin and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Dolphin() {
		super();
		this.water_type = WaterType.SEA;
	}
	
	
	 /**
     * Constructor that creates a Dolphin object with specific values for name, speed, energy,
     * competition type, and track.
     * @param name The dolphin's name
     * @param speed The dolphin's speed
     * @param energy_meter The dolphin's energy in meters
     * @param comp The competition type for the dolphin
     * @param track The track for the dolphin
     */
	public Dolphin(String name,int speed,int energy_meter,String comp,String track) {
		super(name,speed,energy_meter,PATH_IMG,comp,track);
		this.water_type = WaterType.SWEET;
	}
	
	
	/**
	 * A constructor that creates an object of type Dolphin and initializes the parameters with the 
	 * values received from the user.
	 * @param _name The dolphin's name
	 * @param g The dolphin's gender
	 * @param w The dolphin's weight
	 * @param sp The dolphin's speed
	 * @param m An array of medals the dolphin has
	 * @param p The dolphin's location
	 * @param td The total destance the dolphin traveled
	 * @param dive_d The dolphin's dive dept
	 * @param wt The type of water the dolphin lives in
	 */
	public Dolphin(String _name, Gender g, double w, int sp, Medal[] m, Point p, double dive_d, WaterType wt) {
		super(_name,g,w,sp,m,p,dive_d);
		this.water_type = wt;
		
	}
	
	
	/**
	 * The method checks if two objects of type Dolphin are the same.
	 * Two Dolphines are considered equal if they have the same properties and water type.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Dolphin) {
			Dolphin other = (Dolphin)obj;
			if(super.equals(other) && this.water_type == other.water_type)
				ans = true;
		}
		return ans;
	}
	
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Dolphin.
	 */
	public String toString() {
		return super.toString() + "\n" + 
	    "Water type:" + this.getWaterType();
	}
	
	
	/**
	 * Gets the water type.
	 * @return The water type.
	 */
	protected WaterType getWaterType() {
		return water_type;
	}
	
	
	/**
	 * @override of the method getType() from Animal.
	 * Gets the type of the class.
	 * @return The type of the class.
	 */
	public String getType() {
		return "Dolphin";
	}
	
	
	/**
	 * @override of the method getSound() from Animal.
	 * Gets the sound the dolphin makes.
	 * @return The Dolphin's sound.
	 */
	protected String getSound() {
		return SOUND;
	}
	
	
	/**
     * Draws the dolphin on the provided graphics context.
     * This method utilizes the superclass's drawObject method to render the dolphin image.
     * @param g The graphics context to draw on
     */
    @Override
	public void drawObject(Graphics g) {
		super.drawObject(g);
	}
	
    
    /**
     * Gets the category of the animal by invoking the superclass method.
     * @return The category of the animal
     */
    @Override
	public String getCategory() {
		return super.getCategory();
	}
    
    
    /**
     * Loads an image from the specified file path.
     * 
     * This method overrides the {@code loadImage} method from the superclass.
     * It loads an image from the given file path and performs any necessary
     * operations defined in the superclass method.
     * 
     * @param s The file path of the image to be loaded.
     */
    public void loadImage(String s) {
    	super.loadImage(s);
    }
		


}
