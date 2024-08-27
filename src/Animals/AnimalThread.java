package Animals;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.SwingUtilities;

import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;
import Mobility.Point;

/**
 * Represents a thread that manages the movement of an `Animal` in a competition.
 * It handles waiting for the start signal, moving the animal towards a destination,
 * and updating the competition panel with the animal's progress.
 */
public class AnimalThread implements Runnable{
	private Animal participant;
	private double needed_distance;
	private AtomicBoolean current_start_flag;
	private AtomicBoolean finish_flag;
	private CompetitionPanel panel;
	private static int SLEEP_TIME = 2000;
	private Object group_lock;
	private Point destination;
	
	/**
     * Default constructor for `AnimalThread`. Initializes with default values.
     */
	public AnimalThread() {
		
	}
	
	
	/**
     * Constructs an `AnimalThread` with the specified parameters.
     *
     * @param p the `Animal` instance that this thread will manage
     * @param n_d the distance needed for the animal to move
     * @param s_f the `AtomicBoolean` indicating the start signal for the animal
     * @param f_f the `AtomicBoolean` indicating if the animal has finished
     * @param destination the destination point for the animal
     * @param lock the object used for synchronization
     * @param panel the `CompetitionPanel` used for updating the UI
     */
	public AnimalThread(Animal p, double n_d, AtomicBoolean s_f, AtomicBoolean f_f, Point destination, Object lock,CompetitionPanel panel) {
		this.participant = p;
		this.needed_distance = n_d;
		this.current_start_flag = s_f;
		this.finish_flag = f_f;
		this.panel = panel;
		this.destination = destination;
		this.group_lock = lock;
	}
	
	
	 /**
     * Executes the thread's logic. This includes waiting for the start signal,
     * moving the animal, and updating the competition panel.
     */
    @Override
	public void run() {
		synchronized(group_lock) {
			System.out.println(this.participant.getAnimalName() + "waiting to start");
			while(!this.getCurrentStartFlag().get()) {
				try {
					group_lock.wait();
				}catch(InterruptedException e) {
					System.out.println("Interrupted from waiting -> AnimalThread");
				}
			}
			System.out.println(this.participant.getAnimalName() + "starting to move");
			synchronized(participant) {
				panel.startMovingAnimal(this.getParticipant(),destination);
				double d = this.participant.getTotalDistance();
				
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Thread was interrupted during movement -> AnimalThread");
					return;
				}
				
				if(this.getParticipant().getLoc().equals(destination)) {
					if(this.getParticipant().getComp().equals("Courier Competition")) {
						this.current_start_flag.set(false);
						this.finish_flag.set(true);
						group_lock.notifyAll();
					}
					else if(this.getParticipant().getComp().equals("Regular Competition")) {
						this.current_start_flag.set(false);
						this.finish_flag.set(true);
						group_lock.notify();
					}
				}
				
			}	
	
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				System.out.println("Thread interrupted from sleeping -> AnimalThread");
			}
		}
	}
	
	
    /**
     * Retrieves the `Animal` instance that this thread is managing.
     *
     * @return the `Animal` instance
     */
	public Animal getParticipant() {
		return this.participant;
	}
	
	
	/**
     * Retrieves the distance needed for the animal to move.
     *
     * @return the needed distance
     */
	public double getNeededDistance() {
		return this.needed_distance;
	}
	
	/**
     * Retrieves the `AtomicBoolean` indicating the start signal for the animal.
     *
     * @return the start signal
     */
	public AtomicBoolean getCurrentStartFlag() {
		return this.current_start_flag;
	}
	
	
	/**
     * Retrieves the `AtomicBoolean` indicating if the animal has finished.
     *
     * @return the finish flag
     */
	public AtomicBoolean getFinishFlag() {
		return this.finish_flag;
	}
	
	
	/**
     * Sets the current start flag to the given `AtomicBoolean` value.
     *
     * @param b the new start flag value
     * @return true if the flag was set successfully
     */
	public synchronized boolean setCurrentStartFlag(AtomicBoolean b) {
		this.current_start_flag = b;
		return true;
	}
	
	
	 /**
     * Sets the finish flag to the given `AtomicBoolean` value.
     *
     * @param b the new finish flag value
     * @return true if the flag was set successfully
     */
	public synchronized boolean setFinishFlag(AtomicBoolean b) {
		this.finish_flag = b;
		return true;
	}
	
	
	/**
     * Sets the sleep time for the thread.
     *
     * @param time the new sleep time in milliseconds
     * @return true if the sleep time was set successfully
     */
	public synchronized boolean setSleepTime(int time) {
		SLEEP_TIME = time;
		return true;
	}

}
