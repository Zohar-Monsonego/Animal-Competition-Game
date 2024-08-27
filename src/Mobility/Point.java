package Mobility;

import Graphics.IClonable;

/**
 * The Point class represents a point in a 2-dimensional space with integer coordinates.
 * It provides methods to manipulate and retrieve the coordinates of the point.
 * The class fields:
 * - x - Represents the position of the object on the x-axis.
 * - y - Represents the position of the object on the y-axis.
 */
public class Point implements IClonable{
	private int x = 0;
	private int y = 0;
	
	
	/**
	 * Default constructor that initializes the point to (0, 0).
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	
	/**
	 * A constructor that initializes the point to the specified coordinates,
     * if both coordinates are non-negative. Otherwise, defaults to (0, 0).
	 * @param _x The x-coordinate of the point.
	 * @param _y The y-coordinate of the point.
	 */
	public Point(int _x, int _y) {
		if(_x >= 0 && _y >= 0) {
			this.x = _x;
			this.y = _y;
		}
		else {
			System.out.print("You entered a negative input, therefor the default input was used" + "\n");
		}
	}
	
	/**
	 * Checks if this point is equal to another object.
     * Two points are considered equal if they have the same x and y coordinates.
     * @param obj The object to compare with.
     * @return true - if the points are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Point) {
			ans = (x == ((Point)obj).x && y == ((Point)obj).y);
		}
		return ans;
	}
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Point.
	 */
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
	
	/**
	 * Sets the x-coordinate of the point to the specified value, if non-negative.
	 * @param val_x The new value for the x-coordinate.
	 * @return true - if the x-coordinate was successfully set, false - if not.
	 */
	public boolean setX(int val_x) {
		if(val_x >= 0) {
			this.x = val_x;
			return true;
		}
		return false;
	}
	
	
	/**
	 * Sets the y-coordinate of the point to the specified value, if non-negative.
	 * @param val_y The new value for the x-coordinate.
	 * @return true - if the y-coordinate was successfully set, false - if not.
	 */
	public boolean setY(int val_y) {
		if(val_y >= 0) {
			this.y = val_y;
			return true;
		}
		return false;
	}
	
	
	 /**
	 * Gets the x-coordinate of the point.
     * @return The x-coordinate of the point.
     */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate of the point.
     * @return The y-coordinate of the point.
	 */
	public int getY() {
		return y;
	}
	
	public Object clone() {
		return clone();
	}

}
