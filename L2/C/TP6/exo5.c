#include <stdio.h>
#include <string.h>
#include "exo4.c"

typedef struct{
    int nbr;
    char** words;
}w_index;

void free_index(w_index* pi){
    int i=0;
    while(i<pi->nbr){
        free(*((pi->words)+i));
        i++;
    }
    free(pi->words);
}

void print_index(w_index* pi){
    int i=0;
    while(i<pi->nbr){
        printf("Index %d: \"%s\"\n",i,*(pi->words+i));
        i++;
    }
}

int size_words(w_index* pi){
    int i=0;
    size_t res=0;
    while(i<pi->nbr){
        res+=strlen(*(pi->words+i));
        i++;
    }
    return (int)res;
}

char* concat_words(w_index* pi){
    char* res=malloc(sizeof(char*)*size_words(pi)+pi->nbr);
    int index,i=0;
    while(i<pi->nbr){
        memmove(res+index,*(pi->words+i),(sizeof(char)*strlen(*(pi->words+i))));
        if(res==NULL) return NULL;
        index+=(int)strlen(*(pi->words+i));
        *(res+index)=' ';
        index++,i++;
    }
    *(res+index-1)='\0';
    return res;
}

w_index* cons_index(const char* s){
    w_index* res= malloc(sizeof(w_index));
    int nbr=nbr_words(s);
    res->nbr=nbr;
    res->words=malloc(sizeof(char*)*nbr);
    char* tmpString=next_word(s);
    char* exactString;
    int acc,i=0;
    while(tmpString!=NULL){
        exactString=extract_word(tmpString,&acc);
        *(res->words+i)=malloc(sizeof(char)*(acc+1));
        memmove(*(res->words+i),exactString,acc);
        *((*(res->words+i))+acc)='\0';
        tmpString=next_word(tmpString+acc);
        i++;
    }
    return res;
}

int main(void){
    /*
    char* s1="coucou";
    char* s2="oui";
    char* s3="non";
    w_index* pi= malloc(sizeof(w_index));
    pi->nbr=3;
    pi->words=malloc(sizeof(char)*3);
    *(pi->words)=s1;
    *(pi->words+1)=s2;
    *(pi->words+2)=s3;
     */
    //print_index(pi);
    //printf("Valeur : %d\n",size_words(pi));
    //printf("Concat: %lu\n",strlen(concat_words(pi)));

    w_index* pi2= cons_index(" ab   cde  f ");
    print_index(pi2);
    char* s=concat_words(pi2);
    printf("%s\n",s);
    free(s);
    free_index(pi2);
}
