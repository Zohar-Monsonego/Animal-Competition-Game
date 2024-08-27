package Graphics;


/**
 * The IAnimal interface extends the IMoveable interface and adds functionality specific to animals.
 * It provides a method for the animal to consume energy.
 */
public interface IAnimal extends IMoveable{
	
	/**
     * Allows the animal to consume a specified amount of energy.
     * 
     * @param energy the amount of energy to consume
     * @return true if the animal successfully consumes the specified amount of energy, false otherwise
     */
	public boolean eat(int energy);

}
