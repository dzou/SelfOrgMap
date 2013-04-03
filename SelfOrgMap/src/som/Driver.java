package som;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/* This class just runs the MainProcess. Ensure that
 * GUI is run on the EDT.
 */
public class Driver {
	public static void main(String[] args) {
		EventQueue.invokeLater(new MainProcess());
	}
}
