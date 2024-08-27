package Competitions;

import java.util.concurrent.atomic.AtomicBoolean;

import Animals.Animal;
import Animals.AnimalThread;
import Graphics.CalculateDestination;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;
import Mobility.Point;


/**
 * Represents a regular competition in the tournament where animals compete in groups.
 * Extends the `Tournament` class and sets up and manages the competition for each group.
 */
public class RegularCompetition extends Tournament{
	
	
	/**
     * Constructs a `RegularCompetition` instance with the specified parameters.
     *
     * @param a a 2D array of `Animal` objects representing the animals in the competition
     * @param g_count the number of groups in the competition
     * @param a_count an array where each element specifies the number of animals in each group
     * @param window the `CompetitionFrame` window for the competition
     * @param panel the `CompetitionPanel` panel used in the competition
     */
	public RegularCompetition(Animal[][] a, int g_count, int[] a_count,CompetitionFrame window,CompetitionPanel panel) {
		super(a,g_count,a_count,window,panel);
	}
	
	
	/**
     * Sets up the competition by initializing threads for animals, referees, and the tournament.
     * Each group of animals is handled in its own thread, and the referee monitors the finish status.
     *
     * @param a a 2D array of `Animal` objects representing the animals in the competition
     * @param g_count the number of groups in the competition
     * @param a_count an array where each element specifies the number of animals in each group
     * @param window the `CompetitionFrame` window for the competition
     * @param panel the `CompetitionPanel` panel used in the competition
     */
	public void setUp(Animal[][] a, int g_count, int[] a_count,CompetitionFrame window,CompetitionPanel panel) {
		CalculateDestination des = new CalculateDestination();
		AtomicBoolean startFlag = new AtomicBoolean(true);
		Scores scores = new Scores();
		Object lock = new Object();
		
		for(int i=0;i<g_count;i+=1) {
			System.out.println("choosing group " + i );
			AtomicBoolean finish_flag = new AtomicBoolean(false);
			Point start_point = a[0][i].getLoc();
			System.out.println(a[0][i]);
			Point finish_point = des.calcDestination(a[0][i], a[0][i].getTrack());
			double distance = this.calcDistance(start_point,  finish_point);
			 
			Thread a_t = new Thread(new AnimalThread(a[0][i],distance, startFlag,finish_flag,finish_point,lock,panel));
			a_t.start();
			
			Thread r_t = new Thread(new Referee(finish_flag,a[0][i].getAnimalName(), scores,i));
			r_t.start();
			
			Thread t_t = new Thread(new TournamentThread(scores,startFlag,g_count,window,panel));
			t_t.start();
		}
	}

	/**
     * Calculates the Euclidean distance between two points.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
	private double calcDistance(Point p1, Point p2) {
		double dis = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
		return dis;
	}
}
