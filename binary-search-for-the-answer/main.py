class BinarySearchForTheAnswer:
    def __init__(self, N, coords, k):
        self.coords = coords
        self.left = 0
        self.right = coords[N-1] - coords[0]
        self.k = k

    def check_answer(self, answer):
        k = 1
        last = self.coords[0]
        for coord in self.coords:
            if (coord - last > answer):
                k += 1
                last = coord
        return k <= self.k  

    def search(self):
        while (self.left < self.right):
            self.middle = (self.left + self.right)//2
            if (self.check_answer(self.middle)):
                self.right = self.middle
            else:
                self.left = self.middle+1

        return self.left


if __name__ == "__main__":
    N = int(input())
    k = int(input())
    coords = []
    for i in range(N):
        coords.append(int(input()))
    binary_search = BinarySearchForTheAnswer(N, coords, k)
    print(binary_search.search())