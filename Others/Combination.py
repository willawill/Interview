import sys

def printList(alist):
    print ''.join(alist)

def printUniqueCombinations(alist, numb, blist=[]):
    if not numb: return printList(blist)
    for i in range(len(alist)):
        blist.append(alist[i])
        print blist[0:len(blist)]
        printUniqueCombinations(alist[i+1:], numb-1, blist)
        blist.pop()


if __name__ == '__main__':
    k='love'
    n=len(k)

    for i in range(len(k)+1):
        printUniqueCombinations(list(k), i)
