#!/usr/bin/env python3

import sys

version = sys.version_info
if version.major < 3:
    sys.exit(
        "Python2 n'est PLUS supporté depuis le 1er Janvier 2020, merci d'installer Python3"
    )

import random
from time import process_time as clock

try:
    import matplotlib.pyplot as plt
except ModuleNotFoundError:
    sys.exit("Le module matplolib est nécessaire pour ce TP.")

from tp3 import triInsertionRotation, triFusion, triShell, randomPerm, testeQueLaFonctionTrie, randomTab, derangeUnPeu


############################################################
# Exercice 1.1
#
# Tri rapide avec mémoire auxiliaire et en place
#

def triRapide(T):
    if len(T)<2: return T
    pivot=T[0]
    gauche=[el for el in T[1:] if el<=pivot]
    droite=[el for el in T[1:] if el>pivot]
    return triRapide(gauche)+[pivot]+triRapide(droite)


def triRapideEnPlace(T,debut=0,fin=None):
    if fin is None:fin=len(T)
    if fin-debut<2: return T
    pivot,gauche,droite=T[debut],debut+1,fin-1
    while gauche<=droite:
        if T[gauche]<=pivot: gauche+=1
        elif T[droite]>=pivot: droite-=1
        else:
            T[gauche],T[droite]=T[droite],T[gauche]
            gauche+=1
            droite-=1
    T[debut],T[droite]=T[droite],pivot
    indice_pivot=droite
    triRapideEnPlace(T,debut,indice_pivot)
    triRapideEnPlace(T,indice_pivot+1,fin)
    return T


############################################################
# Exercice 1.2
#
# Tri rapide avec mémoire auxiliaire et en place avec pivot
# aléatoire
#

def triRapideAleatoire(T):
    if len(T) < 2: return T
    pivot = T[random.randint(0,len(T)-1)]
    gauche = [el for el in T[1:] if el <= pivot]
    droite = [el for el in T[1:] if el > pivot]
    return triRapide(gauche) + [pivot] + triRapide(droite)


def triRapideEnPlaceAleatoire(T,debut=0,fin=None):
    if fin is None: fin = len(T)
    if fin - debut < 2: return T
    alea=random.randint(debut,fin-1)
    T[debut],T[alea]=T[alea],T[debut]
    pivot,gauche,droite=T[debut],debut+1,fin-1
    while gauche <= droite:
        if T[gauche] <= pivot:
            gauche += 1
        elif T[droite] >= pivot:
            droite -= 1
        else:
            T[gauche], T[droite] = T[droite], T[gauche]
            gauche += 1
            droite -= 1
    T[debut], T[droite] = T[droite],pivot
    indice_pivot = droite
    triRapideEnPlaceAleatoire(T,debut,indice_pivot)
    triRapideEnPlaceAleatoire(T,indice_pivot+1,fin)
    return T


############################################################
# Exercice 2.1
#
# les tableaux de taille < 15 sont triés par insertion, le
# reste avec l'algo de tri rapide usuel.
#

def triRapideAmeliore(T):
    if len(T)<15:
        T=triInsertionRotation(T)
    else:
        T=triRapide(T)
    return T


############################################################
# Exercice 2.2
#
# Tri rapide seulement pour les tableaux de taille >= 15 et
# ne fait rien pour les tableaux de taille < 15
#

def triRapideIncomplet(T):
    if len(T)>=15:
        pivot=T[0]
        gauche=[el for el in T[1:] if el<=pivot]
        droite=[el for el in T[1:] if el>pivot]
        return triRapideIncomplet(gauche)+[pivot]+triRapideIncomplet(droite)
    else:
        return T


############################################################
# Exercice 2.3
#
# Trie par insertion le résultat de triRapideIncomplet(T).
#
def triSedgewick(T):
    return triInsertionRotation(triRapideIncomplet(T))


############################################################
# Exercice 3.1
#
# Tris drapeau. Attention, les éléments du tableau ne peuvent pas
# avoir d'autres valeurs que 1, 2 ou 3.
#

BLEU, BLANC, ROUGE = 1, 2, 3


def triDrapeau(T):
    blanc,bleu,rouge=[],[],[]
    for i in range(len(T)):
        if T[i]==BLEU: bleu.append(T[i])
        elif T[i]==BLANC: blanc.append(T[i])
        else: rouge.append(T[i])
    return bleu+blanc+rouge


def triDrapeauEnPlace(T):
    bleu,blanc,rouge=0,0,len(T)-1
    while blanc<=rouge:
        if T[blanc]==BLANC:
            blanc+=1
        elif T[blanc]==BLEU:
            T[bleu],T[blanc]=T[blanc],T[bleu]
            bleu+=1
            blanc+=1
        else:
            T[blanc],T[rouge]=T[rouge],T[blanc]
            rouge-=1
    return T


############################################################
# Exercice 3.3
#
# Tris rapide, pivot drapeau pour amélioration si le tableau en entrée
# est très répété.
#

def triRapideDrapeau(T):
    if len(T) < 2: return T
    pivot = T[0]
    blanc,bleu,rouge=[],[],[]
    for i in range(1,len(T)):
        if T[i]<pivot: bleu.append(T[i])
        elif T[i]>pivot: rouge.append(T[i])
        else: blanc.append(T[i])
    return triRapideDrapeau(bleu) + blanc + triRapideDrapeau(rouge)


############################################################
# Exercice 3.3
#
# Effectue un tri drapeau par rapport au pivot.
# Retourne le nombre d'éléments dans chaque catégorie (inférieur au pivot,
# pivot, supérieur au pivot)
#

def partitionDrapeau(T, debut, fin):  # suppose fin-dev >= 2
    milieu,pivot=debut,T[fin]
    while milieu<=fin:
        if T[milieu]<pivot:
            T[debut], T[milieu] = T[milieu], T[debut]
            debut += 1
            milieu += 1
        elif T[milieu]>pivot:
            T[milieu], T[fin] = T[fin], T[milieu]
            fin -= 1
        else:
            milieu += 1
    return debut-1,milieu


############################################################
# Exercice 3.3
#
# Tri rapide en place utilisant un partitionnement drapeau
#

def triRapideDrapeauEnPlace(T, debut=0, fin=None):
    if fin is None: fin=len(T)-1
    if fin-debut<2: return T
    indice_pivot,milieu=partitionDrapeau(T,debut,fin)
    triRapideDrapeauEnPlace(T,debut,indice_pivot)
    triRapideDrapeauEnPlace(T,milieu,fin)
    return T


from tp3 import mesure, mesureMoyenne, courbes, affiche, compareAlgos


def testTriNonPermutation(tri, maxVal=3):
    for size in range(2, 101):
        T = randomTab(size, 1, maxVal)
        T2 = tri(T)
        for i in range(1, len(T2)):
            if T2[i - 1] > T2[i]: return False
    return True


def compareAlgosSurTableauxRepetes(algos, taille=20000, pas=1000, ech=15, maxVal=3):
    for tri in algos:
        if testTriNonPermutation(tri):
            print(tri.__name__ + ": OK")
        else:
            print(tri.__name__ + ": échoue")

    print("Comparaison à l'aide de randomTab")
    tableaux = [[i, [randomTab(i, 1, 3) for j in range(ech)]] for i in range(2, taille, pas)]
    courbes(algos, tableaux, styleLigne='-')
    affiche("Comparaison à l'aide de randomTab")


##############################################################
#
# Main
#

if __name__ == '__main__':
    trisRapides = [triRapide, triRapideEnPlace, triRapideAleatoire, triRapideEnPlaceAleatoire]
    trisHybrides = [triRapideAmeliore, triSedgewick, triShell]
    trisDrapeaux = [triDrapeau, triDrapeauEnPlace]
    trisRapideDrapeaux = [triRapideDrapeau, triRapideDrapeauEnPlace]

    # exercice 1
    # print("Exercice 1")
    # algos = trisRapides
    # compareAlgos(algos)

    # exercice 2

    # print("Exercice 2")
    # algos = [triRapideAmeliore, triSedgewick]
    # compareAlgos(algos)
    # algos = trisRapides + trisHybrides
    # compareAlgos(algos)

    # exercice 3

    # print("Exercice 3")
    # comparaison des tris drapeaux
    # print("Comparaisons sur tableaux très répétés")
    # algos = trisDrapeaux
    # compareAlgosSurTableauxRepetes (algos, maxVal=3)

    # comparaison des tris rapide drapeaux
    print("Comparaisons sur tableaux très répétés")
    algos = [triRapide, triRapideEnPlace] + trisRapideDrapeaux
    compareAlgosSurTableauxRepetes(algos, taille=1000, pas=100, ech=5, maxVal=5)
