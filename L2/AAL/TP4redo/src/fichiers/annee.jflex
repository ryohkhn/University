%%
%public
%class Lexer
%unicode
%standalone
%line
%column

%{
public double count = 0;
public double somme =0;
%}

annee = [0-9][0-9][0-9][0-9]

%{eof
%eof}

%%
{annee}     {System.out.println("Ligne: "+yyline+" Position: "+yycolumn+" Année:"+yytext());}
[^]           {}
