import java.util.LinkedList;
import java.util.Stack;

public class Npr_Rodriguez_Lucas{

    public static Arbre nprToTree(LinkedList<String> nprExpr){
        // pile de noeud
        Stack<Noeud> stack=new Stack<>();
        Noeud droitTmp;
        Noeud gaucheTmp;
        for(String s:nprExpr){
            // si c'est un opérateur on ajoute à la pile un noeud contenant la valeur
            if(isInteger(s)){
                stack.push(new Noeud(s));
            }
            // sinon dans le cas d'un opérateur on pop les deux noeuds et on push un nouveau noeud contenant l'opérateur et les deux noeuds récupérés en tant que fils
            else{
                droitTmp=stack.pop();
                gaucheTmp=stack.pop();
                stack.push(new Noeud(s,droitTmp,gaucheTmp));
            }
        }
        // on retourne l'arbre, si l'expression est bonne la pile ne contient plus qu'un noeud qui est le racine de l'arbre
        return new Arbre(stack.pop());
    }

    public static String treeToExpr(Noeud n){
        String res="";
        // si c'est un opérateur on ouvre une parenthèse
        if(!isInteger(n.value)){
            res+="(";
        }
        // parcourt infixe sur le reste de l'arbre
        if(n.gauche!=null){
            res+=treeToExpr(n.gauche);
        }
        res+=n.value;
        if(n.droit!=null){
            res+=treeToExpr(n.droit);
        }
        // si c'est un opérateur on ferme la parenthèse
        if(!isInteger(n.value)){
            res+=")";
        }
        return res;
    }

    // fonction booléenne vérifiant si un String est bien un entier via la fonction parseInt
    public static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
