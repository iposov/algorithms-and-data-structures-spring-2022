#!/bin/python

class Heap:
    def __init__(self):
        self.list = []


    def siftDown(self,i):
        while len(self.list)>2*i+1:
            left = 2*i+1
            right = 2*i+2
            j = left
            if(right<len(self.list)) and (self.list[right]>self.list[left]):
                j = right
            if(self.list[i]>self.list[j]):
                break
            self.list[i], self.list[j] = self.list[j], self.list[i]
            i = j


    def siftUp(self,i):
        while self.list[i]>self.list[(i-1)//2] and i>0:
            self.list[i], self.list[(i-1)//2] = self.list[(i-1)//2], self.list[i]
            i = (i-1)//2

    def getMinimal(self):
        minimal = self.list[0]
        self.list[0] = self.list[-1]
        del self.list[-1]
        self.siftDown(0)
        return minimal
    
    def insert(self,i):
        self.list.append(i)
        self.siftUp(len(self.list)-1)

n = int(input())
heap = Heap()
for x in range(n):
    value = input()
    if(value == "GET"):
        minimal = heap.getMinimal()
        print(minimal)
    else:
        heap.insert(int(value))