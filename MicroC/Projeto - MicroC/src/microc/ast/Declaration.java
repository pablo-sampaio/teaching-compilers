package microc.ast;

import java.io.PrintStream;

import microc.symbol_table.Scope;
import microc.symbol_table.SymbolTable;

public class Declaration {
	private Type type;
	private IdentifierList identifiers;
	
	public Declaration(Type t, IdentifierList list) {
		type = t;
		identifiers = list;
	}
	
	public void verifySemantic() throws SemanticException {
		Scope scope = SymbolTable.instance.getCurrentScope(); 
		
		for (String id : identifiers) {
			// testa se já foi declarado no escopo atual
			if (scope.exists(id)) {
				throw new SemanticException("Identificador redeclarado: \"" + id + "\".");
			} else {
				scope.put(id, type);
			}
		}
		
	}

	public void generateCode(PrintStream out) {
		/* faz nada */
		
	}
	
}
