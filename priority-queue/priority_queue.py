class Heap(object):
    def __init__(self):
        self.data = []


    def sift_down(self, i):
        left = 2 * i + 1
        right = 2 * i + 2
        x = i
        if left < len(self.data) and right < len(self.data):
            if self.data[left] > self.data[right]:
                x = left
            if self.data[left] < self.data[right]:
                x = right
        if x != i:
            self.data[i], self.data[x] = self.data[x], self.data[i]


    def sift_up(self, i):
        parent = (i - 1) // 2
        while i > 0 and self.data[parent] < self.data[i]:
            self.data[i], self.data[parent] = self.data[parent], self.data[i]
            i = parent
            parent = (i - 1) // 2
           

    def get_max(self):
        x = self.data[0]
        self.data[0] = self.data[-1]
        self.data.pop()
        if len(self.data) > 0:
            self.sift_down(0)
        return x


    def insert(self, x):
        self.data.append(x)
        if len(self.data) > 1:
            self.sift_up(len(self.data) - 1)

n = int(input())
data = Heap()
for i in range (n):
    s = input()
    if s == "GET":
        print (data.get_max())
    else:
        data.insert(int(s))

