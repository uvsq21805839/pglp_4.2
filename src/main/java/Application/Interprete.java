package Application;

import java.util.HashMap;
import java.util.Map;

import Interpretateur.InterGeneric;
import Interpretateur.Quit;
import Interpretateur.Undo;


public class Interprete {

 
public final class Interpreteur {
	 
	private Map<String, InterGeneric> commands;
	 
	private Interpreteur() {
		commands = new HashMap<String, InterGeneric>();
	}
	
	public void addCommand(final String name,
	final InterGeneric command) {
		this.commands.put(name, command);
	}
	
	public void executeCommand(final String name) throws Exception {
		if (commands.containsKey(name)) {
			try {
				commands.get(name).apply();
			} catch (Exception e) {
				System.err.println("la commande n'existe pas");
			}
		} else {
			throw new Exception();
		}
	}
	
	public Interpreteur init(final Undo u) {
		Interpreteur i = new Interpreteur();
		i.addCommand("undo", u);
		i.addCommand("quit", new Quit());
		return i;
	}
}
}