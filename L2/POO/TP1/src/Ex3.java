public class Ex3 {

    // méthode permettant de vérifier si un charatère est bien présent dans un tableau, s'il est présent, il retourne sa position sinon il return -1
    public static int isInArray(char c,char[] tab){
        for(int i=0;i<tab.length;i++){
            if(c==tab[i]) return i;
        }
        return -1;
    }

    public static void Shift(String[] args){
        char[] s={'a','e','i','o','u','y'};
        for(int i=0;i<args.length;i++){
            for(int j=0;j<args[i].length();j++){ // on parcourt les arguments, puis chaque lettre des String
                if(isInArray(args[i].charAt(j),s)!=-1){ // on vérifie si le charactère appartient bien au tableau des voyelles
                    int pos=isInArray(args[i].charAt(j),s);
                    if(pos==5){ // cas ou la voyelle est "y", on doit retourner au début du tableau
                        System.out.print("a");
                    }
                    else{
                        System.out.print(s[pos+1]);
                    }
                }
                else{
                    System.out.print(args[i].charAt(j)); // s'il n'appartient pas au tableau des voyelles on affiche la lettre normalement
                }
            }
            System.out.print(" "); // affiche les espaces entre les mots
        }
    }
}
