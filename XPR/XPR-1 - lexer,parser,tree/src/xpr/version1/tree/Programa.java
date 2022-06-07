package xpr.version1.tree;

import java.util.LinkedList;

// program ::= (comand)*
public class Programa {
	private LinkedList<Comando> comandos;

	public Programa() {
		this.comandos = new LinkedList<Comando>();
	}
	
	public void addComando(Comando c) {
		this.comandos.addFirst(c);
	}
}
