import collections


def put_coin_to_the_sum(coins_count, coins_by_value, cur_sum):
    for coin_of_value in list_of_coin_values:
        if cur_sum + coin_of_value < target:
            coins_count += 1
            coins_by_value[coin_of_value] += 1
            cur_sum += coin_of_value
            copy_coins_by_value = dict(coins_by_value)
            result, final_coins = put_coin_to_the_sum(coins_count, copy_coins_by_value, cur_sum)
            # return result, final_coins
        elif cur_sum + coin_of_value == target:
            coins_count += 1
            coins_by_value[coin_of_value] += 1
            cur_sum += coin_of_value
            return True, coins_by_value
    return False, None


coin_types = int(input()) - 4
dict_coins_by_value = dict()
list_of_coin_values = []
for i in range(coin_types):
    value = int(input())
    dict_coins_by_value[value] = 0
    list_of_coin_values.append(value)
list_of_coin_values.sort(reverse=True)
target = int(input())
# cur_coins = [0] * len(coin_values)
result, final_coins = put_coin_to_the_sum(0, dict_coins_by_value, 0)

sum = 0
for key, value in final_coins.items():
    sum += value
print(sum)
for key, value in final_coins.items():
    print(value)
