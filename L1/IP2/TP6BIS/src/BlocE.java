public class BlocE {
    private  int  adresse_retour;
    private  int  argument;
    private  int  valeur_retour;

    public  BlocE(int adr , int  arg){
        this.adresse_retour = adr;
        this.argument = arg;
    }
    int  getVal (){
        return  this.valeur_retour;
    }
    public  int  getAdr () {
        return this.adresse_retour;
    }
    public  int  getArg (){
        return  this.argument;
    }
    public  void  setVal(int v) {
        this.valeur_retour = v;
    }
}
