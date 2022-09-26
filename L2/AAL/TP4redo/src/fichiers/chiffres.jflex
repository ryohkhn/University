%%
%public
%class Lexer
%unicode
%standalone

%{
public int count = 0;
public int somme =0;
%}

chiffre = [0-9]

%{eof
	System.out.println("nbre de chiffres = "+ count);
	System.out.println("somme de chiffres = "+ somme);
%eof}

%%
{chiffre}     {count++;somme+=Integer.parseInt(yytext());}
[^]           {}
