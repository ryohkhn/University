public class Fibonacci_Rodriguez_Lucas{

    public static int fibonacci(int n){
        if(n==1 || n==0){
            return 1;
        }
        return fibonacci(n-2)+fibonacci(n-1);
    }

    public static long fibonacciIter(int n){
        if(n==0) return 1;
        if(n==1) return 1;
        long oldest=0;
        long old=1;
        long current=0;
        for(int i=1;i<=n;i++){
            current=old+oldest;
            oldest=old;
            old=current;
        }
        return current;
    }

    public static long fibonacciTerm(int n){
        return fibonacciTerm2(n,1,1);
    }

    public static long fibonacciTerm2(int n, long acc1, long acc2){
        if(n==0) return acc1;
        if(n==1) return acc2;
        return fibonacciTerm2(n-1,acc2,acc1+acc2);
    }

    // On remarque très rapidement que la fonction récursive naïve n'est pas si efficace, la fonction fait trop d'appels à chaque nouvel appel, ce qui en plus prend beaucoup de place dans la mémoire
    // La fonction itérative qui n'est comme explicitée pas récursive est quant à elle bien plus rapide que la fonction récursive
    // Même avec des très grands nombres le temps d'éxecution de différence entre la fonction itérative et la récursive terminale n'est pas flagrant même si la récursive terminale est plus efficace
    // Je suppose que pour des nombres encore plus grands la fonction itérative commencera à être de moins en moins efficacea
}
