package microc.symbol_table;

import java.util.HashMap;

import microc.ast.Type;


public class Scope {
	private HashMap<String,Type> symbols;
	
	private final int scopeIndex;	
	private int lastSubscope = 0;	
	
	public Scope(int subscope) {
		symbols = new HashMap<String,Type>();
		scopeIndex = subscope;
	}

	public void put(String identifier, Type type) {
		symbols.put(identifier, type);
	}
	
	public Type get(String identifier) {
		return symbols.get(identifier);
	}
	
	public boolean exists(String identifier) {
		return symbols.containsKey(identifier);
	}
	
	public int getScopeIndex() {
		return scopeIndex;
	}
	
	public Scope createSubscope() {
		lastSubscope ++;
		return new Scope(lastSubscope);
	}
	
}