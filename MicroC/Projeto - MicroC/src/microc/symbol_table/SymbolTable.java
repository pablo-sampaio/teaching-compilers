package microc.symbol_table;

import java.util.Stack;

import microc.ast.Type;


public class SymbolTable {
	public static final SymbolTable instance = new SymbolTable(); 
	
	private Stack<Scope> scopes;
	private int tempIndex;
	private int labelIndex;
	
	
	public SymbolTable() {
		scopes = new Stack<Scope>();
		tempIndex = 0;
		labelIndex = 0;
	}

	public Type lookup(String identifier) {
		Scope current;
		
		for (int i = scopes.size() - 1; i >= 0; i --) {
			current = scopes.get(i);
			
			if (current.exists(identifier)) {
				return current.get(identifier);
			}
		}
		
		return null;
	}
	
	public String getUniqueName(String identifier) {
		Stack<Integer> indexes = new Stack<Integer>();
		
		Scope current;
		boolean found = false;
		
		for (int i = scopes.size() - 1; i >= 0; i --) {
			current = scopes.get(i);
			
			if (found) {
				indexes.push(current.getScopeIndex());			
			} else if (current.exists(identifier)) {
				found = true;
				indexes.push(current.getScopeIndex());
			}
		}
		
		if (! found) return null;
		
		String name = identifier;
		int scopeIndex;
		while (!indexes.empty()) {
			scopeIndex = indexes.pop();
			if (scopeIndex != -1) {
				name = name + "_" + scopeIndex;
			}
		}
		
		return name;
	}
	
	public void beginScope() {
		Scope scope;
		
		if (scopes.empty()) {
			scope = new Scope(-1);		
		} else {
			scope = scopes.peek().createSubscope();			
		}
		
		scopes.add(scope);
	}
	
	public void endScope() {
		scopes.pop();
	}
	
	public Scope getCurrentScope() {
		return scopes.peek();
	}
	
	public String getNewTemporary() {
		tempIndex ++;
		return "_t" + tempIndex;
	}
	
	public String getNewLabel() {
		labelIndex ++;
		return "_LABEL" + labelIndex;
	}
	
}

