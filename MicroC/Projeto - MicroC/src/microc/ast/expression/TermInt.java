package microc.ast.expression;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.symbol_table.SymbolTable;

public class TermInt implements Expression {
	private int value;
	
	public TermInt(Integer v) {
		value = v;
	}
	
	public Type getType() {
		return Type.INT; 
	}

	@Override
	public void verifySemantic() throws SemanticException {
		/* faz nada */		
	}

	@Override
	public String generateCode(PrintStream out) {
		String var = SymbolTable.instance.getNewTemporary();
		
		out.println(var + " = " + value);
		
		return var;
	}
	
}
