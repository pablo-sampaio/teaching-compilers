/**
 * Este arquivo define a an�lise l�xica para uma linguagem de express�es
 * alg�bricas. Ela le um arquivo, dividindo-o em trechos menores (lexemas)
 * que s�o classificados e retornados como tokens. Os tokens s�o retornados
 * um por vez, a cada chamada da fun��o "next_token". 
 * 
 * Autor: Pablo Sampaio
 */
 
#include <stdio.h>
#include <stdlib.h>
#include "token.h"

// vari�veis usadas na an�lise l�xica
FILE* input = NULL;
int nextChar = -1;


// reinicia a an�lise l�xica
void reset_lexer(FILE* in) {
    if (input != NULL) {
        delete input;
    }
     
	// contem o codigo fonte a ser analisado
	input = in;
    // anda para o primeiro byte da entrada 
	nextChar = getc(input);
}

	
// fun��o principal, que identifica qual o proximo
// token da entrada para retorna-lo. 
token next_token() {
    token token;
	token_type tipo;
	
	// testa se chegou ao fim do arquivo
	if (nextChar == -1) {
        token.type = TOKEN_EOF;
	    token.lexeme = 0;
		return token;
	}

	// identifica os demais tipos de tokens
	if (nextChar >= '0' && nextChar <= '9') {
		tipo = TOKEN_NUMERO;
	} else if (nextChar == ';') {
		tipo = TOKEN_PT_VIRG;
	} else if (nextChar == '+') {
		tipo = TOKEN_MAIS;
	} else if (nextChar == '*') {
		tipo = TOKEN_VEZES;
	} else if (nextChar == '(') {
		tipo = TOKEN_ABRE_PAR;
	} else if (nextChar == ')') {
		tipo = TOKEN_FECHA_PAR;
	} else {
		printf(" ERRO LEXICO: caracter inesperado - \'%c\'.\n", (char)nextChar);
		system("PAUSE");
		exit(1);
	}
	
	token.type = tipo;
	token.lexeme = nextChar;
		
	// prepara para a leitura do pr�ximo token
	nextChar = getc(input);

	return token;
}
