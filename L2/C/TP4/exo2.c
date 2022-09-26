#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

struct array{
    int *ptr;
    unsigned int capacite;
    unsigned int taille;
};
typedef struct array array;

array* array_init(unsigned int cap){
    array* p=malloc(sizeof(array));
    if(p==NULL) return NULL;
    p->ptr=malloc(cap*sizeof(int));
    if(p->ptr==NULL) return NULL;
    p->capacite=cap;
    p->taille=0;
    return p;
}

void array_destroy(array *t){
    free(t->ptr);
    free(t);
}

int array_get(array *t, unsigned int index){
    assert(index>=0 && t->capacite>=index);
    return t->ptr[index];
}

void array_set(array *t, unsigned int index, int valeur){
    assert(index<=t->taille+1 && t->capacite>=index && t->capacite>=t->taille);
    t->ptr[index]=valeur;
    if(index>=t->taille){
        t->taille++;
    }
}

void append(array *t, int val){
    assert(t->capacite>t->taille);
    t->ptr[t->taille]=val;
    t->taille++;
}

void array_print(array* t){
    for(int i=0;i<=t->taille;i++){
        printf("%d ",t->ptr[i]);
    }
    printf("\n");
}

int array_search(array *t,unsigned int index){
    for(int i=0;i<=t->taille;i++){
        if(t->ptr[i]==index) return i;
    }
    return -1;
}

array* array_init_from(int* mem, unsigned int len, unsigned int cap){
    assert(cap>len);
    array* res= array_init(cap);
    for(int i=0; i<len; i++){
        res->ptr[i]=mem[i];
        res->taille++;
    }
    return res;
}

void array_remove(array *t, unsigned int index){
    assert(t->capacite>index && index<=t->taille);
    t->ptr[index]=0;
    for(int i=index;i<t->taille;i++){
        t->ptr[i]=t->ptr[i+1];
        t->ptr[i+1]=0;
    }
    t->ptr[t->taille]=0;
}

void array_insert(array *t, unsigned int index, int valeur){
    assert(index<=t->taille);
    if(t->taille==t->capacite){
        t=realloc(t,sizeof(array)*2);
    }
    t->taille++;
    for(int i=t->taille;i>index;i--){
        t->ptr[i]=t->ptr[i-1];
    }
    t->ptr[index]=valeur;
}

int main(){
    array* test=array_init(12);
    array_set(test,0,12);
    append(test,23);
    append(test,94);
    append(test,129);
    //array_print(test);
    //printf("%d\n", array_search(test,2));
    //printf("%d\n", array_search(test,23));
    //array* test2=array_init_from(test->ptr,3,6);
    //array_print(test2);
    //array_remove(test,2);
    array_print(test);
    array_insert(test,0,34);
    array_print(test);
}
