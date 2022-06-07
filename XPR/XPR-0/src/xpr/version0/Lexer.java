package xpr.version0;

import java.io.IOException;
import java.io.InputStream;

import xpr.util.CompilerException;


/**
 * Esta classe faz a análise léxica para uma linguagem de expressões
 * algébricas. Ela le uma sequencia de caracteres, dividindo-a em trechos
 * menores (lexemas) que são categorizados e retornados como tokens. Os
 * tokens são retornados um por vez, a cada chamada da função "nextToken". 
 * 
 * @author Pablo Sampaio
 */
public class Lexer {
	private InputStream input;
	private int nextChar;
	
	public Lexer() {
		this.nextChar = -1;
	} 
	
	public void reset(InputStream in) throws CompilerException {
		try {
			// contem o codigo fonte a ser analisado
			this.input = in;
			// anda para o primeiro byte da entrada 
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
		
		// testa se chegou ao fim do arquivo
		if (this.nextChar == -1) {
			return new Token(TokenType.EOF);
		}

		// identifica os demais tipos de tokens
		if (nextChar >= '0' && nextChar <= '9') {
			tipo = TokenType.NUMERO;
		} else if (nextChar == ';') {
			tipo = TokenType.PT_VIRG;
		} else if (nextChar == '+') {
			tipo = TokenType.MAIS;
		} else if (nextChar == '*') {
			tipo = TokenType.VEZES;
		} else if (nextChar == '(') {
			tipo = TokenType.ABRE_PAR;
		} else if (nextChar == ')') {
			tipo = TokenType.FECHA_PAR;
		} else {
			throw new CompilerException("Caracter inesperado: " + (char)nextChar);
		}
		
		String lexema = "" + (char)nextChar;
		
		// prepara para a leitura do próximo token
		this.nextChar = this.readByte();

		return new Token(tipo, lexema);
	}
	

}
