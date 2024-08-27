package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Graphics.IClonable;
import Mobility.Point;
import Olympics.Medal;

/**
 * Represents an alligator, extending the WaterAnimal class 
 * and implementing the IReptile and ITerrestrialAnimal interfaces.
 * Fields:
 * - areaOfLiving: A string representing the area where the alligator lives.
 * - terrestrial: A delegate for handling terrestrial behavior with a pointer to a class that implements ITerrestrialAnimal.
 */

public class Alligator extends WaterAnimal implements IReptile, ITerrestrialAnimal{
	
	/**
	 * The sound the alligator makes
	 */
	private static final String SOUND = "Roar";
	private String areaOfLiving;
	private TerrestrialBehavior terrestrial;  // Delegate for terrestrial behavior
	private static final String PATH_IMG = "src//Images/alligator3.png";
	
	
	/**
	 * A default constructor that creates an object of type Alligator and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Alligator() {
		super();
		this.areaOfLiving = "River";
		this.terrestrial = new TerrestrialBehavior(4);
	}
	

	
	/**
     * Constructor that creates an Alligator object with specific values for name, speed, energy, competition, and track.
     * @param name The alligator's name
     * @param speed The alligator's speed
     * @param energy_meter The alligator's energy in meters
     * @param comp The competition type for the alligator
     * @param track The track for the alligator
     */
	public Alligator(String name, int speed, int energy_meter,String comp,String track) {
		super(name,speed,energy_meter,PATH_IMG,comp,track);
		this.areaOfLiving = "River";
		this.terrestrial = new TerrestrialBehavior(4);
	}
	
	/**
	 * A constructor that creates an object of type Alligator and initializes the parameters with the 
	 * values received from the user.
	 * @param _name Alligator's name
	 * @param g Alligator's gender
	 * @param w Alligator's weight
	 * @param sp Alligator's speed
	 * @param m Alligator's array of medals it has
	 * @param p The location of the alligator
	 * @param td the total distance traveled by the alligator 
	 * @param dive_d The dive depth the alligator can dive
	 * @param a_o_l The area the alligator lives
	 * @param num_l The number of legs the alligator has
	 */
	public Alligator(String _name, Gender g, double w, int sp, Medal[] m, Point p, double dive_d, String a_o_l, int num_l) {
		super(_name,g,w,sp,m,p,dive_d);
		this.areaOfLiving = a_o_l;
		this.terrestrial = new TerrestrialBehavior(num_l);
	}
	
	
	
	
	/**
	 * The method checks if two objects of type Alligator are the same.
	 * Two alligators are considered equal if they have the same properties and area of living.
	 * @param obj The object to compare to.
	 * @return True - if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Alligator) {
			Alligator other = (Alligator)obj;
			if(super.equals(other) && areaOfLiving.equals(other.areaOfLiving) && terrestrial.getNumberOfLegs() == other.getNumberOfLegs())
				ans = true;
		}
		return ans;
	}
	
	
	/**
	 * the method prints all the class's fields and their values
	 * @return A representation of the class Alligator.
	 */
	public String toString() {
		return super.toString() + "\n" + 
	    "Area of living:" + this.getAreaOfLiving() + "\n" + 
				"Number of legs: " + this.terrestrial.getNumberOfLegs();
	}
	
	/**
	 * Gets the alligator living area.
	 * @return The alligator living area.
	 */
	protected String getAreaOfLiving() {
		return areaOfLiving;
	}
	
	/**
	 * @override of the method getType() from Animal.
	 * Gets the class type.
	 * @return The class type.
	 */
	public String getType() {
		return "Alligator";
	}
	
	
	/**
	 * @override of the method getSound() from Animal.
	 * Gets the sound the alligator makes.
	 * @return The alligator's sound
	 */
	protected String getSound() {
		return SOUND;
	}
	
	/**
	 * Implementation of the method speedUp(int) from IRetile
	 * The method calculates the speed of the alligator after receiving a new speed, 
	 * if the speed does not exceed the maximum speed it updates the speed field.
	 * @param s The speed need to be added to the current alligator's speed.
	 * @return True - If the speed was added successfully, false - if not.
	 */
	public boolean speedUp(int s) {
		boolean ans;
		int total_speed = this.getSpeed() + s;
		if(total_speed <= MAX_SPEED) {
			this.setSpeed(total_speed);
			ans = true;
		}
		else {
			System.out.println("The speed has exceeded the maximum speed");
			ans = false;
		}
		return ans;
		
	}
	
	
	 /**
     * Gets the number of legs the alligator has.
     * @return The number of legs
     */
    @Override
	public int getNumberOfLegs() {
		return terrestrial.getNumberOfLegs();
	}
	
    /**
     * Draws the alligator on the provided graphics context.
     * Calls the superclass's drawObject method to render the alligator's image.
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
