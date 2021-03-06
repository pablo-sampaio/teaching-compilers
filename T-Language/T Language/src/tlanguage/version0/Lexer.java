/* The following code was generated by JFlex 1.4.1 on 13/06/09 23:19 */

package tlanguage.version0;

import tlanguage.Token;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 13/06/09 23:19 from the specification file
 * <tt>D:/Projetos/Projetos de Compiladores/T Language/src/tlanguage/version0/Lexer.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  6,  0,  1,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  0,  0,  0,  0, 38,  0,  0,  0,  0,  0,  0,  0, 12,  4,  0, 
    37, 37, 37, 37, 37, 37, 37, 37, 37, 37,  5,  0,  0,  0,  0,  0, 
     0, 26, 36, 27, 36, 28, 36, 36, 36, 36, 33, 36, 36, 36, 36, 36, 
    29, 36, 32, 36, 30, 36, 36, 36, 36, 36, 36,  2,  0,  3,  0, 37, 
     0, 24, 34, 25, 36, 14, 15, 21, 23,  7, 31, 35, 22, 19,  8, 16, 
     9, 36, 18, 13, 11, 10, 20, 17, 36, 36, 36,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\14\1\1\7\2\10\1\11\12\10\1\12\21\10\1\13"+
    "\1\14\1\15\6\10\1\16\1\17\4\10\1\20\1\10"+
    "\1\21\1\22\1\23\2\10\1\24";

  private static int [] zzUnpackAction() {
    int [] result = new int[75];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\47\0\47\0\165\0\47\0\47"+
    "\0\234\0\303\0\352\0\u0111\0\u0138\0\u015f\0\u0186\0\u01ad"+
    "\0\u01d4\0\u01fb\0\u0222\0\u0249\0\47\0\303\0\u0270\0\u0297"+
    "\0\u02be\0\u02e5\0\u030c\0\u0333\0\u035a\0\u0381\0\u03a8\0\u03cf"+
    "\0\u03f6\0\u041d\0\u0444\0\u046b\0\u0492\0\u04b9\0\u04e0\0\u0507"+
    "\0\u052e\0\u0555\0\u057c\0\u05a3\0\u05ca\0\u05f1\0\u0618\0\u063f"+
    "\0\u0666\0\u068d\0\u06b4\0\u06db\0\303\0\303\0\303\0\u0702"+
    "\0\u0729\0\u0750\0\u0777\0\u079e\0\u07c5\0\303\0\303\0\u07ec"+
    "\0\u0813\0\u083a\0\u0861\0\303\0\u0888\0\303\0\303\0\303"+
    "\0\u08af\0\u08d6\0\303";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[75];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\4\12\1\2\4\12\1\13\1\14\1\15\1\12\1\16"+
    "\1\17\1\12\1\20\1\12\1\21\5\12\1\22\1\12"+
    "\1\23\2\12\1\2\1\24\50\0\1\3\51\0\1\25"+
    "\51\0\1\26\1\27\6\26\1\30\26\26\10\0\37\26"+
    "\10\0\13\26\1\31\23\26\10\0\1\32\6\26\1\33"+
    "\27\26\10\0\11\26\1\34\25\26\10\0\11\26\1\35"+
    "\25\26\10\0\7\26\1\36\27\26\10\0\22\26\1\37"+
    "\14\26\10\0\24\26\1\40\12\26\10\0\25\26\1\41"+
    "\11\26\10\0\17\26\1\42\17\26\47\0\1\43\7\0"+
    "\2\26\1\44\34\26\10\0\5\26\1\45\31\26\10\0"+
    "\1\46\36\26\10\0\16\26\1\47\20\26\10\0\30\26"+
    "\1\50\6\26\10\0\15\26\1\51\21\26\10\0\4\26"+
    "\1\52\32\26\10\0\10\26\1\53\26\26\10\0\22\26"+
    "\1\54\14\26\10\0\24\26\1\55\12\26\10\0\32\26"+
    "\1\56\4\26\10\0\21\26\1\57\15\26\1\0\6\43"+
    "\1\0\40\43\7\0\3\26\1\60\33\26\10\0\1\26"+
    "\1\61\35\26\10\0\4\26\1\62\32\26\10\0\20\26"+
    "\1\63\16\26\10\0\7\26\1\64\27\26\10\0\7\26"+
    "\1\65\27\26\10\0\11\26\1\66\25\26\10\0\4\26"+
    "\1\67\32\26\10\0\7\26\1\70\27\26\10\0\25\26"+
    "\1\71\11\26\10\0\25\26\1\72\11\26\10\0\1\26"+
    "\1\73\35\26\10\0\4\26\1\74\32\26\10\0\11\26"+
    "\1\75\25\26\10\0\7\26\1\76\27\26\10\0\4\26"+
    "\1\77\32\26\10\0\22\26\1\100\14\26\10\0\2\26"+
    "\1\101\34\26\10\0\26\26\1\102\10\26\10\0\24\26"+
    "\1\103\12\26\10\0\34\26\1\104\2\26\10\0\5\26"+
    "\1\105\31\26\10\0\4\26\1\106\32\26\10\0\4\26"+
    "\1\107\32\26\10\0\4\26\1\110\32\26\10\0\27\26"+
    "\1\110\7\26\10\0\27\26\1\107\7\26\10\0\6\26"+
    "\1\111\30\26\10\0\7\26\1\112\27\26\10\0\4\26"+
    "\1\113\32\26\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2301];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\2\11\1\1\2\11\14\1\1\11"+
    "\66\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[75];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	//Para facilitar a cria??o dos tokens.
	Token newToken(int tokenId) {
    	return new Token(tokenId, yyline+1, yycolumn+1, yytext());
	}
	Token newToken(int tokenId, Object value) {
    	return new Token(tokenId, yyline+1, yycolumn+1, value);
	}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 10: 
          { // Coment?rios de linha.
          }
        case 21: break;
        case 4: 
          { return newToken(sym.RIGHT_BRACKET);
          }
        case 22: break;
        case 17: 
          { return newToken(sym.IF_NOT);
          }
        case 23: break;
        case 11: 
          { return newToken(sym.MOVE);
          }
        case 24: break;
        case 18: 
          { return newToken(sym.REJECT);
          }
        case 25: break;
        case 7: 
          { return newToken(sym.DOT_DOT);
          }
        case 26: break;
        case 6: 
          { return newToken(sym.LINE_BREAK);
          }
        case 27: break;
        case 14: 
          { return newToken(sym.WRITE);
          }
        case 28: break;
        case 19: 
          { return newToken(sym.ACCEPT);
          }
        case 29: break;
        case 9: 
          { return newToken(sym.IF);
          }
        case 30: break;
        case 12: 
          { return newToken(sym.GOTO);
          }
        case 31: break;
        case 2: 
          { // Espa?os em branco.
          }
        case 32: break;
        case 1: 
          { return newToken(sym.SYMBOL_LITERAL, yytext().charAt(0));
          }
        case 33: break;
        case 15: 
          { return newToken(sym.RIGHT);
          }
        case 34: break;
        case 13: 
          { return newToken(sym.LEFT);
          }
        case 35: break;
        case 3: 
          { return newToken(sym.LEFT_BRACKET);
          }
        case 36: break;
        case 20: 
          { return newToken(sym.INPUT_SET);
          }
        case 37: break;
        case 5: 
          { return newToken(sym.COLON);
          }
        case 38: break;
        case 8: 
          { return newToken(sym.IDENTIFIER);
          }
        case 39: break;
        case 16: 
          { return newToken(sym.SYMBOL_LITERAL, new Character((char)0));
          }
        case 40: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                return newToken(sym.EOF);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
