package xpr.version1.tree;

// comand ::= DEF IDENTIFICADOR ATRIBUI expr PT_VIRG
public class DeclaraVariavel implements Comando {
	private String identificador;
	private Expressao expressao;
	
	public DeclaraVariavel(String id, Expressao e) {
		this.identificador = id;
		this.expressao = e;
	}
	
}
