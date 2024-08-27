package Graphics;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Animals.Animal;


/**
 * A panel that displays a table of animal information using the MVC pattern.
 */
public class AnimalTableMVC extends JPanel{
	
	
	/**
     * Constructs a new AnimalTableMVC panel.
     *
     * @param animals the list of animals to be displayed in the table
     */
	public AnimalTableMVC(List<Animal> animals) {
		super();
		
		AnimalTableModel model = new AnimalTableModel(animals);
		JTable animals_table = new JTable(model);
		
		setColumnWidths(animals_table, 100, 100, 100, 100, 150, 100, 150);
		animals_table.setPreferredScrollableViewportSize(new Dimension(800,300));
		animals_table.setFillsViewportHeight(true);
		this.add(new JScrollPane(animals_table));
		
		this.setVisible(true);
		
	}
	
	
	
	/**
     * Sets the preferred and minimum widths for the columns of the table.
     *
     * @param table the table whose columns' widths are to be set
     * @param widths the array of widths to set for each column
     */
	 private void setColumnWidths(JTable table, int... widths) {
	        for (int i = 0; i <table.getColumnCount(); i++) {
	            if (i < widths.length) {
	                table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
	                table.getColumnModel().getColumn(i).setMinWidth(widths[i]);
	            }
	        }
	    }

}
