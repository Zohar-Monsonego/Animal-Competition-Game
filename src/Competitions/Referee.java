package Competitions;

import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Represents a referee in the tournament that monitors when an animal arrives at the destination
 * and updates the scores accordingly.
 * Implements the `Runnable` interface to allow execution in a separate thread.
 */
public class Referee implements Runnable{
	private String animal_name;
	private Scores scores;
	private AtomicBoolean is_arrived;
	private Object lock1 = new Object();
	private int group_index;
	
	
	/**
     * Constructs a `Referee` instance with the specified parameters.
     *
     * @param value an `AtomicBoolean` indicating whether the animal has arrived at the destination
     * @param animal_name the name of the animal being refereed
     * @param s the `Scores` object where scores are updated
     * @param index the index of the group in which the animal is competing
     */
	public Referee(AtomicBoolean value,String animal_name,Scores s,int index) {
		this.animal_name = animal_name;
		this.scores = s;
		this.is_arrived = value;
		this.group_index = index;
	}
	
	
	/**
     * The method executed by the thread. It waits until the `is_arrived` flag is set to `true`,
     * then updates the scores with the animal's name and group index.
     */
	public void run() {
		synchronized(lock1) {
			while(!is_arrived.get()) {
				try {
					lock1.wait();
				}catch(InterruptedException e) {
					System.out.println("Interrupted from being waiting -> Referee");
				}
			}
			scores.add(this.getAnimalName(),this.getGroupIndex());
			lock1.notifyAll();
			}
	}
	
	
	/**
     * Returns the name of the animal being refereed.
     *
     * @return the name of the animal
     */
	protected String getAnimalName() {
		return this.animal_name;
	}
	
	/**
     * Returns the `AtomicBoolean` indicating whether the animal has arrived at the destination.
     *
     * @return the `AtomicBoolean` indicating the arrival status
     */
	protected AtomicBoolean getIsArrived() {
		return this.is_arrived;
	}
	
	/**
     * Returns the index of the group in which the animal is competing.
     *
     * @return the group index
     */
	protected int getGroupIndex() {
		return this.group_index;
	}

}
