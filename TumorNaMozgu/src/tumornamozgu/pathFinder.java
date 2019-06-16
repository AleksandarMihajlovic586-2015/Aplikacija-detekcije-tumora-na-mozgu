package tumornamozgu;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class pathFinder {
	
	String path;
	
	public pathFinder() {

	JButton open = new JButton();
	JFileChooser file = new JFileChooser();
	file.setCurrentDirectory(new java.io.File("."));
	file.setDialogTitle("Izaberi datoteku");
	
    if(file.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
    }
    path = file.getSelectedFile().getAbsolutePath();
	
     }
}
