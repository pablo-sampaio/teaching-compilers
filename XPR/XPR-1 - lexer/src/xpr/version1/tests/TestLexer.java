package xpr.version1.tests;

import java.io.FileReader;

import xpr.version1.Lexer;
import xpr.version1.Token;
import xpr.version1.TokenType;

/**
 * Classe criada para fazer testes com o lexer. 
 */
public class TestLexer {

	public static void main(String[] args) throws Exception {
		Lexer lexer = null;
		Token token = null;
		
		System.out.println("\n\n\n");
		System.out.println(" == TESTE DO LEXER ==\n");
		System.out.println(" Digite alguma string terminada em \";\" e tecle ENTER:\n\n");
		System.out.print(" ");

		// passa a entrada padrão para o lexer
		// para usar arquivo, descomente a linha abaixo
		lexer = new Lexer(System.in);
		//lexer = new Lexer(new FileReader("prog.txt"));
		
		do {
			token = lexer.nextToken();
			System.out.println("\t" + token.toString());
		
		} while (token.getType() != TokenType.PT_VIRG);
		
		System.out.println("\n == FIM ==");
		
	}

}