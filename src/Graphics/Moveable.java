package Graphics;

import Mobility.Location;
import Mobility.Point;

import Animals.Animal;
import Animals.Orientation;


/**
 * The {@code Moveable} class implements the {@link IMoveable} interface
 * to provide movement functionality for an {@link Animal} object.
 * 
 * This class allows an animal to move to a specified point, adjust its
 * orientation based on the direction of movement, and updates its energy
 * and distance traveled.
 */
public class Moveable implements IMoveable{

	String animal_name;
	int animal_speed;
	Point animal_loc;
	int energy_per_meter;
	int current_energy;
	double total_d;
	Orientation orien;
	
	
	
	/**
	 * Constructs a {@code Moveable} object with the specified parameters.
	 * 
	 * @param n The name of the animal.
	 * @param sp The speed of the animal.
	 * @param loc The location of the animal as a {@link Point}.
	 * @param energy_meter The energy consumption per meter.
	 * @param cur_energy The current energy of the animal.
	 * @param total_d The total distance traveled by the animal.
	 * @param o The orientation of the animal as an {@link Orientation} enum.
	 */
	public Moveable(String n, int sp, Point loc, int energy_meter,int cur_energy,double total_d, Orientation o) {
		this.animal_name = n;
		this.animal_speed = sp;
		this.animal_loc = loc;
		this.energy_per_meter = energy_meter;
		this.current_energy = cur_energy;
		this.total_d = total_d;
		this.orien = o;
	}
	
	
	/**
     * Gets the name of the animal associated with this Moveable object.
     * 
     * @return The name of the animal.
     */
	public String getAnimalName() {
		return this.animal_name;
	}
	
	
	/**
     * Gets the speed of the animal associated with this Moveable object.
     * 
     * @return The speed of the animal.
     */
	public int getSpeed() {
		return this.animal_speed;
	}
	
	
	/**
     * Moves the animal to the specified point and updates its state.
     * 
     * <p>This method calculates the distance to the target point, updates the animal's 
     * current energy, total distance traveled, and location. It also adjusts 
     * the animal's orientation based on the direction of movement.</p>
     * 
     * @param p The target point to move to.
     * @return The distance traveled to the target point, or 0 if the animal 
     *         does not have enough energy to move.
     */
	public double move(Point p) {
		double distance = Math.sqrt(Math.pow(p.getX() - this.animal_loc.getX(), 2) + Math.pow(p.getY() - this.animal_loc.getY(), 2));
		this.animal_loc.setX(p.getX());
		this.animal_loc.setY(p.getY());
		System.out.println(animal_loc);
			
		if(p.getX() > this.animal_loc.getX()) {
			this.orien = Orientation.EAST;
		}
		else if(p.getX() < this.animal_loc.getX()) {
			this.orien = Orientation.WEST;
		}
		else if(p.getY() > this.animal_loc.getY()) {
			this.orien = Orientation.SOUTH;
		} 
		else if(p.getY() < this.animal_loc.getY()) {
			this.orien = Orientation.NORTH;
		}
		return distance;
	}

}
