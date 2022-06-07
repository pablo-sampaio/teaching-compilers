package xpr.version1;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import xpr.CompilerException;
import xpr.general.Token;
import xpr.general.TokenType;
import xpr.general.XprLexer;
import xpr.general.XprParser;


/**
 * Esta classe faz o reconhecimento sintático (parsing) da linguagem XPR
 * para representar expressões algébricas simples. Ela calcula o resultado
 * da expressão algébrica à medida que faz o seu reconhecimento.
 * 
 * @author Pablo Sampaio
 */
public class Parser implements XprParser {
	private XprLexer lexer;
	private Token currentToken;
	private Map<String,Integer> symbolTable; 
	
	private StringBuilder output;
	
	public Parser() {
	}

	/**
	 * Metodo principal, a partir do qual é feito reconhecimento
	 * de um dado código fonte em XPR.
	 */
	public String parse(String sourceCode) throws CompilerException {
		output = new StringBuilder();
		symbolTable = new HashMap<String,Integer>();

		// reinicia o lexer e lê o primeiro token
		lexer = new Lexer(new ByteArrayInputStream(sourceCode.getBytes()));
		acceptToken();
		
		// tenta reconhecer algo que case com o símbolo "program",
		// que eh o símbolo inicial da gramática
		this.parseProgram();
		
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
			this.parseComand();
		} while (currentToken.getType() != TokenType.EOF);
	}
	
	/**
	 *   <comand> ::= <definition> ";"
	 *              | <expr> ";"
	 */
	private void parseComand() throws CompilerException {
		String id;
		int valor;
		
		if (currentToken.getType() == TokenType.DEF) {
			id = this.parseDefinition();
			this.acceptToken(TokenType.PT_VIRG);
			
			output.append("  >> definido: " + id + "=" + this.symbolTable.get(id) + "\n");
		
		} else {
			valor = this.parseExpr();
			this.acceptToken(TokenType.PT_VIRG);
			
			output.append("  >> valor: " + valor + "\n");
		}
		
	}

	/**
	 *   <definition> ::= "def" IDENTIFICADOR "=" <expr>
	 */
	private String parseDefinition() throws CompilerException {
		String id;
		int valor;
		
		// neste ponto, o token DEF ja foi reconhecido,
		// então o token atual pode ser aceito
		this.acceptToken();

		// testa se o próximo token é um identificador e lê o seu lexema
		if (currentToken.getType() == TokenType.IDENTIFICADOR) {
			id = currentToken.getLexeme();
			this.acceptToken();
		} else {
			throw new CompilerException("Erro na definição. Foi lido um \"" 
					+ currentToken.getType() + "\", quando o esperado era um identificador.");
		}
		
		this.acceptToken(TokenType.ATRIBUI);
		
		valor = this.parseExpr();
		
		// registra o identificador se ele ainda não existir
		if (! this.symbolTable.containsKey(id)) {
			this.symbolTable.put(id, valor);
		} else {
			throw new CompilerException("Identificador ja existe: " + id + ".");
		}
		
		return id;
	}
	
	/**
	 *   <expr> ::= <term> <restExpr>
	 */
	private int parseExpr() throws CompilerException {
		int resultado;
		
		resultado = this.parseTerm();
		resultado = this.parseRestExpr(resultado);
		
		return resultado;
	}

	/**
	 *   <restExpr> ::= "+" <term> <restExpr>
	 *                | "-" <term> <restExpr>
	 *                | --vazio--
	 */
	private int parseRestExpr(int valorEsquerda) throws CompilerException {
		int resultado = valorEsquerda;
		
		if (currentToken.getType() == TokenType.MAIS) {
			this.acceptToken();
			resultado += this.parseTerm();
			resultado  = this.parseRestExpr(resultado);
		
		} else if (currentToken.getType() == TokenType.MENOS) {
			this.acceptToken();
			resultado -= this.parseTerm();
			resultado  = this.parseRestExpr(resultado);

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
		
		resultado = this.parseFactor();
		resultado = this.parseRestTerm(resultado);
		
		return resultado;
	}

	/**
	 *   <restTerm> ::= "*" <factor> <restTerm>
	 *                | "/" <factor> <restTerm>
	 *                | --vazio--
	 */
	private int parseRestTerm(int valorEsquerda) throws CompilerException {
		int resultado = valorEsquerda;
		
		if (currentToken.getType() == TokenType.VEZES) {
			this.acceptToken();
			resultado *= this.parseFactor();
			resultado  = this.parseRestTerm(resultado);
		
		} else if (currentToken.getType() == TokenType.DIVIDE) {
			this.acceptToken();
			resultado /= this.parseFactor();
			resultado  = this.parseRestTerm(resultado);
		
		} else {
			/* faz nada */
		}
		
		return resultado;
	}

	/**
	 *   <factor> ::= NUMERO
	 *              | IDENTIFICADOR
	 *              | "(" <expr> ")"
	 */
	private int parseFactor() throws CompilerException {
		int resultado;
		String lexema = currentToken.getLexeme();
		
		if (currentToken.getType() == TokenType.NUMERO) {
			resultado = Integer.parseInt(lexema);
			this.acceptToken();
		
		} else if (currentToken.getType() == TokenType.IDENTIFICADOR) {
			if (this.symbolTable.containsKey(lexema)) {
				resultado = this.symbolTable.get(lexema);
				this.acceptToken();
			} else {
				throw new CompilerException("Identificador nao definido: " + lexema + ".");
			}

		} else if (currentToken.getType() == TokenType.ABRE_PAR) {
			this.acceptToken();
			resultado = this.parseExpr();
			this.acceptToken(TokenType.FECHA_PAR);

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
		
		String teste = "def x = 22 -4*5 /2; def y = 5; x +y; x * 20; //comentario";
		
		System.out.println(" == TESTE DO PARSER ==");
		System.out.println(" Texto fonte a ser reconhecido: \"" + teste + "\"");
		
		String msg = parser.parse(teste);
		
		System.out.println(msg);
		
		System.out.println(" == FIM ==");
	}

}