import static java.lang.Integer.max;

public class Personne {
    private String prenom;
    private String nomDeFamille;
    private Personne mere, pere;

    public Personne(String prenom,String nomDeFamille){
        this.prenom=prenom;
        this.nomDeFamille=nomDeFamille;
        this.mere=null;
        this.pere=null;
    }

    public Personne(String prenom,String nomDeFamille,Personne mere,Personne pere){
        this.prenom=prenom;
        this.nomDeFamille=nomDeFamille;
        this.mere=mere;
        this.pere=pere;
    }

    public boolean estFrereOuSoeur(Personne p){
        if(p==null || this.pere==null || this.mere==null || p==this){
            return false;
        }
        return (this.pere==p.pere && this.mere==p.mere);
    }

    public boolean estCousinGermain(Personne p){
        if(p==null || p==this){
            return false;
        }
        if(this.pere==null && this.mere!=null){
            return (this.mere.estFrereOuSoeur(p.mere) || this.mere.estFrereOuSoeur(p.pere));
        }
        if(this.pere!=null && this.mere==null){
            return (this.pere.estFrereOuSoeur(p.mere) || this.pere.estFrereOuSoeur(p.pere));
        }
        return (this.pere.estFrereOuSoeur(p.pere) || this.mere.estFrereOuSoeur(p.mere) || this.pere.estFrereOuSoeur(p.mere) || this.mere.estFrereOuSoeur(p.pere));
    }

    public int nbAscendantsVivants(){
        int ascMere=0;
        int ascPere=0;
        if(this.mere!=null){
            ascMere=this.mere.nbAscendantsVivants();
        }
        if(this.pere!=null){
            ascPere=this.pere.nbAscendantsVivants();
        }
        return 1+ascMere+ascPere;
    }

    public boolean possedeCommeAscendant(Personne p){
        if(p==this){
            return true;
        }
        if(this.mere==null && this.pere==null){
            return false;
        }
        if(this.mere==null && this.pere!=null){
            return this.pere.possedeCommeAscendant(p);
        }
        if(this.pere==null && this.mere!=null){
            return this.mere.possedeCommeAscendant(p);
        }
        return this.pere.possedeCommeAscendant(p) || this.mere.possedeCommeAscendant(p);
    }

    public int distanceDAscendanceAux(Personne p){
        int dm=0;
        int dp=0;
        if(p==this){
            return 0;
        }
        if(!this.possedeCommeAscendant(p)){
            return -1;
        }
        if(this.pere!=null){
           dp=this.pere.distanceDAscendanceAux(p);
        }
        if(this.mere!=null){
            dm=this.mere.distanceDAscendanceAux(p);
        }
        return 1+max(dp,dm);
    }

    public void afficheAscendantAux(Personne p,String s){
        if(p==this){
            System.out.println(s+this.prenom+this.nomDeFamille);
        }
        if(this.mere!=null){
            this.mere.afficheAscendantAux(p,s+this.nomDeFamille+this.prenom+"enfant de");
        }
        if(this.pere!=null){
            this.pere.afficheAscendantAux(p,s+this.nomDeFamille+this.nomDeFamille+"enfant de");
        }
    }
}
