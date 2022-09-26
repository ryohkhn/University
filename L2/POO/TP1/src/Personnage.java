import java.util.Random;

public class Personnage {

    // le nom et les informationis initial sont en final, selon moi ces valeurs ne devraient pas changer
    private final String nom;
    private final Informations initial;
    private Informations actuel;

    public Personnage(String nom){
        this.nom=nom;
        initial=new Informations(100,20,15);
        actuel=new Informations(initial);
    }

    public Informations getActuel(){
        return actuel;
    }

    // on utilise la fonction toString de la class Informations pour compléter ce toString
    public String toString(){
        return (this.nom+":\n"+actuel.toString());
    }

    public boolean estVivant(){
        if(actuel.getVitalite()>0) return true;
        return false;
    }

    public void rebirth(){
        actuel.setAgilite(initial.getAgilite());
        actuel.setForce(initial.getForce());
        actuel.setVitalite(initial.getVitalite());
    }

    public void attaque(Personnage def){
        Random rd=new Random();
        // ici, l'énoncé a un problème. Si jamais la force du joueur actuel et celle du défenseur est la même, alors le max sera 1 donc l'attaque sera de 1.
        // Si le max est 1 et que leur agilité est la même, l'attaque est donc divisée par 2 ce qui signifie une attaque de 0,5. Sauf que cette attaque est impossible car on utilise des entiers(imposé par l'énoncé)
        int max=Math.max(2,this.actuel.getForce()-def.actuel.getForce());
        int n= rd.nextInt(max)+1;

        // affichage de quel personnage attaque quel personnage, ainsi que le test de l'agilité
        System.out.println(this.nom+" attaque "+def.nom);
        if(def.actuel.getAgilite()<this.actuel.getAgilite()){
            def.actuel.setVitalite(def.actuel.getVitalite()-n);
            System.out.println("Il fait perdre "+n+" point(s) de vitalité à "+def.nom);
        }
        // cas ou l'agilité de l'attaquant est supérieure
        else{
            System.out.println("Il fait perdre "+n/2+" point(s) de vitalité à "+def.nom);
            def.actuel.setVitalite(def.actuel.getVitalite()-(n/2));
            System.out.println("Il fait perdre "+(def.actuel.getAgilite()/3)+" point(s) d'agilité à "+def.nom);
            def.actuel.setAgilite(def.actuel.getAgilite()-(def.actuel.getAgilite()/3));
            System.out.println("Il lui reste "+def.getActuel().getAgilite()+" point(s) d'agilité");
        }
        System.out.println("Il lui reste "+def.getActuel().getVitalite()+" point(s) de vie");
        System.out.println();
    }

    public void lutteIter(Personnage p2){
        if(!this.estVivant() || !p2.estVivant()) return; // on return directement s'il un des deux personnages est déjà mort
        boolean alivep1=true;
        boolean alivep2=true;

        while(alivep1 && alivep2){ // boucle while qui tourne tant que l'un des deux personnages n'est pas mort
            this.attaque(p2);
            if(p2.estVivant()){ // test de vitalité du personnage p2 après l'attaque, s'il est vivant il riposte
               p2.attaque(this);
               if(!this.estVivant()){
                   alivep1=false;
               }
            }
            else{
                alivep2=false;
            }
        }

        if(!alivep1) System.out.println(p2.nom + " a tué " + this.nom); // print pour informer qui a gagné le combat
        else System.out.println(this.nom + " a tué " + p2.nom);
    }


    public void lutteRec(Personnage p2){
        if(!this.estVivant() || !p2.estVivant()) return; // on return directement s'il un des deux personnages est déjà mort
        this.attaque(p2);
        if(!p2.estVivant()){ // test de vitalité du personnage p2 après l'attaque
            System.out.println(this.nom + " a tué " + p2.nom);
            return;
        }
        p2.attaque(this);
        if(!this.estVivant()){ // test de vitalité du personnage this après l'attaque
            System.out.println(p2.nom + " a tué " + this.nom);
            return;
        }
        lutteRec(p2);
    }
}
