#include<stdio.h>
#include<math.h>

int q1(){
    int v,res;

    printf("Entrez un entier:\n");

    scanf("%d",&v);

    for(int i=1;i<=v;i++){
        res+=pow(i,3);
    }

    return res;
}

void q2(){
    int nbVal,res,tmp;
    printf("Entrez un entier:\n");
    scanf("%d",&nbVal);

    for(int i=0;i<nbVal;i++){
        scanf("%d",&tmp);
        res+=tmp;
    }

    printf("Somme des entiers : ");
    printf("%d\n",res);
    printf("Moyenne des entiers : ");
    printf("%d / %d = %d\n",res,nbVal,res/nbVal);
}

int fact(int n){
    int res=1;
    for(int i=1;i<=n;i++){
        res*=i;
        printf("%d! = %d\n",i,res);
    }
    return res;
}

void affichage(int t[]){
    int tmp;
    tmp=sizeof(t);
    printf("%d\n",tmp);
    tmp=sizeof(t[0]);
    printf("%d\n",tmp);
    tmp=sizeof(t)/sizeof(t[0]);
    printf("%d\n",tmp);
}

void q5(){
    int tab[]={42,17,24,43,1,03};
    affichage(tab);
}

int main(){
    int tmp;
    //tmp=q1();
    //printf("%d\n",tmp);
    //q2();
    //fact(6);
    q5();
    return 0;
}