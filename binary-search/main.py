def binary_search(array, x_i):
    left = 0
    N = len(array)
    right = N - 1

    while left <= right:
        middle = (left + right) // 2
        if (x_i < array[middle]):
            right = middle - 1
        else:
            if (x_i > array[middle]):
                left = middle + 1
            else:
                return middle
    return -1

if __name__ == "__main__":
    n = int(input())
    a = [int(x) for x in input().split()]
    k = int(input())
    for i in range(0, k):
        x_i = int(input())
        res = binary_search(a, x_i)
        print(res)
