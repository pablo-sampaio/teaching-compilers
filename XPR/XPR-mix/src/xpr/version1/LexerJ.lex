package xpr.version1;

import xpr.CompilerException;
import xpr.general.Token;
import xpr.general.TokenType;

%%

%type Token
%class LexerJ
%implements xpr.general.XprLexer
%function nextToken

%eofval{
  //tratamento de fim de arquivo
  return new Token(TokenType.EOF);
%eofval}

%yylexthrow{ 
  //excecao lançada pela funcao do lexer
  CompilerException
%yylexthrow}

whiteSpace=([ \n\t\f\r]+)

%%

{whiteSpace} { 
               // Nenhum token é retornado.
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
[a-zA-Z]+  { return new Token(TokenType.IDENTIFICADOR, yytext()); }
[0-9]+     { return new Token(TokenType.NUMERO, yytext()); }

"//"[^\n]+ {
	         // Expressão para comentários
	         // Não retorna token
	       }

. { 
     // Qualquer string que nao casar com as expressoes regulares definidas
     // acima resultara nesta excecao.
     throw new CompilerException("Caracter inesperado: " + yytext());
  }
