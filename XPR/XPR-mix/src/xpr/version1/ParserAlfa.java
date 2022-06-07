package xpr.version1;

import java.io.ByteArrayInputStream;

import xpr.CompilerException;
import xpr.general.Token;
import xpr.general.TokenType;
import xpr.general.XprLexer;
import xpr.general.XprParser;


/**
 * Esta classe faz o reconhecimento sintático (parsing) da linguagem XPR
 * para representar expressões algébricas simples. 
 * 
 * @author Pablo Sampaio
 */
public class ParserAlfa implements XprParser {
	private XprLexer lexer;
	private Token currentToken;
	
	private StringBuilder output;
	
	public ParserAlfa() {
	}

	/**
	 * Metodo principal, a partir do qual é feito reconhecimento
	 * de um dado código fonte em XPR.
	 */
	public String parse(String sourceCode) throws CompilerException {
		output = new StringBuilder();

		// reinicia o lexer e lê o primeiro token
		lexer = new LexerJ(new ByteArrayInputStream(sourceCode.getBytes()));
		acceptToken();
		
		// tenta reconhecer algo que case com o símbolo "program",
		// que eh o símbolo inicial da gramática
		parseProgram();
		
		// se nao der exceção antes de chegar aqui, então o programa
		// está sintaticamente correto
		output.append(" Sintaxe OK!");
		
		return output.toString();
	}

	///////////////////////////////////////////////////////////
	//////////// FUNCOES PARA MANIPULAR OS TOKENS /////////////

	private void acceptToken() throws CompilerException {
		try {
			currentToken = lexer.nextToken();
		} catch (Exception e) {
			throw new CompilerException("Erro inesperado: " + e.getMessage());
		}
	}

	private void acceptToken(TokenType tp) throws CompilerException {
		if (currentToken.getType() == tp) {
			acceptToken();

		} else {
			throw new CompilerException("Token inesperado: "
					        + "foi lido um \"" + currentToken.getType() 
					        + "\", quando o esperado era \"" + tp + "\".");
		}

	}
	
	///////////////////////////////////////////////////////////
	///////////// METODOS DERIVADOS DA GRAMATICA //////////////
	
	/**
	 *   <program> ::= <comand> ( <comand> )*
	 */
	private void parseProgram() throws CompilerException {
		do {
			parseComand();
		} while (currentToken.getType() != TokenType.EOF);
	}
	
	/**
	 *   <comand> ::= <definition> ";"
	 *              | <expr> ";"
	 */
	private void parseComand() throws CompilerException {
		
		if (currentToken.getType() == TokenType.DEF) {
			parseDefinition();
			acceptToken(TokenType.PT_VIRG);
		
		} else {
			parseExpr();
			acceptToken(TokenType.PT_VIRG);
		}
		
	}

	/**
	 *   <definition> ::= "def" IDENTIFICADOR "=" <expr>
	 */
	private String parseDefinition() throws CompilerException {
		
		// neste ponto, o token DEF ja foi reconhecido,
		// então o token atual pode ser aceito
		acceptToken();

		acceptToken(TokenType.IDENTIFICADOR);
		acceptToken(TokenType.ATRIBUI);
		
		parseExpr();
		
		return null;
	}
	
	/**
	 *   <expr> ::= <term> <restExpr>
	 */
	private int parseExpr() throws CompilerException {
		
		parseTerm();
		parseRestExpr();
		
		return -1;
	}

	/**
	 *   <restExpr> ::= "+" <term> <restExpr>
	 *                | "-" <term> <restExpr>
	 *                | --vazio--
	 */
	private int parseRestExpr() throws CompilerException {
		
		if (currentToken.getType() == TokenType.MAIS) {
			acceptToken();
			parseTerm();
			parseRestExpr();
		
		} else if (currentToken.getType() == TokenType.MENOS) {
			acceptToken();
			parseTerm();
			parseRestExpr();

		} else {
			/* faz nada */
		}

		return -1;
	}
	
	/**
	 *   <term> ::= <factor> <restTerm>
	 */
	private int parseTerm() throws CompilerException {
		
		parseFactor();
		parseRestTerm();
		
		return -1;
	}

	/**
	 *   <restTerm> ::= "*" <factor> <restTerm>
	 *                | "/" <factor> <restTerm>
	 *                | --vazio--
	 */
	private int parseRestTerm() throws CompilerException {
		
		if (currentToken.getType() == TokenType.VEZES) {
			acceptToken();
			parseFactor();
			parseRestTerm();
		
		} else if (currentToken.getType() == TokenType.DIVIDE) {
			acceptToken();
			parseFactor();
			parseRestTerm();
		
		} else {
			/* faz nada */
		}
		
		return -1;
	}

	/**
	 *   <factor> ::= NUMERO
	 *              | IDENTIFICADOR
	 *              | "(" <expr> ")"
	 */
	private int parseFactor() throws CompilerException {
		
		if (currentToken.getType() == TokenType.NUMERO) {
			acceptToken();
		
		} else if (currentToken.getType() == TokenType.IDENTIFICADOR) {
			acceptToken();

		} else if (currentToken.getType() == TokenType.ABRE_PAR) {
			acceptToken();
			parseExpr();
			acceptToken(TokenType.FECHA_PAR);

		} else {
			throw new CompilerException("Token inesperado: " + currentToken.getType() + ".");
		}

		return -1;
	}
	
	/////////////////////////////////////////////////////////////

	/**
	 * Este metodo executa um pequeno teste de reconhecimento.  
	 */
	public static void main(String[] args) throws Exception {
		ParserAlfa parser = new ParserAlfa();
		
		String teste = "def x = 22 -4*5 /2; def y = 5; x +y; x * 20; //comentario";
		
		System.out.println(" == TESTE DO PARSER ==");
		System.out.println(" Texto fonte a ser reconhecido: \"" + teste + "\"");
		
		String msg = parser.parse(teste);
		
		System.out.println(msg);
		
		System.out.println(" == FIM ==");
	}

}