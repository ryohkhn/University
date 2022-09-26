#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define NBC 20

enum etat{
    VALIDEE,ENCOURS,EXPEDIEE
};

typedef enum etat etat;

struct commande{
    int num_com;
    int prix_exp;
    int prix_prod;
    etat etat_com;
};

typedef struct commande commande;

commande com_alea(int num){
    int expe=(rand()%20)+1;
    int valeur=(rand()%2000)+1;
    etat rand_etat=(etat)rand()%3;
    commande res={ .num_com=num, .prix_exp=expe, .prix_prod=valeur, .etat_com=rand_etat};
    return res;
}

void affiche_com(commande commande){
    printf("Numéro : %d\n",commande.num_com);
    printf("Prix expédition : %d\n",commande.prix_exp);
    printf("Prix production : %d\n",commande.prix_prod);
    switch (commande.etat_com) {
        case 0: printf("État commande : Validée\n"); break;
        case 1: printf("État commande : En cours\n"); break;
        case 2: printf("État commande : Expediée\n"); break;
    }
}

void affiche_exp(commande t[],int taille){
    for(int i=0;i<taille;i++){
        if(t[i].etat_com==2){
            affiche_com(t[i]);
        }
    }
}

int nbr_en_cours(commande t[], int taille){
    int res=0;
    for(int i=0;i<taille;i++){
        if(t[i].etat_com==1){
            res++;
        }
    }
    return res;
}

int cout_validees(commande t[], int taille){
    int res=0;
    for(int i=0;i<taille;i++){
        if(t[i].etat_com==0){
            res++;
        }
    }
    return res;
}

int main(){
    srand(time(NULL));
    commande tab[NBC];
    for(int i=0;i<NBC;i++){
        tab[i]= com_alea(i);
    }
    affiche_exp(tab,NBC);
    printf("Commandes en cours : %d\n", nbr_en_cours(tab,NBC));
    printf("Cout des commandes validées : %d", cout_validees(tab,NBC));
}
