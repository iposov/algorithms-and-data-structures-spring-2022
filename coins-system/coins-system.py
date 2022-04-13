import sys


def find_combination(coin_types, target):
    # я не придумал, как проверить, что сумма не была набрана меньшим количеством монет без этого,
    # 8 Гб памяти на лист из 10^9 чисел в 27 тесте
    # target + 1 монета не может потребоваться, что набрать сумму target
    got_sum_with_x_coins = [target + 1] * (target + 1)
    got_sum_with_x_coins[0] = 0

    dynamic_results = {0: dict.fromkeys(coin_types, 0)}
    coin_types_sorted = sorted(coin_types)
    double_max_coin = coin_types_sorted[-1] * 2

    for i in range(1, target + 1):
        for coin in coin_types:
            if i >= coin and got_sum_with_x_coins[i - coin] + 1 < got_sum_with_x_coins[i]:
                got_sum_with_x_coins[i] = got_sum_with_x_coins[i - coin] + 1
                dynamic_results[i] = dynamic_results[i - coin].copy()
                dynamic_results[i][coin] += 1
        if i % (double_max_coin * 10) == 0:
            # чтобы получить новый оптимальный набор никогда не потребуется обращаться к набору с суммой элементов
            # меньшей чем на max_coin * 2, чем текущего набора, поэтому хранить всю историю не нужно
            # освобождать память необязательно так часто, как можно
            # по идее потребление памяти с этим освобождением должно иметь потолок, но оно плавно растёт
            new_data = {k: v for k, v in dynamic_results.items() if k >= i - double_max_coin}
            dynamic_results.clear()
            dynamic_results = new_data
        if target > 1000000:
            if i % (target // 100) == 0:
                print(str(i // (target // 100)) + "/100", file=sys.stderr)

    if target in dynamic_results:
        final = dynamic_results[target]
        return final
    else:
        return None



def print_result(list_of_coin_types, amount_of_coins_by_type):
    if amount_of_coins_by_type:
        sum = 0
        for coin_type in list_of_coin_types:
            sum += amount_of_coins_by_type[coin_type]
        print(sum)
        for coin_type in list_of_coin_types:
            print(amount_of_coins_by_type[coin_type])
    else:
        print(-1)


coin_types_count = int(input()) - 4
coin_types = []
for i in range(coin_types_count):
    coin_types.append(int(input()))
# list_of_coin_types.sort(reverse=True)
target = int(input())

result = find_combination(coin_types, target)
print_result(coin_types, result)