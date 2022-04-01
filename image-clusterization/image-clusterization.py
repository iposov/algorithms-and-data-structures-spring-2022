# BFS to mark whole island, when marked, search for next island
# list of tuples (#, num of island)
import numpy as np


def mark_island(A, A_mapped, island_number, x_start, y_start):
    list_to_mark = [(x_start, y_start)]
    while list_to_mark:
        print()


def print_matrix(matrix, without_quotes = True):
    if without_quotes:
        for row in matrix:
            for char in row:
                print(char, end='')
            print()
    else:
        for row in matrix:
            print(row)


number_of_islands = 0
temp = list(map(int, input().split()))
height = temp[0]
width = temp[1]
A = np.matrix()
A_mapped = np.zeros(shape=(5, 5)) # [[None]*width]*height
for i in range(height):
    A.append(list(input()))
print(number_of_islands)
