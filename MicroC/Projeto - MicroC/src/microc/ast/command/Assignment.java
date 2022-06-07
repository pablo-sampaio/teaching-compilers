package microc.ast.command;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.ast.expression.Expression;
import microc.symbol_table.SymbolTable;


public class Assignment implements Command {
	private String identifier;
	private Expression expression;
	
	private String identifierUnique;
	
	
	public Assignment(String id, Expression e) {
		identifier = id;
		expression = e;
	}

	@Override
	public void verifySemantic() throws SemanticException {
		Type variableType;
		Type expressionType;

		variableType = SymbolTable.instance.lookup(identifier);
		
		if (variableType != null) {
			identifierUnique = SymbolTable.instance.getUniqueName(identifier);
			
			expression.verifySemantic();
			expressionType = expression.getType();
			
			if (variableType != expressionType) {
				throw new SemanticException("Variavel \"" + identifier + "\" nao pode receber uma "
						                    + "expressao do tipo \"" + expressionType + "\".");
			}
		
		} else {
			throw new SemanticException("Identificador \"" + identifier + "\" nao foi declarado.");
		
		}

	}

	@Override
	public void generateCode(PrintStream out) {
		String varExp = expression.generateCode(out);
		
		out.println(identifierUnique + " = " + varExp);
	}

}
