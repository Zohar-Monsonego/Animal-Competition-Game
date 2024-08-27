package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;
import Olympics.Medal;


/**
 * The class represents a pigeon, the class expands the class: AirlAnimal.
 * The field in the class:
 * - family - Represents which family the pigeon is from.
 */
public class Pigeon extends AirAnimal{
	
	/**
	 * The sound the pigeon makes.
	 */
	private static final String SOUND = "Arr-rar-rar-rar-raah";
	private String family;
	private static final String PATH_IMG = "src//Images/pigeon.png";
	

	/**
	 * A default constructor that creates an object of type Pigeon and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Pigeon() {
		super();
		this.family = "Panthera leo";
	}
	
	
	/**
     * Constructs a {@code Pigeon} with specified name, speed, energy per meter, competition type, and track.
     * Initializes the family to "Panthera leo".
     * 
     * @param name The name of the pigeon.
     * @param speed The speed of the pigeon.
     * @param energy_meter The energy required per meter for the pigeon.
     * @param comp The competition type for the pigeon.
     * @param track The track for the pigeon.
     */
	public Pigeon(String name, int speed, int energy_meter,String comp, String track) {
		super(name,speed,energy_meter,PATH_IMG,comp,track);
		this.family = "Panthera leo";
	}
	
	/**
	 * A constructor that creates an object of type Pigeon and initializes the parameters with the 
	 * values received from the user.
	 * @param n The pigeon's name
	 * @param g The pigeon's gender
	 * @param w The pigeon's weight
	 * @param s The pigeon's speed
	 * @param m The array of medals the pigeon has
	 * @param po The location of the pigeon
	 * @param td The total distance the pigeon traveled
	 * @param wing Distance between wing and wing of the pigeon
	 * @param fami Which family the pigeon is from
	 */
	public Pigeon(String n, Gender g, double w, int s, Medal[] m,Point po, double wing, String fami) {
		super(n,g,w,s,m,po,wing);
		this.family = fami;
	}
	
	
	/**
	 * The method checks if two objects of type Pigeon are the same.
	 * Two Pigeons are considered equal if they have the same properties and family.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Pigeon) {
			Pigeon other = (Pigeon)obj;
			if(super.equals(other) && family.equals(other.family))
				ans = true;
		}
		return ans;
	}
	
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Pigeon.
	 */
	public String toString() {
		return super.toString() + "\n" + "Family:" + this.getFamily();
	}
	
	
	/**
	 * Gets the pigeon's family.
	 * @return The pigeon's family.
	 */
	protected String getFamily() {
		return family;
	}
	
	
	/**
	 * @override of the method getType() from Animal.
	 * Gets the type of the class.
	 * @return The type of the class .
	 */
	public String getType() {
		return "Pigeon";
	}
	
	
	/**
	 * @override of the method getSound() from Animal.
	 * Gets the sound the pigeon makes.
	 * @return The pigeon's sound.
	 */
	protected String getSound() {
		return SOUND;
	}
	
	
	/**
     * Draws the pigeon object using the specified {@code Graphics} context.
     * Delegates to the {@code drawObject} method of the superclass.
     * 
     * @param g The {@code Graphics} context to use for drawing.
     */
    @Override
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
