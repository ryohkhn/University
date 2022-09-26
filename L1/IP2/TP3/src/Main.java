public class Main {

    public static void main(String[] args) {
		Utilisateur Lucas=new Utilisateur("ryoh","123123","lucasrodriguez@etu.u-paris.fr");
		Utilisateur Lucas2=new Utilisateur("ryoh2","123123","lucasrodriguez@etu.u-paris.fr");
		Salon test=new Salon();
		Salon test2=new Salon();
		test.ajouterUtilisateur(Lucas);
		test2.ajouterUtilisateur(Lucas);
		test2.ajouterUtilisateur(Lucas2);
		Message a=new Message("Bonjour à tous",Lucas);
		Message b=new Message("Bonjour à tous",Lucas);
		Message c=new Message("Bonjour à tous",Lucas);
		Message d=new Message("Bonjour à tous",Lucas);
		Message e=new Message("Bonjour à tous",Lucas2);
		Message f=new Message("Bonjour les amis",Lucas2);
		test.ajouterMessage(a);
		test.ajouterMessage(b);
		test.ajouterMessage(c);
		test2.ajouterMessage(d);
		test2.ajouterMessage(e);
		test2.ajouterMessage(f);
		Chat Discord=new Chat();
		Discord.ajouterSalon(test);
		Discord.ajouterSalon(test2);
		System.out.println(Discord.estPresent(Lucas));
		System.out.println(Discord.nombreMessages(Lucas));
		System.out.println(Discord.bavard().getPseudo());
    }
}
