%%
%public
%class Lexer
%unicode
%standalone

%{
public int count = 0;
public Double countTotal=0.0;
%}

chiffre = [0-9]
signe = "" | "-"
flottant = "." | ""
nombre = {signe}{chiffre}*{flottant}{chiffre}*

%{eof
	System.out.println("Nombre de flottants = "+ count);
	System.out.println("Sommme de flottants = "+ countTotal);
	if(count!=0){
	System.out.println("Moyenne : "+countTotal/count);
	}

%eof}

%%
{nombre}     {count++;countTotal+=Double.parseDouble(yytext());}
[^]          {}
