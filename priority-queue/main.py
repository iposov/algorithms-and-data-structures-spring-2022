class BinaryHeap:
    def __init__(self):
        self.array = []
        self.size = 0

    def sift_down(self, i):
        while (2*i+1 < self.size):
            left = 2 * i + 1
            right = 2 * i + 2
            j = left
            if (right < self.size and self.array[right] > self.array[left]):
                j = right
            if (self.array[i] > self.array[j]):
                break
            self.array[i], self.array[j] = self.array[j], self.array[i]
            i = j

    def get(self):
        print(self.array[0])
        self.array[0] = self.array[self.size-1]
        self.size -= 1
        self.array.pop(-1)
        self.sift_down(0)

    def sift_up(self, i):
        while (self.array[i] > self.array[(i-1)//2] and i > 0):
            self.array[i], self.array[(i-1)//2] = self.array[(i-1)//2], self.array[i]
            i = (i - 1) // 2

    def insert(self, num):
        self.size += 1
        self.array.append(num)
        self.sift_up(self.size - 1)


if __name__ == "__main__":
    N = int(input())
    heap = BinaryHeap()
    for i in range (N):
        cmd = input()
        if (cmd == "GET"):
            heap.get()
        else:
            heap.insert(int(cmd))
