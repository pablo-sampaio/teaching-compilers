package microc.ast.expression;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.symbol_table.SymbolTable;

public class TermVariable implements Expression {
	private String identifier;
	
	private String identifierUnique;
	private Type type;

	public TermVariable(String id) {
		identifier = id;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void verifySemantic() throws SemanticException {
		SymbolTable table = SymbolTable.instance;
		
		type = table.lookup(identifier);
		if (type == null) {
			throw new SemanticException("Identificador \"" + identifier + "\" nao foi declarado.");
		}
		
		identifierUnique = SymbolTable.instance.getUniqueName(identifier);
	}

	@Override
	public String generateCode(PrintStream out) {
		return identifierUnique;
	}

}
