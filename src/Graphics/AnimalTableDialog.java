package Graphics;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JDialog;

import Animals.Animal;


/**
 * A dialog that displays a table with information about animals.
 */
public class AnimalTableDialog extends JDialog{
	
	
	/**
     * Constructs a new AnimalTableDialog.
     *
     * @param father_window the parent CompetitionFrame
     * @param animals the list of animals to be displayed in the table
     */
	public AnimalTableDialog(CompetitionFrame father_window, List<Animal> animals) {
		super(father_window, "Info", true);
		
		setLayout(new BorderLayout());
		AnimalTableMVC table = new AnimalTableMVC(animals);
		
		this.add(table, BorderLayout.CENTER);
		
		this.pack();
		this.setSize(800, 300);
		this.setLocationRelativeTo(father_window);
	}

}
