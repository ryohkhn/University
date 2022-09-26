package Tp1;

public class Edudiant {
    String nom;
    String prenom;
    int num;
    int note;

    public Edudiant(String nom, String prenom, int num, int note) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.note = note;
    }

    public static void afficher(Edudiant etu) {
        System.out.println("Nom " + etu.nom + " Prénom " + etu.prenom + "(Numéro d'étudiant " + etu.num + " ) : Note " + etu.note);
    }

    public static boolean estAdmis(Edudiant u) {
        return u.note >= 10;
    }

    public static String mention(Edudiant u) {
        if (u.note >= 16) {
            return "Très bien";
        } else if (u.note >= 14) {
            return "Bien";
        } else if (u.note >= 12) {
            return "Assez bien";
        } else if (u.note >= 10) {
            return "Passable";
        } else {
            return u.note >= 0 ? "Ajourné" : "Note invalide";
        }
    }
}
