package Animals;


/**
 * an interface that represents the terrestrial behavior of an animal, implementing the ITerrestrialAnimal interface.
 * Fields:
 * - number_of_legs: The number of legs the terrestrial animal has.
 */
public class TerrestrialBehavior implements ITerrestrialAnimal {
	private int number_of_legs;
	
	
	/**
     * Constructor that initializes the number of legs for the terrestrial animal.
     * @param num_l The number of legs
     */
	public TerrestrialBehavior(int num_l) {
		this.number_of_legs = num_l;
	}
	
	/**
     * Gets the number of legs the terrestrial animal has.
     * @return The number of legs
     */
    @Override
	public int getNumberOfLegs() {
		return this.number_of_legs;
	}

}
