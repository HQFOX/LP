import java_cup.runtime.Symbol;

%%

%char
%line
%type Symbol

%{
  private Symbol token(int id, Object value) {
    return new Symbol(id, yychar, yyline, value);
  }

  private Symbol token(int id) {
    return token(id, yytext());
  }
%}

%eofval{
  return token(sym.EOF);
%eofval}

%%

chama			{ return token(sym.CHAMA); }
locais			{ return token(sym.LOCAIS); }
regressa			{ return token(sym.REGRESSA); }
coloca_arg			{ return token(sym.COLOCA_ARG); }

empilha_var		{ return token(sym.EMPILHA_VAR); }
empilha_arg		{ return token(sym.EMPILHA_ARG); }
empilha		{ return token(sym.EMPILHA); }

atribui_var		{ return token(sym.ATRIBUI_VAR); }
atribui_arg		{ return token(sym.ATRIBUI_ARG); }

soma			{ return token(sym.SOMA); }
sub			{ return token(sym.SUB); }
mult			{ return token(sym.MULT); }
div			{ return token(sym.DIV); }
mod				{return token(sym.MOD);	}
exp			{ return token(sym.EXP); }

sigual			{ return token(sym.SIGUAL); }
smenor			{ return token(sym.SMENOR); }
salta			{ return token(sym.SALTA); }

escreve_int			{ return token(sym.ESCREVE_INT); }
escreve_str			{ return token(sym.ESCREVE_STR); }
muda_linha			{ return token(sym.MUDA_LINHA); }

[a-zA-Z][a-zA-Z0-9_]*	{ return token(sym.IDENTIFICADOR, yytext()); }

:			{ return token(sym.DOIS_PONTOS); }

-?[0-9]+		{ return token(sym.INTEIRO, yytext()); }
\"(\\[\\\"]|[^\"\\])*\"	{
			  String s = yytext();

			  return token(sym.STRING, s.substring(1,s.length()-1));
			}

[\ \n\t]		{ /* ignora brancos */ }

#.*			{ /* e comentários */ }

.	      {
	        System.err.println("** Caracter invalido: `" + yytext() + "'");

		return token(sym.ERRO);
	      }
