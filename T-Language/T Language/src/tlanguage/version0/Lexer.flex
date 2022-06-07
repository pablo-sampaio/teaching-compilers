package tlanguage.version0;

import tlanguage.Token;

%%

%class Lexer
%public
%cup
%8bit
%line
%column

%{
	//Para facilitar a criação dos tokens.
	Token newToken(int tokenId) {
    	return new Token(tokenId, yyline+1, yycolumn+1, yytext());
	}
	Token newToken(int tokenId, Object value) {
    	return new Token(tokenId, yyline+1, yycolumn+1, value);
	}
%}

whiteSpace=([ \t\f\r]+)

%%

{whiteSpace} { 
	// Espaços em branco.
}

"["   { return newToken(sym.LEFT_BRACKET); }
"]"   { return newToken(sym.RIGHT_BRACKET); }
".."  { return newToken(sym.DOT_DOT); }  //para input-set
":"   { return newToken(sym.COLON); }    //para labels
"\n"  { return newToken(sym.LINE_BREAK); }

"input-set" { return newToken(sym.INPUT_SET); }
"if"        { return newToken(sym.IF); }
"if-not"    { return newToken(sym.IF_NOT); }
"write"     { return newToken(sym.WRITE); }
"move"      { return newToken(sym.MOVE); }
"goto"      { return newToken(sym.GOTO); }
"left"      { return newToken(sym.LEFT); }
"right"     { return newToken(sym.RIGHT); }

"accept"|"ACCEPT"  { return newToken(sym.ACCEPT); }
"reject"|"REJECT"  { return newToken(sym.REJECT); }

"blank" { return newToken(sym.SYMBOL_LITERAL, new Character((char)0)); }
.       { return newToken(sym.SYMBOL_LITERAL, yytext().charAt(0)); } 
/* TODO: restringir aos printables! */

[a-zA-Z][a-zA-Z0-9\-_]+  { return newToken(sym.IDENTIFIER); }

"%%"[^\n]* {
	// Comentários de linha.
}

// TODO: TRATAR ERRO !!! 

<<EOF>> {
	return newToken(sym.EOF);
}
