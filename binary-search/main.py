def find(arr, xi):
    left = 0
    right = len(arr) - 1
    while left <= right:
        middle = (left + right) // 2
        if xi < arr[middle]:
            right = middle - 1
        elif xi > arr[middle]:
            left = middle + 1
        else:
            return middle
    return -1


if __name__ == '__main__':
    N = input()
    arr = [int(n) for n in input().split()]
    K = int(input())
    for xi in range(K):
        xi = int(input())
        print(find(arr, xi))
