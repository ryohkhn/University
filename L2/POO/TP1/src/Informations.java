public class Informations {

    private int vitalite;
    private int force;
    private int agilite;

    public Informations(int v,int f,int a){
        this.vitalite=v;
        this.force=f;
        this.agilite=a;
    }

    public Informations(Informations inf){
        this(inf.vitalite,inf.force,inf.agilite);
    }

    public int getVitalite(){
        return vitalite;
    }

    public int getAgilite(){
        return agilite;
    }

    public int getForce(){
        return force;
    }

    public void setAgilite(int agilite){
        this.agilite = agilite;
    }

    public void setForce(int force){
        this.force = force;
    }

    public void setVitalite(int vitalite){
        this.vitalite = vitalite;
    }

    public String toString(){
        return (this.vitalite+" point(s) de vie, "+this.force+" de force et "+this.agilite+" d'agilité");
    }
}

