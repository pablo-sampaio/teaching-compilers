/**
 * Este arquivo serve para testar o analisador l�xico.
 * Para isso, � preciso acrescent�-lo no projeto, removendo
 * tamb�m o arquivo "mainParser.cpp".
 */

#include <stdio.h>
#include <stdlib.h>

#include "lexer.h"


int main()
{
	token token;
		
	printf("\n\n\n");
	printf(" == TESTE DO LEXER ==\n\n");
	printf(" Digite alguma express�o terminada em \";\" e tecle ENTER:\n\n\n ");

	// passa a entrada padr�o para o lexer
	reset_lexer(stdin);
		
	do {
		token = next_token();
		printf("\t[tipo_%d, \"%c\"]\n", token.type, token.lexeme);
		
	} while (token.type != TOKEN_PT_VIRG);
		
	printf("\n == FIM ==\n");
		
	system("PAUSE");
	return 1;
}
