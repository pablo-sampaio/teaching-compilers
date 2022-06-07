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
public class Parser {
	private Lexer lexer;
	private Token currentToken;
	
	public Parser() {
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
		parseProgram();
		acceptToken(TokenType.EOF);
		
		// se nao der exce��o antes de chegar aqui, ent�o o programa
		// est� sintaticamente correto
		return "Sintaxe OK";
	}

	///////////////////////////////////////////////////////////
	//////////// METODOS PARA MANIPULAR OS TOKENS /////////////

	private void acceptToken() throws CompilerException {
		currentToken = lexer.nextToken();		
	}

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
		parseComand();
	}
	
	/**
	 *   <comand> ::= <expr> ";"
	 */
	private void parseComand() throws CompilerException {
		parseExpr();
		acceptToken(TokenType.PT_VIRG);
	}
	
	/**
	 *   <expr> ::= <term> <restExpr>
	 */
	private void parseExpr() throws CompilerException {
		parseTerm();
		parseRestExpr();
	}

	/**
	 *   <restExpr> ::= "+" <term> <restExpr>
	 *                | --vazio--
	 */
	private void parseRestExpr() throws CompilerException {
		
		if (currentToken.getType() == TokenType.MAIS) {
			acceptToken();
			parseTerm();
			parseRestExpr();
		
		} else {
			/* faz nada */
		}
		
	}
	
	/**
	 *   <term> ::= <factor> <restTerm>
	 */
	private void parseTerm() throws CompilerException {
		parseFactor();
		parseRestTerm();
	}

	/**
	 *   <restTerm> ::= "*" <factor> <restTerm>
	 *                | --vazio--
	 */
	private void parseRestTerm() throws CompilerException {
		
		if (currentToken.getType() == TokenType.VEZES) {
			acceptToken();
			parseFactor();
			parseRestTerm();
		
		} else {
			/* faz nada */
		}
		
	}

	/**
	 *   <factor> ::= NUMERO
	 *              | "(" <expr> ")"
	 */
	private void parseFactor() throws CompilerException {

		if (currentToken.getType() == TokenType.NUMERO) {
			acceptToken();

		} else if (currentToken.getType() == TokenType.ABRE_PAR) {
			acceptToken();
			parseExpr();
			acceptToken(TokenType.FECHA_PAR);

		} else {
			throw new CompilerException("Token inesperado: " + currentToken.getType() + ".");
		}

	}
	
	
}