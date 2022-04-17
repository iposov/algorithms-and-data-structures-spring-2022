
def increasing_subsequence(n, array):
    f = [0] * n

    for i in range(n):
        for j in range(i):
            if array[j] < array[i] and f[j] > f[i]:
                f[i] = f[j]
        f[i] += 1

    return max(f)


def main():
    n = int(input())
    array = [int(input()) for _ in range(n)]
    print(increasing_subsequence(n, array))


if __name__ == "__main__":
    main()