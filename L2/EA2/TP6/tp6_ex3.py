#!/usr/bin/env python3

from tp6_ex1_ex2 import *


def mot_to_int(mot):
    n=len(mot)
    res=0
    for i in range(n):
        res+=(ord(mot[i]) * pow(31,n-i)) % pow(2, 32)
    return res


def creer_dico(lg=0):
    return TableHachage(lg,hash,hash1,hash2)


def ajouter_mot(dico, mot):
    cle=mot_to_int(mot)
    inserer(dico,cle)
    return dico


def retirer_mot(dico, mot):
    cle=mot_to_int(mot)
    supprimer(dico,cle)
    return dico


def dans_dico(dico, mot):
    cle=mot_to_int(mot)
    if rechercher(dico,cle) is None:
        return False
    return True


##############################################################
#
# crée un générateur des mots contenus dans le roman de Marcel Proust
#
def proust():
    with open("proust.txt", encoding="utf-8") as f:
        for ligne in f:
            for mot in ligne.split():
                tmp = mot.strip('-,.?!;:"«»()^').lower()
                if tmp != '': yield tmp


##############################################################
#
# Main
#

if __name__ == '__main__':
    S = creer_dico(8)
    for mot in proust():
        ajouter_mot(S,mot)


    for mot in proust():
        if dans_dico(S,mot):
            print("\""+mot+"\""+" dans dico")
        else:
            print("\""+mot+"\""+" pas dans dico")

    print("---------")

    if dans_dico(S,"un"):
        print("\"un\" dans dico")
    retirer_mot(S,"un")
    if dans_dico(S,"un"):
        print("\"un\" dans dico")
    else:
        print("\"un\" retiré")