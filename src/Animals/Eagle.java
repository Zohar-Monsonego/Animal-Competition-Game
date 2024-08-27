package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Graphics.CompetitionFrame;
import Mobility.Point;
import Olympics.Medal;


/**
 * The class represents an eagle, the class expands the class: AirlAnimal.
 * The fields in the class:
 * - altitudeOfFlight - The height the eagle can fly.
 * - MAX_ALTITUDE -  a static parameter that represents the max height the eagle can fly.
 */
public class Eagle extends AirAnimal{
	
	/**
	 * the sound the eagle's makes.
	 */
	private static final String SOUND = "Clack-wack-chack";
	private double altitudeOfFlight;
	private static final double MAX_ALTITUDE = 1000;
	private static final String PATH= "src//Images/eagle2.png";
	
	
	/**
	 * A default constructor that creates an object of type Eagle and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Eagle() {
		super();
		this.altitudeOfFlight = 500;
	}
	
	
	 /**
     * Constructor that creates an Eagle object with specific values for name, speed, energy, 
     * competition type, and track.
     * @param name The eagle's name
     * @param speed The eagle's speed
     * @param energy_m The eagle's energy in meters
     * @param comp The competition type for the eagle
     * @param track The track for the eagle
     */
	public Eagle(String name, int speed, int energy_m,String comp, String track) {
		super(name,speed,energy_m,PATH,comp,track);
		this.altitudeOfFlight = 300;
	}
	
	/**
	 * A constructor that creates an object of type Eagle and initializes the parameters with the 
	 * values received from the user.
	 * @param n The eagle's name
	 * @param g The eagle's gender
	 * @param w The eagle's weight
	 * @param s The eagle's speed
	 * @param m The array of medals the eagle has
	 * @param po The location of the eagle
	 * @param td The total distance the eagle traveled
	 * @param wing Distance between wing and wing of the eagle
	 * @param alt The height the eagle can fly
	 */
	public Eagle(String n, Gender g, double w, int s, Medal[] m,Point po, double wing, double alt) {
		super(n,g,w,s,m,po,wing);
		this.altitudeOfFlight = alt;
	}
	
	
	/**
	 * The method checks if two objects of type Eagle are the same.
	 * Two Eagles are considered equal if they have the same properties and altitude of flight.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Eagle) {
			Eagle other = (Eagle)obj;
			if(super.equals(other) && this.altitudeOfFlight == other.altitudeOfFlight)
				ans = true;
		}
		return ans;
	}

	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Eagle.
	 */
	public String toString() {
		return super.toString() + "\n" + 
	    "Altitude of flight:" + this.getAltitude();
	}
	
	
	/**
	 * Gets the altitude of flight.
	 * @return The altitude of flight.
	 */
	protected double getAltitude() {
		return altitudeOfFlight;
	}
	
	
	/**
	 * @override of the method getType() from Animal.
	 * Gets the type of the class.
	 * @return The type of the class .
	 */
	public String getType() {
		return "Eagle";
	}
	
	
	/**
	 * @override of the method getSound() from Animal.
	 * Gets the sound the eagle makes.
	 * @return The eagle's sound.
	 */
	protected String getSound() {
		return SOUND;
	}
	
	
	 /**
     * Draws the eagle on the provided graphics context.
     * This method utilizes the superclass's drawObject method to render the eagle image.
     * @param g The graphics context to draw on
     */
    @Override
	public void drawObject(Graphics g) {
		super.drawObject(g);
	}
	
    
    /**
     * Gets the name of the animal by invoking the superclass method.
     * @return The name of the animal
     */
    @Override
	public String getAnimalName() {
		return super.getAnimalName();
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
