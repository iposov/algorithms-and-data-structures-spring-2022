#Vlasenko Vlad 8305

print('Введите число N, размер массива')
N = int(input())

print('Введите массив: числа через пробел')
array = [int(i) for i in input().split()]

print('Введите кол-во чисел')
constOfSearch = int(input())

listOfNumbers = []
print('Введите X_i')
for i in range(0, constOfSearch):

    numberOfSearch = int(input())
    listOfNumbers.append(numberOfSearch)

for numberOfSearch in listOfNumbers:

    left = 0
    right = len(array) - 1
    middle = (left + right) // 2

    while array[middle] != numberOfSearch and left <= right:
        if numberOfSearch > array[middle]:
            left = middle + 1
        else:
            right = middle - 1
        middle = (left + right) // 2

    if left > right:
        print(-1)
    else:
        print(middle)

