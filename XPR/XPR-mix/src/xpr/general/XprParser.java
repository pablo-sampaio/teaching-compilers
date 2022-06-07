package xpr.general;

import xpr.CompilerException;


public interface XprParser {

	public abstract String parse(String sourceCode) throws CompilerException;

}
