#include<stdio.h>
#define N 27

void q1(int value){
    int initialValue=value;
    int res=0;
    while(value!=1){
        res++;
        if(value%2==0){
            value/=2;
            //printf("%d ",value);
        }
        else{
            value*=3;
            value+=1;
            //printf("%d ",value);
        }
    }
    printf("\n%d : %d",initialValue,res);
}

int main(){
    for (int i=1; i<=N; i++) {
        q1(i);
    }
    return 0;
}