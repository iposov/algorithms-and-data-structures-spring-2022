from calendar import c
from dataclasses import dataclass
from logging import root
from operator import truediv


class Node:
    def __init__(self, key, left=None, right=None):
        self.key = key
        self.right = right
        self.left = left

class Tree:
    def __init__(self,root=None):
        self.root = root
    
    def search(self, node, k):
        if(node == None):
            return False
        if (node.key == k):
            return True
        if (node.key > k):
            return self.search(node.left, k)
        else:
            return self.search(node.right, k)

    def add(self, node, k):
        if node == None:
            return Node(k)
        elif k < node.key:
            node.left = self.add(node.left, k)
        else:
            node.right = self.add(node.right, k)
        return node

    def next(self, node, k):
        current = self.root
        successor = None
        while (current != None):
            if(current.key > k):
                successor = current
                current = current.left
            else:
                current = current.right
        return successor


def main():
    N = int(input())
    root = Node(int(input()))
    tree = Tree(root) 
    #print("-")
    #comment for contains.in
    print("- -")
    for _ in range(N-1):
        num = int(input())
        if(tree.search(root, num)):
            #print("+")
            #comment for contains.in
            print("+", end = " ")

        else:
             #print("-")
             #comment for contains.in
             print("-", end = " ")
             tree.add(root, num)
        
        #comment for contains.in
        next = tree.next(root, num)
        if(next != None):
          print(next.key)
        else:
           print("-")

if __name__ == "__main__":
    main()
