package xpr.version0;

import java.io.ByteArrayInputStream;

import xpr.CompilerException;
import xpr.general.Token;
import xpr.general.TokenType;
import xpr.general.XprParser;


/**
 * Esta classe faz o reconhecimento sint�tico (parsing) da linguagem XPR
 * para representar express�es alg�bricas simples. Ela calcula o resultado
 * da express�o alg�brica � medida que faz o seu reconhecimento, 
 * funcionando como um interpretador.
 * 
 * @author Pablo Sampaio
 */
public class Parser implements XprParser {
	private Lexer lexer;
	private Token currentToken;
	
	private StringBuilder output;
	
	public Parser() {
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
		int valor = parseExpr();

		acceptToken(TokenType.PT_VIRG);
			
		output.append("  >> valor: " + valor + "\n");
	}
	
	/**
	 *   <expr> ::= <term> <restExpr>
	 */
	private int parseExpr() throws CompilerException {
		int resultado;
		
		resultado = parseTerm();
		resultado = parseRestExpr(resultado);
		
		return resultado;
	}

	/**
	 *   <restExpr> ::= "+" <term> <restExpr>
	 *                | --vazio--
	 */
	private int parseRestExpr(int valorEsquerda) throws CompilerException {
		int resultado = valorEsquerda;
		
		if (currentToken.getType() == TokenType.MAIS) {
			acceptToken();
			resultado += parseTerm();
			resultado  = parseRestExpr(resultado);
		
		} else {
			/* faz nada */
		}

		return resultado;
	}
	
	/**
	 *   <term> ::= <factor> <restTerm>
	 */
	private int parseTerm() throws CompilerException {
		int resultado;
		
		resultado = parseFactor();
		resultado = parseRestTerm(resultado);
		
		return resultado;
	}

	/**
	 *   <restTerm> ::= "*" <factor> <restTerm>
	 *                | --vazio--
	 */
	private int parseRestTerm(int valorEsquerda) throws CompilerException {
		int resultado = valorEsquerda;
		
		if (currentToken.getType() == TokenType.VEZES) {
			acceptToken();
			resultado *= parseFactor();
			resultado  = parseRestTerm(resultado);
		
		} else {
			/* faz nada */
		}
		
		return resultado;
	}

	/**
	 *   <factor> ::= NUMERO
	 *              | "(" <expr> ")"
	 */
	private int parseFactor() throws CompilerException {
		int resultado;
		
		if (currentToken.getType() == TokenType.NUMERO) {
			resultado = Integer.parseInt(currentToken.getLexeme());
			acceptToken();

		} else if (currentToken.getType() == TokenType.ABRE_PAR) {
			acceptToken();
			resultado = parseExpr();
			acceptToken(TokenType.FECHA_PAR);

		} else {
			throw new CompilerException("Token inesperado: " + currentToken.getType() + ".");
		}

		return resultado;
	}
	
	/////////////////////////////////////////////////////////////

	/**
	 * Este metodo executa um pequeno teste de reconhecimento.  
	 */
	public static void main(String[] args) throws Exception {
		Parser parser = new Parser();
		
		String teste = "2+4*5;";
		
		System.out.println(" == TESTE DO PARSER ==");
		System.out.println(" Texto fonte a ser reconhecido: \"" + teste + "\"");
		
		String msg = parser.parse(teste);
		
		System.out.println(" " + msg);
		
		System.out.println(" == FIM ==");
	}
	
}