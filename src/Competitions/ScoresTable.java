package Competitions;

import java.awt.BorderLayout;
import java.util.Date;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * Displays a table of competition scores in a dialog window.
 * The table shows the names of animals and their finish times.
 */
public class ScoresTable {
	private JTable table;
	private DefaultTableModel model;
	
	
	/**
     * Constructs a `ScoresTable` instance and displays the scores in a dialog.
     *
     * @param window the parent JFrame to center the dialog on
     * @param scores_map a map of animal names to their finish times
     */
	public ScoresTable(JFrame window, Map<String,Date> scores_map) {
		String[] columns_names = { "Animal name", "Finish time"};
		model = new DefaultTableModel(columns_names,0);
		table = new JTable(model);
		
		for(Map.Entry<String,Date> entry :scores_map.entrySet()){
			String key = entry.getKey();
			Date finish_time = entry.getValue();
			model.addRow(new Object[] {key,finish_time});
		}
		
		System.out.println("Animal Name\tFinish Time");
        for (Map.Entry<String, Date> entry : scores_map.entrySet()) {
            String name = entry.getKey();
            Date finishTime = entry.getValue();
            System.out.println(name + "\t" + finishTime);
        }
		
		
		JDialog dialog = new JDialog(window, "Competitions Scores", true);
		dialog.setSize(400,300);
		dialog.setLocationRelativeTo(window);

		JScrollPane scrollPane = new JScrollPane(table);
		dialog.add(scrollPane, BorderLayout.CENTER);
		
		dialog.setVisible(true);
	}
		


}
