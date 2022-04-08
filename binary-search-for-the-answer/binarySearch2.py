#!/bin/python


def check(coordList,x,k):
    objs = 1
    lastObj = coordList[0]
    for coord in coordList:
        if(coord-lastObj>x):
            objs = objs+1
            lastObj = coord
    return k>=objs

def calc(coordList,k):
    # Самая левая точка точно хороший вариант
    left = 0
    right = coordList[-1]-coordList[0]
    while(right > left):
        middle = (left+right)//2
        if(check(coordList,middle,k)):
            right = middle
        else:
            left = middle+1
    return left, right

n = int(input())
k = int(input())
coordList = []
for x in range(n):
    coordList.append(int(input()))
result,_ = calc(coordList,k)
print(result)