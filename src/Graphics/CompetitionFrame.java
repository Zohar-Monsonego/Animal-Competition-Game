package Graphics;

import java.awt.image.BufferedImage;
import Animals.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Mobility.Point;


/**
 * CompetitionFrame is the main frame for the competition application. 
 * It includes a menu with options for File and Help, and a competition panel.
 */
public class CompetitionFrame extends JFrame {
	private CompetitionPanel p;
	
	
	/**
     * Constructs a new CompetitionFrame.
     */
	public CompetitionFrame() {
		super("Competition");
		
		setLayout(new BorderLayout()); // helps to manage the windom with areas: north, south...
		
		JButton file_button = new JButton("File");
		JButton help_button = new JButton("Help");
		
		JPanel menu_panel = new JPanel();
		menu_panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		
		JButton exit_b = new JButton("Exit");
		JButton help_b = new JButton("Help");
		exit_b.setVisible(false);//hide this button until the user clicks on: File
		help_b.setVisible(false);//hide this button until the user clicks on: Help
		
		JPanel bottom_1 = new JPanel();
		bottom_1.setLayout(new BoxLayout(bottom_1, BoxLayout.Y_AXIS));
		bottom_1.add(file_button);
		bottom_1.add(exit_b);
		
		JPanel bottom_2 = new JPanel();
		bottom_2.setLayout(new BoxLayout(bottom_2, BoxLayout.Y_AXIS));
		bottom_2.add(help_button);
		bottom_2.add(help_b);
		
		menu_panel.add(bottom_1);
		menu_panel.add(bottom_2);
		
		file_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit_b.setVisible(true);
				menu_panel.revalidate();
				menu_panel.repaint();
			}
		});
		
		exit_b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		help_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help_b.setVisible(true);
				menu_panel.revalidate();
				menu_panel.repaint();
			}
		});
		
		help_b.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Home Work 2\nGUI", "Message",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		p = new CompetitionPanel(this);
		
		
		getContentPane().add(menu_panel, BorderLayout.NORTH);
		getContentPane().add(p,BorderLayout.CENTER);
		setSize(1400,900);
		setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
				
	}
	
	
	/**
     * Gets the CompetitionPanel associated with this frame.
     * 
     * @return the competition panel
     */
	public CompetitionPanel getP() {
		return this.p;
	}
	
	
	
	 /**
     * The main method to launch the competition application.
     * 
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		CompetitionFrame c = new CompetitionFrame();
		c.setVisible(true);
		
	}
	
	
	
}
