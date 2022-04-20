from math import ceil


def binary_search(array, value):
    left = 0
    right = len(array)
    while left < right - 1:
        middle = ceil((right + left) / 2)
        if value >= array[middle]:
            left = middle
        else:
            right = middle
    if array[left] == value:
        print(left)
    else:
        print(-1)


if __name__ == '__main__':
    input()
    array = list(map(int, input().strip().split()))

    amount = int(input())
    for _ in range(amount):
        binary_search(array, int(input()))
