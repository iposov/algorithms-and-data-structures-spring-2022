def binary_search(array, element, start, end):
    if start > end:
        return -1

    mid = (start + end) // 2
    if element == array[mid]:
        return mid

    if element < array[mid]:
        return binary_search(array, element, start, mid-1)
    else:
        return binary_search(array, element, mid+1, end)


def main():
    N = int(input()) 
    string_list = input().split(" ")
    array = [int(i) for i in string_list]
    K = int(input()) 
    for _ in range(K):
        element = int(input())
        res = binary_search(array,element,0,N-1)    
        print(res)

if __name__ == "__main__":
    main()