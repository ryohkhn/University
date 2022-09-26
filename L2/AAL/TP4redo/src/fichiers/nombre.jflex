%%
%public
%class Lexer
%unicode
%standalone

%{
public double count = 0;
public double somme =0;
%}

nombre = [0-9]
signe = "" | "-"
flottant= "." | ""
nombreNeg =  {signe}{nombre}*{flottant}{nombre}*

%{eof
	System.out.println("nbre d'entiers = "+ count);
	System.out.println("somme d'entiers = "+ somme);
%eof}

%%
{nombreNeg}     {count++;somme+=Double.parseDouble(yytext());}
[^]           {}
