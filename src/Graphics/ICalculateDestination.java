package Graphics;


import Animals.Animal;
import Mobility.Point;


/**
 * Interface for calculating the destination point for an animal in a competition.
 * Implementations of this interface define how to determine where an animal should move
 * based on its characteristics and the track it is competing on.
 */
public interface ICalculateDestination {
	
	/**
     * Calculates the destination point for the given animal on the specified track.
     *
     * @param a the `Animal` instance for which the destination is being calculated
     * @param Track the name or identifier of the track the animal is competing on
     * @return the calculated `Point` representing the destination for the animal
     */
	public Point calcDestination(Animal a, String Track);

}
