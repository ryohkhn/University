#include <stdio.h>

void swap(int *p, int *q){
    int tmp=*p;
    *p=*q;
    *q=tmp;
}

void print_tab(int t[], int start, int end){
    for(int i=start;i<end;i++){
        printf("%p : %d\n",&t[i],t[i]);
    }
}

void sort(int t[],int start,int end){
    for (int n=end-1;n>1;n--) {
        for(int i=start;i<n;i++){
            if(t[i]>t[i+1]){
                swap(&t[i],&t[i+1]);
            }
        }
    }
}

void sort_ptr(int *start,int *end){
    while(end>start){
        int *startcopy=start;
        while(startcopy<end){
            if(*startcopy>*(startcopy+1)){
                swap(startcopy,startcopy+1);
            }
            startcopy++;
        }
        end--;
    }
}

int main(){
    int t[]={45,23,122,3,4,8,4};
    sort_ptr(&t[0],&t[6]);
    print_tab(t,0,6);
}
