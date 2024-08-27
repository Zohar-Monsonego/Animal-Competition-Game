package Graphics;

import Animals.Animal;

/**
 * The IClonable interface is a marker interface used to indicate that implementing classes 
 * support cloning operations. Marker interfaces do not contain any methods or fields.
 * 
 * Classes implementing this interface should provide their own mechanisms for cloning instances.
 */
public interface IClonable {

	public Object clone();
	
}
