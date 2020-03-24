package Interpretateur;

/*
 * @Diawara
 */

public class Quit implements InterGeneric {
	/**
	 * constructeur de la classe.
	 */
	public Quit() {
	}
	/**
	 * affiche que l'utilisateur a quitté l appli.
	 */
	public void apply() {
		System.out.println("Vous avez quitté");
	}

}
