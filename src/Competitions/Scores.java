package Competitions;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Manages and stores the scores of animals in a competition.
 * Stores the names of the animals along with their finish times.
 */
public class Scores {
	private Map<String,Date> scores;
	
	
	/**
     * Constructs a `Scores` instance with an empty synchronized map.
     */
	public Scores() {
		this.scores = Collections.synchronizedMap(new HashMap());
	}
	
	
	/**
     * Adds a score entry for an animal in a specific group.
     * The entry includes the animal's name and the current date and time.
     *
     * @param name the name of the animal
     * @param group_index the index of the group the animal belongs to
     */
	public void add(String name,int group_index) {
		if(name != null) {
			String key = "Group " + group_index + ": " + name;
			this.scores.put(key, new Date());
		}
	}
	
	
	/**
     * Returns an unmodifiable view of the scores map.
     * This provides a snapshot of the scores at the time of the method call.
     *
     * @return an unmodifiable map of scores
     */
	public synchronized Map<String,Date> getAll(){
		return Collections.unmodifiableMap(new HashMap(this.scores));//return a copy of scores
	}

}
