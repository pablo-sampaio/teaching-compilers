
#include <stdio.h>
#include "token.h"

// declara que as fun��es do lexer est�o definidas
// externamente (em outro arquivo).

extern token next_token();
extern void reset_lexer(FILE* in);
