def binary_search(array, x_i):
    left = 0
    right = len(array) - 1

    while left <= right:
        middle = (left + right) // 2

        if x_i > array[middle]:
            left = middle + 1
        elif x_i < array[middle]:
            right = middle - 1
        else:
            return middle
    return -1


if __name__ == '__main__':
    N = int(input())
    array = [int(i) for i in input().split(" ")]
    K = int(input())

    for x_i in range(K):
        x_i = int(input())
        print(binary_search(array, x_i))
