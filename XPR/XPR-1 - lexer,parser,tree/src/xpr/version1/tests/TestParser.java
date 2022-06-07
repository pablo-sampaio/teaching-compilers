package xpr.version1.tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java_cup.runtime.Symbol;
import xpr.version1.Lexer;
import xpr.version1.Parser;


/**
 * Exemplo de integração do analisador léxico gerado pelo JFLex 
 * com o parser gerador pelo CUP.
 * 
 * Este exemplo usa um arquivo como entrada. 
 *
 * Pablo Azevedo Sampaio
 * 14/03/2009
 */

public class TestParser {

	public static void main(String args[]) throws IOException {
		Lexer lexer;
		Parser parser;
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite o nome do arquivo: ");
        String arquivo = in.readLine();
        System.out.println();
		
		try {
			lexer = new Lexer(new FileInputStream(arquivo));
			parser = new Parser(lexer);

			Symbol s = parser.parse();
			
			//s.value contem o objeto "Programa" montado pelo parser
			System.out.println(s.value);
			
			System.out.println("\nSintaxe OK!");
		
		} catch (Exception e) {
			System.out.println("\nErro sintático!");
			e.printStackTrace();
		}

	}

}
