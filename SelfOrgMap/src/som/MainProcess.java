package som;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class MainProcess implements Runnable {
	public void run() {
		/* Create the GUI. */
		JFrame frame = new JFrame();
		Screen screen = new Screen(); // Screen does all of the work
		
		frame.add(screen);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
