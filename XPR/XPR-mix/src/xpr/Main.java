package xpr;

public class Main {

	/**
	 * A fun��o que testa o frame. 
	 */
	public static void main(String[] args) {
		CompilerFrame frame = new CompilerFrame(new xpr.version1.Parser());
		frame.showCenterScreen();
	}
	
}
