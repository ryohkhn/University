public class Mediane {

    public static int compteInf(int[] t, int x){
        // compteur pour le nombre de valeurs inférieures à la médiane
        int compt=0;

        for(int i=0;i<t.length;i++){
            if(t[i]<x){
                compt++;
            }
        }
        return compt;
    }

    // fonction bouléenne permettant de vérifier qu'une valeur est bien dans le tableau

    public static boolean isInArray(int x, int[] tab){
        for(int i=0;i<tab.length;i++){
            if(tab[i]==x){
                return true;
            }
        }
        return false;
    }

    /* la valeur de la médiane est initialisée à 0 puis est incrémentée tant que la fonction compteInf() ne donne pas un résultat qui vérifie (n-1)/2
    la valeur de médiane supposée est ensuite vérifiée par isInArray() pour être sur qu'elle est bien dans le tableau, sinon elle est incrémentée
    comme on est sur d'avoir n éléments impairs et distinct dans le tableau, on trouvera la valeur réelle de la médiane avec la boule while
    */

    public static int algo(int[] t){
        int mediane=0;
        while(compteInf(t,mediane)!=(t.length-1)/2){
            mediane++;
        }
        while(!isInArray(mediane,t)){
            mediane++;
        }
        return mediane;
    }

}
