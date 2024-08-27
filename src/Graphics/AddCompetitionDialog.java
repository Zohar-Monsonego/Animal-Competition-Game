package Graphics;

//import java.awt.Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Animals.Animal;
import Competitions.CourierTournament;
import Competitions.RegularCompetition;
import Mobility.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A dialog for adding a competition.
 * <p>
 * This dialog allows the user to select a competition type (Courier or Regular), 
 * add groups and animals to the competition, and finalize the setup.
 * </p>
 */
public class AddCompetitionDialog extends JDialog implements ActionListener{
	private static final int MIN_GROUP = 2;
	private static final int MAX_GROUP = 4;
	private static final int MIN_ANIMALS = 2;
	private static final int MAX_COU_ANIMALS = 5;
	private static final int MAX_REG_ANIMALS = 1;
	
	private final String[] comp_name = {"Air", "Water", "Terrestrial"};
	private final JComboBox<String> combo = new JComboBox<String>(comp_name);
	private String select_comp;
	private final ButtonGroup radios = new ButtonGroup();
	private JTable table;
	private DefaultTableModel table_model;
	private Animal[][] competition_animals;
	private int group_count;
	private JButton add_group;
	private JButton finish_button;
	private String[] typeGroup;
	private String[] trackGroup = new String[MAX_GROUP];
	private int[] animal_count = new int[MAX_GROUP];
	private CompetitionPanel panel;
	private CalculateDestination des = new CalculateDestination();
	private ZooPanel zoo = new ZooPanel();
	
	
	
	
	 /**
     * Constructs a new AddCompetitionDialog.
     *
     * @param window the parent JFrame
     */
	public AddCompetitionDialog(CompetitionFrame window){
		super(window,"Add Competition",true);
		
		this.panel = window.getP();
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		final String[] langs = {"Courier Competition", "Regular Competition"};
		for(int i=0; i<langs.length; i+=1) {
			JRadioButton radio = new JRadioButton(langs[i]);
			radio.setActionCommand(langs[i]);
			radio.setSelected(i==0);
			
			if(i==0) {
				this.select_comp = radio.getActionCommand();
			}
			radio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select_comp = e.getActionCommand(); 
					
				}
			});
			
			this.add(radio);
			radios.add(radio);
		}

		
		allocationArray(select_comp);
		
		group_count = 0;
		

		this.add_group = new JButton("Add Group");
	
		add_group.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGroup(select_comp);
			}
		});
		this.add(add_group);
		
		table_model = new DefaultTableModel();
		table = new JTable(table_model);
		
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
	    table.setFillsViewportHeight(true);
	    
		JScrollPane scroll_pane = new JScrollPane(table);
		this.add(scroll_pane);
				
		this.finish_button = new JButton("Finish");
		finish_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(select_comp.equals("Courier Competition")) {
					if(select_comp.equals("Terrestrial")) {
						Animal[] a1 = null;
						for(int i=0;i<group_count;i+=1) {
							a1 = new Animal[animal_count[i]];
							a1[0] = competition_animals[0][i];
							panel.addAnimal(a1[0]);
							for(int j=1;j<animal_count[i];j+=1) {
								a1[j] = competition_animals[j][i];
								int d = calcDistanceTerrestrial(animal_count[i]);
								
								
							}
						}
					}
					else {
						Animal[] a2 = null;
						for(int i=0 ;i<group_count;i+=1) {
							a2 = new Animal[animal_count[i]];
							a2[0] = competition_animals[0][i];
							System.out.println("animal " + "0," + i + competition_animals[0][i].getLoc());
							panel.addAnimal(a2[0]);
							for(int j=1; j<animal_count[i];j+=1) {
								a2[j] = competition_animals[j][i];
								int d = calcDistanceEachAnimal(a2[0],animal_count[i]);
								setAnimalLocation(a2[j],a2[j-1],d);
								panel.addAnimal(a2[j]);
							}
						}
					}
	
					zoo.addCompetition(competition_animals);
					CourierTournament courier_t =  new CourierTournament(competition_animals, group_count,animal_count,window,panel);
					dispose();
				}
					
				else if(select_comp.equals("Regular Competition")) {
					//printArray(competition_animals);
					
					for(int i=0;i<group_count;i+=1) {
						for(int j=0;j<animal_count[i];j+=1) {
							panel.addAnimal(competition_animals[j][i]);
						}
					}
					RegularCompetition regular_c = new RegularCompetition(competition_animals,group_count,animal_count,window,panel);
					dispose();
				}
			}
		});
		
		
		
		
		
		
		
		this.pack();
		this.setSize(300,150);
		this.setLocationRelativeTo(window);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		select_comp = e.getActionCommand();
		System.out.println("Selected competition: " + getSelectComp());
	}

	
	 /**
     * Returns the selected competition type.
     *
     * @return the selected competition type
     */
	protected String getSelectComp() {
		return select_comp;
	
	}
	
	
	/**
	 * A private method to add a new group in a competition
	 * @param comp Thw competition type the user chose
	 */
	private void addGroup(String comp) {
		if(this.group_count < MAX_GROUP) {
			int new_group_number = table_model.getColumnCount() + 1;
		    table_model.addColumn("Group " + new_group_number);
		    this.group_count += 1;
		    
		    JButton add_animal = new JButton("Add Animal - Group" + this.group_count);
		    int group_index = this.group_count - 1;

		    add_animal.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	if(animal_count[group_index] >= MAX_COU_ANIMALS) {
		        		JOptionPane.showMessageDialog(null, "Exceed maximum animals per group");
		    			add_animal.setEnabled(false);
		        	}
		        	else if(select_comp.equals("Regular Competition")){
		        		 addAnimalRegularComp(group_index,select_comp);
		        	}
		        	else if(select_comp.equals("Courier Competition")) {
		        		addAnimalCourierComp(group_index,select_comp);
		        	}
		    
		        }
		    });
		    
		    this.add(add_animal);
		    this.add(finish_button);
		    
		    if(this.group_count >= MAX_GROUP) {
		    	this.add_group.setEnabled(false);
		    }
		}
		   
	    table.setPreferredScrollableViewportSize(table.getPreferredSize());
		this.pack();

		    
	}
	
	/**
	 * A method to add an animal to a Regular competition
	 * @param group_index The index of the group
	 * @param comp The competition type the user chose
	 */
	private void addAnimalRegularComp(int group_index, String comp) {
		if(this.animal_count[group_index] == 1) {
			JOptionPane.showMessageDialog(null, "Only one animal is allowed per group in a Regular Competition");
	        return;
		}
		
		AddAnimalDialog animal_dialog = new AddAnimalDialog(null);
	    animal_dialog.setVisible(true);
	    String animal_name = animal_dialog.getName(); 
	    String type = animal_dialog.getComp();
	    String track = animal_dialog.getTrack();
	    
	    if(animal_name == null) {
	    	return;
	    }
	   
	    Object[] newRow = new Object[table_model.getColumnCount()];
	    newRow[group_index] = animal_name;
	    table_model.addRow(newRow);
	    this.animal_count[group_index] += 1;
	    table_model.setValueAt(animal_name, 0, group_index);
	    table_model.fireTableDataChanged();
	    
	    animal_dialog.fillArray(competition_animals, 0, group_index);

	    
	    table.revalidate();
	    table.repaint();
	    table.setPreferredScrollableViewportSize(table.getPreferredSize());
	    this.pack();
	}
	
	
	/**
	 * A method to add an animal to a Courier competition 
	 * group_index The index of the group
	 * @param comp The competition type the user chose
	 */
	private void addAnimalCourierComp(int group_index, String comp) {
		
		 AddAnimalDialog animal_dialog = new AddAnimalDialog(null);
		 animal_dialog.setVisible(true);
		 String animalName = animal_dialog.getName(); 
		 String type = animal_dialog.getComp();
		 String track = animal_dialog.getTrack();
		
		 
		 if(animalName == null) {
		     return;
		 }
		    
		 if(this.typeGroup == null) {
		     this.typeGroup = new String[MAX_GROUP];
		 }
		 
		 if(this.typeGroup[group_index] == null) {
		     this.typeGroup[group_index] = type;
		     this.trackGroup[group_index] = track;
		 }else if(!this.typeGroup[group_index].equals(type)) {
		     JOptionPane.showMessageDialog(null, "You cannot add a different type of animal.");
		     return;
		 }
		 if(type.equals("Terrestrial")) {
			 trackGroup[group_index] = null;
		 }else if(!track.equals(trackGroup[group_index])){
			 JOptionPane.showMessageDialog(null, "All animals in this group must be on the same track (" + this.trackGroup[group_index] + ")");
			 return;
		 }
		 
		 boolean added = false;
		 int row_count = table_model.getRowCount();
		 int column_count = table_model.getColumnCount();
		 
		 for (int i = 0; i < row_count; i++) {
		     if (table_model.getValueAt(i, group_index) == null) {
		         table_model.setValueAt(animalName, i, group_index);
		         added = true;
		         
		         if (i < MAX_COU_ANIMALS) {
		        	 System.out.println("Adding animal to position: (" + i + ", " + group_index + ")");
		        	 animal_dialog.fillArray(competition_animals, i, group_index);
		             this.animal_count[group_index] += 1;
		            } else {
		                JOptionPane.showMessageDialog(null, "Cannot add more animals to this group.");
		         }
		         break;
		     }
		     
		     
		 }
		 
		 if(!added) {
			 if(row_count < MAX_COU_ANIMALS) {
				 Object[] newRow = new Object[column_count];
			     newRow[group_index] = animalName;
			     table_model.addRow(newRow);
			     this.animal_count[group_index] += 1;
	
			     System.out.println("Adding animal to position: (" + row_count + ", " + group_index + ")");
			     animal_dialog.fillArray(competition_animals, row_count, group_index);
		     } else {
		         JOptionPane.showMessageDialog(null, "Cannot add more rows to the table.");
		     }
		 }
		     
		 table.revalidate();
		 table.repaint();
		 table.setPreferredScrollableViewportSize(table.getPreferredSize());
		 this.pack();

		    
		    
	}
	
	/**
	 * A method to allocate dynamically the array
	 * @param comp The competition type the user chose
	 */
	private void allocationArray(String comp) {
		if(comp.equals("Regular Competition")) {
			this.competition_animals = new Animal[MAX_GROUP][MAX_REG_ANIMALS];
		}
		else if(comp.equals("Courier Competition")) {
			this.competition_animals = new Animal[MAX_GROUP][MAX_COU_ANIMALS];
		}
	}
	
	
	
	/**
	 * Returns the 2D array of animals participating in the competition.
	 *
	 * @return a 2D array of `Animal` objects representing the competition animals
	 */
	protected Animal[][] getCompetitionAnimals() {
		return this.competition_animals;
	}
	
	
	/**
	 * Prints the details of the specified 2D array of animals to the console.
	 * Each animal's information is printed along with a newline for separation.
	 *
	 * @param a a 2D array of `Animal` objects to be printed
	 */
	public void printArray(Animal[][] a) {
		for(int i=0;i<a.length;i+=1)
			for(int j=0;j<MAX_GROUP;j+=1) {
				System.out.println(a[j][i]);
				System.out.println();
			}
	}
	
	
	/**
	 * Sets the location of the given animal based on the location of another animal and a distance.
	 * The x-coordinate of the first animal is updated to be the x-coordinate of the second animal plus the distance.
	 *
	 * @param a the `Animal` whose location is to be set
	 * @param a2 the `Animal` whose location is used as a reference
	 * @param distance the distance to be added to the x-coordinate of the reference animal
	 */
	private void setAnimalLocation(Animal a,Animal a2, int distance) {
			a.getLoc().setX(a2.getLoc().getX() + distance);
    }
		
	
	/**
	 * Calculates the distance each animal should move in order to reach its destination, based on the total number of animals in a group.
	 * The distance is computed as the total distance divided by the number of animals.
	 *
	 * @param a the `Animal` whose destination is to be calculated
	 * @param a_count the total number of animals in the group
	 * @return the distance each animal should move
	 */
	private int calcDistanceEachAnimal(Animal a,int a_count) {
		Point start_point = a.getLoc();
		Point finish_point = des.calcDestination(a, a.getTrack());
		int distance = (int)(calcDistance(start_point,finish_point)/a_count);
		return distance;
		
	}
	
	
	/**
	 * Sets the location of each animal in the array based on the previous animal's location and the calculated distance.
	 * This method updates the location of animals in a group, ensuring they are spaced correctly.
	 *
	 * @param a a 2D array of `Animal` objects to be updated
	 * @param g_count the number of groups
	 * @param a_count an array indicating the number of animals in each group
	 */
	public void setArrayLocation(Animal[][] a, int g_count, int[] a_count) {
		synchronized(a) {
			for(int i=0;i<g_count;i+=1) {
				for(int j=1;j<a_count[i];j+=1) {
					int d = calcDistanceEachAnimal(a[0][0],a_count[i]);
					setAnimalLocation(a[j][i],a[j-1][i],d);
				}
			}
		}
	}
	
	/**
	 * Calculates the distance between two points using the Euclidean distance formula.
	 *
	 * @param p1 the first `Point`
	 * @param p2 the second `Point`
	 * @return the distance between the two points
	 */
	 double calcDistance(Point p1, Point p2) {
		double dis = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
		return dis;
	}
	 
	 /**
	  * Calculates the total distance for a terrestrial competition track.
	  * The track is represented as a rectangular path with specified start and end points.
	  *
	  * @param a_count the number of animals in the group
	  * @return the distance each animal should travel, divided equally among all animals
	  */
	 public int calcDistanceTerrestrial( int a_count) {
		 Point p1 = new Point(57,20);
		 Point p2 = new Point(1300,20);
		 Point p3 = new Point(1300,760);
		 double left_right = calcDistance(p1,p2);
		 double up_down = calcDistance(p2,p3);
		 
		 double total_d = (left_right * 2) + (up_down * 2);
		 return (int)total_d/a_count;
		 
	 }
	 
	 /**
	  * Sets the location of a terrestrial animal based on the location of another animal and a distance.
	  * The x-coordinate of the first animal is updated to be the x-coordinate of the second animal plus the distance.
	  *
	  * @param a the `Animal` whose location is to be set
	  * @param a2 the `Animal` whose location is used as a reference
	  * @param distance the distance to be added to the x-coordinate of the reference animal
	  */
	 private void setTerrestrialLocation(Animal a, Animal a2, int distance) {
		 a.getLoc().setX((a2.getLoc().getX() + distance));
	 }
	
	

}
