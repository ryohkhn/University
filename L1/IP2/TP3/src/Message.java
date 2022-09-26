public class Message {
    public String message;
    public Utilisateur u;

    public Message(String message, Utilisateur u){
        this.message=message;
        this.u=u;
    }

    public void afficherMessage(){
        System.out.println(this.u.getPseudo()+": "+this.message);
    }

}
