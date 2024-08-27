package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;
import Olympics.Medal;


/**
 * The class represents a whale, the class expands the class: WaterlAnimal.
 * The field in the class:
 * - food_type - the kind of food the whale eats.
 */
public class Whale extends WaterAnimal{
	
	/**
	 * the sound the whale makes.
	 */
	private static final String SOUND = "Splash";
	private String foodType;
	private static final String PATH_IMG = "src//Images/whale.png";
	
	
	/**
	 * A default constructor that creates an object of type Whale and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Whale() {
		super();
		this.foodType = "Fishes";
	}
	
	
	/**
     * Constructs a {@code Whale} with specified name, speed, energy per meter, competition type, and track.
     * Initializes the food type to "Jellyfish".
     * 
     * @param name The name of the whale.
     * @param speed The speed of the whale.
     * @param energy_meter The energy required per meter for the whale.
     * @param comp The type of competition the whale participates in.
     * @param track The track for the whale in the competition.
     */
	public Whale(String name,int speed,int energy_meter,String comp,String track) {
		super(name,speed,energy_meter,PATH_IMG,comp,track);
		this.foodType = "Gelyfish";
	}
	
	
	/**
	 * A constructor that creates an object of type Whale and initializes the parameters with the 
	 * values received from the user.
	 * @param _name The whale's name
	 * @param g The whale's gender
	 * @param w The whale's weight
	 * @param sp The whale's speed
	 * @param m An array of medals the whale has
	 * @param p The whale's location
	 * @param td The total destance the whale traveled
	 * @param dive_d The whale's dive dept
	 * @param ft The food type the whale eats.
	 */
	public Whale(String _name, Gender g, double w, int sp, Medal[] m, Point p, double dive_d, String ft) {
		super(_name,g,w,sp,m,p,dive_d);
		this.foodType = ft;
	}
	
	
	/**
	 * The method checks if two objects of type Whale are the same.
	 * Two Whales are considered equal if they have the same properties and food type.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Whale) {
			Whale other = (Whale)obj;
			if(super.equals(other) && foodType.equals(other.foodType))
				ans = true;
		}
		return ans;
	}
	
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Whale.
	 */
	public String toString() {
		return super.toString() + "\n" + "Food type:" + this.getFoodType();
	}
	
	
	/**
	 * Gets the food type
	 * @return The food type.
	 */
	protected String getFoodType() {
		return foodType;
	}
	
	
	/**
	 * @override of the method getType() from Animal.
	 * Gets the type of the class.
	 * @return The type of the class.
	 */
	public String getType() {
		return "Whale";
	}
	
	
	/**
	 * @override of the method getSound() from Animal.
	 * Gets the sound the whale makes.
	 * @return The whale's sound.
	 */
	protected String getSound() {
		return SOUND;
	}

	
	/**
     * Draws the whale object using the specified {@code Graphics} context.
     * Delegates to the {@code drawObject} method of the superclass.
     * 
     * @param g The {@code Graphics} context to use for drawing.
     */
	public void drawObject(Graphics g) {
		super.drawObject(g);
	}
	
	 /**
     * Gets the category of the animal.
     * 
     * @return The category of the animal, which is inherited from the superclass.
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
