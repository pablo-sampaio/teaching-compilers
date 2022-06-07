package microc.ast.command;

import java.io.PrintStream;

import microc.ast.DeclarationList;
import microc.ast.SemanticException;
import microc.symbol_table.SymbolTable;

public class Block implements Command {
	private DeclarationList variables;
	private CommandList commands;


	public Block(DeclarationList d, CommandList c) {
		variables = d;
		commands = c;
	}

	@Override
	public void verifySemantic() throws SemanticException {
		SymbolTable.instance.beginScope();
		
		variables.verifySemantic();
		commands.verifySemantic();
		
		SymbolTable.instance.endScope();
	}

	@Override
	public void generateCode(PrintStream out) {
		variables.generateCode(out);
		commands.generateCode(out);	
	}

}
