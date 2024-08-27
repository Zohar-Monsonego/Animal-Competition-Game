package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;
import Olympics.Medal;


/**
 * The class represents a dog, the class expands the class: TerrestrialAnimal.
 * The field in the class:
 * - breed - represents what breed the dog is from.
 */
public class Dog extends TerrestrialAnimal{
	/**
	 * The sound the dog makes.
	 */
	private static final String SOUND = "Woof Woof";
	private String breed;
	private static final String PATH_IMG1 = "src//Images/dog2E.png";
	private static final String PATH_IMG2 = "src//Images/dog2S.png";
	private static final String PATH_IMG3 = "src//Images/dog2W.png";
	private static final String PATH_IMG4 = "src//Images/dog2N.png";
	
	
	/**
	 * A default constructor that creates an object of type Dog and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Dog() {
		super();
		this.breed = "Chow Chow";
	}
	
	
	 /**
     * Constructor that creates a Dog object with specific values for name, speed, and energy.
     * @param name The dog's name
     * @param speed The dog's speed
     * @param energy_meter The dog's energy in meters
     */
	public Dog(String name, int speed, int energy_meter) {
		super(name,speed,energy_meter,PATH_IMG1);
		this.breed = "Chow Chow";
		
	}
	
	/**
	 * A constructor that creates an object of type Dog and initializes the parameters with the 
	 * values received from the user.
	 * @param _name The dog's name.
	 * @param g The dog's gender.
	 * @param w The dog's weight.
	 * @param sp The dog's speed.
	 * @param m An array of medals the dog has.
	 * @param p The location of the dog.
	 * @param td The total distance traveled by the dog.
	 * @param b The breed's dog.
	 */
	public Dog(String _name, Gender g, double w, int sp, Medal[] m, Point p, String b) {
		super(_name,g,w,sp,m,p,4);
		this.breed = b;
	}
	
	
	/**
	 * The method checks if two objects of type Dog are the same.
	 * Two dogs are considered equal if they have the same properties and breed.
	 * @param obj The object to compare with
	 * @return True if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Dog) {
			Dog other = (Dog)obj;
			if(super.equals(other) && breed.equals(other.breed))
				ans = true;
		}
		return ans;
	}
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Dog.
	 */
	public String toString() {
		return super.toString() + "\n" + 
	    "Breed:" + this.getBreed() + "\n";
	}

	
	/**
	 * Gets the breed of the dog.
	 * @return The breed of the dog.
	 */
	protected String getBreed() {
		return breed;
	}
	
	
	/**
	 * @override of the method getType() from Animal.
	 * Gets the type of the class.
	 * @return The type of the class.
	 */
	public String getType() {
		return "Dog";
	}
	
	
	/**
	 * @override of the method getSound() from Animal.
	 * Gets the sound the dog makes.
	 * @return The dog's sound.
	 */
	protected String getSound() {
		return SOUND;
	}
	
	 /**
     * Draws the dog on the provided graphics context.
     * This method currently calls the superclass's drawObject method to render the dog's image.
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
