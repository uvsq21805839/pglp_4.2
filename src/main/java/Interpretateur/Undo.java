
package Interpretateur;

import java.util.Stack;

/*
 * @Diawara
 */

public class Undo implements InterGeneric {

	private Stack<Stack<Double>> undo;
	
	private Stack<Double> pile;
	
	public Undo(final Stack<Double> pileOperandes) {
		pile = pileOperandes;
		undo = new Stack<Stack<Double>>();
	}
	
	public void alertChange() {
		@SuppressWarnings("unchecked")
		Stack<Double> s = (Stack<Double>) pile.clone();
		undo.push(s);
	}
	
	private void copyLastStack() {
		for (double d : undo.lastElement()) {
			pile.push(d);
		}
	}
	
	public void apply() {
		while (!pile.isEmpty()) {
			pile.pop();
		}
		
		undo.pop();
		copyLastStack();
	}
}
