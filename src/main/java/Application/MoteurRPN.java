package Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Interpretateur.Undo;
import Operateur.Addition;
import Operateur.Calcule;
import Operateur.Division;
import Operateur.Multiplication;
import Operateur.Soustraction;



public final class MoteurRPN {

	 
	private Map<String, Calcule> operations;
	 
	private Stack<Double> pile;
	 
	private Undo undo;
	 
	private MoteurRPN(final Stack<Double> pileOperandes, final Undo undoP) {
		operations = new HashMap<String, Calcule>();
		pile = pileOperandes;
		undo = undoP;
	}
	 
	public void addOperande(final double d) {
		pile.push(d);
		undo.alertChange();
	}
	 
	public void addCommand(final String name,
			final Calcule command) {
		this.operations.put(name, command);
	}
	 
	public boolean executeCommand(final String name) throws Exception {
		if (operations.containsKey(name)) {
			if (pile.size() < 2) {
				System.err.println("nbre d'opérandes "
						+ "dans l'expression invalide");
				return false;
			}
			double operande2 = pile.pop();
			double operande1 = pile.pop();
			try {
				pile.push(operations.get(name)
				.apply(operande1, operande2));
				undo.alertChange();
				return true;
			} catch (Exception e) {
				pile.push(operande1);
				pile.push(operande2);
				return false;
			}
		} else {
			 
			throw new Exception();
		}
	}
	 	public static MoteurRPN init(final Stack<Double> pile, final Undo u) {
		MoteurRPN x = new MoteurRPN(pile, u);
		x.addCommand("+", new Addition());
		x.addCommand("-", new Soustraction());
		x.addCommand("*", new Multiplication());
		x.addCommand("/", new Division());
		return x;
	}
}
