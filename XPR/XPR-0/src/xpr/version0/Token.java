package xpr.version0;


/**
 * Cada token � um par formado pelo lexema e a classifica��o dele.
 * 
 * @author Pablo Sampaio
 */
public class Token {
	private TokenType tipo;
	private String lexema;

	public Token(TokenType tipo) {
		this.tipo = tipo;
	}
	
	public Token(TokenType tipo, String lexema) {
		this.tipo = tipo;
		this.lexema = lexema;
	}
	
	public TokenType getType() {
		return tipo;
	}
	
	public String getLexeme() {
		return lexema;
	}
	
	public String toString() {
		if (lexema == null || lexema.length() == 0) {
			return "[" + tipo + "]";	
		} else {
			return "[" + tipo + "," + lexema + "]";
		}
	}

}

