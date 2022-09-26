#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* dupliquer(const char* s){
    char* res=malloc(strlen(s)+1);
    if(res==NULL) return NULL;
    memmove(res,s, strlen(s)+1);
    return res;
}

int ordrealpha(const char* s1,const char* s2){
    for(int i=0;i<strlen(s1)+1;i++){
        if(s1[i]=='\0' && s2[i]=='\0') return 0;
        if(s1[i]=='\0' || s1[i]<s2[i]) return -1;
        if(s2[i]=='\0' || s1[i]>s2[i]) return 1;
    }
    return 0;
}

char* multiplier(const char* s,unsigned int n){
    char* res= malloc(strlen(s)*n+1);
    for(int i=0;i<n;i++){
        memmove(res+strlen(s)*i,s, strlen(s));
    }
    res[strlen(s)*n]='\0';
    return res;
}

int main(){
    char test[]="abcdef";
    char* oui=dupliquer(test);
    printf("%s\n", multiplier(test,4));
}