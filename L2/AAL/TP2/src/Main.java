import java.util.HashSet;
import java.util.Set;

public class Main{

    public static void testAutomate1(){
	Etat[] etats = new Etat[3];
	etats[0] = new Etat(0,false);
	etats[1] = new Etat(1,false);
	etats[2] = new Etat(2,true);
	etats[0].ajouteTransition('a', etats[1]);
	etats[0].ajouteTransition('a', etats[2]);
	etats[1].ajouteTransition('a', etats[1]);
	etats[1].ajouteTransition('c', etats[1]);
	etats[1].ajouteTransition('b', etats[2]);
	Automate a = new Automate(etats[0]);
	System.out.println(a);

	String s = "ab";
	System.out.println("Mot " + s + " accepté ? " + a.accepte(s));

	Set<Etat> s1 = new HashSet<Etat>();
	s1.add(etats[0]);
	Set<Etat> s2 = new HashSet<Etat>();
	s2.add(etats[1]);
	s2.add(etats[2]);
	Set<Etat> s3 = new HashSet<Etat>();
	s3.add(etats[2]);
	s3.add(etats[1]);
	s3.add(etats[2]);

	System.out.println(" s1 == s2 ? " + s1.equals(s2));
	System.out.println(" s2 == s3 ? " + s2.equals(s3));
    }

    public static void testAutomate2(){
		Etat[] etats=new Etat[11];
		for (int i = 0; i <11; i++) {
			if (i == 10) {
				etats[i] = new Etat(i, true);
			} else {
				etats[i] = new Etat(i, false);
			}
		}
		etats[0].ajouteTransition('a',etats[0]);
		etats[0].ajouteTransition('b',etats[0]);
		etats[0].ajouteTransition('a',etats[1]);
		for (int i = 1; i <10; i++) {
			etats[i].ajouteTransition('a',etats[i+1]);
			etats[i].ajouteTransition('b',etats[i+1]);
		}
		Automate a2=new Automate(etats[0]);
		System.out.println(a2);
		System.out.println(a2.nombreTransitions());

		String s="aaaaaaabbbaaa";
		System.out.println("Mot "+" accepté ? "+ a2.accepte(s));
	}

    public static void testAutomate3(){
		Etat[] etats=new Etat[31];
		for (int i = 0; i <31; i++) {
			if (i == 30) {
				etats[i] = new Etat(i, true);
			} else {
				etats[i] = new Etat(i, false);
			}
		}
		for (int i = 0; i <31; i++) {
			if(i==30){
				etats[i].ajouteTransition('a',etats[i]);
				etats[i].ajouteTransition('b',etats[i]);
			}
			else{
				etats[i].ajouteTransition('a',etats[i]);
				etats[i].ajouteTransition('b',etats[i]);
				etats[i].ajouteTransition('a',etats[i+1]);
				etats[i].ajouteTransition('b',etats[i+1]);
			}
		}

		Automate a3=new Automate(etats[0]);
		System.out.println(a3);

		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println("Mot "+" accepté ? "+ a3.accepte(s));
    }

    public static void main(String[] args){
		//testAutomate1();
		testAutomate2();
		//testAutomate3();
    }
}
