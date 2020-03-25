package pglp_4;

import static org.junit.Assert.*;

import org.junit.Test;

import Operateur.Soustraction;



public class SoustractionTest {

	@Test
	public void test() {
		Soustraction x = new Soustraction();
		assertTrue(x.apply(1.0, 1.0) == 0.0);
	}
}
