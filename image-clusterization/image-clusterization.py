# BFS to mark whole island, when marked, search for next island
# list of tuples (#, num of island)
import numpy
import numpy as np


def set_mark(map, y, x, cur_mark):
    if map[y][x] == 0:
        map[y][x] = cur_mark


def mark_island(A):
    A_map = np.zeros(shape=(height, width)).astype(int)
    to_mark = set() # set, чтобы не добавлять дубли
    cur_island = 0
    for y in range(height):
        for x in range(width):
            _temp_A = A[y][x]
            _temp_A_map = A_map[y][x]
            if A[y][x] == '#' and A_map[y][x] == 0:
                cur_island += 1
                to_mark.add((y, x))
                while to_mark:
                    _y, _x = to_mark.pop()
                    set_mark(A_map, _y, _x, cur_island)
                    if _y + 1 < height and A[_y + 1][_x] == '#':  # bot
                        if A_map[_y+1][_x] == 0:
                            to_mark.add((_y + 1, _x))
                    if _y - 1 >= 0 and A[_y - 1][_x] == '#':  # top
                        if A_map[_y - 1][_x] == 0:
                            to_mark.add((_y - 1, _x))
                    if _x + 1 < width and A[_y][_x + 1] == '#':  # right
                        if A_map[_y][_x + 1] == 0:
                            to_mark.add((_y, _x + 1))
                    if _x - 1 >= 0 and A[_y][_x - 1] == '#':  # left
                        if A_map[_y][_x - 1] == 0:
                            to_mark.add((_y, _x - 1))

    return cur_island, A_map


temp = list(map(int, input().split()))
height = temp[0]
width = temp[1]
A_temp = []
for i in range(height):
    A_temp.append(list(input()))

island_count, A_mapped = mark_island(A_temp)
print(island_count)

