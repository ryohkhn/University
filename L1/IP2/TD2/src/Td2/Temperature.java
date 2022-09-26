package Td2;

public class Temperature {
    private double temperature;
    private String unite;

    public Temperature(){
        this.temperature=0;
        this.unite="Kelvin";
    }

    public Temperature(double temperature, String unite){
        this.temperature=temperature;
        if (unite.equals("Celcius") || !unite.equals("Fahrenheit")){
            this.unite=unite;
        }
        else{
            this.unite="Kelvin";
        }
    }

    public Temperature(Temperature t){
        this.unite=t.unite;
        this.temperature=t.temperature;
    }
}
