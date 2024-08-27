package Graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JDialog;

import Animals.Animal;


/**
 * The {@code ZooPanel} class extends {@link JDialog} and represents a dialog
 * for displaying or interacting with zoo-related information or components. 
 */
public class ZooPanel extends JDialog {
	
	 /**
     * A synchronized list of 2D arrays of {@link Animal} objects representing
     * different zoo competitions.
     */
	private List<Animal[][]> competitions; 
	
	
	/**
     * Constructs a new {@code ZooPanel} instance with an empty list of competitions.
     */
	public ZooPanel() {
		this.competitions = Collections.synchronizedList(new ArrayList<Animal[][]>());
	}
	
	
	/**
     * Adds a new competition to the list of competitions.
     * 
     * @param comp a 2D array of {@link Animal} objects representing the competition to be added
     * If the provided competition is {@code null}, an error message is printed to the console.
     */
	public void addCompetition(Animal[][] comp) {
		synchronized(competitions) {
			if(comp != null) {
				competitions.add(comp);
			}
			else {
				System.out.println("The competition you want to add is null");
			}
		}
	}
	
	

}
