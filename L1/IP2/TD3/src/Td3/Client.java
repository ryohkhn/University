package Td3;

public class Client {
    private final String nom;
    private final String prenom;

    public Client(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }


}
