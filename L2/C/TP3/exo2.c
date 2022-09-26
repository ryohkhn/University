#include <stdio.h>

int occ(int nbr,int t[], int v){
    for(int i=0;i<=nbr;i++){
        printf("%d ",t[i]);
        if(t[i]==v){
            return i+1;
        }
    }
    return -1;
}

int *occ_ptr(int nbr, int t[], int v){
    for(int i=0;i<=nbr;i++){
        printf("%p ",&t[i]);
        if(t[i]==v){
            return &t[i];
        }
    }
    return NULL;
}

int main(){
    int t[]={45,23,122,3,4,8,4};
    int tmp=occ(7,t,4);
    printf("Position : %d\n",tmp);
    int *tmpRef=occ_ptr(7,t,23);
    printf("Adresse : %p\n",tmpRef);
}
