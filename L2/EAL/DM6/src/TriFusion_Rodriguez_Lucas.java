public class TriFusion_Rodriguez_Lucas{
    public static int[] fusion(int[] tab1,int[] tab2){
        int[] res=new int[tab1.length+tab2.length];

        int i=0; // valeur d'index du permier tableau
        int j=0; // valeur d'index du deuxième tableau
        int k=0; // valeur d'index du tableau résultat
        while(i<tab1.length && j<tab2.length){
            // on compare les valeurs une à une entre les deux tableaux et on attribue la valeur la plus petite dans le nouveau tableau
            if(tab1[i]<tab2[j]){
                res[k]=tab1[i];
                i++;
            }else{
                res[k]=tab2[j];
                j++;
            }
            k++;
        }
        // si jamais le premier tableau est plus grand que le deuxième
        while(i<tab1.length){
            res[k]=tab1[i];
            i++; k++;
        }
        // si jamais le deuxième tableau est plus grand que le premier
        while(j< tab2.length){
            res[k]=tab2[j];
            j++; k++;
        }
        return res;
    }

    public static int[] triFusion(int[] tab){
        // inutile de faire triFusion si le tableau ne contient que 1 valeur
        if(tab.length<=1){
            return tab;
        }
        // on crée deux tableaux, le premier contenant la moitié des valeurs du tableau en argument et le deuxième le reste du tableau.
        int[] temp=new int[tab.length/2];
        int[] temp2=new int[(tab.length)-(tab.length/2)];
        // fonction pour remplir le premier tableau
        for(int i=0;i<tab.length/2;i++){
            temp[i]=tab[i];
        }
        int index=0;
        // fonction pour remplir le deuxième tableau
        for(int j=tab.length/2;j<tab.length;j++){
            temp2[index]=tab[j];
            index++;
        }
        return fusion(triFusion(temp),triFusion(temp2));
    }

    /*
    Soit T un tableau de longueur t.
    On montre par induction que la fonction triFusion(T) renvoie un tableau trié.

    Cas de base:
    Si t<=1 alors le tableau T ne contient qu'une seule valeur, la fonction triFusion retourne un tableau trié.

    Cas inductif:
    Supposons que la propriété est vraie pour t<=k pour k>=0.
    On montre que la propriété est aussi vraie pour t=k+1;

    triFusion(T) retourne donc fusion(triFusion(L),triFusion(R)), or L=[1,n/2] et R=[n/2+1,n]
    On sait que triFusion(L) est plus petit que k, n/2<k.
    Par notre hypothèse d'induction, le résultat de triFusion(L) et triFusion(R) sont tous les deux triés, car tous
    les deux présents dans [1,k].
    Donc l'hypothèse est vraie pour t=k+1, le tableau est bien trié.
    */
}
