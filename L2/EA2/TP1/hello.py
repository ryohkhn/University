#!/usr/bin/env python3
from copy import copy


def affiche():
    print("Hello World!")
    print("Bonjour le monde!")


def dev():
    print ("developpeur Lucas")


def exo3q2():
    list1 = range(0, 10)
    list2 = range(2, 11)
    list3 = range(2, 11, 2)
    list4 = range(10, 0, -2)
    for i in list1:
        print(i)
    print("-----")
    for i in list2:
        print(i)
    print("-----")
    for i in list3:
        print(i)
    print("-----")
    for i in list4:
        print(i)


def exo3q3():
    listL1 = [i for i in range(0, 13, 2)]
    listL2 = [i for i in "abcdef"]
    listL1.reverse()
    listL3 = zip(listL2, listL1)
    for i in listL3:
        print(i)


def exo3q4():
    listL1 = [i for i in range(0, 13, 2)]
    print(listL1)
    listL2 = [i for i in "abcdef"]
    listL1.reverse()
    listL3 = list(zip(listL2, listL1))
    print(listL3)
    print(listL3[2:5])
    print(listL3[1::2])
    listL4 = copy(listL3)
    listL5 = [i for i in range(0, 1000, 7)]
    listL5 = listL5[1:21]
    for i in range(2, len(listL5), 3):
        listL5[i] = 0

    print(listL5)


def exo3q6():
    list = [i for i in range(2,36,3)]
    LG = list[0:len(list)//2]
    LD = list[len(list)//2:len(list)]
    print(LG)
    print(LD)


# exo3q3()
# exo3q4()
exo3q6()
