def cs(coins, k, n):
    bool_array = [False for _ in range(n + 1)]
    bool_array[0] = True

    for i in range(n + 1):
        for j in range(k):
            if i - coins[j] >= 0:
                if bool_array[i - coins[j]]:
                    bool_array[i] = True
                    break

    if bool_array[n]:
        return "YES"
    else:
        return "NO"

def main():
    k = int(input())
    coins = [int(input()) for _ in range(k)]
    n = int(input())
    print(cs(coins, k, n))


if __name__ == "__main__":
    main()