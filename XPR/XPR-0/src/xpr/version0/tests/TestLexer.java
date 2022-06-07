package xpr.version0.tests;

import java.io.FileInputStream;

import xpr.version0.Lexer;
import xpr.version0.Token;
import xpr.version0.TokenType;

public class TestLexer {

	/**
	 * Este metodo permite fazer testes com o lexer usando a
	 * entrada padrão.  
	 */
	public static void main(String[] args) throws Exception {
		Lexer lexer = new Lexer();
		Token token = null;
		
		System.out.println("\n\n\n");
		System.out.println(" == TESTE DO LEXER ==\n");
		System.out.println(" Digite alguma string terminada em \";\" e tecle ENTER:\n\n");
		System.out.print(" ");

		// passa a entrada padrão para o lexer
		lexer.reset(System.in);
		
		// parar passar um arquivo como entrada
		//lexer.reset(new FileInputStream("caminho do arquivo"));
		
		do {
			token = lexer.nextToken();
			System.out.println("\t" + token);
		
		} while (token.getType() != TokenType.PT_VIRG);
		
		System.out.println("\n == FIM ==");
		
	}
	
}
