%class Lexer  //générera le fichier Lexer.java
%unicode
%standalone


%{
//éventuellement code java qui sera recopié au début de du lexer généré

    public int compteBlabla = 0;
    public int compteZ = 0;
    public int longueurZ = 0;

%}

//définition d'expressions régulières

moustique = z+


%{eof
   //éventuellement code java qui sera recopié en fin du lexer généré

  System.out.println("\n nombre de blabla = "+ compteBlabla);
  System.out.println(" moyenne des Z = "+longueurZ/compteZ);
  
%eof}

%%

//les règles:

bla(bla)+      {compteBlabla++;System.out.println(yytext()+":"+compteBlabla);}
{moustique}    {System.out.println("il y a un moustique!");longueurZ+=yylength();compteZ++;}
[^] {}
