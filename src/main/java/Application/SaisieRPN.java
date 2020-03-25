package Application;

import java.util.Scanner;
import java.util.Stack;

import Application.Interprete.Interpreteur;
import Interpretateur.Undo;
 

public class SaisieRPN {
 
	private MoteurRPN moteur;
	
	private Interpreteur interprete;
	 
	private Stack<Double> pile;
	 
	private Scanner s;
	 
	public SaisieRPN() {
		pile = new Stack<Double>();
		Undo u = new Undo(pile);
		u.alertChange();
		moteur = MoteurRPN.init(pile, u);
		interprete = Interpreteur.init(u);
	}
	
	public double calcul() throws Exception {
		s = new Scanner(System.in);
		double d;
		boolean continuer = true;
		String line = "";
		
		System.out.print("Bienvenue sur ma calculatrice RPN by Diawara  : \n \n"
		+"              Mode d'utilisation : \n"		
		+"-Exemple: l’expression « 2 × (3 + 4) »  s’écrira « 234 + × »\n"
		+ "-Cette calculatrice supporter les opérations de base (+, -, *, /) sur des nombres entiers\n"
		+ "-Chaque saisie se terminer par la touche entrée\n"
		+ "- \"undo\" pour annuler la saisie précédente\n"
		+ "- \"exit\" pour sortir(quitter).\n>"
		
				);
		while (continuer) {
			try {  
				d = s.nextDouble();
				moteur.addOperande(d);
			} catch (java.util.InputMismatchException e) {
				line = s.nextLine();
				try {  
					moteur.executeCommand(line);
				} catch (Exception m) {
					try {
						 
						interprete.executeCommand(line);
					} catch (Exception i) {
						System.err.println(
						"Commande non autorisée/"
						+ "reconnue");
					}
				}
			}
			if (line.equalsIgnoreCase("quit")) {
				continuer = false;
			} else {
				System.out.print(
				"\nExpression : " + pile + "\n>");
				 
			}
		}
		s.close();
		 
	
		 
		System.out.println("resultat : " + pile);
		return pile.pop();
	}
}
