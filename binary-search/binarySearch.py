#!/bin/python

ArrayLength = input()
ArrayStr = input()
ArrayMapped = map(int,ArrayStr.split(' '))
Array = list(ArrayMapped)

def binSearch(Array,searchNum):
    left = 0
    right = len(Array)-1
    while(left<=right):
        middle = (left+right)//2
        if(Array[middle] == searchNum):
            return middle
        elif(Array[middle]<searchNum):
            left = middle+1
        else:
            right = middle-1
    return -1

searchNumCount = int(input())
for x in range(searchNumCount):
    num = int(input())
    print(binSearch(Array,num))