def binary_search(a, xi):
    left = 0
    right = len(a) - 1
    while left - right <= 0:
        middle = (left + right) // 2
        if xi < a[middle]:
            right = middle - 1
        elif xi > a[middle]:
            left = middle + 1
        else:
            return middle
    return -1

if __name__ == '__main__':
    n = int(input())
    a = [int(n) for n in input().split()]
    print(n)
    print(list(a))
    k = int(input())
    for new_element in range(k):
        new_element = int(input())
        print(binary_search(a, new_element))

