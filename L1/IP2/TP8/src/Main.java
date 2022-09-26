public class Main {

    public static void main(String[] args) {
        Robot r1=new Robot("r1","bonjour le peuple");
        Robot r2=new Robot("r2","il fait beau");
        Robot r3=new Robot("r3","il fait chaud ojd");
        TableRonde tableRonde=new TableRonde(r1);
        tableRonde.ajouteRob(r2);
        tableRonde.ajouteRob(r3);
        tableRonde.affiche();
        DiscussionEntreRobots Discord=new DiscussionEntreRobots();
        Discord.discussionEntreRobots(tableRonde);
        tableRonde.affiche();
    }
}
