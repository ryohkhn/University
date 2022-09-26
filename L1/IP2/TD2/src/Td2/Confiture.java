package Td2;

public class Confiture {
    final String fruit;
    private int proportion;
    private int cal;
    static int calSucre = 384;

    public Confiture(String fruit,int proportion,int cal){
        this.fruit=fruit;
        this.proportion=proportion;
        this.cal=cal;
    }

    public Confiture(String fruit,int cal){
        this(fruit,50,cal);
    }

    public String description(){
        return ("Confiture de "+ this.fruit +", "+this.proportion+"% de fruit, "+this.cal+" calories aux 100 grammes.");
    }

    public int calPerQ(int g){
        int res=(this.cal*g)/100;
        return res;
    }

    public boolean egal(Confiture c){
        return (this.fruit.equals(c.fruit) && this.proportion==(c.proportion) && this.cal==(c.cal));
    }

    public String getFruit(){
        return this.fruit;
    }

    public void setCal(int cal){
        this.cal=cal;
    }

    public void setProportion(int proportion){
        this.proportion=proportion;
    }
}
