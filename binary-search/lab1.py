def binary_search(a, a_i):
    start = 0
    end = len(a) - 1
    while start <= end:
        mid = (start + end) // 2
        if a[mid] == a_i:
            return mid
        elif a_i < a[mid]:
            end = mid - 1
        else:
            start = mid + 1
    return -1


def main():
    _ = int(input())
    a = []
    for el in input().split():
        a.append(int(el))
    k = int(input())
    for _ in range(k):
        a_i = int(input())
        print(binary_search(a, a_i))


if __name__ == "__main__":
    main()
