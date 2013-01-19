package som;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Set;

import javax.swing.*;

public class Screen extends JPanel {
	
	private OrganizingMap map;
	
	public Screen() {
		map = new OrganizingMap(150, 150);
		addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
        		MyThread t = new MyThread();
        		t.start();
            }
        });
		
    }
	
	private class MyThread extends Thread {
		public void run() {
			for (int i = 0; i < 10000; i++) {
	    		Pixel input = new Pixel(0, 0);
	    		Pixel match = map.findClosestMatch(input);
	    		Set<Pixel> set = map.getNearbyPixels(match);
	    		map.setWeights(input, set);
	    		repaint();
	    		try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(map.getRow(), map.getCol());
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Pixel[][] array = map.getMap();
		BufferedImage image = new BufferedImage(array.length, 
				array[0].length, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				image.setRGB(i, j, array[i][j].getColorCode());
			}
		}
		g.drawImage(image, 0, 0, null);
	}
}
