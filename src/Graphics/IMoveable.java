package Graphics;

import Mobility.Point;


/**
 * The {@code IMoveable} interface defines methods for objects that can move.
 * 
 * This interface includes:
 * - A method {@link #getAnimalName()} to get the name of the animal.
 * - A method {@link #getSpeed()} to get the speed of the moving object.
 * - A method {@link #move(Point)} to move the object to a specified point and return the distance traveled.
 */
public interface IMoveable {
	
	 /**
     * Gets the name of the animal or object that implements this interface.
     * 
     * @return The name of the animal or object.
     */
	public String getAnimalName();
	
	
	/**
     * Gets the speed of the animal or object.
     * 
     * @return The speed in units per time unit.
     */
	public int getSpeed();
	
	/**
     * Moves the object to the specified point.
     * 
     * @param p The target point to move to.
     * @return The distance traveled to the point.
     */
	public double move(Point p);

}
