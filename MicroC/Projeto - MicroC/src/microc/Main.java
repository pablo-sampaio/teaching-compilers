package microc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java_cup.runtime.Symbol;
import microc.ast.Program;
import microc.ast.SemanticException;
import microc.syntax.Lexer;
import microc.syntax.Parser;


public class Main {

	public static void main(String[] args) throws IOException {
		Lexer lexer;
		Parser parser;
		
		Symbol symbol;
		Program program;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite o nome do arquivo: ");
        String arquivo = in.readLine();
		
		while (arquivo != null && !arquivo.equals("")) {
			lexer = new Lexer(new FileReader("samples\\" + arquivo + ".txt"));
			parser = new Parser(lexer);
			
			try {
				symbol = parser.parse();
				System.out.println("Sintaxe OK!");
				
				program = (Program) symbol.value;
				
				System.out.println("Início da verificação semântica");
				program.verifySemantic();
				System.out.println("Verificação semântica - ok!");
				
				System.out.println("Início da geração de código");
				program.generateCode(System.out);
				System.out.println("Geração de código - ok!");

			} catch (SemanticException e) {
				System.out.println("Erro semantico!");
				System.out.println("> " + e.getMessage());
				//e.printStackTrace();
				
			} catch (Exception e) {
				System.out.println("Provavel erro sintatico!");
				System.out.println("> " + e.getMessage());
				System.out.println("> Erro na linha " + lexer.getLine() 
						            + " coluna " + lexer.getColumn());
				e.printStackTrace();
			}

	        System.out.print("\nDigite o nome do arquivo: ");
			arquivo = in.readLine();
		}
		
	}

}
