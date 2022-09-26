public class EntreeSpeciale extends Entree{
    public EntreeSpeciale(Dossier p, String n, Element e){
        super(p, n, e);
    }

    public void supprimer(){
        System.out.println("Impossible de supprimer une entrée spéciale.");
    }

    public void remplacer(Element e){
        System.out.println("Impossible de mofifier une entrée spéciale.");
    }
}
