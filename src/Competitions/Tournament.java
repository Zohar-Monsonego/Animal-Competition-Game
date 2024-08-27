package Competitions;

import Animals.Animal;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;

/**
 * Abstract class representing a competition tournament.
 * Subclasses are responsible for setting up and running specific types of tournaments.
 */
public abstract class Tournament {
	protected TournamentThread t_thread;
	
	
	/**
     * Constructs a `Tournament` instance and initializes the tournament setup.
     *
     * @param a an array of animals participating in the tournament
     * @param g_count the number of groups in the tournament
     * @param a_count an array where each element represents the number of animals in each group
     * @param window the main competition frame
     * @param panel the competition panel used for displaying information
     */
	public Tournament(Animal[][] a, int g_count,int[] a_count,CompetitionFrame window,CompetitionPanel panel) {
		setUp(a,g_count,a_count,window,panel);
	}
	
	 /**
     * Abstract method to set up the tournament. Subclasses must provide
     * their own implementation of how the tournament should be initialized.
     *
     * @param animals an array of animals participating in the tournament
     * @param g_count the number of groups in the tournament
     * @param a_count an array where each element represents the number of animals in each group
     * @param window the main competition frame
     * @param panel the competition panel used for displaying information
     */
	public abstract void setUp(Animal[][] animals, int g_count,int[] a_count, CompetitionFrame window,CompetitionPanel panel);
	
	
	/**
     * Retrieves the `TournamentThread` associated with this tournament.
     *
     * @return the `TournamentThread` instance
     */
	public TournamentThread getThread() {
		return this.t_thread;
	}

}
