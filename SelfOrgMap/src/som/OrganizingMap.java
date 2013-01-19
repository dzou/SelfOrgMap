package som;

import java.awt.Color;
import java.util.*;

public class OrganizingMap {
	private Pixel[][] array;
	private final int radius = 200; 		// squared distance
	private final double learningRate = 0.3;
	
	public OrganizingMap(int x, int y) {
		array = new Pixel[x][y];
		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[r].length; c++) {
				array[r][c] = new Pixel(r, c);
			}
		}
	}
	
	public OrganizingMap(Color color, int x, int y) {
		array = new Pixel[x][y];
		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[r].length; c++) {
				array[r][c] = new Pixel(color, r, c);
			}
		}
	}
	
	public Pixel findClosestMatch(Pixel input) {
		int minDist = -1;
		Pixel minPix = null;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				Pixel current = array[i][j];
				int dist = getDist(input, current);
				if (minPix == null || dist < minDist) {
					minDist = dist;
					minPix = current;
				}
			}
		}
		
		return minPix;
	}
	
	public Set<Pixel> getNearbyPixels(Pixel input) {
		HashSet<Pixel> set = new HashSet<Pixel>();
		int inputRow = input.row;
		int inputCol = input.col;
		int trueRadius = (int)(Math.sqrt(radius) + 0.5);
		
		for (int i = inputRow - trueRadius; i < inputRow + trueRadius; i++) {
			
			if (i > array.length - 1 || i < 0)
				continue;
			
			for (int j = inputCol - trueRadius; j < inputCol + trueRadius; j++) {
				
				if (j > array[i].length - 1 || j < 0)
					continue;
				
				if (close(input, array[i][j]))
					set.add(array[i][j]);
			}
		}
		
		return set;
	}
	
	public void setWeights(Pixel input, Set<Pixel> s) {
		
		int inputRed = input.red;
		int inputBlue = input.blue;
		int inputGreen = input.green;
		
		Iterator<Pixel> iter = s.iterator();
		while (iter.hasNext()) {
			Pixel current = iter.next();
			int currentRed = current.red;
			int currentBlue = current.blue;
			int currentGreen = current.green;
			
			currentRed = currentRed + (int)(learningRate * (inputRed - currentRed));
			currentBlue = currentBlue + (int)(learningRate * (inputBlue - currentBlue));
			currentGreen = currentGreen + (int)(learningRate * (inputGreen - currentGreen));
			
			current.updateColor(currentRed, currentBlue, currentGreen);
		}
	}
	
	public boolean close(Pixel p1, Pixel p2) {
		int dist = (p1.row - p2.row) * (p1.row - p2.row) 
				+ (p1.col - p2.col) * (p1.col - p2.col);
		if (dist < radius)
			return true;
		else
			return false;
	}
	
	public int getDist(Pixel p1, Pixel p2) {
		return (int)(Math.pow(p1.red - p2.red, 2) + Math.pow(p1.blue - p2.blue, 2) 
		+ Math.pow(p1.green - p2.green, 2));
	}
	
	public Pixel[][] getMap() {
		return array;
	}
	
	public int getRow() {
		return array.length;
	}
	
	public int getCol() {
		return array[0].length;
	}
}
