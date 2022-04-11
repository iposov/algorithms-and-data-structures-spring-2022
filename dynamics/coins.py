from testslib.TestsSuite import TestsSuite
import random


def collect(price, system):
    nums = [False] * (price + 1)
    nums[0] = True
    for i in range(price + 1):
        for coin in system:
            if i - coin >= 0 and nums[i - coin]:
                nums[i] = True
                break

    return nums[price]


def collect_compress(price, system):
    max_coin = max(system)
    mod = max_coin + 1
    nums = [False] * mod
    nums[0] = True
    for i in range(1, price + 1):
        i_ = i % mod
        found_coin = False
        for coin in system:
            i_coin = (i - coin) % mod
            if nums[i_coin]:
                found_coin = True
                break
        nums[i_] = found_coin

    return nums[price % mod]


def collect_optimal(price, system):
    count = len(system)
    max_coin = max(system)
    mod = max_coin + 1
    nums = [False] * mod
    nums[0] = [0] * count, 0

    for i in range(1, price + 1):
        i_ = i % mod
        optimal_count = 0
        optimal_coin_index = -1
        optimal_numbers = []
        for coin_index, coin in enumerate(system):
            i_coin = (i - coin) % mod
            if nums[i_coin]:
                numbers, total = nums[i_coin]
                if optimal_coin_index < 0 or total < optimal_count:
                    optimal_coin_index = coin_index
                    optimal_count = total
                    optimal_numbers = numbers
        if optimal_coin_index >= 0:
            new_numbers = optimal_numbers.copy()
            new_numbers[optimal_coin_index] += 1
            nums[i_] = new_numbers, optimal_count + 1
        else:
            nums[i_] = False

    result = nums[price % mod]
    if not result:
        return False

    return result[0]


# print(collect(10, [2, 3, 7]))
# print(collect(1, [2, 3, 7]))
# print(collect(6, [2, 5, 7]))
# print(collect(100, [11, 17, 23]))
#
# print("-----------------")
#
# print(collect_compress(10, [2, 3, 7]))
# print(collect_compress(1, [2, 3, 7]))
# print(collect_compress(6, [2, 5, 7]))
# print(collect_compress(100, [11, 17, 23]))
#
# print("--------------------")
#
# print(collect_optimal(10, [2, 3, 7]))
# print(collect_optimal(1, [2, 3, 7]))
# print(collect_optimal(6, [2, 5, 7]))
# print(collect_optimal(100, [11, 17, 27]))
#
# print(collect_optimal(1_000_000_000, [11, 17, 27]))

random.seed(42)

with TestsSuite('coins-system') as ts:
    for i in range(7, 20):
        n = random.randint(2 ** i, 2 ** (i + 1))
        coins_probably_possible = random.sample(range(2, 50), i - 4)
        coins_probably_impossible = random.sample(range(n // 7, n // 3), i - 4)
        for coins in coins_probably_possible, coins_probably_impossible:

            tc = ts.get()
            statement = tc.statement()
            print(len(coins), file=statement)
            print(*coins, sep='\n', file=statement)
            print(n, file=statement)

            result = collect_optimal(n, coins)

            ans1 = tc.answer('possible')
            ans2 = tc.answer('how-many')
            ans3 = tc.answer('full-answer')

            if result:
                print('YES', file=ans1)
                print(sum(result), file=ans2)
                print(sum(result), file=ans3)
                print(*result, sep='\n', file=ans3)
            else:
                print('NO', file=ans1)
                print(-1, file=ans2)
                print(-1, file=ans3)


    tc = ts.get()
    st = tc.statement()
    ans1 = tc.answer('possible')
    ans2 = tc.answer('how-many')
    ans3 = tc.answer('full-answer')

    print('''3
11
17
27
1000000000''', file=st)

    print('YES', file=ans1)
    print(37037038, file=ans2)
    print(37037038, file=ans3)
    print(1, file=ans3)
    print(1, file=ans3)
    print(37037036, file=ans3)
