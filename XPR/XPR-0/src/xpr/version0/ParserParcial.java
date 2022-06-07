package xpr.version0;

import java.io.InputStream;

import xpr.util.CompilerException;


/**
 * Esta classe faz o reconhecimento sint�tico (parsing) da linguagem XPR
 * para representar express�es alg�bricas simples. Este parser apenas testa
 * se a entrada est� sintaticamente correta.
 * 
 * @author Pablo Sampaio
 */
public class ParserParcial {
	private Lexer lexer;
	private Token currentToken;
	
	public ParserParcial() {
		lexer = new Lexer();
	}
	
	/**
	 * Metodo principal, a partir do qual � feito reconhecimento
	 * de um c�digo fonte em XPR.
	 */
	public String parse(InputStream input) throws CompilerException {

		// reinicia o lexer e l� o primeiro token
		lexer.reset(input);
		currentToken = lexer.nextToken();
		
		// tenta reconhecer algo que case com o s�mbolo "program",
		// que eh o s�mbolo inicial da gram�tica
		//TODO
		
		// se nao der exce��o antes de chegar aqui, ent�o o programa
		// est� sintaticamente correto
		return "Sintaxe OK";
	}

	///////////////////////////////////////////////////////////
	//////////// METODOS PARA MANIPULAR OS TOKENS /////////////

	/**
	 * Apenas aceita o token (avan�a para o pr�ximo). 
	 */
	private void acceptToken() throws CompilerException {
		currentToken = lexer.nextToken();		
	}

	/**
	 * Verifica se o token � do tipo esperado. Se for, aceita (avan�a para o pr�ximo). 
	 * Se n�o for, lan�a exce��o.
	 */
	private void acceptToken(TokenType tp) throws CompilerException {
		if (currentToken.getType() == tp) {
			currentToken = lexer.nextToken();

		} else {
			throw new CompilerException("Token inesperado: "
					        + "foi lido um \"" + currentToken.getType() 
					        + "\", quando o esperado era \"" + tp + "\".");
		}

	}
	
	///////////////////////////////////////////////////////////
	//////////// METODOS PARA OS N�O-TERMINAIS ////////////////
	
	/**
	 *   <program> ::= <comand>
	 */
	private void parseProgram() throws CompilerException {
		//TODO
	}
	
	/**
	 *   <comand> ::= <expr> ";"
	 */
	private void parseComand() throws CompilerException {
		//TODO
	}
	
	/**
	 *   <expr> ::= <term> <restExpr>
	 */

	/**
	 *   <restExpr> ::= "+" <term> <restExpr>
	 *                | --vazio--
	 */
	
	/**
	 *   <term> ::= <factor> <restTerm>
	 */

	/**
	 *   <restTerm> ::= "*" <factor> <restTerm>
	 *                | --vazio--
	 */

	/**
	 *   <factor> ::= NUMERO
	 *              | "(" <expr> ")"
	 */
	
	
}