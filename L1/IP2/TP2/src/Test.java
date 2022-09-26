public class Test {

    //2. static signifie que l'attribut n'a pas de "sujet", pour une méthode elle sera appellée de la sorte "methode()". Une méthode static sera générale à toute la class.
    // final fait en sorte que l'attribut ne puisse pas être modifié sans un setter, et vu sans un setter.
    // prenom et nom ne peuvent pas être vus en dehors de la class sans un setter, note peut être vu en dehors de la class.

    public static void main(String[] args) {
        Etudiant e1=new Etudiant("Luke","Skywalker",5.25);
        Etudiant e2=new Etudiant("Leia","Organa",9.25);
        Etudiant e3=new Etudiant("Lucas","Rodriguez",8.25);
        /*System.out.println("nb d'etudiants: "+ Etudiant.getNombreDEtudiants());
        System.out.println("somme des notes: " + Etudiant.getNombreDEtudiants());
        e1.afficher();
        e2.afficher();
        Etudiant.afficher2(e1);
        Etudiant.afficher2(e2);
        System.out.println(e1.estAdmis());
        System.out.println(e2.estAdmis());
        System.out.println(Etudiant.moyenne());
        System.out.println(e1.meilleurQueLaMoyenne());
        System.out.println(e3.meilleurQueLaMoyenne());
        e2.modifierNote(19.5);
        e2.afficher();
        System.out.println("moyenne: "+Etudiant.moyenne());*/
        Trio trio1=new Trio(e1,e2,e3);
        //trio1.premier().afficher();
        System.out.println(trio1.classement("Lucas","Rodriguez"));
        System.out.println(trio1.classement("Leia","Organa"));
        System.out.println(trio1.classement("Luke","Skywalker"));
        System.out.println(trio1.meilleurQueLaMoyenne());
    }
}
