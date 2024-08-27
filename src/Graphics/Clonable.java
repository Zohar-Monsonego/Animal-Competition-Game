package Graphics;

import Animals.Animal;

/**
 * A class that implements the IClonable interface, representing a clonable object.
 */
public class Clonable implements IClonable{
	
	
	/**
     * Constructs a new Clonable object.
     */
	public Clonable() {};
	
	public Clonable clone() {
		try {
	         return (Clonable) super.clone();
			
		} catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
