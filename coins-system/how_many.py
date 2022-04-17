def check(sum_idx, coins):
    result = [0] * (sum_idx + 1)
    result[0] = 1
    for i in range(1, sum_idx+1):
        for coin in coins:
            if 0 < coin <= i:
                if result[i - coin]:
                    result[i] = result[i - coin] + 1
                    break
    return result[sum_idx] - 1


if __name__ == '__main__':
    input_values = [int(input()) for _ in range(int(input()))]
    print(check(int(input()), input_values))
