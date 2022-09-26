%%
%public
%class Lexer
%unicode
%standalone

%{

%}

motMajToMajMin = [A-Z][a-z]* | [A-Z][A-Z]*

%{eof

%eof}

%%

{motMajToMajMin} {System.out.println(yytext());}
