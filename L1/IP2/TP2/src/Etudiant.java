public class Etudiant {
    final String prenom;
    final String nom;
    double note;

    private static int nombreDEtudiants = 0;
    static double sommeDesNotes = 0;

    public Etudiant(String prenom, String nom, double note) {
        this.prenom = prenom;
        this.nom = nom;
        this.note = note;
        nombreDEtudiants++;
        sommeDesNotes += note;
    }

    public static int getNombreDEtudiants() {
        return nombreDEtudiants;
    }


    public void afficher() {
        System.out.println(this.nom + " " + this.prenom + ": " + this.note);
    }

    public static void afficher2(Etudiant e) {
        System.out.println(e.nom + " " + e.prenom + ": " + e.note);
    }

    public boolean estAdmis(){
        return this.note >= 10;
    }

    public static double moyenne(){
        return sommeDesNotes/nombreDEtudiants;
    }

    public boolean meilleurQueLaMoyenne(){
        return this.note>moyenne();
    }

    public void modifierNote(double nouvelleNote){
        sommeDesNotes-=this.note;
        this.note=nouvelleNote;
        sommeDesNotes+=nouvelleNote;
    }

}
