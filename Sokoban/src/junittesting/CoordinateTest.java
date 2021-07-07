package junittesting;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sokoban.Coordinates;

class CoordinateTest {
	
	@Test
	void testGetX() {
		Coordinates x = new Coordinates();
		x.setX(1);
		int a = x.getX();
		assertEquals(a,1);
		
	}
	
	@Test
	void testGetY() {
		Coordinates y = new Coordinates();
		y.setY(2);
		int a = y.getY();
		assertEquals(2,a);
	}
}


