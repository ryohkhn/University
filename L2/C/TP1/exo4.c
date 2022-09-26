#include <stdio.h>
#define SUP 100 


void algo(){
    int tab[SUP]={0};
    for(int i=2;i<sizeof(tab)/sizeof(tab[0]);i++){
        if(tab[i]==0){
            for(int j=i;j<SUP;j+=i){
                tab[j]=1;
            }
            printf("%d ",i);
        }
    }
}

int main(){
    algo();
}