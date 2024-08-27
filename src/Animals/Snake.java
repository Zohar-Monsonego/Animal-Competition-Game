package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;
import Olympics.Medal;


/**
 * The class represents a snake, the class extends the class: TerrestrialAniaml,
 * and also implements the interface: IReptile.
 * The field in the class are:
 * - poisonous - Represents the venom level of the snake.
 * - length - represents the length of the snakeץ
 */
public class Snake extends TerrestrialAnimal implements IReptile{
	
	/**
	 * The sound the snake makes.
	 */
	private static final String SOUND = "SSSSSSS";
	private Poisonous poisonous;
	private double length;
	private static final String PATH_IMG1 = "src//Images/snake1.png";
	private static final String PATH_IMG2 = "src//Images/snake2.png";
	private static final String PATH_IMG3 = "src//Images/snake3.png";
	private static final String PATH_IMG4 = "src//Images/snake4.png";
	
	/**
	 * A default constructor that creates an object of type Snake and call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	public Snake() {
		super();
		this.poisonous = Poisonous.MID;
		this.length = 50.67;
	}
	
	/**
     * Constructs a {@code Snake} with specified name, speed, and energy per meter.
     * Initializes the venom level to {@code Poisonous.HIGH} and the length to 100.
     * 
     * @param name The name of the snake.
     * @param speed The speed of the snake.
     * @param energy_meter The energy required per meter for the snake.
     */
	public Snake(String name, int speed, int energy_meter) {
		super(name,speed,energy_meter,PATH_IMG1,PATH_IMG2,PATH_IMG3,PATH_IMG4);
		this.poisonous = Poisonous.HIGH;
		this.length = 100;
	}
	
	
	/**
	 * A constructor that creates an object of type Snake and initializes the parameters with the 
	 * values received from the user.
	 * @param _name The snake's name
	 * @param g The snake's gender
	 * @param w The snake's weight
	 * @param sp The snake's speed
	 * @param m An array of medals the snake has
	 * @param p The snake's location
	 * @param td The total distance the snake traveled
	 * @param po The venom level of the snake 
	 * @param l The length of the snake
	 */
	public Snake(String _name, Gender g, double w, int sp, Medal[] m, Point p, Poisonous po, double l) {
		super(_name,g,w,sp,m,p,0);
		this.poisonous = po;
		this.length = l;
	}
	
	
	/**
	 * The method checks if two objects of type Snake are the same.
	 * Two Snakes are considered equal if they have the same properties, poisonous and length.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Snake) {
			Snake other = (Snake)obj;
			if(super.equals(other) && this.poisonous == other.poisonous && this.length == other.length)
				ans = true;
		}
		return ans;
	}
	
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Snake.
	 */
	public String toString() {
		return super.toString() + "\n" + "Poisonous:" + this.getPoisonous() + "\n" + "Length:" + this.getLength();
	}
	
	
	/**
	 * Gets the poisonous of the snake
	 * @return The poisonous of the snkae.
	 */
	protected Poisonous getPoisonous() {
		return poisonous;
	}
	
	
	/**
	 * Gets the snake's length
	 * @return The snake's length.
	 */
	protected double getLength() {
		return length;
	}
	
	
	/**
	 * @override of the method getType() from Animal.
	 * Gets the type of the class.
	 * @return The type of the class .
	 */
	public String getType() {
		 return "Snake";
	}
	
	
	/**
	 * @override of the method getSound() from Animal.
	 * Gets the sound the snake makes.
	 * @return The snake's sound.
	 */
	protected String getSound() {
		return SOUND;
	}
	
	
	/**
	 * Implementation of the method speedUp(int) from IRetile
	 * The method calculates the speed of the snake after receiving a new speed, 
	 * if the speed does not exceed the maximum speed it updates the speed field.
	 * @param s The speed need to be added to the current snake's speed.
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
     * Draws the snake object using the specified {@code Graphics} context.
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
