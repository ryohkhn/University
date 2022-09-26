package Td3;

public class FileDAttente {
    public Client[] clientsPossibles;
    private int capacite;
    private int taille;
    private int premier;
    private int dernier;

    public FileDAttente(int capacite) {
        this.capacite = capacite;
        this.clientsPossibles = new Client[1];
        this.taille = 0;
        this.premier = -1;
        this.dernier = -1;
    }

    public int getTaille() {
        return this.taille;
    }


    public void ajouterClient(Client c) {
        if (this.taille < this.capacite) {
            int i = this.premier;
            int j = 1;
            while (j <= this.taille) {
                if (clientsPossibles[i].equals(c)) {
                    return;
                }
                j++;
                i = (i + 1) % this.capacite;
            }
            dernier = (dernier + 1) % this.capacite;
            this.clientsPossibles[dernier] = c;
            if (this.taille == 0) {
                this.premier = (this.premier + 1) % this.capacite;
            }
            this.taille++;
        }

    }

    public Client extrairePremier() {
        if (this.taille > 0) {
            Client res = clientsPossibles[this.premier];
            clientsPossibles[this.premier] = null;
            this.premier = (this.premier + 1) % this.capacite;
            this.taille--;
            if (this.taille == 0) {
                this.premier = -1;
                this.dernier = -1;
            }
            return res;
        }
        return null;
    }
}
