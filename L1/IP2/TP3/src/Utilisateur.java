public class Utilisateur {
    private String pseudo;
    private String motDePasse;
    private final String adresseMail;

    public Utilisateur(String pseudo, String motDePasse, String adresseMail){
        this.pseudo=pseudo;
        this.motDePasse=motDePasse;
        this.adresseMail=adresseMail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String motDePasse,String pseudo) {
        if(testMotDePasse(motDePasse)){
            this.pseudo=pseudo;
        }
    }

    public boolean testMotDePasse(String s){
        if(this.motDePasse.equals(s)){
            return true;
        }
        return false;
    }

    public void changerMotDePasse(String motDePasse,String nouveauMotDePasse) {
        if (this.testMotDePasse(motDePasse)) {
            this.motDePasse = nouveauMotDePasse;
        }
    }


}
