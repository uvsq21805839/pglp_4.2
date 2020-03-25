package Operateur;

public class Division implements Calcule {

	public double apply(double operande1, double operande2) throws Exception {
		// TODO Auto-generated method stub
		if (operande2 == 0) {
			System.err.println("Division par 0 non autorisée");
			throw new Exception();
		}
		return operande1 / operande2;
	}
}