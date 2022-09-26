%%
%public
%class Lexer  //générera le fichier Lexer.java
%unicode
%standalone


%{
//éventuellement code java qui sera recopié au début de du lexer généré

    public int compteBlabla = 0;
    public int compt=0;
    public int div=0;
%}

//définition d'expressions régulières

moustique = z+


%{eof
   //éventuellement code java qui sera recopié en fin du lexer généré
   //System.out.println("\n nombre de blabla = "+ compteBlabla);
   if(div!=0){
   System.out.println("Moyenne de longueur d'apparition de la lettre 'z': " + compt/div);
   }else{
   System.out.println("Aucun moustique");
   }

%eof}

%%

//les règles:

bla(bla)+      {compteBlabla++;System.out.println(yytext()+" : "+compteBlabla);}
{moustique}    {System.out.println("il y a un moustique!");compt+=yylength();div++;}
[^]            {System.out.println("coucou");}
