#include <math.h>
#include <stdio.h>
#define SUP 100

void q1(){
    int tab[SUP]={0};
    for(int i=2;i<sizeof(tab)/sizeof(tab[0]);i++){
        if(tab[i]==0){
            for(int j=i;j<SUP;j+=i){
                tab[j]=1;
            }   
            if(tab[i]!=0){
                printf("(%d %d)",i,i+2);
            }
        }
    }
}

int main(){
    q1();
    return 0;
}

