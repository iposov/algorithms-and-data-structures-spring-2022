def check(sum_idx, coins):
    result = [False] * (sum_idx + 1)
    result[0] = True
    for i in range(1, sum_idx+1):
        for coin in coins:
            if 0 < coin <= i:
                if result[i - coin]:
                    result[i] = True
                    break
    return result[sum_idx]


if __name__ == '__main__':
    input_values = [int(input()) for _ in range(int(input()))]

    if check(int(input()), input_values):
        print("YES")
    else:
        print("NO")
