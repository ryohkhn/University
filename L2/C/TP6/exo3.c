#include <stdio.h>
#include <string.h>
#include <malloc.h>
#include <assert.h>

typedef struct mutation{
    size_t indice;
    size_t len;
}mutation;

int nboc(const char* s, const char* sub){
    int res=0;
    int bool=0;
    for(int i=0;i< strlen(s);i++){
        for(int j=0;j<strlen(sub);j++){
            if(*(sub+j)!=*(s+i+j)) bool=1;
        }
        if(!bool) res++;
        bool=0;
    }
    return res;
}

mutation diff(const char* s, const char* t){
    assert(strlen(s)==strlen(t));
    int res=0;
    mutation mut;
    for(int i=0;i<strlen(s);i++){
        if(*(s+i)!=*(t+i)){
            int j=i;
            while(*(s+j)!=*(t+j) && j<strlen(s)){
                j++;
                res++;
            }
            mut.len=res;
            mut.indice=i;
            return mut;
        }
    }
    mut.len=(size_t) NULL;
    mut.indice=(size_t) NULL;
    return mut;
}

mutation longest(const char* s, const char* t){
    mutation m=diff(s,t);
    int len=0;
    int indice=0;
    int indiceLenReduc=0;
    while(m.len!=(size_t)NULL){
        s+=m.indice+m.len;
        t+=m.indice+m.len;
        if(m.len>len){
            len=(int)m.len;
            indice=indiceLenReduc+(int)m.indice;
        }
        indiceLenReduc+=(int)(m.indice+m.len);
        m=diff(s,t);
    }
    mutation res={.len=len,.indice=indice};
    return res;
}

char* longest_string(const char* s, const char* t){
    mutation m=longest(s,t);
    char* res=malloc((sizeof(char)*m.len)+1);
    if(res==NULL) return NULL;
    memmove(res,t+m.indice,(sizeof(char)*m.len));
    res[m.len]='\0';
    return res;
}

int main(void){
    //printf("%d\n",nboc("aaacaa","aa"));
    //mutation m=diff("aaaaca","aaaaaa");
    //mutation test=longest("aaagtcaaa","abbgatbgt");
    mutation test=longest("aaagtcaaa","abbgatbgt");
    printf("ind: %zu len: %zu\n",test.indice,test.len);
    char* s= longest_string("aaagtcaaa","abbgatbgt");
    printf("longest_string : %s\n",s);
}
