#!/usr/bin/env python3

#importe indirectement tp5 et ea4lib
from tp5_ex1 import *
from random import randint
import matplotlib.pyplot as plt
import math

''' retourne une permutation aléatoire de taille n selon la loi de
    probabilité uniforme '''
def permutation(n) :
    l = [ (i + 1) for i in range(n) ]
    for i in range(n) :
        r = randint(i, n - 1)
        if i != r :
            l[i], l[r] = l[r], l[i]
    return l

#
# À COMPLÉTER !
#
''' retourne la hauteur du sous-arbre de racine r de l'arbre
    (en particulier, -1 pour l'arbre vide) '''
def hauteur(arbre):
    if arbre is Vide: return -1
    if filsGauche(arbre) is Vide and filsDroit(arbre) is Vide:
        return 0
    hauteurGauche=1+hauteur(filsGauche(arbre))
    hauteurDroit=1+hauteur(filsDroit(arbre))
    return max(hauteurDroit,hauteurGauche)

#
# À COMPLÉTER !
#
''' renvoie un ABR construit par insertions successives des éléments
    de la permutation perm '''
def genererABRparInsertion(perm) :
    if len(perm)==0: return Vide
    arbre=Feuille(perm[0])
    for i in range(1,len(perm)):
        arbre=insertionABR(arbre,perm[i])
    return arbre

#
# À COMPLÉTER !
#
''' renvoie les hauteurs de m arbres de taille n, construits par
    genereABRparInsertion '''
def statsHauteursABRparInsertion(n,m) :
    res=[]
    for i in range(m):
        arbre=genererABRparInsertion(permutation(n))
        tmp=hauteur(arbre)
        res.append(tmp)
    return res



def tracer(limite, pas, m):
    '''trace la courbe des hauteurs, la hauteur moyenne et log(n) à base 2 '''
    print('Tracer de la courbe')
    lx, ly, ly_moy = [], [], []
    for i in range(1,limite,pas):
        print('Stat calculée : %d / %d' % (i, limite), end="\r")
        tmp = statsHauteursABRparInsertion(i, m)
        if tmp == None: return
        lx.extend([i]*m)
        ly.extend(tmp)
        ly_moy.append(sum(tmp)/m)
    print('Stat calculée : %d / %d' % (limite, limite))
    plt.plot([(math.log(i,2) if i>0 else 0) for i in range(limite)], color="blue")
    plt.plot(lx, ly, '.', color="orange")
    plt.plot(range(1,limite,pas), ly_moy, color="red")
    plt.ylabel('hauteur(n)')
    plt.xlabel('n = nombre noeuds')
    plt.title('Distribution des hauteurs d\'arbres aléatoires obtenus par n insertions')
    plt.show()
    print('')
    return ()


#####################################################################
##  TESTS
#####################################################################

def testHauteur() :
  arbres = [Vide, arbre3ABR1, arbre3ABR2, arbre3ABR3, arbre10ABR1, arbre10ABR2, arbre100ABR1, arbre100ABR2]
  res = [-1, 1, 2, 2, 9, 4, 12, 12]
  score = 0
  print('Test hauteur')
  for i in range(len(arbres)):
    print (' - test %d/%d: ' % (i + 1, len(arbres)), end='')
    if hauteur(arbres[i]) == res[i]:
      printcol(" {ok}", "green")
      score += 1
    else:
        printcol(" {echec}", "red", end='')
        print(": obtenu ", hauteur(arbres[i]), end='')
        print(" <> attendu ", res[i])
  printcol ('  score {%d/%d} ' % (score, len(arbres)), "cyan")

def testGenerer() :
  elements = [[2,1,3],[1,2,3],[3,1,2],[1, 2, 4, 3] ,[1, 6, 3, 2, 5, 4], [4, 9, 8, 5, 6, 1, 3, 10, 7, 2]]
  score = 0
  print('Test genereABRparInsertion')
  for i in range(len(arbres)):
    print (' - test %d/%d: ' % (i + 1, len(arbres)), end='')
    elt = elements[i]
    a = genererABRparInsertion(elt)
    res = arbreBinaireDeFichier('tests/testGenerer_%d.txt' % i)
    if a == res :
      printcol(" {ok}", "green")
      score += 1
    else:
        printcol(" {echec}", "red", end='')
        print(": obtenu ", a, end='')
        print(" <> attendu ", res)
  printcol ('  score {%d/%d} ' % (score, len(arbres)), "cyan")

if __name__ == '__main__':
    testHauteur()
    testGenerer()
    tracer(500,5,10)
    pass
