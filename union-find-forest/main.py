#Vlasenko Vlad
#8305
#union-find-forest

def create(unity):
    arr = [i for i in range(unity)]
    return arr

def find(a,arr):
    while (arr[a] != a):
        a = arr[a]
    return a

def compr(arr, first, second):
    a = find(first, arr)
    b = find(second, arr)
    if(a == b):
        return "YES"
    else:
        arr[a] = b
        return "NO"

if __name__ == "__main__":
    print('Введите размер множества')
    dim = input().split(" ")
    unity = int(dim[0])
    N = int(dim[1])
    arr = create(unity)
    for _ in range(N):
        print("Введите 2 числа через пробел")
        dim = input().split(" ")
        first = int(dim[0])
        second = int(dim[1])
        result = compr(arr, first, second)
        print(result)
