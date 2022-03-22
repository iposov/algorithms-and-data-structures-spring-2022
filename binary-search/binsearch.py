from typing import Optional
from typing import List

def binsearch(a: List[int], key: int) -> Optional[int]:
    l, r = 0, len(a) - 1

    while l <= r:
        m = int((l + r) / 2)
        if a[m] > key:
            r = m - 1
        elif a[m] < key:
            l = m + 1
        elif a[m] == key:
            return m

    return -1

def main():
    array_size = int(input())
    array = list(map(int, input().split(" ")))
    tests_count = int(input())
    for _ in range(tests_count):
        key = int(input())
        print(binsearch(array, key))

if __name__ == "__main__":
    main()