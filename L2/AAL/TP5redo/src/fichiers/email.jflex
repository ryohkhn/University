%%
%public
%class Lexer
%unicode
%standalone

%{

%}

accent = "." | "-" | "_" | ""
mot = {accent}[a-zA-Z]+{accent}[a-zA-Z]+{accent}
res = [a-zA-Z]+{mot}+[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+

%{eof

%eof}

%%
{res} {System.out.println(yytext());}
[^] {}