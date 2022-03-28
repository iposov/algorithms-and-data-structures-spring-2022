

#Vlasenko Vlad 8305


class Main:

    def __init__(source):
        source.list = []

    def goDown(source,i):
        while len(source.list) > 2 * i + 1:
            left = 2 * i + 1
            right = 2 * i + 2
            j = left
            if(right < len(source.list)) and (source.list[right] > source.list[left]):
                j = right
            if(source.list[i] > source.list[j]):
                break
            source.list[i], source.list[j] = source.list[j], source.list[i]
            i = j

    def goUp(source, i):
        while source.list[i] > source.list[(i - 1) // 2] and i > 0:
            source.list[i], source.list[(i - 1) // 2] = source.list[(i - 1) // 2], source.list[i]
            i = (i - 1) // 2

    def getMin(source):
        min = source.list[0]
        source.list[0] = source.list[-1]
        del source.list[-1]
        source.goDown(0)
        return min

    def insert(source, i):
        source.list.append(i)
        source.goUp(len(source.list) - 1)

print("Введите количество элементов")
N = int(input())
box = Main()
for x in range(N):
    print("Введите число или 'GET'")
    number = input()
    if (number == "GET"):
        min = box.getMin()
        print(min)
    else:
        box.insert(int(number))
