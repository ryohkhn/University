#!/usr/bin/env python3

from tp5 import Vide, Noeud, Feuille, etiquetteRacine, estVide, filsGauche, filsDroit
from tp5 import arbre3ABR1, arbre3ABR2, arbre3ABR3, arbre10ABR1, arbre10ABR2, arbre100ABR1, arbre100ABR2, arbre100notABR, dessineArbreBinaire
from tp5 import arbreBinaireVersFichier, arbreBinaireDeFichier
from ea4lib import printcol

#
# À COMPLÉTER !
#
def parcoursInfixe(arbre):
    if arbre is Vide: return arbre
    res=[]
    if filsGauche(arbre)!=Vide: res+=parcoursInfixe(filsGauche(arbre))
    res+=[etiquetteRacine(arbre)]
    if filsDroit(arbre)!=Vide: res+=parcoursInfixe(filsDroit(arbre))
    return res

#
# À COMPLÉTER !
#
def estUnABR(arbre) :
    if arbre is Vide: return False
    res=parcoursInfixe(arbre)
    for i in range(0,len(res)-1):
        if res[i]>res[i+1]:
            return False
    return True

#
# À COMPLÉTER !
#
''' l'étiquette minimale de l'arbre (en supposant que c'est un ABR).
    Renvoie None si l'arbre est vide '''
def minimumABR(arbre) :
    if arbre is Vide: return None
    if filsGauche(arbre) is Vide:
        return etiquetteRacine(arbre)
    return minimumABR(filsGauche(arbre))

#
# À COMPLÉTER !
#
''' l'étiquette maximale de l'arbre (en supposant que c'est un ABR).
    Renvoie None si l'arbre est vide '''
def maximumABR(arbre) :
    if arbre is Vide: return None
    if filsDroit(arbre) is Vide:
        return etiquetteRacine(arbre)
    return maximumABR(filsDroit(arbre))

#
# À COMPLÉTER !
#
''' retourne True si elt est dans arbre (en supposant que arbre est un ABR) '''
def rechercheABR(arbre, elt) :
    if arbre is Vide: return False
    if elt>etiquetteRacine(arbre):
        return rechercheABR(filsDroit(arbre),elt)
    elif elt<etiquetteRacine(arbre):
        return rechercheABR(filsGauche(arbre), elt)
    else: return True

#
# À COMPLÉTER !
#
''' insère correctement elt dans arbre (en supposant que arbre est un ABR) '''
def insertionABR(arbre, elt) :
    if arbre is Vide:
        return Feuille(elt)
    if elt>etiquetteRacine(arbre):
        return Noeud(etiquetteRacine(arbre),filsGauche(arbre),insertionABR(filsDroit(arbre),elt))
    elif elt<etiquetteRacine(arbre):
        return Noeud(etiquetteRacine(arbre),insertionABR(filsGauche(arbre),elt),filsDroit(arbre))
    else:
        return arbre


#####################################################################
##  TESTS
#####################################################################

def testData():
  return  [Vide, arbre3ABR1, arbre3ABR2, arbre3ABR3, arbre10ABR2, arbre100ABR1, arbre100ABR2]

def testEstABR():
  print('Test estUnABR:')

  arbreNot = Noeud(7,Feuille(4),Noeud(10,Feuille(6),Feuille(12)))

  tests=[(arbreNot, False), (arbre3ABR1,True), (arbre3ABR2,True), (arbre3ABR3,True), (arbre10ABR1, True), (arbre10ABR2, True), (arbre100ABR1, True), (arbre100ABR2, True),(arbre100notABR, False)]
  for i, (a, val) in enumerate(tests):
    print (' - test %d/%d: ' % (i + 1, len(tests)), end='')
    res = estUnABR(a)
    if res != val:
      printcol(" {echec}", "red", end='')
      print(": obtenu ", res, end='')
      print(" <> attendu ", val)
    else:
      printcol(" {ok}", "green")


def testResults():
    return [[minimumABR, 0,[None, 1, 1, 1, 1, 1, 1]],
        [maximumABR, 0, [None, 3, 3, 3, 10, 100, 100]],
        [rechercheABR, 1, [1,27,3,57,4,100,200],[False,False,True,False,True, True,False]]
        ]

def testAll() :
  tst = testResults()
  arbres = testData()
  print('Arbres : ')
  for j in range(len(arbres)) :
    print('- dessins/arb_' + str(j) + '.pdf')
    dessineArbreBinaire(arbres[j],'./dessins/arb_'+str(j))

  for i in range(len(tst)) :
    fname = tst[i][0]
    farg = tst[i][1]
    fres = tst[i][2 + farg]
    score = 0
    print('Test %s:' % fname.__name__)
    for j in range(len(arbres)) :
      a = arbres[j]
      print (' - test %d/%d: ' % (j + 1, len(arbres)), end='')
      res = fres[j]
      if (farg == 0) :
        res = fname(a)
      elif (farg == 1) :
        res = fname(a,tst[i][2][j])
      if (res == fres[j]) :
        printcol(" {ok}", "green")
        score += 1
      else :
        printcol(" {echec}", "red", end='')
        print(": obtenu ", res, end='')
        print(" <> attendu ", fres[j])
    printcol ('  score {%d/%d} ' % (score, len(arbres)), "cyan")

arbres = [Vide, arbre3ABR1, arbre3ABR2, arbre3ABR3, arbre100ABR1, arbre100ABR2]
elements = [4,4,2,10,27,123]

def testInsertion():
  arbres = [Vide, arbre3ABR1, arbre3ABR2, arbre3ABR3, arbre100ABR1, arbre100ABR2]
  elements = [4,4,2,10,27,123]
  score = 0
  print('Test Insertion')
  for i in range(len(arbres)):
    print (' - test %d/%d: ' % (i + 1, len(arbres)), end='')
    a = arbreBinaireDeFichier('tests/insertion_%d.txt' % i)
    b = insertionABR(arbres[i],elements[i])
    if a == b :
      printcol(" {ok}", "green")
      score += 1
    else:
        printcol(" {echec}", "red", end='')
        print(": obtenu ", b, end='')
        print(" <> attendu ", a)
  printcol ('  score {%d/%d} ' % (score, len(arbres)), "cyan")

def testInsertion2():
  elements=[7,3,9,65,12,1,5,8,13]
  arbre = Vide
  for elt in elements:
    arbre = insertionABR(arbre, elt)
  dessineArbreBinaire(arbre,"dessins/monarbre")
  res = arbreBinaireDeFichier("tests/arbre_insertions.txt")
  print("Test insertions successives a partir d'un arbre vide:", end='')
  if arbre == res :
      printcol(" {ok}", "green")
  else:
      printcol(" {echec}", "red", end='')
      print(": obtenu ", arbre, end='')
      print(" <> attendu ", res)

if __name__ == '__main__':
  testEstABR()
  testAll()
  testInsertion()
  testInsertion2()
