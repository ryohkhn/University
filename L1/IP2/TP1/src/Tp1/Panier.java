package Tp1;

import static Tp1.Fruit.hybridation;

public class Panier {
    Fruit [] f;

    public Panier(Fruit [] f){
        this.f=f;
    }

    public Panier(){
        this.f=new Fruit[0];
    }

    public Panier(Fruit f,Panier p){
        this.f=new Fruit[p.f.length+1];
        for(int i=0;i<p.f.length;i++) {
            this.f[i] = p.f[i];
        }
        this.f[this.f.length-1]=f;
    }

    public static void afficher(Panier p){
        for(int i=0;i<p.f.length;i++){
            Fruit.afficher(p.f[i]);
        }
    }

    public static Panier hybridePanier(Fruit f, Panier p){
        for(int i=0;i<p.f.length;i++){
            p.f[i]=Fruit.hybridation(f,p.f[i]);
        }
        return p;
    }
}
