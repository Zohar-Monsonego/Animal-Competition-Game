package Graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Animals.*;

/**
 * Dialog for adding a new animal to the competition.
 */
public class AddAnimalDialog extends JDialog {
	private JComboBox<String> comp_combo;
	private JComboBox<String> animal_combo;
	private JComboBox<String> track_combo;
	private String selected_comp;
	private String selected_animal;
	private String selected_track;
	private String[] comp = {"Competition","Air", "Water", "Terrestrial"};
	private String[] animals = {"Animal","Eagle", "Pigoen","Alligator", "Whale", "Dolphin","Dog", "Cat", "Snake"}; 
	private String[] water_tracks = {"Track 1", "Track 2", "Track 3", "Track 4"};
	private String[] air_tracks = {"Track 1",  "Track 2", "Track 3", "Track 4", "Track 5"};
	private String animal_name;
	private int animal_speed;
	private int energy_meter;
	private JPanel panel;
	private JButton add;
	private Animal a;
	
	
	/**
     * Constructor to initialize the AddAnimalDialog.
     * 
     * @param window The parent CompetitionFrame.
     */
	public AddAnimalDialog(CompetitionFrame window) {
		super(window, "Add Animal", true);
		
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		animal_combo = new JComboBox<String>(animals);
		animal_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_animal = (String)animal_combo.getSelectedItem();
			}
		});
		
		comp_combo = new JComboBox<String>(comp);
		comp_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_comp = (String)comp_combo.getSelectedItem();
				if(!isCompetitionSuitableToAnimal(selected_comp,selected_animal)) {
					JOptionPane.showMessageDialog(null,"The competition type is not\nsuitable for the animal you selected", "Error Message",JOptionPane.ERROR_MESSAGE);
					
					
				}
				showAnimalDetails(panel,window,selected_comp);
				pack();
				
			}
		});

		add = new JButton("Add Animal");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a != null) {
 
					dispose();
				}
			}
		});
	
		
		this.add(new JLabel("Select an animal"));
		this.add(animal_combo);
		this.add(new JLabel("Select competition type:"));
		this.add(comp_combo);
		this.add(panel);
		this.add(add);
		
		this.pack();
		this.setSize(300,150);
		this.setLocationRelativeTo(window);
	}
	
	
	/**
     * Checks if the selected competition type is suitable for the selected animal.
     * 
     * @param comp   The competition type.
     * @param animal The animal type.
     * @return True if the competition type is suitable for the animal, otherwise false.
     */
	private boolean isCompetitionSuitableToAnimal(String comp, String animal) {
		switch(comp) {
		case "Air":
			return animal.equals("Eagle") || animal.equals("Pigoen");
		case "Water":
			return animal.equals("Alligator") || animal.equals("Whale") || animal.equals("Dolphin");
		case "Terrestrial":
			return animal.equals("Dog") || animal.equals("Cat") || animal.equals("Snake");
		default:
			return false;
		}
	}
	
	
	/**
     * Fills the details of the selected animal and creates an instance of the animal.
     * 
     * @param main_window The main CompetitionFrame window.
     * @param animal      The selected animal type.
     * @param p           The JPanel to display the details.
     * @return The created Animal instance.
     */
	private Animal fillAnimalDetails(CompetitionFrame main_window,String animal, JPanel p) {
		Animal a = null;
		switch(animal) {
		case "Eagle":
			a = new Eagle(this.getName(), this.getSpeed(),this.getEnergyPerMeter(),this.selected_comp, this.selected_track);
			break;
		case "Pigoen":
			a = new Pigeon(this.getName(),this.getSpeed(),this.getEnergyPerMeter(),this.selected_comp, this.selected_track);
			break;
		case "Alligator":
			a = new Alligator(this.getName(),this.getSpeed(),this.getEnergyPerMeter(),this.selected_comp,this.selected_track);
			break;
		case "Whale":
			a = new Whale(this.getName(),this.getSpeed(),this.getEnergyPerMeter(),this.selected_comp, this.selected_track);
			break;
		case "Dolphin":
			a = new Dolphin(this.getName(),this.getSpeed(),this.getEnergyPerMeter(),this.selected_comp, this.selected_track);
			break;
		case "Dog":
			a = new Dog(this.getName(),this.getSpeed(),this.getEnergyPerMeter());
			break;
		case "Cat":
			a = new Cat(this.getName(),this.getSpeed(),this.getEnergyPerMeter());
			break;
		case "Snake":
			a = new Snake(this.getName(),this.getSpeed(),this.getEnergyPerMeter());
			break;
		default:
			break;
		}
		return a;
	}
	

	
	/**
     * Displays the track selection based on the selected competition type.
     * 
     * @param p The JPanel to display the track selection.
     */
	private void showTrackSelection(JPanel p) {
		track_combo = new JComboBox<>();
		switch (selected_comp) {  
        case "Water":
            for (String track : water_tracks) {
                track_combo.addItem(track);
                
            }
            break;
        case "Air":
            for (String track : air_tracks) {
                track_combo.addItem(track);
            }
            break;
		}
		
		p.add(new Label("Select track:"));
		p.add(track_combo);
		panel.revalidate();
        panel.repaint();
		
	}
	
	
	/**
     * Displays the details input fields for the selected animal.
     * 
     * @param p              The JPanel to display the details input fields.
     * @param father_window  The parent CompetitionFrame window.
     * @param selected_comp  The selected competition type.
     */
	private void showAnimalDetails(JPanel p,CompetitionFrame father_window, String selected_comp) {
		panel.removeAll();
		JButton ok = new JButton("OK");
		JTextField name = new JTextField(10);
		JTextField speed = new JTextField(10);
		JTextField energy = new JTextField(10);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					animal_name = name.getText().trim();
					animal_speed = Integer.parseInt(speed.getText().trim());
					energy_meter = Integer.parseInt(energy.getText().trim());
					selected_track = (String) track_combo.getSelectedItem();
					
					if (animal_name.isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty");
					}
					
				    a = fillAnimalDetails(father_window, selected_animal,p);
					
				}catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
		});
		p.add(new Label("Animal name:"));
		p.add(name);
		p.add(new Label("Animal speed:"));
		p.add(speed);
		p.add(new Label("Energy per meter:"));
		p.add(energy);
		showTrackSelection(p); 
		p.add(ok);
		
		p.revalidate();
	    p.repaint();
	}
	
	
	
	public void fillArray(Animal[][] a, int row, int col) {
		System.out.println("add: " + row + "," + col);
		a[row][col] = this.getAnimal();
	}

	/**
     * Retrieves the name of the animal.
     * 
     * @return The animal's name.
     */
	public String getName() {
		return animal_name;
	}
	
	
	/**
     * Retrieves the selected competition type.
     * 
     * @return The selected competition type.
     */
	public String getComp() {
		return this.selected_comp;
	}
	
	
	/**
     * Retrieves the selected animal type.
     * 
     * @return The selected animal type.
     */
	public String getAnimalType() {
		return this.selected_animal;
	}
	
	
	/**
     * Retrieves the speed of the animal.
     * 
     * @return The animal's speed.
     */
	public int getSpeed() {
		return this.animal_speed;
	}
	
	
	/**
     * Retrieves the energy per meter of the animal.
     * 
     * @return The animal's energy per meter.
     */
	public int getEnergyPerMeter() {
		return this.energy_meter;
	}
	
	
	/**
     * Retrieves the created Animal instance.
     * 
     * @return The created Animal instance.
     */
	protected Animal getAnimal() {
		return this.a;
	}
	
	
	/**
     * Sets the name of the animal.
     * 
     * @param n The animal's name.
     */
	public void setName(String n) {
		this.animal_name = n;
	}
	
	public String getTrack() {
		return this.selected_track;
	}


}
