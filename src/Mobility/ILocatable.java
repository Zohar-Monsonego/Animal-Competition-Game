package Mobility;


/**
 * The ILocatable interface represents an object that has a location in space.
 * It defines methods to get and set the location.
 */
public interface ILocatable {
	
	/**
	 * Gets the current location of the object
	 * @return The current location of the object as a Point.
	 */
	public Point getLocation();
	
	/**
	 * Sets the location of the object to the specified point.
	 * @param p The new location to set for the object.
	 * @return true - if the location was successfully set, false - if not.
     */
	public boolean setLocation(Point p); 

}
