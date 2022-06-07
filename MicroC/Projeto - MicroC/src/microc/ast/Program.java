package microc.ast;

import java.io.PrintStream;

import microc.ast.command.Block;
import microc.symbol_table.SymbolTable;


public class Program {
	private DeclarationList globalVariables;
	private Block mainBlock;

	
	public Program(DeclarationList d, Block b) {
		globalVariables = d;
		mainBlock = b;
	}

	public void verifySemantic() throws SemanticException {
		SymbolTable.instance.beginScope();
		
		globalVariables.verifySemantic();		
		mainBlock.verifySemantic();
		
		SymbolTable.instance.endScope();
	}
	
	public void generateCode(PrintStream out) {
		globalVariables.generateCode(out);		
		mainBlock.generateCode(out);
	}
	
}
