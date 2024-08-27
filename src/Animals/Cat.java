package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;
import Olympics.Medal;

/**
 * The class represents a cat, the class extends the class: TerrestrialAnimal.
 * The field in the department is:
 * - castrated - A Boolean variable representing whether the cat is castrated or not
 */

public class Cat extends TerrestrialAnimal{
	
	/**
	 * The sound the cat makes.
	 */
	private static final String SOUND = "Meow";
	private boolean castrated ;
	private static final String PATH_IMG1 = "src//Images/cat1E.png";
	private static final String PATH_IMG2 = "src//Images/cat1S.png";
	private static final String PATH_IMG3 = "src//Images/cat1W.png";
	private static final String PATH_IMG4 = "src//Images/cat1N.png";
	
	
	/**
	 * A default constructor that creates an object of type Cat and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Cat() {
		super();
		this.castrated = true;
	}
	
	/**
     * Constructor that creates a Cat object with specific values for name, speed, and energy.
     * @param name The cat's name
     * @param speed The cat's speed
     * @param energy_meter The cat's energy in meters
     */
	public Cat(String name,int speed, int energy_meter) {
		super(name,speed,energy_meter,PATH_IMG1,PATH_IMG2,PATH_IMG3,PATH_IMG4);
		this.castrated = true;
	}
	
	/**
	 * A constructor that creates an object of type Cat and initializes the parameters with the 
	 * values received from the user.
	 * @param _name The cat's name
	 * @param g The cat's gender
	 * @param w The cat's weight
	 * @param sp The cat's speed
	 * @param m The array of medals the cat has
	 * @param p The location of the cat
	 * @param td The total distance the cat traveled
	 * @param cas If the cat is castrated or not
	 */
	public Cat(String _name, Gender g, double w, int sp, Medal[] m, Point p, boolean cas) {
		super(_name,g,w,sp,m,p,4);
		this.castrated = cas;
	}
	
	
	/**
	 * The method checks if two objects of type Cat are the same.
	 * Two cats are considered equal if they have the same properties and castrated.
	 * @param obj The object to compare with.
	 * @return True - if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Cat) {
			Cat other = (Cat)obj;
			if(super.equals(other) && this.castrated == other.castrated) {
				ans = true;
			}
		}
		return ans;
	}
	
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Cat.
	 */
	public String toString() {
		return super.toString() + "\n" + 
	    "Castrated:" + this.getCastrated();
	}
	
	/**
	 * Gets if the cat is catrated or not.
	 * @return If the cat is catrated or not.
	 */
	protected boolean getCastrated() {
		return castrated;
	}
	
	
	/**
	 * @override of the method getType() from Animal.
	 * @return The type of the class.
	 */
	public String getType() {
		return "Cat";
	}
	
	/**
	 * @override of the method getSound() from Animal.
	 * @return The sound the cat makes.
	 */
	protected String getSound() {
		return SOUND;
	}
	
	 /**
     * Draws the cat on the provided graphics context.
     * This method currently calls the superclass's drawObject method to render the cat's image.
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
     * Gets the name of the animal by invoking the superclass method.
     * @return The name of the animal
     */
	public String getAnimalName() {
		return super.getAnimalName();
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
	public void loadImage(String s1) {
		super.loadImage(s1);
	}


}
