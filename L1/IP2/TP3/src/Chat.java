public class Chat {
    public Salon[] tabChat;
    int dernier;
    int taille;

    public Chat(){
        this.tabChat=new Salon[1];
        this.dernier=-1;
        this.taille=1;
    }

    public void ajouterSalon(Salon s){
        if(this.dernier==-1){
            this.tabChat[0]=s;
            this.dernier++;
        }
        else if(this.dernier==this.taille-1){
            Salon[] newTabChat=new Salon[this.taille+1];
            for(int i=0;i<this.tabChat.length;i++){
                newTabChat[i]=this.tabChat[i];
            }
            newTabChat[newTabChat.length-1]=s;
            this.tabChat=newTabChat;
            this.dernier++;
            this.taille++;
        }
    }

    public boolean estPresent(Utilisateur u){
        for (Salon salon : this.tabChat) {
            if (salon.estPresent(u)) {
                return true;
            }
        }
        return false;
    }

    public int nombreMessages(Utilisateur u){
        int compt=0;
        for(int i=0;i<this.tabChat.length;i++){
            for(int j=0;j<this.tabChat[i].tabMessage.length;j++){
                if(this.tabChat[i].tabMessage[j].u==u){
                    compt++;
                }
            }
        }
        return compt;
    }

    public Utilisateur bavard(){
        int compt=0;
        int res=0;
        Utilisateur u;
        Utilisateur fin=null;
        for(int i=0;i<this.tabChat.length;i++){
            for(int j=0;j<this.tabChat[i].tabUser.length;j++){
                u=this.tabChat[i].tabUser[j];
                res=nombreMessages(u);
                if(compt==0){
                    compt=nombreMessages(u);
                }
                else if(res>=compt){
                    compt=nombreMessages(u);
                    fin=this.tabChat[i].tabUser[j];
                }
            }
        }
        return fin;
    }
}
