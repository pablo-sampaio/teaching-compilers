/**
 * Este arquivo serve para testar o analisador sint�tico
 * (j� devidamente integrado com o analisador l�xico).
 */

#include <stdio.h>
#include <stdlib.h>
#include "parser.h"


int main()
{
	char* arquivo = "programa.txt";

	printf(" == TESTE DO PARSER ==\n\n");
	printf(" Arquivo a ser reconhecido: \"%s\".\n", arquivo);

    // faz a an�lise sint�tica do arquivo
    parse(arquivo);

	printf("\n == FIM ==\n");

	system("PAUSE");
	return 1;
}
