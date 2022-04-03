from typing import Tuple


class Graph:

    def __init__(self, grid) -> None:
        self.paired_grid = grid
        self.visited = set()
    
    def walk(self) -> int:
        sum = 0
        for i in range(len(self.paired_grid)):
            for j in range(len(self.paired_grid[0])):
                sum += self.bfs(i, j)

        return sum

    def bfs(self, i: int, j: int) -> int:
        if not self.in_grid(i, j):
            return 0
        
        if self.get_item(i, j) == '.':
            return 0
        
        if (i, j) in self.visited:
            return 0
        
        self.visited.add((i, j))

        if self.get_item(i, j) == '#':
            for point in self.get_neighbours(i, j):
                self.bfs(*point)
            return 1

    def get_neighbours(self, i: int, j: int):
        raw = [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]
        return [point for point in raw if self.in_grid(*point)]

    def get_item(self, i: int, j: int):
        if not self.in_grid(i, j):
            raise RuntimeError("Not in grid!")
        
        return self.paired_grid[i][j]

    def in_grid(self, i: int, j: int) -> bool:
        return 0 <= i < len(self.paired_grid) and 0 <= j < len(self.paired_grid[0])
        

def read_pair() -> Tuple[int, int]:
    x, y = [int(elem) for elem in input().split(" ")]
    return (x, y)

def main():
    lines, columns = read_pair()
    grid = []
    for i in range(lines):
        line = input()
        grid.append(line)
    
    g = Graph(grid)
    print(g.walk())

if __name__ == "__main__":
    main()
