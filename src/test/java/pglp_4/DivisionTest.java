package pglp_4;

import static org.junit.Assert.*;

import org.junit.Test;

import Operateur.Division;



public class DivisionTest {

	@Test (expected = Exception.class)
	public void testEchec() throws Exception {
		Division a = new Division();
		a.apply(1.0, 0.0);
	}
	@Test
	public void test() throws Exception {
		Division x = new Division();
		assertTrue(x.apply(15.0, 5.0) == 3.0);
	}
}
