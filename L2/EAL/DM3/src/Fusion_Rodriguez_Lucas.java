public class Fusion_Rodriguez_Lucas {

    public static int[] fusion(int[] tab){
        int[] res=new int[tab.length];
        int m=1;

        // on compare la case actuelle avec celle d'avant pour trouver l'index du deuxième tableau trié
        while(m<tab.length && tab[m]>tab[m-1]){
            m++;
        }

        int i=0; // valeur d'index du permier tableau
        int j=m; // valeur d'index du deuxième tableau
        int k=0; // valeur d'index du tableau résultat
        while(i<m && j<tab.length){
            // on compare les valeurs une à une entre les deux tableaux et on attribue la valeur la plus petite dans le nouveau tableau
            if(tab[i]<tab[j]){
                res[k]=tab[i];
                i++;
            }else{
                res[k]=tab[j];
                j++;
            }
            k++;
        }
        // si jamais le premier tableau est plus grand que le deuxième
        while(i<m){
            res[k]=tab[i];
            i++; k++;
        }
        // si jamais le deuxième tableau est plus grand que le premier
        while(j< tab.length){
            res[k]=tab[j];
            j++; k++;
        }
        return res;
    }

    // n=tab.length
    // Pour trouver l'index du deuxième tableau, dans le pire des cas on a n comparaisons
    // Dans le cas ou on a n comparaisons alors le tableau final est déjà trié
    // Le reste de la fonction effectue une comparaison pour chaque attribution dans le tableau résultant
    // Le nombre d'occurences est donc de n dans le pire des cas
}
