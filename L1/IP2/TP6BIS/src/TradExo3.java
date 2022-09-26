import java.util.Stack;

public class TradExo3 {
    static int ic=0;
    static int[] mem=new int[1000];
    public static Stack<Integer> p=new Stack<>();

    public static void main(String[] args){
        while(true){
            switch(ic){
                case 0: mem[0]=0; ic++; break;
                case 1: ic++; break;
                case 2: mem[2]=20; ic++; break;
                case 3: mem[3]=20; ic++; break;
                case 4: p.push(ic+1); ic=300; break;
                case 5: p.pop(); ic++; break;
                case 6: if(mem[0]>=5){
                    ic+=6;
                    break;
                }
                else{
                    ic++;
                    break;
                }
                case 7: p.push(ic+1); ic=100; break;
                case 8: p.pop(); ic++; break;
                case 9: p.push(ic+1); ic=300; break;
                case 10: p.pop(); ic++; break;
                case 11: ic-=5; break;
                case 12: System.exit(0);

                case 100: System.out.println("début tirs"); ic++; break;
                case 101: mem[1]=1; ic++; break;
                case 102: if(mem[1]>=6){
                    ic+=5;
                    break;
                }
                else{
                    ic++;
                    break;
                }
                case 103: p.push(ic+1); ic=200; break;
                case 104: p.pop(); ic++; break;
                case 105: mem[1]++; ic++; break;
                case 106: ic-=4; break;
                case 107: System.out.println("fin tirs"); ic++; break;
                case 108: ic=p.peek(); break;

                case 200: System.out.println("cible "+ mem[1]); ic++; break;
                case 201: mem[3]--; ic++; break;
                case 202: ic=p.peek(); break;

                case 300: mem[0]++; ic++; break;
                case 301: System.out.println("dans le tour "+mem[0]); ic++; break;
                case 302: mem[2]-=4; ic++; break;
                case 303: ic=p.peek(); break;
            }
        }
    }
}
