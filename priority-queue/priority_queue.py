class Heap:
    def __init__(self):
        self.a = []
        self.size = 0

    def max_el(self):
        max_el = self.a[0]
        self.a[0] = self.a[self.size-1]
        self.size -= 1
        self.a.pop(-1)
        self.down(0)
        return max_el

    def down(self, i):
        while 2*i + 1 < self.size:
            left = 2 * i + 1
            right = 2 * i + 2
            j = left
            if right < self.size and self.a[right] > self.a[left]:
                j = right
            if self.a[i] > self.a[j]:
                break
            self.a[i], self.a[j] = self.a[j], self.a[i]
            i = j

    def insert(self, n):
        self.size += 1
        self.a.append(n)
        self.up(self.size - 1)

    def up(self, i):
        while self.a[i] > self.a[(i-1)//2] and i > 0:
            self.a[i], self.a[(i-1)//2] = self.a[(i-1)//2], self.a[i]
            i = (i - 1) // 2


if __name__ == "__main__":
    N = int(input())
    binary_heap = Heap()

    for _ in range(N):
        el = input()
        if el == "GET":
            print(binary_heap.max_el())
        else:
            binary_heap.insert(int(el))
