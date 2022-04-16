def binary_search(arr, elem):
    left, right = 0, len(a) - 1
    while left <= right:
        middle = int((l + r) / 2)
        if arr[middle] > elem:
            right = middle - 1
        elif arr[middle] < elem:
            left = middle + 1
        elif arr[middle] == elem:
            return middle
    return -1

if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split(" ")))
    count = int(input())
    for x in range(count):
        x = int(input())
        print(binary_search(arr, x))