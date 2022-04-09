class Lake:
    def __init__(self, m, n, rows):
        self.m = m
        self.n = n
        self.rows = rows
        self.arr = []
        for i in range(m*n):
            self.arr.append(i)

    def find(self, x):
        while self.arr[x] != x:
            x = self.arr[x]
        return x

    def union(self, x, y):
        x_n = self.find(x)
        y_n = self.find(y)
        if x_n == y_n:
            return "YES"
        self.arr[x_n] = y_n
        return "NO"

    def is_upper(self, idx):
        if idx-self.n >= 0:
            return self.rows[idx-self.n] == "#"
        else:
            return False

    def is_lefter(self, idx):
        if idx % self.n != 0:
            return self.rows[idx-1] == "#"
        else:
            return False

    def cluster(self):
        for i in range(self.m):
            for j in range(self.n):
                rows_idx = j + i * self.n
                # part os island is "#" symbol
                if self.rows[rows_idx] == "#":
                    # if there is part of island upper we need to union it with current part
                    if self.is_upper(rows_idx):
                        self.union(rows_idx, rows_idx-self.n)
                    # if there is part of island lefter we need to union it with current part
                    if self.is_lefter(rows_idx):
                        self.union(rows_idx, rows_idx-1)
        
        islands = set()
        for element in self.arr:
            if self.rows[element] == "#":
                islands.add(self.find(element))

        return len(islands)


if __name__ == "__main__":
    m, n = map(int, input().split())

    rows = []
    for i in range (m):
        rows.append(input())

    lake = Lake(m, n, "".join(rows))
    print(lake.cluster())
