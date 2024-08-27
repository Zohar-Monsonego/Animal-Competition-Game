package Competitions;

import java.util.concurrent.atomic.AtomicBoolean;

import Animals.Animal;
import Animals.AnimalThread;
import Graphics.AddCompetitionDialog;
import Graphics.CalculateDestination;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;
import Mobility.Point;


/**
 * Represents a courier tournament where animals compete in groups to reach a destination.
 * This class extends the `Tournament` class and manages the setup and execution of the tournament.
 */
public class CourierTournament extends Tournament{
	
	
	/**
     * Constructs a `CourierTournament` instance with the specified parameters.
     *
     * @param animals a 2D array of `Animal` objects representing the animals participating in the tournament
     * @param g_count the number of groups in the tournament
     * @param a_count an array indicating the number of animals in each group
     * @param window the `CompetitionFrame` window where the competition is displayed
     * @param panel the `CompetitionPanel` panel where competition controls are available
     */
	public CourierTournament(Animal[][] animals, int g_count, int[] a_count, CompetitionFrame window,CompetitionPanel panel) {
		super(animals, g_count,a_count,window,panel);	
	}

	
	/**
     * Sets up the tournament by initializing the competition dialog, calculating the distances,
     * and starting threads for each animal and referee.
     *
     * @param a a 2D array of `Animal` objects to be used in the competition
     * @param g_count the number of groups in the tournament
     * @param a_count an array indicating the number of animals in each group
     * @param window the `CompetitionFrame` window where the competition is displayed
     * @param panel the `CompetitionPanel` panel where competition controls are available
     */
	public void setUp(Animal[][] a, int g_count,int[] a_count, CompetitionFrame window, CompetitionPanel panel) {
		CalculateDestination des = new CalculateDestination();
		
		AddCompetitionDialog a_dialog = new AddCompetitionDialog(window);
		a_dialog.setArrayLocation(a, g_count, a_count);
		
		
		AtomicBoolean startFlag = new AtomicBoolean(true);
		Scores scores = new Scores();
		
		for(int col=0; col<g_count;col+=1) {
			int n = a_count[col];
			AtomicBoolean[] flag = new AtomicBoolean[n];
			for(int k=0; k<n; k+=1) {
				flag[k] = new AtomicBoolean(false);
			}
				
			Object group_lock = new Object();

			Point start_first_a = a[0][col].getStartLoc();
			Point des_first_a = des.calcDestination(a[0][col], a[0][col].getTrack());
			double distance_first_a = this.calcDistance(start_first_a, des_first_a);
			
			System.out.println(a[1][col].getLoc());
			Thread first_a_t = new Thread(new AnimalThread(a[0][col],distance_first_a/n,startFlag,flag[0],a[1][col].getLoc(), group_lock,panel));
			first_a_t.start();
	
			for(int row=1; row<n; row+=1) {
				System.out.println(a[row][col]);
				Point start_point = a[row][col].getLoc();
				Point des_point = des.calcDestination(a[row][col], a[row][col].getTrack());
				
				Point next_location;
				if(row < n-1) {
					next_location = a[row+1][col].getLoc();
				}
				else {
					next_location = des_point;
				}
				
				Thread a_t = new Thread(new AnimalThread(a[row][col],distance_first_a/n,flag[row-1],flag[row],next_location,group_lock,panel));
				a_t.start();
				
				System.out.println("animal" + row + "," + col + "started moving" );
				
				
			}
			
			Thread r = new Thread(new Referee(flag[n-1],a[n-1][col].getAnimalName(),scores, col));
			r.start();
			Thread t_thread = new Thread(new TournamentThread(scores,startFlag,g_count,window,panel));
			t_thread.start();
				
		}
	}
	

	
	/**
     * Calculates the Euclidean distance between two points.
     *
     * @param p1 the first `Point`
     * @param p2 the second `Point`
     * @return the distance between the two points
     */
	private double calcDistance(Point p1, Point p2) {
		double dis = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
		return dis;
	}
	
	
	
}


