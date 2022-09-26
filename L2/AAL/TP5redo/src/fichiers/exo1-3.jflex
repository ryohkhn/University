%%
%public
%class Lexer
%unicode
%standalone

%{

%}

voyelle = [aeiouy]
consonne = [bcdfghjklmnpqrstvwxz]
mot = [A-Z]*[a-z]+ | [a-z]+
motCon = [A-Z]*[a-z]+{consonne}{consonne}[a-z]+
motVoy = [A-Z]*[a-z]+{voyelle}{voyelle}[a-z]+
motFin= {motCon} | {motVoy}

%{eof

%eof}

%%
{motFin} {}
{mot} {System.out.println(yytext());}
[^] {}