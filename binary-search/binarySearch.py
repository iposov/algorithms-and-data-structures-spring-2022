#!/bin/python

# читаем из файла массив с числами
ArrayLength = input()
ArrayStr = input()
ArrayMapped = map(int,ArrayStr.split(' '))
Array = list(ArrayMapped)

# метод принимает рабочий массив и искомое число
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

# читаем количество чисел, которые надо найти
searchNumCount = int(input())
# searchNumCount читаем число и ищем его в массиве
for x in range(searchNumCount):
    num = int(input())
    print(binSearch(Array,num))