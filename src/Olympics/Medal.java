package Olympics;


/**
 * The Medal class represents an Olympic medal.
 * It includes the fields:
 * - type - The medal's type.
 * - tournament - what tournament the medal was awarded.
 * - year - what year was the tournament.
 * */
public class Medal {
	private Type type;
	private String tournament;
	private int year;
	
	
	/**
	 * Default constructor that initializes the medal to a default gold medal from the Olympics in 2024.
	 */
	public Medal() {
		this.type = Type.GOLD;
		this.tournament = "Olympics";
		this.year = 2024;
	}
	
	/**
	 * A constructor that initializes the medal with the specified type, tournament, and year received from the user.
	 * @param ty The type of the medal (gold, silver, bronze).
	 * @param tour The tournament or event where the medal was awarded.
	 * @param year_ The year when the medal was awarded.
	 */
	public Medal(Type ty, String tour, int year_) {
		this.type = ty;
		this.tournament = tour;
		this.year = year_;
	}
	
	
	/**
	 * Checks if this medal is equal to another object.
     * Two Medals are considered equal if they have the same type, tournament, and year.
     * @param obj The object to compare with.
     * @return true  - if the medals are equal, false - if not.
	 */
	public boolean equals(Object obj) {
		boolean ans = false;
		if(obj instanceof Medal) {
			ans = (type == ((Medal)obj).type && tournament == ((Medal)obj).tournament && year == ((Medal)obj).year);
		}
		return ans;
	}
	
	
	/**
	 * Copy Constructor
     * @param other The object we want to copy from
     */
	public Medal(Medal other) {
		this.type = other.type;
		this.tournament = other.tournament;
		this.year = other.year;
	}
	
	
	/**
	 * The method prints all the class's fields and their values.
	 * @return The representation of the class Medal.
	 */
	public String toString() {
		return "Medal{" + "Type: " + type + ", tournament: " + tournament + ", year: " + year;
	}
	
	
	/**
	 * Gets the type of the medal.
     * @return The type of the medal (gold, silver, bronze).
	 */
	protected Type getType() {
		return type;
	}
	
	/**
	 * Gets the tournament or event where the medal was awarded.
     * @return The tournament or event name.
     */
	protected String getTour() {
		return tournament;
	}
	
	/**
	 * Gets the year when the medal was awarded.
     * @return The year of the medal.
     */
	protected int getYear() {
		return year;
	}
	

}
