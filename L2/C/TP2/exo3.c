#include <stdio.h>
#include <assert.h>

struct fraction{
    long int num;
    long int den;
};

typedef struct fraction fraction;

fraction build(long int n,long int d){
    assert(d!=0);
    fraction res={ .num=n, .den=d};
    return res;
}

void affiche_frac(fraction f){
    printf("%ld/%ld\n",f.num,f.den);
}

int eq_fraction(fraction f, fraction g){
    if(f.num*g.den==g.num*f.den){
        return 1;
    }
    return 0;
}

int is_int(fraction f){
    if(f.num%f.den==0){
        return 1;
    }
    return 0;
}

fraction sum(fraction f,fraction g){
    f.num*=g.den;
    f.den*=g.den;
    g.num*=f.den;
    g.den*=f.den;
    return build(f.num+g.num,f.den+g.den);
}

int main(){
    fraction ex_fractions[7]={build(1,1),build(1,2),build(2,4),build(-9,3), build(8,-20),build(-5,-1),build(1,-3)};
    for(int i=0;i<(sizeof(ex_fractions)/sizeof(ex_fractions[0]));i++){
        //printf("%d\n",eq_fraction(ex_fractions[i],ex_fractions[i+1]));
        //printf("%d\n\n", is_int(ex_fractions[i]));
        affiche_frac(ex_fractions[i]);
        affiche_frac(sum(ex_fractions[i],ex_fractions[i]));
    }
}
