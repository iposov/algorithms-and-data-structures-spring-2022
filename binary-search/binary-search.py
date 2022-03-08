# done by Elizarov Dmitry 8306

# import sys
# sys.stdout = open('log4.txt', 'w')

N = int(input())

arr = [int(i) for i in input().split()]

cnt_search = int(input())

list_numbers = []
for i in range(0, cnt_search):

    number_search = int(input())
    list_numbers.append(number_search)


for number_search in list_numbers:

    left = 0
    right = len(arr) - 1
    middle = (left + right) // 2

    while arr[middle] != number_search and left <= right:
        if number_search > arr[middle]:
            left = middle + 1
        else:
            right = middle - 1
        middle = (left + right) // 2

    if left > right:
        print(-1)
    else:
        print(middle)
