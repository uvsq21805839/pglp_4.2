package pglp_4;

import static org.junit.Assert.*;

import org.junit.Test;

import Operateur.Multiplication;



public class MultiplicationTest {

	@Test
	public void test() {
		Multiplication x = new Multiplication();
		assertTrue(x.apply(2.0, 2.0) == 4.0);
	}
}
