package som;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		OrganizingMap o = new OrganizingMap(500, 500);
		Pixel p1 = new Pixel(0,0);
		Pixel p2 = new Pixel(0, 19);
		System.out.println(o.close(p1, p2));
	}

}
