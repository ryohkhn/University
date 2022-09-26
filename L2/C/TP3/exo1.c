#include <stdio.h>

void swap(int *p, int *q){
    int tmp=*p;
    *p=*q;
    *q=tmp;
}

int main(){
    int x,y;
    x=5;
    y=6;
    printf("(avant) x : %d, y : %d\n",x,y);
    swap(&x,&y);
    printf("(après) x : %d, y : %d\n",x,y);
    int tab[]={3,4,5};
    printf("(avant) tab[0] : %d, tab[1] : %d\n",tab[0],tab[1]);
    swap(&tab[0],&tab[1]);
    printf("(après) tab[0] : %d, tab[1] : %d\n",tab[0],tab[1]);
}
