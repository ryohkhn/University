import java.util.Scanner;
import java.util.Random;

public class Ex4 {

    public static void question(){
        Random rd=new Random();
        int r1=rd.nextInt(9)+1;
        int r2=rd.nextInt(9)+1;
        Scanner sc=new Scanner(System.in);
        boolean res=false;
        int attempts=0; // variable des tentatives
        System.out.println("Quel est le résulat de "+r1+"*"+r2+" :");
        while(!res){ // boucle while qui ne se termine que si le bon résultat est trouvé
            if(sc.nextInt()!=r1*r2){
                attempts++;
                System.out.println("Mauvaise réponse, ressayez :");
            }
            else{
                if(attempts==0){
                    System.out.println("Félicitations, vous avez trouvé du premier coup !");
                }
                else{
                    System.out.println("Bonne réponse, vous avez fait "+attempts+" tentative(s) !");
                }
                res=true;
            }
        }
    }

    public static void evaluation(int n){
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        int note=n;
        System.out.println("Vous allez donner les réponses de "+n+" multiplications, vous serez ensuite noté sur 20.");
        for(int i=0;i<n;i++){ // boucle for qui va tirer n fois deux nombres aléatoires entre 1 et 9
            int r1=rd.nextInt(9)+1;
            int r2=rd.nextInt(9)+1;
            System.out.println((i+1)+"/ Quel est le résulat de "+r1+"*"+r2+" :");
            if(sc.nextInt()!=r1*r2){ // attente de la réponse avec l'objet Scanner
                note--;
            }
        }
        System.out.println("Vous avez obtenu la note de "+note*20/n+"/20"); // calcul de la note ramenée sur 20
    }
}
