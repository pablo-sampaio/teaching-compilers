package xpr.version1;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import xpr.CompilerException;
import xpr.general.XprLexer;
import xpr.general.Token;
import xpr.general.TokenType;


/**
 * Esta classe faz a análise léxica para uma linguagem de expressões
 * algébricas. Ela le uma sequencia de caracteres, dividindo-a em trechos
 * menores (lexemas) que são categorizados e retornados como tokens. Os
 * tokens são retornados um por vez, a cada chamada da função "nextToken". 
 * 
 * @author Pablo Sampaio
 */
public class Lexer implements XprLexer {
	private HashMap<String,TokenType> keywords;
	private InputStream input;
	private int nextChar;
	
	public Lexer(InputStream in) throws CompilerException {
		// guarda a lista de palavras reservadas
		keywords = new HashMap<String, TokenType>();
		keywords.put("def", TokenType.DEF);

		// contem o codigo fonte a ser analisado
		this.input = in;

		// anda para o primeiro byte da entrada
		try {
			this.nextChar = in.read();
		} catch (IOException e) {
			throw new CompilerException(e.getMessage());
		}
	} 
	
	private int readByte() throws CompilerException {
		int theByte;
		
		try {
			theByte = input.read();
		} catch (IOException e) {
			throw new CompilerException(e.getMessage());
		}
		
		return theByte;
	}
	
	/**
	 * Este eh o metodo principal, que identifica qual o proximo
	 * token da entrada para retorna-lo. 
	 */
	public Token nextToken() throws CompilerException {
		TokenType tipo;
		StringBuilder lexema = new StringBuilder();
		
		// ignora os espaços em branco e quebras de linha
		while (nextChar == ' ' || nextChar == '\t' || nextChar == '\r' || nextChar == '\n') {
			this.nextChar = this.readByte();
		}
		
		// testa os tipos de tokens
		if (this.nextChar == -1) {
			tipo = TokenType.EOF;
		
		} else if (Character.isDigit(nextChar)) {
			do {
				lexema.append((char)nextChar);
				this.nextChar = this.readByte();
			} while (Character.isDigit(nextChar));
			
			tipo = TokenType.NUMERO;
		
		} else if (Character.isLetter(nextChar)) {
			do {
				lexema.append((char)nextChar);
				this.nextChar = this.readByte();
			} while (Character.isLetter(nextChar));
			
			if (keywords.containsKey(lexema.toString())) {
				tipo = keywords.get(lexema.toString());
			} else {
				tipo = TokenType.IDENTIFICADOR;
			}
		
		} else if (nextChar == ';') {
			tipo = TokenType.PT_VIRG;
			this.nextChar = this.readByte();
			
		} else if (nextChar == '=') {
			tipo = TokenType.ATRIBUI;
			this.nextChar = this.readByte();
			
		} else if (nextChar == '+') {
			tipo = TokenType.MAIS;
			this.nextChar = this.readByte();
		
		} else if (nextChar == '-') {
			tipo = TokenType.MENOS;
			this.nextChar = this.readByte();
			
		} else if (nextChar == '*') {
			tipo = TokenType.VEZES;
			this.nextChar = this.readByte();
			
		} else if (nextChar == '/') {
			this.nextChar = this.readByte();

			if (nextChar == '/') {
				//se tiver duas barras, é comentário de linha
				do {
					this.nextChar = this.readByte();
				} while (this.nextChar != '\n' && this.nextChar != -1);
				
				//para ignorar o comentário, retorna o próximo token da entrada
				return nextToken();
				
			} else {
				//se tiver uma barra só, é o sinal de divisão
				tipo = TokenType.DIVIDE;
			}
			
		} else if (nextChar == '(') {
			tipo = TokenType.ABRE_PAR;
			this.nextChar = this.readByte();
		
		} else if (nextChar == ')') {
			tipo = TokenType.FECHA_PAR;
			this.nextChar = this.readByte();
			
		} else {
			throw new CompilerException("Caracter inesperado: '" + (char)nextChar + "'");
		
		}
		
		return new Token(tipo, lexema.toString());			
	}
	
	/**
	 * Este metodo permite fazer testes com o lexer usando a
	 * entrada padrão.  
	 */
	public static void main(String[] args) throws Exception {
		Lexer lexer;
		Token token = null;
		
		System.out.println("\n\n\n");
		System.out.println(" == TESTE DO LEXER ==\n");
		System.out.println(" Digite alguma string terminada em \";\" e tecle ENTER:\n\n");
		System.out.print(" ");

		// passa a entrada padrão para o lexer
		lexer = new Lexer(System.in);
		
		do {
			token = lexer.nextToken();
			System.out.println("\t" + token);
		
		} while (token.getType() != TokenType.PT_VIRG);
		
		System.out.println("\n == FIM ==");
		
	}

}
