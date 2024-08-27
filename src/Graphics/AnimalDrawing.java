package Graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Animals.Animal;
import Mobility.Point;

public class AnimalDrawing implements Runnable{
	private ArrayList<Animal> animals;
	private CompetitionPanel panel;
	
	public AnimalDrawing(ArrayList<Animal> animals, CompetitionPanel p ) {
		this.animals = new ArrayList<>(animals);
		this.panel = p;
	}
	
	public void run() {
		while(true) {
			synchronized(animals) {
				for(Animal animal: animals) {
					synchronized(animal) {
						
						Point current_location = animal.getLoc();
						
						drawAnimal(animal, current_location);
					}
				}
			}
			
			//this.panel.getImage().repaint();
			
			try {
				Thread.sleep(50);
			}catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
	
	private void drawAnimal(Animal a, Point loc) {
		Graphics g = panel.getGraphics();
		if(g != null) {
			//this.panel.getImage().setCurrentLoc(loc);
			a.drawObject(g);
		}
	}

}
