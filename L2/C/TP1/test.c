#include <stdio.h>

int main(){
    int n=42;
    int m=2;
    double x=3.14;

    printf("%d\n",n+1);
    printf("%d + %d = %d\n",n,m,n+m);
    printf("%d / %lf = %lf\n",n,x,n/x);

    return 0;
}