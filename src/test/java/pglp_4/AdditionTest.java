package pglp_4;

import static org.junit.Assert.*;

import org.junit.Test;

import Operateur.Addition;



public class AdditionTest {
	@Test
	public void test() {
		Addition x = new Addition();
		assertTrue(x.apply(5.0, 5.0) == 11.0);
	}
}
