/**
 * fichier contenant les definitions des fonctions données dans polynomes.h
 * **/
 
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<math.h>

#include"polynomes.h"

polynome* creer_polynome_vide(){
    polynome* res=malloc(sizeof(polynome));
    if(res==NULL) return NULL;
    res->coef=0;
    res->degre=-1;
    res->suiv=NULL;
    return res;
}

polynome* creer_monome(double c, int d){
    polynome* res=malloc(sizeof(polynome));
    assert(res!=NULL);
    res->coef=c;
    res->degre=d;
    res->suiv=NULL;
    return res;
}

void annuler(polynome* p){
    polynome* tmp=p->suiv;
    //p->suiv=NULL;
    free(p);
    if(tmp!=NULL){
        annuler(tmp);
    }
}

double evaluer_polynome(polynome* p,double x){
    double res=0;
    res+=p->coef*pow(x,p->degre);
    if(p->suiv!=NULL){
        res+=evaluer_polynome(p->suiv,x);
    }
    return res;
}



void afficher_polynome(polynome* p){
    if(p->coef!=0){
        if(p->degre==0){
            printf("%g",p->coef);
        }
        else{
            printf("%gX^%d",p->coef,p->degre);
        }
        if(p->suiv!=NULL){
            if((p->suiv)->coef>0){
                printf(" + ");
            }
            afficher_polynome(p->suiv);
        }
        else{
            printf("\n");
        }
    }
    else if(p->suiv!=NULL){
        afficher_polynome(p->suiv);
    }
}

void ajouter_monome(polynome* p , double c, int d){
    if(p->suiv==NULL){
        polynome* new=creer_monome(c,d);
        p->suiv=new;
    }
    else{
        if((p->suiv)->degre==d){
            (p->suiv)->coef+=c;
        }
        else if((p->suiv)->degre>d){
            ajouter_monome(p->suiv,c,d);
        }
        else{
            polynome* new=creer_monome(c,d);
            new->suiv=p->suiv;
            p->suiv=new;
        }
    }
}

polynome* copie(polynome* p){
    polynome* res=creer_polynome_vide();
    p=p->suiv;
    while(p!=NULL){
        ajouter_monome(res,p->coef,p->degre);
        p=p->suiv;
    }
    return res;
}

polynome* somme(polynome* p1, polynome* p2){
    polynome* p1Res=copie(p1);
    p2=p2->suiv;
    while(p2!=NULL){
        ajouter_monome(p1Res,p2->coef,p2->degre);
        p2=p2->suiv;
    }
    return p1Res;
}

polynome* soustraction(polynome* p1, polynome* p2){
    polynome* p1Res=copie(p1);
    p2=p2->suiv;
    while(p2!=NULL){
        ajouter_monome(p1Res,-(p2->coef),p2->degre);
        p2=p2->suiv;
    }
    return p1Res;
}

polynome* produit(polynome* p1 ,polynome* p2){
    polynome* res=creer_polynome_vide();
    polynome* p1Tmp=p1;
    polynome* p2Tmp=p2;
    while(p1Tmp!=NULL){
        while(p2Tmp!=NULL){
            ajouter_monome(res,p1Tmp->coef*p2Tmp->coef,p1Tmp->degre+p2Tmp->degre);
            p2Tmp=p2Tmp->suiv;
        }
        p1Tmp=p1Tmp->suiv;
        p2Tmp=p2;
    }
    return res;
}

polynome* puissance(polynome* p, int n){
    polynome* p1Res=copie(p);
    while(n>0){
        p1Res=produit(p1Res,p);
        n--;
    }
    return p1Res;
}

void test(){
	polynome* p = creer_polynome_vide();
	ajouter_monome (p,1,2);
	ajouter_monome (p,6,6);
	ajouter_monome (p,-6,6);
	ajouter_monome (p,-1,0);
	printf("\n---------\n p :");
	afficher_polynome(p);
	
	/*
	ajouter_monome (q,-1,2);
	ajouter_monome (q,3,1);
	printf("\n---------\n Q =");
	afficher_polynome(q);
	
	printf("\n---------\n Q(34) = %f ",evaluer_Horner(q,34));
	printf("\n---------\n Q(34) = %f (methode de Horner) ",evaluer_polynome(q,34));
	 */

    printf("\n---------\n");
	polynome* r=somme(p,p);
	printf("P+Q =");
	afficher_polynome(r);

    printf("\n---------\n");
    polynome* r2=soustraction(somme(p,p),p);
    printf("P-Q =");
    afficher_polynome(r2);
	
	printf("\n---------\n");
	polynome* rc = copie(r);
	printf("copie P+Q =");
	afficher_polynome(rc);


    polynome* p1 = creer_polynome_vide();
    ajouter_monome (p1,6,6);
    ajouter_monome (p1,5,5);
    ajouter_monome (p1,6,8);
    polynome* p2 = creer_polynome_vide();
    ajouter_monome (p2,1,6);
    ajouter_monome (p2,1,5);
    ajouter_monome (p2,3,2);

	printf("\n---------\n");
	polynome* pp = produit(p1,p2);
	printf("P*P =");
	afficher_polynome(pp);

	printf("\n---------\n");
	polynome* p3 = puissance(p,3);
	printf("P^3 =");
	afficher_polynome(p3);

    /*

	printf("\n---------\n");
	polynome* dq = derive(q);
	printf("Q'=");
	afficher_polynome(dq);
	
	printf("\n---------\n");
	polynome* comp = composition(q,p);
	printf("q rond p=");
	afficher_polynome(comp);
	
		
	printf("\n---------\n end\n");
	*/
}



int main(void){
    test();
}
