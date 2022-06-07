package xpr.version1.tree;

// comand ::= expr PT_VIRG 
public class AvaliaExpressao implements Comando {
	private Expressao expressao;
	
	public AvaliaExpressao(Expressao e) {
		this.expressao = e;
	}
	
	public Expressao getExpressao() {
		return this.expressao;
	}
}
