#include <stdio.h>
#include <string.h>
#include <assert.h>
#include <malloc.h>
#include <ctype.h>

int nbr_words(const char* s){
    int isWord=0;
    int count=0;
    for(int i=0;i<strlen(s);i++){
        if(!isspace(*(s+i)) && !isWord){
            count++;
            isWord=1;
        }
        else if(isspace(*(s+i)) && isWord){
            isWord=0;
        }
    }
    return count;
}

int word_len(const char* w){
    assert(*w!=' ');
    int count=0;
    while(!isspace(*(w+count))){
        count++;
    }
    return count;
}

char* extract_word(const char* w,int* pl){
    assert(*w!=' ');
    *pl=word_len(w);
    char* res=malloc(sizeof(char)*(*pl)+1);
    if(res==NULL) return NULL;
    memmove(res,w,*pl);
    *(res+*pl)='\0';
    return res;
}

char* next_word(const char* w){
    int i=0;
    while(isspace(*(w+i))){
        i++;
    }
    if(*(w+i)=='\0') return NULL;
    return w+i;
}

/*
int main(void){
    //printf("Taille: %d\n", nbr_words(" a aa  ba a bbbb "));
    char* s=" a aa  ba a bbbb ";

    //printf("Mot: %d\n", word_len(s+12));

    //int ln=0;
    //char* test= extract_word(s+12,&ln);
    //printf("Mot: %s Taille:%d\n",test,ln);

    printf("Mot: %s.\n", next_word(s+1));
}*/
