package tlanguage.version1;


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
%}

whiteSpace=([ \n\t\f\r]+)

%%

{whiteSpace} { 
	// Espaços em branco.
}

"{"   { return newToken(sym.LEFT_BRACE); }
"}"   { return newToken(sym.RIGHT_BRACE); }
"("   { return newToken(sym.LEFT_PAR); }
")"   { return newToken(sym.RIGHT_PAR); }
".."  { return newToken(sym.DOT_DOT); }
","   { return newToken(sym.COMMA); }
":"   { return newToken(sym.COLON); }
";"   { return newToken(sym.SEMICOLON); }

"|"   { return newToken(sym.OR); }
"~"   { return newToken(sym.NOT); }

"input-set" { return newToken(sym.INPUT_SET); }
"condition"   { return newToken(sym.CONDITION_TYPE); }
"symbol"    { return newToken(sym.SYMBOL_TYPE); }
"direction"   { return newToken(sym.DIRECTION_TYPE); }
"main"   { return newToken(sym.MAIN); }
"if"   { return newToken(sym.IF); }
"else"   { return newToken(sym.ELSE); }
"write"   { return newToken(sym.WRITE); }
"move"   { return newToken(sym.MOVE); }
"goto"   { return newToken(sym.GOTO); }
"left"   { return newToken(sym.LEFT); }
"right"   { return newToken(sym.RIGHT); }

"accept"|"ACCEPT"  { return newToken(sym.ACCEPT); }
"reject"|"REJECT"  { return newToken(sym.REJECT); }

"blank" { return newToken(sym.SYMBOL_LITERAL); }
.       { return newToken(sym.SYMBOL_LITERAL); } /* restringir aos printables! */

[a-zA-Z][a-zA-Z0-9\-_]+  { return newToken(sym.IDENTIFIER); }

"//"[^\n]* {
	// Comentários de linha.
}

// PRECISA TRATAR ERRO ?

<<EOF>> {
	return newToken(sym.EOF);
}
