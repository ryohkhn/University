%%
%public
%class Lexer
%unicode
%standalone

%{

%}

motMajToMajMin = [A-Z][a-z]* | [A-Z][A-Z]*
motAl = {mot}al
motInv = {mot}[xsz]
motAuEu = {mot}au | {mot}eu
motAlInv= "bal" | "carnaval" | "festival" | "recital"
motAuEuInv = "bleu" | "pneu"

%{eof

%eof}

%%


{motAuEuInv} {System.out.print(yytext());}
{motAuEu} {System.out.print(yytext()+"x");}
{motAlInv} {System.out.print(yytext()+"s");}
{motAl} {String txt=yytext();
System.out.print(txt.substring(0,txt.length()-1)+"ux");}
{motInv} {System.out.print(yytext());}
{mot} {System.out.print(yytext()+"s");}
