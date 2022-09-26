%%
%public
%class Lexer
%unicode
%standalone

%{

%}

accent = "." | "?" | "!"
mot = [A-Z][a-z]+ | [a-z]+
coupageMot = " " | "," | ""
phrase = {coupageMot}{mot}{coupageMot}{mot}{coupageMot}
phraseAccent = {phrase}+{accent}

%{eof

%eof}

%%
{phraseAccent} {System.out.print(yytext()+"\n");}
[^] {}
