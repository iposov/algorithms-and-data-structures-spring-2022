import math


def binary_search(x_i, A):
    left = 0
    right = len(A) - 1

    while left <= right:
        middle = math.floor((left + right)/2)
        if A[middle] < x_i:
            left = middle + 1
        elif A[middle] > x_i:
            right = middle - 1
        else:
            return middle
    return -1


def main():
    N = int(input())
    A = list(map(int, input().split()))
    K = int(input())
    for i in range(K):
        x_i = int(input())
        print(binary_search(x_i, A))
        print(binary_search(x_i, A))


if __name__ == "__main__":
    main()


