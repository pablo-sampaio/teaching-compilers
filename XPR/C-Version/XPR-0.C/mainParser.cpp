/**
 * Este arquivo serve para testar o analisador sintático
 * (já devidamente integrado com o analisador léxico).
 */

#include <stdio.h>
#include <stdlib.h>
#include "parser.h"


int main()
{
	char* arquivo = "programa.txt";

	printf(" == TESTE DO PARSER ==\n\n");
	printf(" Arquivo a ser reconhecido: \"%s\".\n", arquivo);

    // faz a análise sintática do arquivo
    parse(arquivo);

	printf("\n == FIM ==\n");

	system("PAUSE");
	return 1;
}
