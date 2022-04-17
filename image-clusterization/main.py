
class UnionFindForest:
    def __init__(self, size):
        self.parents = list(range(size))
        self.rank = [0] * size

    def find(self, x):
        y = x
        while self.parents[x] != x:
            x = self.parents[x]
        while self.parents[y] != y:
            y = self.parents[y]
            self.parents[y] = x
        return x

    def union(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return False
        if self.rank[a] > self.rank[b]:
            self.parents[a] = b
        else:
            self.parents[b] = a
        self.rank[a] += 1
        self.rank[b] += 1
        return True

    def count_of_sets(self):
        unique_sets = [0] * len(self.parents)
        size = 0
        for a in self.parents:
            representative = self.find(a)
            if representative not in unique_sets:
                unique_sets[size] = representative
                size += 1
        return size


if __name__ == '__main__':
    n, m = map(int, input().strip().split())

    earth = []
    islands_indexes_set = set()
    islands_amount = 0
    for j in range(m):
        line = input()
        earth.append(line)
        islands_amount += line.count('#')
        islands_indexes_set = islands_indexes_set.union(set((j, i) for i, val in enumerate(line) if val == '#'))

    forest = UnionFindForest(islands_amount)

    islands_indexes_list = list(islands_indexes_set)

    for islands_index in sorted(islands_indexes_list):
        i, j = islands_index
        left_sibling = (i - 1, j)
        top_sibling = (i, j - 1)
        if left_sibling in islands_indexes_set:
            forest.union(islands_indexes_list.index(islands_index), islands_indexes_list.index(left_sibling))
        if top_sibling in islands_indexes_set:
            forest.union(islands_indexes_list.index(islands_index), islands_indexes_list.index(top_sibling))
    print(forest.count_of_sets())
