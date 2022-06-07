package microc.ast.expression;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.symbol_table.SymbolTable;

public class TermFloat implements Expression {
	private float value;
	
	public TermFloat(Float v) {
		value = v;
	}
	
	public Type getType() {
		return Type.FLOAT; 
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
