package xpr.version0;

import java.io.ByteArrayInputStream;

import xpr.CompilerException;
import xpr.general.Token;
import xpr.general.TokenType;
import xpr.general.XprParser;


/**
 * Esta classe faz o reconhecimento sint�tico (parsing) da linguagem XPR
 * para representar express�es alg�bricas simples. Esta classe � o esqueleto
 * da classe "Parser", que tamb�m calcula o valor da express�o.
 * 
 * @author Pablo Sampaio
 */
public class ParserAlfa implements XprParser {
	private Lexer lexer;
	private Token currentToken;
	
	private StringBuilder output;
	
	public ParserAlfa() {
		lexer = new Lexer();
	}
	
	/**
	 * Metodo principal, a partir do qual � feito reconhecimento
	 * de um dado c�digo fonte em XPR.
	 */
	public String parse(String fonte) throws CompilerException {
		output = new StringBuilder();

		// reinicia o lexer e l� o primeiro token
		lexer.reset(new ByteArrayInputStream(fonte.getBytes()));
		currentToken = lexer.nextToken();
		
		// tenta reconhecer algo que case com o s�mbolo "program",
		// que eh o s�mbolo inicial da gram�tica
		parseProgram();
		acceptToken(TokenType.EOF);
		
		// se nao der exce��o antes de chegar aqui, ent�o o programa
		// est� sintaticamente correto
		output.append("Sintaxe OK!");
		
		return output.toString();
	}

	///////////////////////////////////////////////////////////
	//////////// FUNCOES PARA MANIPULAR OS TOKENS /////////////

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
	///////////// METODOS DERIVADOS DA GRAMATICA //////////////
	
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
	
	/////////////////////////////////////////////////////////////

	/**
	 * Este metodo executa um pequeno teste de reconhecimento.  
	 */
	public static void main(String[] args) throws Exception {
		ParserAlfa parser = new ParserAlfa();
		
		String teste = "2+4*5;";
		
		System.out.println(" == TESTE DO PARSER ==");
		System.out.println(" Texto fonte a ser reconhecido: \"" + teste + "\"");
		
		String msg = parser.parse( teste);
		
		System.out.println(" " + msg);
		
		System.out.println(" == FIM ==");
	}
	
}