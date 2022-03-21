class Stack:

    def __init__(self):
        self.a = []

    def push(self, x):
        self.a.append(x)

    def pop(self):
        return self.a.pop()

    def empty(self):
        return len(self.a) == 0


class Queue:

    def __init__(self):
        self.a = []

    def push(self, x):
        self.a.append(x)

    def pop(self):
        return self.a.pop(0)

    def empty(self):
        return len(self.a) == 0


class Graph:

    def __init__(self):
        self.edges = []

    def add_direct_edge(self, a, b):
        self._ensure_size(a)
        self._ensure_size(b)
        self.edges[a].append(b)

    def add_edge(self, a, b):
        self._ensure_size(a)
        self._ensure_size(b)
        self.edges[a].append(b)
        self.edges[b].append(a)

    def vertices_count(self):
        return len(self.edges)

    def search(self, u, dClass):
        n = self.vertices_count()
        color = [0] * n
        time_in = [0] * n

        d = dClass()

        next_time = 1

        d.push(u)
        color[u] = 1

        while not d.empty():
            v = d.pop()
            if color[v] == 2:
                continue
            time_in[v] = next_time
            next_time += 1
            color[v] = 2
            for w in self.edges[v]:
                if color[w] != 2:
                    color[w] = 1
                    d.push(w)

        return time_in

    def _ensure_size(self, n):
        while len(self.edges) <= n:
            self.edges.append([])


g = Graph()
g.add_edge(0, 1)
g.add_edge(1, 2)
g.add_edge(1, 3)
g.add_edge(2, 3)
g.add_edge(3, 4)
g.add_edge(3, 5)
g.add_edge(3, 6)
g.add_edge(4, 5)
g.add_edge(6, 5)
g.add_edge(0, 7)
g.add_edge(7, 8)
g.add_edge(7, 9)
g.add_edge(7, 10)
g.add_edge(8, 11)
g.add_edge(9, 11)
g.add_edge(10, 12)
g.add_edge(11, 12)


def invert_to_letters(a):
    b = [''] * len(a)
    for i, v in enumerate(a):
        b[v - 1] = chr(ord('a') + i)
    return b


dfs = g.search(0, Stack)
bfs = g.search(0, Queue)

print(''.join(invert_to_letters(dfs)))
print(''.join(invert_to_letters(bfs)))
