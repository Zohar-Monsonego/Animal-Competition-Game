package Animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Graphics.Clonable;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;
import Graphics.Drawable;
import Graphics.IAnimal;
import Graphics.IClonable;
import Graphics.IDrawable;
import Graphics.IMoveable;
import Graphics.Moveable;
import Mobility.ILocatable;
import Mobility.Location;
import Mobility.Mobile;
import Mobility.Point;
import Olympics.Medal;
import Olympics.Type;


/**
 * The {@code Animal} class represents an abstract model for animals in the system.
 * It extends the {@link Mobile} class and implements {@link IAnimal} and {@link ILocatable} interfaces.
 * 
 * Each animal has characteristics such as name, gender, weight, speed, medals, and various attributes related
 * to its movement and energy.</p>
 */
public abstract class Animal extends Mobile implements IAnimal, ILocatable, IMoveable,IDrawable{
	
	/**
	 * The sound the animal makes
	 */
	private static final String SOUND = "None";
	private String name;
	private  Gender gender;
	private double weight;
	private int speed;
	private Medal[] medals;
	private int size;
	private int id;
	private Location current_loc;
	private Point start_loc;
	private Location destination_loc;
	private Orientation orien;
	private int maxEnergy;
	private int energyPerMeter;
	private int currentEnergy;
	private int energy_consumption;
	private String comp;
	private String track;
	private CompetitionPanel pan;
	private Drawable drawable;
	private Moveable moveable;
	private Clonable clonable;
	
	
	
	/**
	 * A default constructor who creates an object of Animal and initializes the location of the animal 
	 * @param p - A Point object -> default location, and initializes 
	 *  
	 */
	public Animal(Point p) {
		super(p);
		this.name = "Sheleg";
		this.gender = Gender.FEMALE;
		this.weight = 10.55;
		this.speed = 15;
		this.medals = new Medal[1];
		this.medals[0] = new Medal();
	}
	
	
	public Animal(Animal obj) {
		super(obj.start_loc);
		this.name = obj.name;
		this.gender = obj.gender;
		this.weight = obj.weight;
		this.speed = obj.speed;
		this.medals = obj.medals;
		this.size = obj.size;
		this.id = obj.id;
		this.current_loc = obj.current_loc;
		this.start_loc = obj.start_loc;
		this.orien = obj.orien;
		this.maxEnergy = obj.maxEnergy;
		this.energyPerMeter = obj.energyPerMeter;
		this.currentEnergy = obj.currentEnergy;
		this.energy_consumption = obj.energy_consumption;
		this.comp = obj.comp;
		this.track = obj.track;
		this.pan = obj.pan;
		this.drawable = obj.drawable;
		this.moveable = obj.moveable;
		this.clonable = obj.clonable;
	}
	
	
	 /**
     * Constructs an {@code Animal} with specified attributes.
     * @param name The name of the animal.
     * @param speed The speed of the animal.
     * @param energy_m The energy required per meter.
     * @param location The initial location of the animal.
     * @param img1 The path to the animal's image.
     * @param comp The competition type.
     * @param track The track type.
     */
	public Animal(String name, int speed, int energy_m,Point location, String img1,String comp,String track) {
		super(location);
		this.name = name;
		this.gender = Gender.FEMALE;
		this.weight = 50;
		this.speed = speed;
		this.medals = new Medal[1];
		this.medals[0] = new Medal();
		this.size = 65;
		this.id = 111111;
		this.current_loc = new Location(location);
		this.start_loc = new Point(location.getX(),location.getY());
		this.orien = Orientation.EAST;
		this.maxEnergy = 200;
		this.energyPerMeter = energy_m;
		this.currentEnergy = 100;
		this.energy_consumption = 100;
		this.comp = comp;
		this.track = track;
		this.pan = new CompetitionPanel(new CompetitionFrame());
		this.drawable = new Drawable(this.getLoc(),this.getSize(),this.getOrien().EAST);
		this.drawable.loadImage(img1);
		this.moveable = new Moveable(name,speed,this.getLoc(),energy_m,this.getCurrentEnergy(),this.getTotalDistance(),this.getOrien().EAST);
		this.clonable = new Clonable();
		
	}
	
	
	/**
     * Constructs an {@code Animal} with specified attributes and multiple images.
     * @param name The name of the animal.
     * @param speed The speed of the animal.
     * @param energy_m The energy required per meter.
     * @param location The initial location of the animal.
     * @param img1 The path to the first image of the animal.
     * @param img2 The path to the second image of the animal.
     * @param img3 The path to the third image of the animal.
     * @param img4 The path to the fourth image of the animal.
     * @param comp The competition type.
     * @param track The track type.
     */
	public Animal(String name, int speed, int energy_m,Point location, String img1, String img2, String img3, String img4,String comp,String track) {
		super(location);
		this.name = name;
		this.gender = Gender.FEMALE;
		this.weight = 50;
		this.speed = speed;
		this.medals = new Medal[1];
		this.medals[0] = new Medal();
		this.size = 65;
		this.id = 111111;
		this.current_loc = new Location(location);
		this.start_loc = new Point(location.getX(),location.getY());
		this.orien = Orientation.EAST;
		this.maxEnergy = 200;
		this.energyPerMeter = energy_m;
		this.currentEnergy = 100;
		this.energy_consumption = 100;
		this.comp = comp;
		this.track = track;
		this.pan = new CompetitionPanel(new CompetitionFrame());
		this.drawable = new Drawable(this.getLoc(),this.getSize(),this.getOrien().EAST);
		this.drawable.loadImage(img1, img2, img3, img4);
		this.moveable = new Moveable(name,speed,this.getLoc(),energy_m,this.getCurrentEnergy(),this.getTotalDistance(),this.getOrien().EAST);
		this.clonable = new Clonable();
	}
	
	
	
	/**
	 * A constructor who creates an object of Animal
	 * @param _name Animal's name
	 * @param g Animal's gender
	 * @param w Animal's weight
	 * @param sp Animal's speed
	 * @param m Array of the medals the animal has
	 * @param p animal's location
	 * @param td animal's total distance
	 */
	public Animal(String _name, Gender g, double w, int sp, Medal[] m, Point p) {
		super(p);
		this.name = _name;
		this.gender = g;
		this.weight = w;
		this.speed = sp;
		this.medals = new Medal[m.length];
		for(int i=0; i<m.length; i+=1) {
			this.medals[i] = new Medal(m[i]);
		}
	}
	
	
	/**
	 * equals method, checks for equality between two objects of Animal type.
	 *  @param obj An object of type Object
	 *  @return True - if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Animal) {
			Animal other = (Animal)obj;
		    if(!name.equals(other.name))
		    	return false;
		    if(other.gender != this.gender)
		    	return false;
		    if(other.weight != this.weight)
		    	return false;
		    if(other.speed != this.speed)
		    	return false;
		    for(int i=0; i<this.medals.length; i+=1) {
		    	if(other.medals[i] != this.medals[i])
		    		return false;
		    }
		    	
		    	
		}
		return true;
	}
	
	/**
	 * Gets the animal's name.
	 * @return The animal's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the animal's gender.
	 * @return The animal's gender.
	 */
	protected Gender getGender() {
		return gender;
	}
	
	/**
	 * Gets the animal's weight.
	 * @return The animal's weight.
	 */
	protected double getWeight() {
		return weight;
	}
	
	/**
	 * 
	 * Gets the animal's speed.
	 * @return The animal's speed.
	 */
	public int getSpeed() {
		return speed;
	}
	
	protected boolean setSpeed(int s) {
		this.speed = s;
		return true;
	}
	
	/**
	 * Gets the array of medals the animal has.
	 * @return The array of medals the animal has.
	 */
	public Medal[] getMedals() {
		return medals;
	}
	
	
	/**
	 * Gets the sound the animal makes.
	 * @return The sound the animal makes.
	 */
	protected abstract String getSound();
	
	 /**
	  * Gets the type of the class.
	  * @return The type of the class.
	  */
	public abstract String getType();
	
	
	/**
	 * The method toString, prints the representation of Animal class
	 * @return A string that contains all the fields of the class
	 */
	public String toString() {
		return super.toString() + "\n" +  "Name:" + this.getName() + "\n" +
			   "Gender:" + this.getGender() + "\n" +
			   "weight:" + this.getWeight() + "\n" +
			   "speed:" + this.getSpeed() + "\n" +
			   "Medals:" + Arrays.toString(this.getMedals()) + "\n" +
			   "Sound:" + this.getSound();
	}
	
	
	/**
     * Moves the animal to a new location.
     * @param p The new location.
     * @return The distance traveled.
     */
	public double move(Point p) {
		return moveable.move(p);
	}
	
	
	/**
	 * The method prints the name of the animal and the sound it makes.
	 * @return void
	 */
	public void makeSound() {
		System.out.print("Animal " + this.getType() + " said " + this.getSound() + "\n");
	}
	
	
	/**
     * Draws the animal on the screen.
     * @param g The graphics context.
     */
	public void drawObject(Graphics g) {
		drawable.drawObject(g);
	}
	


	/**
     * Gets the size of the animal image.
     * @return The animal's size.
     */
	public int getSize() {
		return size;
	}
	
	
	 /**
     * Gets the orientation of the animal.
     * @return The animal's orientation.
     */
	public Orientation getOrien() {
		return this.orien;
	}
	
	
	/**
     * Sets the orientation of the animal.
     * @param o The new orientation.
     */
	public boolean setOrien(Orientation o) {
		this.orien = o;
		return true;
	}

	
	/**
	 * Gets the current location of the animal.
	 * @return The current location as a Point object.
	 */
	public Point getLoc() {
		return this.current_loc.getLocation();
	}
	
	
	/**
	 * Sets the location of the animal to a new Point.
	 * @param p The new location as a Point object.
	 * @return {@code true} if the location was updated successfully.
	 */
	public boolean setLoc(Point p) {
        this.current_loc.setLocation(p);
        return true;
    }
	
	/**
	 * Updates the animal's current energy based on the energy it consumes.
	 * @param energy The amount of energy to add.
	 * @return {@code true} if the energy was successfully added without exceeding max energy; 
	 *         {@code false} if adding the energy would exceed the maximum allowed energy.
	 */
	public boolean eat(int energy) {
		int c_energy = this.currentEnergy;
		if((c_energy += energy) < this.maxEnergy) {
			this.currentEnergy += energy;
			this.energy_consumption += energy;
			return true;
			
		}
		else {
			return false;
		}
	}
	
	/**
	 * Gets the name of the animal.
	 * @return The name of the animal.
	 */
	public String getAnimalName() {
		return moveable.getAnimalName();
	}
	
	/**
	 * Gets the category of the animal.
	 * This is an abstract method that should be implemented by subclasses to return the specific category of the animal.
	 * @return The category of the animal.
	 */
	public abstract String getCategory();
	
	
	/**
     * Gets the current energy of the animal.
     * @return The current energy.
     */
	public int getCurrentEnergy() {
		return this.currentEnergy;
	}
	
	
	 /**
     * Sets the current energy of the animal.
     * @param energy The new energy amount.
     * @return {@code true} if the energy was set successfully.
     */
	public boolean setCurrrentEnergy(int e) {
		if(e < 0) {
			this.currentEnergy = 0;
			return true;
		}
		else {
			this.currentEnergy = e;;
			return true;
		}
		
	}

	
	
	/**
	 * Gets the total distance the animal has traveled.
	 * @return The total distance traveled.
	 */
	public double getTotalDistance() {
		return super.getTotalDistance();
	}
	
	
	
	/**
	 * Sets the total distance traveled by the animal.
	 * 
	 * This method overrides the {@code setTotalDistance} method from the superclass.
	 * It sets the total distance traveled by the animal to the specified distance.
	 * 
	 * @param d The total distance to be set for the animal.
	 * @return {@code true} if the total distance was set successfully.
	 */
	public boolean setTotalDistance(double d) {
		super.setTotalDistance(d);
		return true;
	}
	
	 /**
     * Gets the energy consumption rate of the animal.
     * @return The energy consumption rate.
     */
	public int getEnergyConsumption() {
		return this.energy_consumption;
	}
	
	 /**
     * Gets the competition type of the animal.
     * @return The competition type.
     */
	public String getComp() {
		return this.comp;
	}
	
	/**
     * Gets the track type of the animal.
     * @return The track type.
     */
	public String getTrack() {
		return this.track;
	}
	
	
	  /**
     * Gets the amount of energy the animal has per meter.
     * @return The energy per meter.
     */
	public int getEnergyPerMeter() {
		return this.energyPerMeter;
	}
	
	
	/**
	 * Loads an image from the specified file path.
	 * 
	 * This method delegates the loading of the image to the `drawable` object's
	 * `loadImage` method.
	 * 
	 * @param nm The file path of the image to be loaded.
	 */
	public void loadImage(String nm) {
		drawable.loadImage(nm);
	}
	
	public Point getStartLoc() {
		return this.start_loc;
	}
	
	
	public Animal clone() {
        try {
            Animal cloned = (Animal) super.clone();
            
            if (this.clonable != null) {
                cloned.clonable = this.clonable.clone(); 
            }
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


	
}
