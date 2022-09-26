%%
%public
%class Lexer
%unicode
%standalone

%{
public int count = 0;
public int countTotal=0;
%}

chiffre = [0-9]
signe = "+" | "-"
nombre = {chiffre}+ | {signe}{chiffre}+

%{eof
	System.out.println("Nombre de chiffres = "+ count);
	System.out.println("Sommme de chiffres = "+ countTotal);
	if(count!=0){
	System.out.println("Moyenne : "+countTotal/count);
	}

%eof}

%%
{nombre}     {count++;countTotal+=Integer.parseInt(yytext());}
[^]          {}
