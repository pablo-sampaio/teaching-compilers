package microc.ast.expression;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.symbol_table.SymbolTable;

public class TermChar implements Expression {
	private char value;
	
	public TermChar(Character c) {
		value = c;
	}
	
	public Type getType() {
		return Type.CHAR; 
	}

	@Override
	public void verifySemantic() throws SemanticException {
		/* faz nada */		
	}


	@Override
	public String generateCode(PrintStream out) {
		String var = SymbolTable.instance.getNewTemporary();
		
		// TODO: verificar bug no valor
		out.println(var + " = '" + value + "'");
		
		return var;
	}

}