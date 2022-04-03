def create(U):
    array = [i for i in range(U)]
    return array

def find(x,array):
    while (array[x] != x):
        x = array[x]
    return x

def union(array, first, second):
  x = find(first, array)
  y = find(second, array) 
  if(x == y):
    return "YES"
  else:
    array[x] = y
    return "NO"

def main():
    str = input().split(" ")
    U = int(str[0])
    N  = int(str[1])
    array = create(U)
    for _ in range(N):
        str = input().split(" ")
        first = int(str[0])
        second = int(str[1])
        res = union(array, first, second)
        print(res)

if __name__ == "__main__":
    main()