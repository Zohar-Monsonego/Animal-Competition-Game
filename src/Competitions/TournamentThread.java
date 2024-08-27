package Competitions;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;

import Animals.AnimalThread;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;


/**
 * Handles the execution of tournament-related tasks in a separate thread.
 * This includes waiting for the start signal and updating scores as the tournament progresses.
 */
public class TournamentThread implements Runnable{
	private Scores scores;
	private AtomicBoolean startSignal = new AtomicBoolean(false);
	private int groups;
	private Object lock = new Object();
	private AnimalThread t = new AnimalThread();
	private CompetitionFrame window;
	private CompetitionPanel panel;
	
	
	/**
     * Constructs a `TournamentThread` instance with the specified parameters.
     *
     * @param s the `Scores` instance used for recording the scores
     * @param s_f an `AtomicBoolean` signal used to start the tournament
     * @param g the number of groups in the tournament
     * @param window the main competition frame
     * @param p the competition panel used for displaying information
     */
	public TournamentThread(Scores s,AtomicBoolean s_f, int g,CompetitionFrame window, CompetitionPanel p) {
		this.scores = s;
		this.startSignal = s_f;
		this.groups = g;
		this.window = window;
		this.panel = p;
	}
	
	
	/**
     * Executes the tournament thread's logic. This includes waiting for the start signal,
     * updating scores for each group, and notifying the competition panel.
     */
    @Override
	public void run() {
		synchronized(lock) {
			while(!startSignal.get()) {
				try {
				lock.wait();
				}catch(InterruptedException e) {
					System.out.println("Interrypted from waiting -> TournamentThread");
				}
				t.setCurrentStartFlag(new AtomicBoolean(true));
				for(int i=0;i<groups;i+=1) {
					if(!t.getCurrentStartFlag().get()) {
						scores.add(t.getParticipant().getName(),i);
				}
			    panel.setScores(this.getScores());
				lock.notifyAll();
					
				}
			}
		}
	}
	
	
    /**
     * Retrieves the competition frame associated with this thread.
     *
     * @return the `CompetitionFrame` instance
     */
	protected JFrame getWindow() {
		return this.window;
	}
	
	
	/**
     * Retrieves the `Scores` instance associated with this thread.
     *
     * @return the `Scores` instance
     */
	protected Scores getScores() {
		return this.scores;
	}
}
