import java.util.Random;

public class DiscussionEntreRobots{

    public DiscussionEntreRobots(){
    }

    public void discussionEntreRobots(TableRonde tableRonde){
        Random rand=new Random();
        int tmp=rand.nextInt(6);
        while(tableRonde.getCourant()!=null){
            tableRonde.parle(tmp);
        }
        System.out.print("Tout va bien !");
    }
}
