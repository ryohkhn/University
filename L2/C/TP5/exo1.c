#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STACK_INITIAL_CAPACITY 32

typedef struct point{
    double x;
    double y;
}point;

typedef struct stack{
    int capacity;
    int length;
    point* buffer;
}stack;

void stack_print(stack* s){
    printf("Capacity %d\n",s->capacity);
    printf("Length: %d\n",s->length);
    for(int i=0;i<s->length;i++){
        printf("[%d] %20f %20f\n",i,s->buffer[i].x,s->buffer[i].y);
    }
}

stack* stack_new(){
    stack* res=malloc(sizeof(stack));
    if(res==NULL){
        free(res);
        return NULL;
    }
    res->length=0;
    res->capacity=STACK_INITIAL_CAPACITY;
    res->buffer=malloc(sizeof(point)*STACK_INITIAL_CAPACITY);
    return res;
}

void stack_delete(stack* s){
    free(s->buffer);
    free(s);
}

int stack_push(stack* s, point p){
    if(s->length==s->capacity){
        s->capacity*=2;
        s->buffer=realloc(s->buffer,sizeof(point)*s->capacity);
        if(s->buffer==NULL){
            stack_delete(s);
            return -1;
        }
    }
    s->buffer[s->length]=p;
    s->length++;
    return 0;
}

int stack_pop(stack* s, point* p){
    if(s->length==0){
        return -1;
    }
    if(4*s->length<=s->capacity && s->length>=2){
        s->capacity/=2;
        s->buffer=realloc(s->buffer,sizeof(point)*s->capacity);
        if(s->buffer==NULL){
            stack_delete(s);
            return -1;
        }
    }
    s->length--;
    *p=s->buffer[s->length];
    point tmp={.x=0,.y=0};
    s->buffer[s->length]=tmp;
    return 0;
}

stack* stack_clone(stack* s){
    stack* tpm=stack_new();
    memmove(tpm,s,sizeof(stack));
    free(s);
    return tpm;
}

int stack_push_vect(stack* s, int len, point* vect){
    if(s->length+len>s->capacity){
        while(s->length+len>s->capacity){
            s->capacity*=2;
        }
        s->buffer=realloc(s->buffer,sizeof(point)*s->capacity);
        if(s->buffer==NULL){
            stack_delete(s);
            return -1;
        }
    }
    memmove(s->buffer+s->length,vect,sizeof(point)*len);
    s->length+=len;
    return 0;
}

int stack_pop_vect(stack* s, int len, point* vect){
    if(len==0) return 0;
    int length=s->length<len?s->length:len;
    point* tmp= malloc(sizeof(point)*length);
    int i=0;
    while(i<length){
        memmove(vect+i,s->buffer+s->length-1,sizeof(point));
        if(stack_pop(s,tmp+i)==-1) return -1;
        i++;
    }
    return length;
}

void printPoint(point* p){
    printf("x: %f\n",p->x);
    printf("y: %f\n",p->y);
}

int main(){
    stack* tmp=stack_new();
    point p={.x=19,.y=12};
    point p2={.x=29,.y=14};
    point p3={.x=190,.y=2};
    point ps[]={{.x=20,.y=145},{.x=188,.y=978}};
    //point* pop=&p;
    //point p4={.x=1122,.y=62};
    //point p5={.x=222,.y=90};
    stack_push(tmp,p);
    stack_push(tmp,p2);
    stack_push(tmp,p3);
    //stack_push(tmp,p4);
    //stack_push(tmp,p5);
    //stack_print(tmp);
    //stack_pop(tmp,pop);
    //stack_print(tmp);
    //printf("%f",pop->x);

    //stack_print(tmp);
    //stack* tmp2= stack_clone(tmp);
    //stack_print(tmp2);

    stack_push_vect(tmp,2,ps);
    //stack_print(tmp);

    int val=3;
    point* stock=malloc(sizeof(point)*val);
    stack_pop_vect(tmp,val,stock);
    stack_print(tmp);
    for(int i=0;i<val;i++){
        printf("x:%f y:%f\n",(stock+i)->x,(stock+i)->y);
    }


}