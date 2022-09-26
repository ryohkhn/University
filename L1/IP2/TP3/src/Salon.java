public class Salon {
    public Utilisateur[] tabUser;
    public Message[] tabMessage;
    int dernier;
    int taille;
    int dernierMsg;
    int tailleMsg;

    public Salon(){
        this.tabUser=new Utilisateur[1];
        this.tabMessage=new Message[1];
        this.dernier=-1;
        this.taille=1;
        this.dernierMsg=-1;
        this.tailleMsg=1;
    }

    public void ajouterUtilisateur(Utilisateur u){
        if(this.estPresent(u)){
            return;
        }
        if(this.dernier==-1){
            this.tabUser[0]=u;
            this.dernier++;
        }
        else if(this.dernier==this.taille-1){
            Utilisateur[] newTabUser=new Utilisateur[this.taille+1];
            for(int i=0;i<this.tabUser.length;i++){
                newTabUser[i]=this.tabUser[i];
            }
            newTabUser[newTabUser.length-1]=u;
            this.tabUser=newTabUser;
            this.dernier++;
            this.taille++;
        }
    }

    public void ajouterMessage(Message m){
        if(!this.estPresent(m.u)){
            return;
        }
        if(this.dernierMsg==-1){
            this.tabMessage[0]=m;
            this.dernierMsg++;
        }
        else if(this.dernierMsg==this.tailleMsg-1){
            Message [] newTabMsg=new Message[this.tailleMsg+1];
            for(int i=0;i<this.tabMessage.length;i++){
                newTabMsg[i]=this.tabMessage[i];
            }
            newTabMsg[newTabMsg.length-1]=m;
            this.tabMessage=newTabMsg;
            this.dernierMsg++;
            this.tailleMsg++;
        }
    }

    public void exclusUtilisateur(Utilisateur u){
        if(!this.estPresent(u)){
            return;
        }
        for(int i=0;i<this.tabUser.length;i++){
            if(this.tabUser[i]==u){
                this.tabUser[i]=null;
            }
        }
        for(int j=0;j<this.tabMessage.length;j++){
            if (this.tabMessage[j] != null) {
                if(this.tabMessage[j].u==u){
                    tabMessage[j]=null;
                }
            }
        }

        // Cette partie de ma méthode permet de recréer un tableau et d'enlever toutes les cases null que je viens de créer

        Utilisateur[] newTabUser=new Utilisateur[this.tabUser.length];
        int comptUser=0;
        Message[] newTabMsg=new Message[this.tabMessage.length];
        int comptMsg=0;

        for(int k=0;k<this.tabUser.length;k++){
            if(this.tabUser[k]!=null){
                newTabUser[comptUser]=this.tabUser[k];
                comptUser++;
            }
        }
        this.tabUser=newTabUser;
        for(int l=0;l<this.tabMessage.length;l++){
            if(this.tabMessage[l]!=null){
                newTabMsg[comptMsg]=this.tabMessage[l];
                comptMsg++;
            }
        }
    }

    public boolean estPresent(Utilisateur u){
        for (Utilisateur utilisateur : this.tabUser) {
            if (utilisateur == u) {
                return true;
            }
        }
        return false;
    }

    public void afficher() {
        for (Message message : this.tabMessage) {
            if (message !=null){
                message.afficherMessage();
            }
        }
    }

    public void afficherUser(){
        for(Utilisateur utilisateur : this.tabUser){
            if(utilisateur == null){
            }
            else{
                System.out.println(utilisateur.getPseudo());
            }
        }
    }
}
