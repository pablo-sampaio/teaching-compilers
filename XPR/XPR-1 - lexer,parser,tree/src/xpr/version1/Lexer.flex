package xpr.version1;

// esta é a classe do CUP que usamos no lugar da classe Token
// já para o lugar da classe TokenType, o CUP gera a classe sym
import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%cup

whiteSpace=([ \n\t\f\r]+)
letra=[a-zA-Z]
numero=[0-9]

%%

{whiteSpace} { 
	// Caracteres ignorados.
	// Nenhum token é retornado.
}

";" { return new Symbol(sym.PT_VIRG); }
"+" { return new Symbol(sym.MAIS); }
"-" { return new Symbol(sym.MENOS); }
"*" { return new Symbol(sym.VEZES); }
"/" { return new Symbol(sym.DIVIDE); }
"(" { return new Symbol(sym.ABRE_PAR); }
")" { return new Symbol(sym.FECHA_PAR); }
"=" { return new Symbol(sym.ATRIBUI); }

"def"      { return new Symbol(sym.DEF); }
{letra}+   { return new Symbol(sym.IDENTIFICADOR, yytext()); }
{numero}+  { return new Symbol(sym.NUMERO, yytext()); }

"//"[^\n]* {
	// Comentários de linha.
	// Não retorna token.
}

. { 
    // Casa com qualquer caracter que não casar com as expressoes anteriores.
    System.out.println("Illegal character : " + yytext());
    return new Symbol(sym.error);
}

<<EOF>> {
	// Casa com o fim do arquivo apenas.
	return new Symbol(sym.EOF);
}
