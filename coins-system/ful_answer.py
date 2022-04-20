def check(sum_idx, coins):
    result = [False] * (sum_idx + 1)
    result[0] = True
    results = [[]] * (sum_idx + 1)
    results[0] = [0] * len(coins)
    for i in range(1, sum_idx+1):
        for j, coin in enumerate(coins):
            if 0 < coin <= i:
                if result[i - coin]:
                    results[i] = results[i - coin].copy()
                    results[i][j] += 1
                    result[i] = True
                    break
    return results[sum_idx]


if __name__ == '__main__':
    input_values = [int(input()) for _ in range(int(input()))]

    answer = check(int(input()), input_values)
    if answer:
        print(sum(answer))
        print('\n'.join(map(str, answer)))
    else:
        print(-1)

