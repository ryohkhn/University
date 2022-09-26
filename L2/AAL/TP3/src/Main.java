import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main{

    public static void exemple() {

        System.out.println("--------------------------");
        System.out.println("Exemple:");
        // création d'un automate avec deux états pour a*b+
        Automate a = new Automate(2);
        a.ajouteTransition(0, 0, 'a');
        a.ajouteTransition(0, 1, 'b');
        a.ajouteTransition(1, 1, 'b');
        a.setInitial(0, true);
        a.setAcceptant(1, true);
        
        System.out.println(a);
        System.out.println(a.accepte(""));
        System.out.println(a.accepte("ab"));
        System.out.println(a.accepte("babaa"));
        System.out.println(a.accepte("aaabbb"));
        // l'algorithme d'acceptation est efficace
        System.out.println(
            a.accepte("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        
        System.out.println("--------------------------");
        System.out.println("Test de remplaceAParC:");
        Automate c = remplaceAParC(a); // Donne un automate pour c*b+
        System.out.println(c);
        System.out.println(c);
        System.out.println(c.accepte("ab"));
        System.out.println(c.accepte("cb"));
        System.out.println(c.accepte("cab"));
        System.out.println(c.accepte("ccbbb"));
        
    }

    // Exemple:
    // remplace les 'a' par des 'c' dans toutes les transitions de l'automate a1
    public static Automate remplaceAParC(Automate a1){
        Automate a2 = new Automate(a1.nbEtats());

        for (int i = 0; i < a1.nbEtats(); ++i){
            Etat e = a1.getEtat(i);
            
            // On copie les états initiaux / acceptants
            a2.setInitial(i, e.estInitial);
            a2.setAcceptant(i, e.estAcceptant);

            // On copie les transitions
            for (char c: e.alphabet()) {
                for (int id: e.succ(c)) {
                    if (c == 'a')
                        // Si la transition est étiquetée par un 'a', on remplace par la même avec 'c'
                        a2.ajouteTransition(e.getId(), id, 'c');
                    else
                        a2.ajouteTransition(e.getId(), id, c);
                }
            }
        }

        return a2;
    }

    // Calcul de l'automate reconnaissant le miroir de a1 
    public static Automate automateMiroir(Automate a1) {
        Automate a2=new Automate(a1.nbEtats());

        for(int i=0; i<a1.nbEtats(); i++){
            Etat e=a1.getEtat(i);

            if(e.estInitial){
                a2.setAcceptant(i,true);
            }
            if(e.estAcceptant){
                a2.setInitial(i,true);
            }

            for(char c:e.alphabet()){
                for(int id:e.succ(c)){
                    a2.ajouteTransition(id, e.getId(), c);
                }
            }
        }
        return a2;
    }

    public static void testMiroir() {
        System.out.println("--------------------------");
        System.out.println("Test de l'automate miroir:");

        Automate a=new Automate(4);
        a.ajouteTransition(0, 1, 'a');
        a.ajouteTransition(1, 2, 'b');
        a.ajouteTransition(2, 3, 'c');
        a.setInitial(0, true);
        a.setAcceptant(3, true);

        Automate c=automateMiroir(a);
        System.out.println(c);
        System.out.println(c.accepte("abc"));
        System.out.println(c.accepte("cba"));
        System.out.println(c.accepte("cb"));
    }

    // Calcul d'un automate correspondant à l'automate a1 complété 
    public static Automate automateComplete(Automate a1) {
        if(a1.estComplet()) return a1;

        Automate a2=new Automate(a1.nbEtats()+1);

        for(int i=0; i<a1.nbEtats(); i++){
            Etat e=a1.getEtat(i);

            a2.setInitial(i, e.estInitial);
            a2.setAcceptant(i, e.estAcceptant);

            for(char c:a1.alphabet()){
                if(e.succ(c)==null){
                    a2.ajouteTransition(e.getId(), a1.nbEtats(), c);
                }
                a2.ajouteTransition(a1.nbEtats(),a1.nbEtats(),c);
            }
            for(char c:e.alphabet()){
                for(int id:e.succ(c)){
                    a2.ajouteTransition(e.getId(), id, c);
                }
            }
        }
        return a2;
    }

    public static void testComplete() {
        System.out.println("--------------------------");
        System.out.println("Test de l'automate complété:");

        Automate a=new Automate(4);
        a.ajouteTransition(0, 1, 'a');
        a.ajouteTransition(1, 2, 'b');
        a.ajouteTransition(2, 3, 'c');
        a.setInitial(0, true);
        a.setAcceptant(3, true);

        Automate c=automateComplete(a);
        System.out.println(c);
        System.out.println(c.accepte("abc"));
        System.out.println(c.accepte("abcab"));
        System.out.println(c.accepte("cb"));
    }

    /********** Déterminisation **********/
    public static int ensembleVersEntier(Set<Integer> s) {
        List<Integer> temp=new ArrayList<>();
        int res=0;
        int compt=0;
        for(int i:s){
            res+=i;
        }
        while(res>0){
            temp.add(res%2);
            res/=2;
        }
        for(int j=temp.size(); j>0; j--){

            compt++;
        }
        return res;
    }

    public static Set<Integer> entierVersEnsemble(int i) {
        return null;
    }

    // Calcul de l'automate déterministe correspondant à l'automate a1 
    public static Automate automateDeterministe(Automate a1) {
        // TODO !
        return new Automate(0);
    }

    public static void testDeterministe() {
        System.out.println("--------------------------");
        System.out.println("Test de l'automate déterministe:");

    }

    /********** Complémentaire **********/
    // Calcul de l'automate complémentaire de l'automate a1 
    public static Automate automateComplementaire(Automate a1) {
        // TODO !
        return new Automate(0);
    }

    public static void testComplementaire() {
        System.out.println("--------------------------");
        System.out.println("Test de l'automate complémentaire:");
        System.out.println("A faire !");
    }

    /********** Automate Produit **********/
    // Calcul de l'automate produit de a1 et a2 
    public static Automate automateProduit(Automate a1, Automate a2) {
        // TODO !
        return new Automate(0);
    }

    /********** Intersection **********/
    // Calcul de l'automate reconnaissant l'intersection de L(a1) et L(a2) 
    public static Automate automateIntersection(Automate a1, Automate a2) {
        // TODO !
        return new Automate(0);
    }

    public static void testIntersection() {
        System.out.println("--------------------------");
        System.out.println("Test de l'automate intersection:");
        System.out.println("A faire !");
    }

    public static void main(String[] args){
        //exemple();
        // Pensez à tester vos fonctions !
        //testMiroir();
        testComplete();
        //testDeterministe();
        //testComplementaire();
        //testIntersection();
    }
}
