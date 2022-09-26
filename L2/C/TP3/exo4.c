#include <stdio.h>

/*void print_tab(int t[], int start, int end){
    for(int i=start;i<end;i++){
        printf("%p : %d\n",&t[i],t[i]);
    }
}
*/

void print_tab(int *pstart, int *pend){
    while(pstart<pend){
        printf("%p : %d\n",&pstart,*pstart);
        pstart++;
    }
}

int main(){
    int t[]={45,23,122,3,4,8,4};
    int *pstart=&t[2];
    int *pend=&t[5];
    print_tab(pstart,pend);
}
