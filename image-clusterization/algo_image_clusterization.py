#NOT DONE
def create(N, M):
    start = 0
    end = M
    array = []
    for i in range(N):
        str = [num for num in range(start, end)]
        array.append(str)
        start += M
        end += M
    return array

def find(x,y,array,M):
    num = M*x + y
    while (array[x][y] != num):
        num = array[x][y]
    return num

def union(array, first_1, first_2,second_1, second_2,M):
  x = find(first_1, first_2, array,M)
  y = find(second_1, second_2, array,M) 
  if(x == y):
    return True
  else:
    array[second_1][second_2] = x
    return True

def main():
    str = input().split(" ")
    N = int(str[0])
    M  = int(str[1])
    mask = create(N, M)
    map = []
    str=[]
    for i in range(N):
        str = input()
        map.append(str)
        
    for i in range(N):
        for j in range(M-1):
            if(map[i][j] == map[i][j+1]):
                union(mask,i,j,i,j+1,M)
    for i in range(N-1):
        for j in range(M):
            if(map[i][j] == map[i+1][j]):
                union(mask,i,j,i+1,j,M)
    print(mask)   

if __name__ == "__main__":
    main()