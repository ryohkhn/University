#include <stdio.h>

#define print_ptr(a) printf("%p (%lu) = %d\n",a,(unsigned long)a,*a)

int a=24;
int b=52;

int main(){
    print_ptr(&a);
    print_ptr(&b);

    int c=24;
    int d=52;

    print_ptr(&c);
    print_ptr(&d);
}
