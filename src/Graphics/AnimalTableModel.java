package Graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Animals.Animal;


/**
 * A table model for displaying information about animals.
 */
public class AnimalTableModel extends AbstractTableModel{
	private final String[] column_names = {"Animal", "Catrgory", "Type", "Speed", "Energy Amount", "Distance", "Energy Consumption"};
	private List<Animal> animals;
	
	
	/**
     * Constructs a new AnimalTableModel.
     *
     * @param animals the list of animals to be displayed in the table
     */
	public AnimalTableModel(List<Animal> animals) {
		this.animals = Collections.synchronizedList(new ArrayList<>(animals));
	}
	
	
	/**
     * Returns the number of rows in the table.
     *
     * @return the number of rows
     */
    @Override
	public int getRowCount() {
		return animals.size();
	}
    
    /**
     * Returns the number of columns in the table.
     *
     * @return the number of columns
     */
    @Override
	public int getColumnCount() {
		return 7;
	}
	
    
    /**
     * Returns the value at the specified row and column.
     *
     * @param rowIndex the row index
     * @param columnIndex the column index
     * @return the value at the specified cell
     */
    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Animal animal = animals.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return animal.getAnimalName();
		case 1:
			return animal.getCategory();
		case 2:
			return animal.getType();
		case 3:
			return animal.getSpeed();
		case 4:
			return animal.getCurrentEnergy();
		case 5:
			return animal.getTotalDistance();
		case 6:
			return animal.getEnergyConsumption();
		}
		return null;
	}
	
    
    /**
     * Returns the name of the column at the specified index.
     *
     * @param column the column index
     * @return the name of the column
     */
    @Override
	public String getColumnName(int column) {
		return column_names[column];
		
	}

}
