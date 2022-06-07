package tlanguage;

import java_cup.runtime.Symbol;


public class Token extends Symbol {
	private int line;
	private int column;

	public Token(int sym_num, int ln, int col, String lexeme) {
		super(sym_num, lexeme);
		this.line = ln;
		this.column = col;
	}
	
	public Token(int sym_num, int ln, int col, Object value) {
		super(sym_num, value);
		this.line = ln;
		this.column = col;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	
	public String toString() {
		return "[tipo_" + super.sym + ", " + super.value + "]";
	}

}
