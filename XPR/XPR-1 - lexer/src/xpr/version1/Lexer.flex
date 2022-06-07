package xpr.version1;

%%

%class Lexer
%public

%function nextToken
%type Token

whiteSpace=([ \n\t\f\r]+)
letra=[a-zA-Z]
numero=[0-9]

%%

{whiteSpace} { 
	// Caracteres ignorados.
	// Nenhum token � retornado.
}

";" { return new Token(TokenType.PT_VIRG); }
"+" { return new Token(TokenType.MAIS); }
"-" { return new Token(TokenType.MENOS); }
"*" { return new Token(TokenType.VEZES); }
"/" { return new Token(TokenType.DIVIDE); }
"(" { return new Token(TokenType.ABRE_PAR); }
")" { return new Token(TokenType.FECHA_PAR); }
"=" { return new Token(TokenType.ATRIBUI); }

"def"      { return new Token(TokenType.DEF); }
{letra}+   { return new Token(TokenType.IDENTIFICADOR, yytext()); }
{numero}+  { return new Token(TokenType.NUMERO, yytext()); }

"//"[^\n]* {
	// Coment�rios de linha.
	// N�o retorna token.
}

. { 
    // Casa com qualquer caracter que n�o casar com as expressoes acima.
    System.err.println("Illegal character : " + yytext());
}

<<EOF>> {
	// Casa com o fim do arquivo apenas.
	return new Token(TokenType.EOF);
}
