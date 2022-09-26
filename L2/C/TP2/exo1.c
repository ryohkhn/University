#include <stdio.h>

int g(n){
    if(n==1){
        return 1;
    }
    return 3*f(n/2);
}

int f(int n){
    if(n==1){
        return 2;
    }
    return 2*g(n-1);
}

int main(){
    printf("%d",f(20));
    // return 432
}