package Animals;


import Mobility.Point;
import Olympics.Medal;


/**
 * Class WaterAnimal is an abstract class, the class extends the class: Animal. It represents the marine animals.
 * The class has two field:
 * - MAX_DIVE - Represents the maximum depth that a marine animal can diveץ
 * - diveDept - Represents the depth that a certain marine animal can diveץ
 */
public abstract class WaterAnimal extends Animal{
	private static final int MAX_DIVE = -800;
	private double diveDept;
	
	
	/**
	 * A default constructor that call the default constructor of the base class 
	 * and initializes the class's filed with a default value.
	 */
	 public WaterAnimal() {
		 super(new Point(50,0));
		 this.diveDept = -100;
		 
	 }
	 
	 
	 /**
	     * Constructs a {@code WaterAnimal} with specified name, speed, energy per meter, image path, competition type, and track.
	     * Initializes the dive depth to -200.
	     * 
	     * @param name The name of the water animal.
	     * @param speed The speed of the water animal.
	     * @param energy_meter The energy required per meter for the water animal.
	     * @param path The path to the image representing the water animal.
	     * @param comp The type of competition the water animal participates in.
	     * @param track The track for the water animal in the competition.
	     */
	 public WaterAnimal(String name, int speed, int energy_meter,String path,String comp,String track) {
		 super(name,speed,energy_meter,getDestination_track(comp,track),path,comp,track);
		 this.diveDept = -200;
	 }
	 
	 
	 /**
	  * A constructor that initializes the parameters of WaterAnimal with the 
	  * values received from the user.
	  * @param _name The AirAnimal's name.
	  * @param g The WaterAnimal's gender.
	  * @param w The WaterAnimal's weight.
	  * @param sp The WaterAnimal's speed.
	  * @param m An array of medals the WaterAnimal has.
	  * @param p The WaterAnimal's location.
	  * @param td The total distance the WaterAnimal traveled.
	  * @param dive_d The WaterAnimal's dive depth.
	  * @throws IllegalArgumentException if the dive depth is greater than the maximum depth
	  */
	 public WaterAnimal(String _name, Gender g, double w, int sp, Medal[] m, Point p, double dive_d) {
		 super(_name,g,w,sp,m,p);
		 if(dive_d >= MAX_DIVE) {
			 this.diveDept = dive_d;
		 }
		 else {
			 throw new IllegalArgumentException("The dive dept you entered is bigger than the maximum depth" + "\n");
		 }
		 
	 }
	 
	 
	 public WaterAnimal(WaterAnimal obj) {
		 super(obj);
		 this.diveDept = obj.diveDept;
		 
	 }
	 
	 /**
	  * Gets the dive depth
	  * @return The dive depth.
	  */
	 protected double getDiveDept() {
		 return diveDept;
	 }
	 
	 /**
	  * @override of the method getSound() from Animal
	  * Defined as an abstract method.
	  * @return The sound the Water animal makes.
	  */
	 protected abstract String getSound();
	 
	 /**
	  * @override of the method getType() from Animal
	  * Defined as an abstract method.
	  * @return The type of the class.
	  */
	 public abstract String getType();
	 
	 
	 /**
	  * The method prints all the class's fields and their values.
	 * @return The representation of the class WaterAnimal.
	  */
	 public String toString() {
		 return super.toString() + "\n" + "Dive depth:" + this.getDiveDept();
	 }
	
	
	 /**
	 * The method checks if two objects of type WaterAnimal are the same.
	 * Two WaterAnimals are considered equal if they have the same properties and diveDept.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false - if not.
	 */
	 public boolean equals(Object obj) {
		 boolean ans = false;
		 if(obj instanceof WaterAnimal) {
			 WaterAnimal other = (WaterAnimal)obj;
			 if(super.equals(other) && this.diveDept == other.diveDept)
				 ans = true;
		 }
		 return ans;
	 }
	 
	 /**
	  * The function increases the diving depth that the animal can dive, 
	  * only if after the increase the depth does not exceed the maximum depth.
	  * @param d The diving depth we want to add.
	  * @return True - If it was added successfully, false- if not.
	  */
	 public boolean dive(double d) {
		 if(this.getDiveDept()+d >= MAX_DIVE) {
			 this.diveDept += d;
			 return true;
		 }
		 else {
			 System.out.print("Cannot dive further. Max dive depth reached.");
			 return false;
		 }
	 }
	 
	 /**
	     * Gets the category of the animal.
	     * 
	     * @return The category of the animal, which is "Water Animal".
	     */
	    @Override
	 public String getCategory() {
		 return "Water Animal";
	 }
	 
	
	 /**
	  * Determines the destination point based on the competition type and track.
	  * 
	  * @param comp The type of competition.
	  * @param track The track for the competition.
	  * @return The destination point based on the competition type and track.
	  */    
	 private static Point getDestination_track(String comp,String track) {
		 Point cur = null;
		 if(comp.equals("Water")) {
				switch(track) {
				case "Track 1":
					cur = new Point(130,120);
					break;
				case "Track 2":
					cur = new Point(130,300);
					break;
				case "Track 3":
					cur = new Point(130,480);
					break;
				case "Track 4":
					cur = new Point(130,670);
					break;
				default:
					cur = new Point(0,0);	
					break;
				}
			}
			return cur;
	 }
	 
	 
}
