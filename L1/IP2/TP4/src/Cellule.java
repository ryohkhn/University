public class Cellule {
    private Robot rob;
    private Cellule suivant;

    public Cellule(Robot rob, Cellule suivant){
        this.rob=rob;
        this.suivant=suivant;
    }

    public Cellule(Robot rob){
        this(rob,null);
    }

    public Robot getRob() {
        return rob;
    }

    public Cellule getSuivant() {
        return suivant;
    }

    public void affiche(){
        Cellule tmp=this;
        while (tmp!=null){
            System.out.println(tmp.rob.description());
            tmp=tmp.suivant;
        }
    }

    public void ajouteNouveau(Robot r){
        Cellule tmp=this;
        while(tmp.suivant!=null){
            tmp=tmp.suivant;
        }
        tmp.suivant=new Cellule(r);
    }

    public int numerologie(){
        Cellule tmp=this;
        int res = 0;
        while(tmp!=null){
            res+=tmp.rob.getNom()-'a'+1;
            tmp=tmp.suivant;
        }
        return res%9;
    }

    public String bandName(){
        Cellule tmp=this;
        String res="";
        while(tmp!=null){
            res+=tmp.rob.getNom();
            tmp=tmp.suivant;
        }
        return res;
    }

    public void chantez(){
        Cellule tmp=this;
        while(tmp!=null){
            tmp.rob.chante();
            System.out.println();
            tmp=tmp.suivant;
        }
    }

    public Groupe couperAPartirDe(char nom){
        Cellule tmp=this;
        while(tmp.rob.getNom()!=nom){
            tmp=tmp.suivant;
        }
        if(tmp==null){
            return null;
        }
        Groupe res=new Groupe(tmp);
        tmp.suivant=null;
        return res;
    }

    public Groupe prendePause(){
        Cellule tmp=this;
        Cellule finres=null;
        Cellule fin=null;
        Groupe end=null;
        Groupe res=null;
        while(tmp!=null){
            if(tmp.rob.getEnergie()==0){
                if(end==null){
                    end=new Groupe(tmp);
                    fin=end.getChefDeFile();
                }
                else {
                    fin.suivant=tmp;
                    fin=fin.suivant;
                }
            }
            else{
                if(res==null){
                    res=new Groupe(tmp);
                    finres=res.getChefDeFile();
                }
                else{
                    finres.suivant=tmp;
                    finres=finres.suivant;
                }
            }
            tmp=tmp.suivant;
        }
        this.rob=res.getChefDeFile().getRob();
        this.suivant=res.getChefDeFile().suivant;
        return end;
    }

    public int effectifs(){
        Cellule tmp=this;
        int res=0;
        while(tmp!=null) {
            res++;
            tmp = tmp.suivant;
        }
        return res;
    }
}
