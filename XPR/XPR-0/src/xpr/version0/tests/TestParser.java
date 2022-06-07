package xpr.version0.tests;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import xpr.version0.Parser;

public class TestParser {

	/**
	 * Este metodo executa um pequeno teste de reconhecimento.  
	 */
	public static void main(String[] args) throws Exception {
		Parser parser = new Parser();
		InputStream entrada;

		System.out.println(" == TESTE DO PARSER ==\n");
		
		//TESTA O PARSER USANDO UMA STRING:		
		String codigo = "2+4*5;";
		System.out.println(" Texto fonte a ser reconhecido: \"" + codigo + "\"");		
		
		entrada = new ByteArrayInputStream(codigo.getBytes());

		//PARA TESTAR USANDO ARQUIVO:
		//entrada = new FileInputStream("caminho do arquivo");
		
		String msg = parser.parse(entrada);
		System.out.println(" >>" + msg + "\n");
		
		System.out.println(" == FIM ==");
	}
	
}
