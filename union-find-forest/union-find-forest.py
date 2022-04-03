from __future__ import annotations
from typing import Optional, Tuple

class Node:

    def __init__(
            self,
            value: int,
            next: Optional[Node] = None,
            head: Optional[Node] = None,
            tail: Optional[Node] = None
        ) -> None:
        self.value = value
        self.next = next
        self.head = head if head else self
        self.tail = tail if tail else self

        if head == None:
            self.head = self
        else:
            self.head = None
        if tail == None:
            self.tail = self
        else:
            self.tail = None

class ListUnions:

    def __init__(self, size) -> None:
        self.elements = [Node(num) for num in range(size)]

    def find_rep(self, element: int) -> Node:
        return self.elements[element].head

    def find(self, element: int) -> int:
        return self.find_rep(element).value
    
    def unite(self, x: int, y: int) -> None:
        if self.find(x) == self.find(y):
            return

        x_node_rep = self.find_rep(x)
        y_node_rep = self.find_rep(y)
        x_node_rep.tail.next = y_node_rep
        x_node_rep.tail = y_node_rep.tail

        while y_node_rep != None:
            y_node_rep.head = x_node_rep
            y_node_rep = y_node_rep.next

class NaiveUnions:

    def __init__(self, size) -> None:
        self.elements = [i for i in range(size)]

    def find(self, element: int) -> int:
        return self.elements[element]

    def unite(self, x: int, y: int) -> None:
        if self.find(x) == self.find(y):
            return
        
        common_union = self.find(x)
        for element, union in enumerate(self.elements):
            if union == y:
               self.elements[element] = common_union

def read_pair() -> Tuple[int, int]:
    x, y = [int(elem) for elem in input().split(" ")]
    return (x, y)

def main():
    set_size, k_unions = read_pair()

    unions = ListUnions(set_size)

    for _ in range(k_unions):
        x, y = read_pair()
        if unions.find(x) == unions.find(y):
            print("YES")
        else:
            unions.unite(x, y)
            print("NO")


if __name__ == "__main__":
    main()