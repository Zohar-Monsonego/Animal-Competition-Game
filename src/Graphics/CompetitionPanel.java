package Graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;

import Animals.Animal;
import Animals.Orientation;
import Competitions.Scores;
import Competitions.ScoresTable;
import Competitions.TournamentThread;
import Mobility.Location;
import Mobility.Point;


/**
 * CompetitionPanel class represents the main panel for the competition,
 * including the background image and the control buttons.
 */
public class CompetitionPanel extends JPanel{
	
	private class ImagePanel extends JPanel{
		
		/**
	     * Inner class ImagePanel represents the panel where the background image
	     * and animals are drawn.
	     */
		private BufferedImage back_img = null;
		private ArrayList<Animal> animals = new ArrayList<>();
		
		
		/**
         * Constructor for ImagePanel, initializes the background image.
         */
		public ImagePanel() {
			try {
				back_img = ImageIO.read(getClass().getResource(BACKGROUND_PATH)); 
			} catch (IOException e) {
				System.out.println("Cannot load image");
			}
			
			
		}
		
		public List<Animal> getAnimals(){
			return this.animals;
		}
		
	
		/**
         * Adds an animal to the panel and starts its movement.
         * 
         * @param a The animal to add.
         */
		public void addAnimal(Animal a) {
			synchronized(animals) {
				animals.add(a);
				repaint();
			}
		}
		
		/**
         * Removes an animal from the panel.
         * 
         * @param a The animal to remove.
         */
		public void removeAnimal(Animal a) {
			animals.remove(a);
			repaint();
		}
		
		/**
         * Paints the component, including the background image and all animals.
         * 
         * @param g The graphics context to use for painting.
         */
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(back_img != null) {
				g.drawImage(back_img,0,0,getWidth(),getHeight(), this);
			}
		    synchronized(animals) {
		    	for(Animal animal : animals) {
					if(animal !=null & !animals.isEmpty()) {
						animal.drawObject(g);
					}
					else {
						System.out.print("couldnt draw animal");
					}
					
				}
			
			}
		}
		
	}
	
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	
	private CompetitionFrame father_window;
	private JPanel table_panel;
	private ArrayList<Animal> displayed_animals = new ArrayList<>();
    private static final String BACKGROUND_PATH = "/Images/competitionBackground.png";
    private ImagePanel image;
    private CalculateDestination des = new CalculateDestination();
    private Scores scores;
	
    
    /**
     * Constructor for CompetitionPanel, initializes the panel with buttons
     * and the background image panel.
     * 
     * @param father_window The parent frame for the competition panel.
     */
	public CompetitionPanel(CompetitionFrame father_window) {
		super(new BorderLayout());
		this.father_window = father_window;
		this.setLayout(new BorderLayout());
		
		
		image = new ImagePanel();
		this.add(image, BorderLayout.CENTER);
		
		/*Thread a_d = new Thread(new AnimalDrawing(animals,this));
		a_d.start();*/
		
        JPanel bottom_panel = new JPanel();
        bottom_panel.setLayout(new GridLayout(1,7,10,10));
		
		button1 = new JButton("Add Competition");
		button2 = new JButton("Add Animal");
		button3 = new JButton("Clear");
		button4 = new JButton("Eat");
		button5 = new JButton("Info");
		button6 = new JButton("Scores");
		button7 = new JButton("Exit");
		
		bottom_panel.add(button1);
		bottom_panel.add(button2);
		bottom_panel.add(button3);
		bottom_panel.add(button4);
		bottom_panel.add(button5);
		bottom_panel.add(button6);
		bottom_panel.add(button7);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompetitionDialog c = new AddCompetitionDialog(father_window);
				c.setVisible(true);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAnimalDialog animal_d = new AddAnimalDialog(father_window);
				//animal_d.setVisible(true);
				
				animal_d.addWindowListener((WindowListener) new WindowAdapter() {
					public void WindowClosed(WindowEvent e) {
						Animal new_animal = animal_d.getAnimal();
						if(new_animal != null) {
							System.out.println(new_animal);
							addAnimal(new_animal);
						}
					}
				});
		        animal_d.setVisible(true);
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean deleted = deleteAnimal();
				if(deleted) {
					JOptionPane.showMessageDialog(null, "Animal deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No animal was deleted.");
                }
			}
		});
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean succeed = eatAnimal();
				if(succeed) {
					JOptionPane.showMessageDialog(null, "Energy added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No energy was added.");
                }
			}
		});
		
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalTableDialog table = new AnimalTableDialog(father_window, getDisplayedAnimals());
				table.setVisible(true);
			}
		});
		
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scores s = new Scores();
				Map<String,Date> scores_map = s.getAll();
				
				ScoresTable s_table = new ScoresTable(father_window,scores_map);
				
			}
		});
		
		
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);
		
		this.add(bottom_panel, BorderLayout.SOUTH);
	}
	
	
	/**
     * Adds an animal to the competition panel.
     * 
     * @param a The animal to add.
     */
	public void addAnimal(Animal a) {
		image.addAnimal(a);
		displayed_animals.add(a);
		repaint();
		
	}

	
	
	/**
     * Removes an animal from the competition panel.
     * 
     * @param a The animal to remove.
     */
	public void removeAnimal(Animal a) {
		
		displayed_animals.remove(a);
		image.repaint();
	}
	
	
	/**
     * Deletes an animal selected by the user from the competition.
     * 
     * @return true if the animal was deleted, false otherwise.
     */
	protected boolean deleteAnimal() {
		if(this.displayed_animals.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No animals to delete");
			return false;
		}
		
		String[] animals_names = new String[this.displayed_animals.size()];
		for(int i=0; i<this.displayed_animals.size();i+=1) {
			animals_names[i] = displayed_animals.get(i).getName();
		}
		
		String selected_animal = (String) JOptionPane.showInputDialog(this,"Select animal to delete:", "Delete animal",JOptionPane.PLAIN_MESSAGE,null,animals_names,animals_names[0]);
		if(selected_animal != null) {
			Animal animal_to_delete = null;
			for(Animal animal: this.displayed_animals) {
				if(animal.getAnimalName().equals(selected_animal)) {
					animal_to_delete = animal;
					break;
				}
			}
			if(animal_to_delete != null) {
				this.removeAnimal(animal_to_delete);
				return true;
			}
		}
		return false;
	}
	
	
	 /**
     * Feeds an animal selected by the user with a specified amount of energy.
     * 
     * @return true if the energy was successfully added, false otherwise.
     */
	protected boolean eatAnimal() {
		if(image.getAnimals().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No animals to feed");
			return false;
		}
		
		String[] animals_names = new String[image.getAnimals().size()];
		for(int i=0; i<image.getAnimals().size();i+=1) {
			animals_names[i] = image.getAnimals().get(i).getName();
		}
		
		String selected_animal = (String) JOptionPane.showInputDialog(this,"Select animal to feed:", "Feed animal",JOptionPane.PLAIN_MESSAGE,null,animals_names,animals_names[0]);
		if(selected_animal != null) {
			Animal animal_to_feed = null;
			for(Animal animal: image.getAnimals()) {
				if(animal.getAnimalName().equals(selected_animal)) {
					animal_to_feed = animal;
					break;
				}
			}
			if(animal_to_feed != null) {
				String energy_input = JOptionPane.showInputDialog(this,"Enter the amount of energy to add:","Add Energy",JOptionPane.PLAIN_MESSAGE);
				try {
					int energy_amount = Integer.parseInt(energy_input);
					boolean success = animal_to_feed.eat(energy_amount);
					if(success) {
						 JOptionPane.showMessageDialog(this,"Energy added successfully!","Success",JOptionPane.INFORMATION_MESSAGE); 
						 return true;
					}else {
						JOptionPane.showMessageDialog(this,"Failed to add energy. The maximum energy limit may be reached.","Error",JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,"Invalid energy amount. Please enter a valid integer.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		return false;
	}
	
	
	/**
     * Starts the movement of an animal towards its destination.
     * 
     * @param a The animal to move.
     * @param destination The destination point of the animal
     */
	public void startMovingAnimal(Animal a, Point destination) {
		//Point destination = des.calcDestination(a, a.getTrack());
		System.out.println("des: " + destination);
		Point current_location = a.getLoc();
		int energy_per_meter = a.getEnergyPerMeter();
		int current_energy = a.getCurrentEnergy();
		
		while(!current_location.equals(destination) && current_energy > 0) {
			int step_distance = a.getSpeed();
            int dx = destination.getX() - current_location.getX();
            int dy = destination.getY() - current_location.getY();
            
            int step_x = (int) (step_distance * Math.signum(dx));
            int step_y = (int) (step_distance * Math.signum(dy));
            
            if (Math.abs(step_x) > Math.abs(dx)) step_x = dx;
            if (Math.abs(step_y) > Math.abs(dy)) step_y = dy;

            Point next_step = new Point(current_location.getX() + step_x, current_location.getY() + step_y);
            
           
			double distance_moved = a.move(next_step);
			a.setCurrrentEnergy((int)(a.getCurrentEnergy() - (distance_moved / energy_per_meter)));
			a.setTotalDistance(distance_moved);
			
			image.revalidate();
			image.repaint();
			
			try {
				Thread.sleep(1000/ a.getSpeed());
			}catch(InterruptedException e) {
	            System.out.println("Thread interrupted from sleeping -> AnimalThread");
	            break;
	        }
			
			//System.out.println("Animal stopped because of lack of energy or reached the destination");
		}
		System.out.println("Animal stopped because of lack of energy or reached the destination");
		
	}
	
	
	 /**
     * Retrieves the list of animals in the competition.
     * 
     * @return The list of animals.
     */
	/*public List<Animal> getAnimals(){
		return this.animals;
	}*/
	
	public List<Animal> getDisplayedAnimals(){
		return this.displayed_animals;
	}
	
	public ImagePanel getImage() {
		return this.image;
	}
	public void setScores(Scores s) {
		this.scores = s;
	}
	

}
