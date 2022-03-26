import array


class PriorityQueue:
    def __init__(self):
        self.a = array.array('i', [])

    def __getitem__(self, key):
        return self.a[key]

    def __setitem__(self, key, value):
        self.a[key] = value

    def heap_size(self):
        return len(self.a)

    def sift_down(self, i):
        while 2 * i + 1 < self.heap_size():
            left = 2 * i + 1
            right = 2 * i + 2
            j = left
            if right < self.heap_size() and self[right] > self[left]:
                j = right
            if self[i] >= self[j]:
                break
            self[i], self[j] = self[j], self[i]
            i = j

    def insert(self, key):
        self.a.insert(0, key)
        self.sift_down(0)

    def extract(self):
        max = self[0]
        self[0] = self[self.heap_size() - 1]
        self.a.pop(self.heap_size() - 1)
        self.sift_down(0)
        return max


heap = PriorityQueue()
N = int(input())
for b in range(N):
    i = input()
    if i == 'GET':
        print(heap.extract())
    else:
        heap.insert(int(i))
