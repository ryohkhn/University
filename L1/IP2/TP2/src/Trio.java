public class Trio {
    private Etudiant[] membres;

    public Trio(Etudiant e1, Etudiant e2, Etudiant e3){
        this.membres=new Etudiant[3];
        membres[0]=e1;
        membres[1]=e2;
        membres[2]=e3;
    }

    public Etudiant premier(){
        double res=membres[0].note;
        int nbr=0;
        for(int i=1;i<this.membres.length;i++){
            if(membres[i].note>=res){
                res=membres[i].note;
                nbr=i;
            }
        }
        return membres[nbr];
    }

    //Méthode qui retrouve un membre dans le tableau à partir des Strings

    public Etudiant searchEtu(String prenom, String nom){
        for(int i=0;i<membres.length;i++) {
            if (membres[i].prenom.equals(prenom) && membres[i].nom.equals(nom)) {
                return membres[i];
            }
        }
        return null;
    }

    //En cas d'égalité il y aura 2 personnes en 1er et le dernier en deuxième etc

    public int classement(String prenom, String nom){
        int etu=-1;
        int res=1;
        int compt=0;
        for(int i=0;i<membres.length;i++){
            if(searchEtu(prenom,nom)==membres[i]){
                etu=i;
            }
        }
        if(etu==-1){
            return 0;
        }
        for(int j=0;j<this.membres.length;j++){
            if(membres[etu].note==membres[j].note){
                compt++;
            }
            else if(membres[etu].note<membres[j].note){
                res++;
            }
        }
        if(compt==0) return res;
        if(compt==1 && res==3) return res-1;
        return res;
    }

    public double moyenne(){
        double res=0;
        for(Etudiant membre:membres){
            res+=membre.note;
        }
        return res/3;
    }

    public boolean meilleurQueLaMoyenne(){
        if(this.moyenne()>Etudiant.moyenne()){
            return true;
        }
        return false;
    }
}

