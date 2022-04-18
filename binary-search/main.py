def binary_search(a, a_i):
    left = 0
    right = len(a) - 1
    while left <= right:
        middle = (left + right) // 2
        if a[middle] == a_i:
            return middle
        elif a_i < a[middle]:
            right = middle
        else:
            left = middle
    return -1

if __name__ == "__main__":
    file = int(input())
    a = []
    for i in input().split():
        a.append(int(i))
    x = int(input())
    for i in range(file):
        a_i = int(input())
        print(binary_search(a, a_i))
