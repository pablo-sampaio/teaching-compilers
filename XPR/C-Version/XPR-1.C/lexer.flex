/* PRIMEIRA PARTE DA ESPECIFICA��O */
/* Op��es do flex e defini��es de macros */

%option outfile="lexer.c" 
%option batch

%{
    //Aqui vc pode definir c�digo C para aparecer no in�cio do lexer gerado
    #include "token.h"
%}

whiteSpace   ([ \n\t\f\r]+)
letra        [a-zA-Z]
numero       [0-9]


/* SEGUNDA PARTE DA ESPECIFICA��O (abaixo do %%) */
/* Regras l�xicas */
%%

{whiteSpace} { 
	// Express�o para caracteres ignorados (espa�os).
	// Nenhum token � retornado.
}

";" { return TOKEN_PT_VIRG; }
"+" { return TOKEN_MAIS; }
"-" { return TOKEN_MENOS; }
"*" { return TOKEN_VEZES; }
"/" { return TOKEN_DIVIDE; }
"(" { return TOKEN_ABRE_PAR; }
")" { return TOKEN_FECHA_PAR; }
"=" { return TOKEN_ATRIBUI; }

"def" { return TOKEN_DEF; }

{letra}+   { return TOKEN_IDENTIFICADOR; }
{numero}+  { return TOKEN_NUMERO; }

"//"[^\n]* {
	// Express�o para coment�rios.
	// N�o retorna token.
}

<<EOF>> {
    // Casa com o fim do arquivo apenas.
    return TOKEN_EOF;
}

.  {
    // Casa com qualquer caracter que n�o casar com as expressoes acima.
	printf( "Illegal character : %s\n", yytext );
}

 
%%

/* TERCEIRA PARTE DA ESPECIFICA��O */
/* Aqui voc� pode colocar qualquer c�digo em C */

int main(int argc, char** argv) {
    int tokenDeParada;
    int token;

	if (argc > 1) {
        printf("\nTokens encontrados no arquivo \"%s\":\n", argv[1]);
		yyin = fopen(argv[1], "r");
		tokenDeParada = TOKEN_EOF;
	} else {
        printf("\nDigite uma expressso terminada em \";\" e pressione ENTER:\n");
        yyin = stdin;
   		tokenDeParada = TOKEN_PT_VIRG;
    }

    do {
        token = yylex();
		printf("\t<tipo_%d, \"%s\">\n", token, yytext);
    } while (token != tokenDeParada);

    system("pause");
    return 1;
}

