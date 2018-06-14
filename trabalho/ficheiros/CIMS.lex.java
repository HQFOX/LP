import java_cup.runtime.Symbol;


class Yylex {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

  private Symbol token(int id, Object value) {
    return new Symbol(id, yychar, yyline, value);
  }
  private Symbol token(int id) {
    return token(id, yytext());
  }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NOT_ACCEPT,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NOT_ACCEPT,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"30:9,31,28,30:2,27,30:18,31,30,25,29,30:9,24,30:2,22:10,23,30:6,21:26,30,26" +
",30:2,12,30,3,16,1,18,10,21,11,2,7,21:2,5,4,20,6,13,21,9,8,15,17,14,21,19,2" +
"1:2,30:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,121,
"0,1,2,1,3,1:2,4,1,5:11,6,5:9,7,8,3,9,10,7,11,12,13,14,15,16,17,18,19,20,21," +
"22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46," +
"47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71," +
"72,73,74,75,76,77,78,79,80,81,82,83,84,5,85,86,87,88,89,90,91,92,93,94")[0];

	private int yy_nxt[][] = unpackFromString(95,32,
"1,2,110,117,55,118,110:2,56,119,57,110,3,110:5,58,110:3,4,5,32,35,3,-1,6,7," +
"3,6,-1:33,110,76,110:3,77,110:16,-1:31,4,-1:10,7:26,-1:2,7:3,-1,110:22,-1:1" +
"0,110:11,108,110:10,-1:10,30:24,8,33,30:5,-1,110:17,9,110:4,-1:34,30:2,-1:6" +
",110:15,10,110:6,-1:10,110:12,11,110:9,-1:10,110:13,12,110:8,-1:10,110:14,1" +
"3,110:7,-1:10,110:2,14,110:19,-1:10,110:2,15,110:19,-1:10,110:2,16,110:19,-" +
"1:10,110:7,17,110:14,-1:10,110:8,18,110:13,-1:10,110:4,19,110:17,-1:10,110:" +
"2,20,110:19,-1:10,110:2,21,110:19,-1:10,110:10,22,110:11,-1:10,110:2,23,110" +
":19,-1:10,110:10,24,110:11,-1:10,110:8,25,110:13,-1:10,110:10,26,110:11,-1:" +
"10,110:8,27,110:13,-1:10,110:14,28,110:7,-1:10,110:8,29,110:13,-1:10,110:5," +
"31,110:10,59,110:5,-1:10,110:2,80,81,110,60,82,110:9,34,110:5,-1:10,110:3,8" +
"3,110:3,111,110:10,36,110:3,-1:10,110:6,37,110:15,-1:10,110:4,38,110:12,86," +
"110:4,-1:10,110:3,39,110:18,-1:10,110:3,40,110:18,-1:10,110:14,41,110:7,-1:" +
"10,110:6,42,110:15,-1:10,110:5,43,110:16,-1:10,110:2,44,110:19,-1:10,110,45" +
",110:20,-1:10,110:7,46,110:14,-1:10,110:8,47,110:13,-1:10,110,48,110:20,-1:" +
"10,110:8,49,110:13,-1:10,110:2,50,110:19,-1:10,110:8,51,110:13,-1:10,110:2," +
"52,110:19,-1:10,110:19,53,110:2,-1:10,110:14,54,110:7,-1:10,110:2,61,110:19" +
",-1:10,110:4,84,110:17,-1:10,110:8,85,110:13,-1:10,87,110:21,-1:10,110:4,62" +
",110:17,-1:10,110:9,88,110:12,-1:10,110:10,89,110:11,-1:10,110:12,113,110:9" +
",-1:10,110:5,91,110:16,-1:10,110:6,92,110:15,-1:10,110:2,93,110:19,-1:10,11" +
"0:2,63,110:19,-1:10,110:19,64,110:2,-1:10,110:16,65,110:5,-1:10,110:8,94,11" +
"0:13,-1:10,96,110:21,-1:10,110:15,97,110:6,-1:10,110:11,98,110:10,-1:10,110" +
":9,99,110:12,-1:10,110:4,66,110:17,-1:10,110:2,101,110:19,-1:10,110:16,102," +
"110:5,-1:10,110:4,115,110:17,-1:10,110:7,67,110:14,-1:10,110:13,103,110:8,-" +
"1:10,110:11,104,110:10,-1:10,110:6,105,110:15,-1:10,110:9,116,110:12,-1:10," +
"110:2,68,110:19,-1:10,110:11,107,110:10,-1:10,110:19,69,110:2,-1:10,110:2,7" +
"0,110:10,71,110:8,-1:10,110:2,72,110:10,73,110:8,-1:10,110:6,74,75,110:14,-" +
"1:10,120,110:21,-1:10,110:10,90,110:11,-1:10,110:6,95,110:15,-1:10,110:9,10" +
"0,110:12,-1:10,110:6,106,110:15,-1:10,110:11,109,110:10,-1:10,110:14,78,110" +
":7,-1:10,110:5,79,110:16,-1:10,110:9,112,110:12,-1:10,110:8,114,110:13,-1:9");

	public Symbol yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return token(sym.EOF);
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -3:
						break;
					case 3:
						{
	        System.err.println("** Caracter invalido: `" + yytext() + "'");
		return token(sym.ERRO);
	      }
					case -4:
						break;
					case 4:
						{ return token(sym.INTEIRO, yytext()); }
					case -5:
						break;
					case 5:
						{ return token(sym.DOIS_PONTOS); }
					case -6:
						break;
					case 6:
						{ /* ignora brancos */ }
					case -7:
						break;
					case 7:
						{ /* e coment�rios */ }
					case -8:
						break;
					case 8:
						{
			  String s = yytext();
			  return token(sym.STRING, s.substring(1,s.length()-1));
			}
					case -9:
						break;
					case 9:
						{return token(sym.MOD);	}
					case -10:
						break;
					case 10:
						{ return token(sym.SUB); }
					case -11:
						break;
					case 11:
						{ return token(sym.EXP); }
					case -12:
						break;
					case 12:
						{ return token(sym.DIV); }
					case -13:
						break;
					case 13:
						{ return token(sym.MULT); }
					case -14:
						break;
					case 14:
						{ return token(sym.SOMA); }
					case -15:
						break;
					case 15:
						{ return token(sym.CHAMA); }
					case -16:
						break;
					case 16:
						{ return token(sym.SALTA); }
					case -17:
						break;
					case 17:
						{ return token(sym.LOCAIS); }
					case -18:
						break;
					case 18:
						{ return token(sym.SMENOR); }
					case -19:
						break;
					case 19:
						{ return token(sym.SIGUAL); }
					case -20:
						break;
					case 20:
						{ return token(sym.EMPILHA); }
					case -21:
						break;
					case 21:
						{ return token(sym.REGRESSA); }
					case -22:
						break;
					case 22:
						{ return token(sym.COLOCA_ARG); }
					case -23:
						break;
					case 23:
						{ return token(sym.MUDA_LINHA); }
					case -24:
						break;
					case 24:
						{ return token(sym.ATRIBUI_ARG); }
					case -25:
						break;
					case 25:
						{ return token(sym.ATRIBUI_VAR); }
					case -26:
						break;
					case 26:
						{ return token(sym.EMPILHA_ARG); }
					case -27:
						break;
					case 27:
						{ return token(sym.EMPILHA_VAR); }
					case -28:
						break;
					case 28:
						{ return token(sym.ESCREVE_INT); }
					case -29:
						break;
					case 29:
						{ return token(sym.ESCREVE_STR); }
					case -30:
						break;
					case 31:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -31:
						break;
					case 32:
						{
	        System.err.println("** Caracter invalido: `" + yytext() + "'");
		return token(sym.ERRO);
	      }
					case -32:
						break;
					case 34:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -33:
						break;
					case 35:
						{
	        System.err.println("** Caracter invalido: `" + yytext() + "'");
		return token(sym.ERRO);
	      }
					case -34:
						break;
					case 36:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -35:
						break;
					case 37:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -36:
						break;
					case 38:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -37:
						break;
					case 39:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -38:
						break;
					case 40:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -39:
						break;
					case 41:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -40:
						break;
					case 42:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -41:
						break;
					case 43:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -42:
						break;
					case 44:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -43:
						break;
					case 45:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -44:
						break;
					case 46:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -45:
						break;
					case 47:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -46:
						break;
					case 48:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -47:
						break;
					case 49:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -48:
						break;
					case 50:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -49:
						break;
					case 51:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -50:
						break;
					case 52:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -51:
						break;
					case 53:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -52:
						break;
					case 54:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -53:
						break;
					case 55:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -54:
						break;
					case 56:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -55:
						break;
					case 57:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -56:
						break;
					case 58:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -57:
						break;
					case 59:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -58:
						break;
					case 60:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -59:
						break;
					case 61:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -60:
						break;
					case 62:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -61:
						break;
					case 63:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -62:
						break;
					case 64:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -63:
						break;
					case 65:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -64:
						break;
					case 66:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -65:
						break;
					case 67:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -66:
						break;
					case 68:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -67:
						break;
					case 69:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -68:
						break;
					case 70:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -69:
						break;
					case 71:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -70:
						break;
					case 72:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -71:
						break;
					case 73:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -72:
						break;
					case 74:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -73:
						break;
					case 75:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -74:
						break;
					case 76:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -75:
						break;
					case 77:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -76:
						break;
					case 78:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -77:
						break;
					case 79:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -78:
						break;
					case 80:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -79:
						break;
					case 81:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -80:
						break;
					case 82:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -81:
						break;
					case 83:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -82:
						break;
					case 84:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -83:
						break;
					case 85:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -84:
						break;
					case 86:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -85:
						break;
					case 87:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -86:
						break;
					case 88:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -87:
						break;
					case 89:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -88:
						break;
					case 90:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -89:
						break;
					case 91:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -90:
						break;
					case 92:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -91:
						break;
					case 93:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -92:
						break;
					case 94:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -93:
						break;
					case 95:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -94:
						break;
					case 96:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -95:
						break;
					case 97:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -96:
						break;
					case 98:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -97:
						break;
					case 99:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -98:
						break;
					case 100:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -99:
						break;
					case 101:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -100:
						break;
					case 102:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -101:
						break;
					case 103:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -102:
						break;
					case 104:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -103:
						break;
					case 105:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -104:
						break;
					case 106:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -105:
						break;
					case 107:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -106:
						break;
					case 108:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -107:
						break;
					case 109:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -108:
						break;
					case 110:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -109:
						break;
					case 111:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -110:
						break;
					case 112:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -111:
						break;
					case 113:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -112:
						break;
					case 114:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -113:
						break;
					case 115:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -114:
						break;
					case 116:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -115:
						break;
					case 117:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -116:
						break;
					case 118:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -117:
						break;
					case 119:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -118:
						break;
					case 120:
						{ return token(sym.IDENTIFICADOR, yytext()); }
					case -119:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
