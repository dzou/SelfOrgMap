package som;

import java.awt.Color;
import java.util.*;

/* Pixel refers to a node in the SOM. Each pixel/node has
 * three values: red, blue, and green. These are used to
 * determine the pixel's color.
 */

public class Pixel {
	public int red, blue, green;
	public Color color;
	public int row, col;
	private int colorCode;
	
	public Pixel(int row, int col, int red, int blue, int green) {
		this.red = red;
		this.blue = blue;
		this.green = green;
		color = new Color(red, blue, green);
		colorCode = color.getRGB();
	}
	
	public Pixel(Color c) {
		color = c;
		red = c.getRed();
		blue = c.getBlue();
		green = c.getGreen();
		colorCode = color.getRGB();
	}
	
	public Pixel(Color c, int row, int col) {
		color = c;
		red = c.getRed();
		blue = c.getBlue();
		green = c.getGreen();
		colorCode = color.getRGB();
		this.row = row;
		this.col = col;
	}
	
	public Pixel(int row, int col) {
		red = (int)(256 * Math.random());
		blue = (int)(256 * Math.random());
		green = (int)(256 * Math.random());
		color = new Color(red, blue, green);
		this.row = row;
		this.col = col;
		colorCode = color.getRGB();
	}
	
	public void updateColor(int r, int b, int g) {
		red = r;
		blue = b;
		green = g;
		color = new Color(red, blue, green);
		colorCode = color.getRGB();
	}
	
	public int getColorCode() {
		return colorCode;
	}
}
