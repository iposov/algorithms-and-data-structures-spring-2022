from typing import Optional
from typing import List


class BinHeap:
    def __init__(self, a: Optional[List] = None) -> None:
        self.a = []

        if a:
            for el in a:
                self.insert(el)

    @property
    def size(self) -> int:
        return len(self.a)

    @property
    def empty(self) -> bool:
        return self.size == 0

    def insert(self, element):
        self.a.append(element)

        size = self.size
        self._siftUp(size - 1)

    def max(self) -> int:
        if not self.empty:
            return self.a[0]

    def pop(self) -> int:
        if self.empty:
            raise IndexError("tried to pop an empty queue")

        if self.size == 1:
            return self.a.pop()
        else:
            value = self.a[0]
            self.a[0] = self.a[-1]
            self.a.pop()
            self._siftDown(0)
            return value

    def _siftUp(self, i):
        if i <= 0:
            return

        parent = int((i - 1) / 2)
        if self.a[i] > self.a[parent]:
            self.a[i], self.a[parent] = self.a[parent], self.a[i]
            self._siftUp(parent)

    # TODO: turn into recursive
    def _siftDown(self, i):
        while 2 * i + 1 < self.size:
            left, right = 2 * i + 1, 2 * i + 2
            j = left
            if right < self.size and self.a[right] > self.a[left]:
                j = right
            if self.a[i] >= self.a[j]:
                break
            self.a[i], self.a[j] = self.a[j], self.a[i]
            i = j

def main():
    h = BinHeap()

    input_size = int(input())
    for _ in range(input_size):
        command = input()
        if command == "GET":
            print(h.pop())
        else:
            try:
                num = int(command)
                h.insert(num)
            except ValueError:
                pass


if __name__ == "__main__":
    main()