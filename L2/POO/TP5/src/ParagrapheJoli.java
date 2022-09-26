public class ParagrapheJoli extends Paragraphe{
    private final int len;

    public ParagrapheJoli(int len){
        super();
        // on ajoute la tabulation en début de paragraphe
        Ligne first=new Ligne();
        Espace tab=new Espace();
        tab.setSize(3);
        first.addChaine(tab);
        this.suite.add(first);
        this.len=len;
    }

    // fonction qui permet de calculer le nombre de charactères dans la dernière ligne du paragraphe
    private int lenLastLigne(){
        int res=0;
        if(!suite.isEmpty()){
            Ligne l=suite.getLast();
            res=l.len();
        }
        return res;
    }

    @Override
    public void addChaine(ChaineCar chaine){
        // si le paragraphe ne contient aucune ligne ou que la longueur dépasse la longueur voulu on crée une nouvelle ligne
        if(this.suite.isEmpty() || this.lenLastLigne()+chaine.len()>this.len){
            Ligne first=new Ligne();
            first.addChaine(chaine);
            this.suite.add(first);
        }
        else{
            this.suite.getLast().addChaine(chaine);
        }
    }
}
