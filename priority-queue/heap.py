class MaxHeap:
    def __init__(self):
        super().__init__()
        self.a = []

    def sift_down(self, i):
        while 2 * i + 1 < len(self.a):
            left = 2 * i + 1
            right = 2 * i + 2
            j = left

            if right < len(self.a) and self.a[right] > self.a[left]:
                j = right
            if self.a[i] > self.a[j]:
                break
            self.a[i], self.a[j] = self.a[j], self.a[i]
            i = j

    def sift_up(self, i):
        while (i - 1) // 2 >= 0 and self.a[i] > self.a[(i - 1) // 2]:
            self.a[i], self.a[(i - 1) // 2] = self.a[(i - 1) // 2], self.a[i]
            i = (i - 1) // 2

    def extract_max(self):
        max_el = self.a[0]
        self.a[0] = self.a[-1]
        self.a.pop(-1)
        self.sift_down(0)
        return max_el

    def insert(self, key):
        self.a.append(key)
        self.sift_up(len(self.a) - 1)


def main():
    n = int(input())
    heap = MaxHeap()
    for _ in range(n):
        inp = input()
        print(heap.extract_max()) if inp == "GET" else heap.insert(int(inp))


if __name__ == '__main__':
    main()
