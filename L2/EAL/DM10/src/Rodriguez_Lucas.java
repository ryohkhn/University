import java.util.LinkedList;

public class Rodriguez_Lucas{

    public static LinkedList<Couple> trasfBinGen(Arbre arbreBinaire){
        // liste résultat de couple (valeur, nombre d'enfant)
        LinkedList<Couple> res=new LinkedList<>();
        // noeud courant et temporaire
        Noeud courant,tmp;
        // on prend le noeud courant et on crée le compteur pour le nombre d'enfants
        courant=arbreBinaire.racine;
        int compt=0;
        // si le noeud gauche n'est pas nul on compte le nombre d'enfant
        if(courant.gauche!=null){
            tmp=courant.gauche;
            compt++;
            while(tmp.droit!=null){
                tmp=tmp.droit;
                compt++;
            }
        }
        // on push le couple (valeur, nombre d'enfant) dans la liste
        res.push(new Couple(courant.valeur,compt));
        // ensuite parcours préfixe basique sur le reste de l'arbre, on concatène ainsi les listes avec la liste résultante
        if(courant.gauche!=null){
            res.addAll(trasfBinGen(new Arbre(courant.gauche)));
        }
        if(courant.droit!=null){
            res.addAll(trasfBinGen(new Arbre(courant.droit)));
        }
        return res;
    }
}
