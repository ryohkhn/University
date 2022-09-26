public class Animal{
    private String regime;

    public Animal(String regime){
        this.regime=regime;
    }

    public String getRegime() {
        return regime;
    }

    public boolean isHerb(){
        return this.regime.equals("herbivore");
    }

    public boolean isCarnivore(){
        return this.regime.equals("carnivore");
    }

    public void transform(){
        if(this.isCarnivore()){
            this.regime="herbivore";
        }else {
            this.regime = "carnivore";
        }
    }

    public void afficher(){
        System.out.println(this.regime);
    }
    
}
