package Mobility;

import Graphics.CompetitionFrame;

/**
 * Mobility is an abstract class that defines movement in space and implements the interface: ILocation.
 * the class fields are:
 * - location - Represents the current location of the object.
 * - totalDistance - Represents the total distance the object traveled.
 */

public /*abstract*/ class Mobile implements ILocatable {
	private Point location;
	private double totalDistance;
	
	/**
	 * A default constructor,creates a new Mobile object with default values.
     * Initializes the location to (0, 0) and the total distance traveled to 0.
	 */
	public Mobile() {
		this.location = new Point(0,0);
		this.totalDistance = 0;
	}
	
	
	/**
	 * Constructor, creates a new Mobile object with the given initial location.
     * Initializes the total distance traveled to 0.
	 */
	public Mobile(Point p) {
		location = new Point(p.getX(),p.getY());
		this.totalDistance = 0;
	}
	
	
	/**
	 * The method checks if two objects of type Mobile are the same.
	 * Two Mobiles are considered equal if they have the same location and total distance.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Mobile) {
			Mobile other = (Mobile)obj;
			ans = (other.location.getX() == this.location.getX() && other.location.getY() == this.location.getY() && other.totalDistance == this.totalDistance);
		}
		return ans;
	}
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Mobile.
	 */
	public String toString() {
		return "Location: (" + this.location.getX() + "," + this.location.getY() + ")" + "\n" + 
	    "Total distance: " + this.totalDistance;
	}
	
	/**
	 * A method that receives a decimal number representing some distance 
	 * that the object has traveled and adds it to the total distance
	 * @param td The  distance need to be added to the total distance.
	 * @return void.
	 */
	public void addTotalDistance(double td) {
		this.totalDistance += td;
	}
	
	/**
	 * A method that calculates the distance between the current object and a point that is obtained.
	 * @param p The other point that we want to calculate the distance from thr current point to it.
	 * @return The distance traveled.
	 */
	public double calcDistance(Point p) {
		return Math.sqrt(Math.pow(p.getX() - this.location.getX(), 2) + Math.pow(p.getY() - this.location.getY(), 2));
	}
	
	/**
	 * Move method calculates the distance the object traveled from the point it is at to the point it reached - the received point.
	 * If the distance is greater than 0, it updates the total distance accordingly,
	 * If not, it only returns the distance traveled.
	 * @param p A point the object reached.
	 * @return The distance traveled.
	 */
	//public abstract double move(Point p);
	
	/**
	 * Gets the total distance.
	 * @return The total distance.
	 */
	protected double getTotalDistance() {
		return totalDistance;
	}
	
	
	/**
	 * Updates the total distance by adding a distance to the total distance.
	 * @param td the distance needs to be added.
	 * @return True - if it added successfuly, false- if not.
	 */
	public boolean setTotalDistance(double td) {
		this.totalDistance += td;
		return true;
	}
	
	/**
	 * Gets the current location of the object.
	 * @return The current location.
	 */
	public Point getLocation(){
		return this.location;
		
	}
	
	/**
	 * A method that updates the position of the object by given new point.
	 * @param p1 The new point.
	 * @return True - if it updated successfuly, false- if not.
	 */
	public boolean setLocation(Point p1) {
		boolean ans = false;
		ans = (this.location.setX(p1.getX()) && this.location.setY(p1.getY()));
		return ans;
	}
	
	
	


}
