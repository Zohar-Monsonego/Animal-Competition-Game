package Animals;

import Graphics.CalculateDestination;
import Graphics.ICalculateDestination;
import Mobility.Point;
import Olympics.Medal;


/**
 * Class AirAnimal is an abstract class, it represents the aerial animals.
 * The class has one field:
 * - wingspan - Describes the distance from the edge of one wing to the edge of the other 
 */
public abstract class AirAnimal extends Animal{
	private double wingspan;
	
	
	
	
	
	/**
	 * A default constructor who creates an object of AirAnimal and initializes the location of the 
	 * animal and the wingspan to the default values.
	 */
	public AirAnimal() {
		super(new Point(0,100));
		this.wingspan = 4.5;
	}
	
	
	/**
     * Constructor to create an AirAnimal object with specific attributes.
     * @param name The name of the animal.
     * @param speed The speed of the animal.
     * @param energy_m The amount of energy the animal has.
     * @param path The path to the image of the animal.
     * @param comp The competition type.
     * @param track The track type.
     */
	public AirAnimal(String name, int speed, int energy_m,String path,String comp,String track) {
		super(name,speed,energy_m,getDestination_track(comp,track),path,comp,track);
		this.wingspan = 12.2;
	}
	
	/**
	 * A constructor who creates an object of AirAnimal according to the values the user entered
	 * @param n The animal's name
	 * @param g The animal's gender
	 * @param w The animal's weight
	 * @param s The animal's speed
	 * @param m The array of medals the animal has
	 * @param po The location of the animal
	 * @param td The total distance the animal traveled
	 * @param wing Distance between wing and wing of the air animal
	 */
	public AirAnimal(String n, Gender g, double w, int s, Medal[] m,Point po, double wing) {
		super(n,g,w,s,m,po);
		this.wingspan = wing;
	}
	
	
	/**
	 * Gets the wingspan of the air animal 
	 * @return The wingspan of the air animal
	 */
	protected double getWingspan() {
		return wingspan;
	}
	
	
	/**
	 * An abstract method who gets the type of the animal
	 * @return The animal's type
	 */
	public abstract String getType();
	
	
	/**
	 * An abstract method who gets the sound the animal makes
	 * @return The animal's sound
	 */
	protected abstract String getSound();
	
	
	/**
	 * The method prints all the fields of the class and their values
	 * @return The representation of the class
	 */
	public String toString() {
		return super.toString() + "\n" + 
	    " Wingspan:" + this.getWingspan();
	}
	
	
	/**
	 * equals method, checks for equality between two objects of AirAnimal type.
	 * @param obj An object of type Object 
	 * @return True - if the objects are equal, false - if not
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof AirAnimal) {
			AirAnimal other = (AirAnimal)obj;
			if(super.equals(other) && this.wingspan == other.wingspan)
				ans = true;
		}
		return ans;
	}
	
	 /**
     * Gets the category of the animal.
     * @return The category of the animal, which is "Air Animal".
     */
	public String getCategory() {
		return "Air Animal";
	}
	
	
	 /**
     * Gets the destination point based on the competition type and track.
     * @param comp The competition type.
     * @param track The track type.
     * @return The destination point for the specified track.
     */
	private static Point getDestination_track(String comp,String track) {
		Point cur = null;
		if(comp.equals("Air")) {
			switch(track) {
			case "Track 1":
				cur = new Point(57,20);
				break;
			case "Track 2":
				cur = new Point(57,200);
				break;
			case "Track 3":
				cur = new Point(57,380);
				break;
			case "Track 4":
				cur = new Point(57,580);
				break;
			case "Track 5":
				cur = new Point(57,760);
				break;
			default:
				cur = new Point(0,0);	
				break;
			}
		}
		return cur;
	}
	
	
	

}
