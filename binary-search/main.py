class BinarySearch:
    def __init__(self, N, array):
        self.array = array
        self.left = 0
        self.right = N-1
        self.index = -1

    def search(self, x_i):
        while (self.left < self.right):
            self.middle = (self.left + self.right)//2
            if (x_i == self.array[self.middle]):
                self.index = self.middle
                return
            if (x_i > self.array[self.middle]):
                self.left = self.middle+1
            else:
                self.right = self.middle-1
                
        self.middle = (self.left + self.right)//2
        if (x_i == self.array[self.middle]):
            self.index = self.middle
            return


if __name__ == "__main__":
    N = int(input())
    array = [int(n) for n in input().split()]
    K = int(input())
    for i in range (K):
        binary_search = BinarySearch(N, array)
        x_i = int(input())
        binary_search.search(x_i)
        print(binary_search.index)