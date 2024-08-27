package Animals;


/**
 * Represents an abstract class for terrestrial animals, extending the Animal class.
 * Provides common properties and methods for terrestrial animals.
 * The class field:
 * - noLegs - The number of legs the terrestrial animal has.
 */
import Mobility.Point;
import Olympics.Medal;

public abstract class TerrestrialAnimal extends Animal{
	private int noLegs;
	
	
	/**
	 * Default constructor for TerrestrialAnimal.
     * Initializes the position to (0, 20) and sets number of legs to 0.
	 */
	public TerrestrialAnimal(){
		super(new Point(0,20));
		this.noLegs = 0;	
	}
	
	
	/**
     * Constructs a {@code TerrestrialAnimal} with specified name, speed, energy per meter, and image path.
     * Initializes the position to (0, 0) and the number of legs to 0.
     * 
     * @param name The name of the terrestrial animal.
     * @param speed The speed of the terrestrial animal.
     * @param energy_meter The energy required per meter for the terrestrial animal.
     * @param path The path to the image representing the terrestrial animal.
     */
	public TerrestrialAnimal(String name, int speed, int energy_meter,String path) {
		super(name,speed,energy_meter,new Point(0,0),path,"Terrestrial","None");
		this.noLegs = 0;
	}
	
	
	/**
     * Constructs a {@code TerrestrialAnimal} with specified name, speed, energy per meter, and multiple image paths.
     * Initializes the position to (0, 0) and the number of legs to 0.
     * 
     * @param name The name of the terrestrial animal.
     * @param speed The speed of the terrestrial animal.
     * @param energy_meter The energy required per meter for the terrestrial animal.
     * @param path1 The path to the first image representing the terrestrial animal.
     * @param path2 The path to the second image representing the terrestrial animal.
     * @param path3 The path to the third image representing the terrestrial animal.
     * @param path4 The path to the fourth image representing the terrestrial animal.
     */
	public TerrestrialAnimal(String name, int speed, int energy_meter,String path1, String path2,String path3,String path4) {
		super(name,speed,energy_meter,new Point(0,0),path1,path2,path3,path4,"Terrestrial","None");
		this.noLegs = 0;
	}
	
	/**
	 * A constructor for TerrestrialAnimal.
	 * @param _name The name of the terrestrial animal.
	 * @param g The gender of the terrestrial animal (MALE, FEMALE, HERMAPHRODITE).
	 * @param w The weight of the terrestrial animal.
	 * @param sp The speed of the terrestrial animal.
	 * @param m An array of medals the terrestrial animal has won.
	 * @param p The position of the terrestrial animal.
	 * @param num_legs The number of legs of the terrestrial animal.
	 */
	public TerrestrialAnimal(String _name, Gender g, double w, int sp, Medal[] m, Point p,int num_legs) {
		super(_name,g,w,sp,m,p);
		this.noLegs = num_legs;
	}
	
	
	/**
	 * Compares this TerrestrialAnimal with the specified object for equality.
     * Overrides the equals method of Object class.
     * @param obj The object to compare with.
     * @return true - if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof TerrestrialAnimal) {
			TerrestrialAnimal other = (TerrestrialAnimal)obj;
			if(super.equals(other) && this.noLegs == other.noLegs)
				ans = true;
		}
		return ans;
		
	}
	
	
	/**
	 * Gets the number of legs of the terrestrial animal.
     * @return The number of legs.
	 * @return
	 */
	protected int getNoLegs() {
		return noLegs;
	}
	
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class TerrestrialAnimal.
	 */
	public String toString() {
		return super.toString() + "\n" + "Number of legs:" + this.getNoLegs();
	}
	
	
	/**
	 * Abstract method to be implemented by subclasses.
     * Gets the type of the terrestrial animal.
     * @return The type of the animal.
	 */
	public abstract String getType();
	
	
	/**
	 * Abstract method to be implemented by subclasses.
     * Gets the sound made by the terrestrial animal.
     * @return The sound made by the animal.
	 */
	protected abstract String getSound();

	
	 /**
     * Gets the category of the animal.
     * 
     * @return The category of the animal, which is "Terrestrial Animal".
     */
    @Override
	public String getCategory() {
		return "Terrestrial Animal";
	}
}
