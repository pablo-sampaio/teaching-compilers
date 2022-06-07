/**
 * Este arquivo implementa o reconhecimento sintático (parsing) da
 * linguagem XPR-0, que representar expressões algébricas simples com
 * operações de adição e multiplicação.
 * 
 * Autor: Pablo Sampaio
 */

#include <stdio.h>
#include <stdlib.h>
#include "lexer.h"

// guarda o token atual, lido do lexer
token current_token;

// protótipo das funções
void accept_token();
void accept_token(token_type tp);
void parse_program();
void parse_comand();
void parse_expr();
void parse_restExpr();
void parse_term();
void parse_restTerm();
void parse_factor();


// função principal, a partir da qual é feito reconhecimento
// de um arquivo com código fonte de XPR.
void parse(const char* arquivo) {
     FILE* file = fopen(arquivo, "r");
     
     if (file == NULL) {
         printf(" Erro ao abrir o arquivo: \"%s\".\n", arquivo);
         system("PAUSE");
         exit(1);
     }

	// reinicia o lexer e lê o primeiro token
	reset_lexer(file);
	current_token = next_token();
		
	// tenta reconhecer algo que case com o símbolo "program"
	parse_program();
	accept_token(TOKEN_EOF);
		
	// se nao der erro antes de chegar aqui, então o programa
	// está sintaticamente correto
	printf(" Sintaxe OK!\n");
		
}

///////////////////////////////////////////////////////////
//////////// FUNCOES PARA MANIPULAR OS TOKENS /////////////

void accept_token() {
	current_token = next_token();		
}

void accept_token(token_type tp) {
	if (current_token.type == tp) {
		current_token = next_token();

	} else {
         printf(" ERRO SINTATICO: token inesperado - foi lido um ");
         printf("\"tipo_%d\", quando o esperado era um \"tipo_%d\".\n", current_token.type, tp);
         system("PAUSE");
         exit(1);
	}
}
	
///////////////////////////////////////////////////////////
///////////// METODOS DERIVADOS DA GRAMATICA //////////////
	
/**
 *   <program> ::= <comand>
 */
void parse_program() {
	parse_comand();
}
	
/**
 *   <comand> ::= <expr> ";"
 */
void parse_comand() {
	parse_expr();
	accept_token(TOKEN_PT_VIRG);
}
	
/**
 *   <expr> ::= <term> <restExpr>
 */
void parse_expr() {
	parse_term();
	parse_restExpr();
}

/**
 *   <restExpr> ::= "+" <term> <restExpr>
 *                | --vazio--
 */
void parse_restExpr() {
	if (current_token.type == TOKEN_MAIS) {
		accept_token();
		parse_term();
		parse_restExpr();
	} else {
		/* faz nada */
	}
}
	
/**
 *   <term> ::= <factor> <restTerm>
 */
void parse_term() {
	parse_factor();
	parse_restTerm();
}

/**
 *   <restTerm> ::= "*" <factor> <restTerm>
 *                | --vazio--
 */
void parse_restTerm() {
	if (current_token.type == TOKEN_VEZES) {
		accept_token();
		parse_factor();
		parse_restTerm();
	} else {
		/* faz nada */
	}
}

/**
 *   <factor> ::= NUMERO
 *              | "(" <expr> ")"
 */
void parse_factor() {
	if (current_token.type == TOKEN_NUMERO) {
		accept_token();

	} else if (current_token.type == TOKEN_ABRE_PAR) {
		accept_token();
		parse_expr();
		accept_token(TOKEN_FECHA_PAR);

	} else {
		printf(" ERRO SINTATICO: token inesperado - \"tipo_%d\".\n", current_token.type);
        system("PAUSE");
        exit(1);
	}

}

/////////////////////////////////////////////////////////////
