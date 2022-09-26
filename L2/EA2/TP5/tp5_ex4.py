#!/usr/bin/env python3

#importe indirectement tp5 et tp5_ex* pour * < 3
from tp5_ex3 import *
from math import sqrt

#
# À COMPLÉTER !
#
''' renvoie un ABR de taille n construit par insertions successives
    des éléments de la permutation perm (de taille n^2), puis suppression
    d'éléments aléatoires '''
def genererABRparInsPuisSup(perm) :
    arbre=Vide
    lenPerm=len(perm)
    for i in range(0,lenPerm):
        insertionABR(arbre,perm[i])
    for i in range(0,lenPerm-(int(sqrt(lenPerm)))):
        suppressionABR(arbre,perm[i],True)
    return arbre

#
# À COMPLÉTER !
#
''' renvoie un couple (ABR, taille) construit par
    insertions/supressions successives entremêlées des éléments de
    permins et permsup respectivement '''
def genererABRparInsEtSup(permins, permsup) :
    arbre = Vide
    taille=0
    for i in range(0,len(permins)):
        if i%2==0:
            insertionABR(arbre, permins[i])
            taille+=1
        else:
            if suppressionABR(arbre,permsup[i],True) is not None:
                taille-=1
    return arbre,taille

#
# À COMPLÉTER !
#
''' renvoie le tableau des hauteurs de m arbres de taille n,
    construits par genererABRparInsPuisSup '''
def statsHauteursABRparInsPuisSup(n, m) :
    res = []
    for i in range(m):
        arbre = genererABRparInsPuisSup(permutation(n))
        tmp = hauteur(arbre)
        res.append(tmp)
    return res

#
# À COMPLÉTER !
#
''' renvoie le tableau des (taille, hauteur)s de m arbres
    construits par genererABRparInsEtSup sur 2 permutations de taille 2n '''
def statsHauteursABRparInsEtSup(n, m) :
    res = []
    for i in range(m):
        arbre,taille = genererABRparInsEtSup(permutation(2*n),permutation(2*n))
        res+=[(taille,hauteur(arbre))]
    return res

#
# NE PAS MODIFIER
#

def tracerInsPuisSup(limite, pas, m):
    print('Test InsPuisSup')
    lx, ly, ly_moy = [], [], []
    for i in range(1, limite, pas) :
        print('Stat calculée : %d / %d' % (i, limite), end="\r")
        tmp = statsHauteursABRparInsPuisSup(i, m)
        lx.extend([i]*m)
        ly.extend(tmp)
        ly_moy.append(sum(tmp)/m)
    print('Stat calculée : %d / %d' % (limite, limite))
    plt.plot([(math.log(i,2) if i>0 else 0) for i in range(limite)], color="blue")
    plt.plot(lx, ly, '.', color="orange")
    plt.plot(range(1,limite,pas), ly_moy, color="red")
    plt.ylabel('hauteur(n)')
    plt.xlabel('n = nombre noeuds')
    plt.title('Distribution des hauteurs d\'arbres aléatoires obtenus par insertions puis suppressions')
    plt.show()
    print('')

def tracerInsEtSup(limite, pas, m):
    print('Test InsEtSup')
    lx, ly = [], []
    plt.plot([(math.log(i,2) if i>0 else 0) for i in range(limite)], color="blue")
    for i in range(1, limite, pas) :
        print('Stat calculée : %d / %d' % (i, limite), end="\r")
        tailles, hauteurs = list(zip(*statsHauteursABRparInsEtSup(i, m)))
        lx.extend(tailles)
        ly.extend(hauteurs)
    print('Stat calculée : %d / %d' % (limite, limite))
    plt.plot(lx, ly, '.', color="green")
    plt.ylabel('hauteur(n)')
    plt.xlabel('n = nombre noeuds')
    plt.title('Distribution des hauteurs d\'arbres aléatoires obtenus par insertions et suppressions')
    plt.show()
    print('')


if __name__ == '__main__':
    tracerInsPuisSup(100,5,5)
    tracerInsEtSup(1000,50,10)
