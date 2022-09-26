%%
%public
%class Lexer
%unicode
%standalone

%{

%}

mot = [A-Z][a-z]+ | [A-Z][A-Z]+
motAl = {mot}al
motInv = {mot}[xsz]
motAuEu = {mot}au | {mot}eu
motAlInv= "bal" | "carnaval" | "festival" | "recital"
motAuEuInv = "bleu" | "pneu"

%{eof

%eof}

%%
{mot} {System.out.print(yytext()+"\n");}
[^] {}
