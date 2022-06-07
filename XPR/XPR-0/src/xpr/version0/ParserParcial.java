package xpr.version0;

import java.io.InputStream;

import xpr.util.CompilerException;


/**
 * Esta classe faz o reconhecimento sintático (parsing) da linguagem XPR
 * para representar expressões algébricas simples. Este parser apenas testa
 * se a entrada está sintaticamente correta.
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
	 * Metodo principal, a partir do qual é feito reconhecimento
	 * de um código fonte em XPR.
	 */
	public String parse(InputStream input) throws CompilerException {

		// reinicia o lexer e lê o primeiro token
		lexer.reset(input);
		currentToken = lexer.nextToken();
		
		// tenta reconhecer algo que case com o símbolo "program",
		// que eh o símbolo inicial da gramática
		//TODO
		
		// se nao der exceção antes de chegar aqui, então o programa
		// está sintaticamente correto
		return "Sintaxe OK";
	}

	///////////////////////////////////////////////////////////
	//////////// METODOS PARA MANIPULAR OS TOKENS /////////////

	/**
	 * Apenas aceita o token (avança para o próximo). 
	 */
	private void acceptToken() throws CompilerException {
		currentToken = lexer.nextToken();		
	}

	/**
	 * Verifica se o token é do tipo esperado. Se for, aceita (avança para o próximo). 
	 * Se não for, lança exceção.
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
	//////////// METODOS PARA OS NÃO-TERMINAIS ////////////////
	
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