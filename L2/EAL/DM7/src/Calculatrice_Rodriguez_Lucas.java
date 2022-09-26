import java.util.ArrayList;
import java.util.LinkedList;

public class Calculatrice_Rodriguez_Lucas{
    /*
    1.
    (a) 12-3-
    (b) 123--
    (c) 12*34*+
    (d) 123*-4+
     */

    // fonction prenant en argument une liste de nombres et d'opérandes représentant une expression en RPN et retourne sa valeur
    public int rpnListToInt(ArrayList<String> rpnExpr){
        LinkedList<String> res=new LinkedList<>();
        String val1; // première valeur récupérée lorsque l'on dépile
        String val2; // seconde valeur récupérée
        String tmpPush; // valeur calculée dans le cas d'une opération
        while(!rpnExpr.isEmpty()){
            // on récupère la première valeur de l'expresion postfixe et on la retire de la liste
            String tmp=rpnExpr.get(0);
            rpnExpr.remove(0);
            switch(tmp){
                // cas des opérateurs
                case "+", "-", "/", "*" -> {
                    // si la taille de la pile est inférieure à deux lors d'une opération alors il y'a eu une erreur d'expression
                    if(res.size()<2){
                        error();
                        return 0;
                    }
                    val1=res.pop();
                    val2=res.pop();
                    // si une des deux valeurs récupérées dans la pile n'est pas un entier alors l'expression contient une erreur
                    if(!isInteger(val1) || !isInteger(val2)){
                        error();
                        return 0;
                    }
                    // switch qui traite chaque opérateur et effectue le calcul pour le stocker dans la variable temporaire
                    tmpPush=switch(tmp){
                        case "+" -> String.valueOf(Integer.parseInt(val2)+Integer.parseInt(val1));
                        case "-" -> String.valueOf(Integer.parseInt(val2)-Integer.parseInt(val1));
                        case "/" -> String.valueOf(Integer.parseInt(val2)/Integer.parseInt(val1));
                        default -> String.valueOf(Integer.parseInt(val2)*Integer.parseInt(val1));
                    };
                    // on push le résultat du calcul dans la pile
                    res.push(tmpPush);
                }
                default -> {
                    // cas ou il s'agit pas d'un opérateur
                    // on vérifie qu'il s'agit bien d'un entier, sinon, il y'a une erreur d'expression
                    if(isInteger(tmp)){
                        // on push l'entier si c'en est bien un
                        res.push(tmp);
                    }
                    else{
                        error();
                        return 0;
                    }
                }
            }
        }
        // on retourne la valeur calculée de la pile et on dépile
        return Integer.parseInt(res.pop());
    }

    // calculatrice qui prend en argument une expression postfixe
    public void calculer(String rpn){
        ArrayList<String> expr=new ArrayList<>();
        // on ajoute les String contenant les nombres et opérateurs à la liste
        for(int i=0;i<rpn.length();i++){
            expr.add(Character.toString(rpn.charAt(i)));
        }
        System.out.println("Expression RPN: "+rpn);
        System.out.println("Expression calculée "+ this.rpnListToInt(expr));
    }

    // fonction booléenne vérifiant si un String est bien un entier via la fonction parseInt
    public boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public void error(){
        System.out.println("Expression incorrecte");
    }
}
