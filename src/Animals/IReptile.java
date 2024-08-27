package Animals;


/**
 * The IReptile interface represents behaviors that a reptile can exhibit.
 * It defines methods related to speed manipulation.
 */
public interface IReptile {
	
	/**
	 * The maximum speed that a reptile can achieve.
	 */
	static final int MAX_SPEED = 5;
	
	
	/**
	 * Speeds up the reptile to the given speed.
	 * @param speed The speed to which the reptile should be accelerated.
	 * @return True - if the reptile successfully speeds up to the given speed, false - if not.
	 */
	public boolean speedUp(int speed);

}
