#include <stdio.h>
#include <limits.h>

int nbr_occ(int nbr,int t[],int v){
    int compt=0;
    for(int i=0;i<nbr;i++){
        printf("%d : %d\n",i,t[i]);
        if(t[i]==v){
            compt++;
        }
    }
    return compt;
}

void nbr_occ_op(int nbr, int t[], int v,int *pnv){
    *pnv=nbr_occ(nbr,t,v);
}

void min_max_op(int nbr, int t[], int *pmin, int *pmax){
    for(int i=0;i<nbr;i++){
        if(t[i]<*pmin){
            *pmin=t[i];
        }
        else if(t[i]>*pmax){
            *pmax=t[i];
        }
    }
}

int main(){
    int t[]={45,23,122,3,4,8,4};
    int tmp=nbr_occ(7,t,4);
    printf("Occurences de v dans le tableau : %d\n",tmp);
    int res=25;
    nbr_occ_op(7,t,4,&res);
    printf("res : %d\n",res);
    int min=INT_MAX;
    int max=INT_MIN;
    min_max_op(7,t,&min,&max);
    printf("Min de t : %d\nMax de t : %d\n",min,max);
}
