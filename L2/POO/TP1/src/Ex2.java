public class Ex2{

    public static void affiche(int[] t){
        for(int i : t) {
            System.out.println(i);
        }
    }

    public static int[] multiplication(int[] t1, int[] t2){
        int max = Math.max(t1.length,t2.length); // détermine le tableau le plus grand et stocke sa valeur
        int[] t3=new int[max]; // nouveau tableau
        for(int i=0;i<max;i++) {
            if(i>t1.length-1){ // cas ou le premier tableau est plus petit que le deuxième, on ne prend donc pas en compte le tableau dans la multiplication
                t3[i]=t2[i];
            }
            else if(i>t2.length-1){ // cas ou le deuxième tableau est plus petit que le premier, on ne prend donc pas en compte le tableau dans la multiplication
                t3[i]=t1[i];
            }
            else{
                t3[i] = t1[i] * t2[i]; // cas ou les deux tableaux ont encore des valeurs au rang i
            }
        }
        return t3;
    }

    public static int[] split(int[] t){
        String s=""; // String qui stocke chaque entier un par un
        for(int i=0;i<t.length;i++){
            s+=String.valueOf(t[i]);
        }
        int[] res= new int[s.length()]; // création du tableau de la longueur du string
        for(int i=0;i<res.length;i++){
            res[i]=Character.getNumericValue(s.charAt(i)); // on parcourt le tableau en remplissant chaque case par un chiffre du string
        }
        return res;
    }
}
