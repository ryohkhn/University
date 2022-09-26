import org.w3c.dom.html.HTMLParagraphElement;

import java.util.Stack;

public class TradPartiel {
    static int ic = 0;
    static int[] mem=new int[1000];
    static Stack<BlocE> p=new Stack<>();

    public static void main(String[] args){
        while(true){
            switch (ic){
                case 0: mem[0]=0; ic++; break;
                case 1: mem[1]=1; ic++; break;
                case 2: if(mem[0]>=10){
                    ic+=6; break;
                }
                else{
                    ic++; break;
                }
                case 3: p.push(new BlocE(ic+1,mem[0])); ic=200; break;
                case 4: mem[1]*=p.peek().getVal(); ic++; break;
                case 5: p.pop(); ic++; break;
                case 6: mem[0]++; ic++; break;
                case 7: ic-=5; break;
                case 8: System.out.println(mem[1]); ic++; break;
                case 9: System.exit(0);

                case 100: p.peek().setVal(2+p.peek().getArg()); ic++; break;
                case 101: ic=p.peek().getAdr(); break;

                case 200: p.push(new BlocE(ic+1,p.peek().getArg())); ic=100; break;
                case 201: mem[3]=p.pop().getVal(); ic++; break;
                case 202: p.peek().setVal(mem[3]); ic++; break;
                case 203: ic=p.peek().getAdr(); break;
            }
        }
    }
}
