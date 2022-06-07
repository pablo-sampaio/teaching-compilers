package tlanguage.version0;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import tlanguage.version0.tree.*;


public class Compiler {
	private Program lastProgram;

	public Compiler() {
		
	}
	
	public void interpret(String filePath) throws IOException {
		interpret(new FileInputStream(filePath), System.out);
	}

	public void interpret(InputStream inputStream, OutputStream outputStream) {
		Lexer lexer = new Lexer(inputStream);
		Parser parser = new Parser(lexer);

		PrintStream out = new PrintStream(outputStream);
		out.println();
		
		try {
			
			lastProgram = parser.start();
			//out.println(lastProgram);
			
			out.println("1. Análise Sintática ok !!!");
			
			boolean correct = lastProgram.verify();
			
			if (correct) {
				out.println("2. Análise Semântica ok !!!");
			} else {
				throw new Exception("Erro semântico!");
			}
			
			boolean result = lastProgram.run("babb#babb");
			
			out.println("3. Resultado da execução: " + (result ? "ACEITA" : "REJEITA"));
		
		} catch (Exception exc) {
			//ErrorReport errors = new ErrorReport();
			
			//errors.addMessage(exc.getMessage());
			//exc.printStackTrace();
		
			//return errors;
			exc.printStackTrace();
			out.println("PROBLEM FOUND !");
		}

		//return lastProgram.getErrorReport();
	}
	
	public static void main(String[] args) throws IOException {
		Compiler compiler = new Compiler();
		
		compiler.interpret("T0-exemplo1.t");
	}
	
}
