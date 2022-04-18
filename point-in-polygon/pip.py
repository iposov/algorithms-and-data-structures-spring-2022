from typing import List


def pip(x: int, y: int, x_array: List[int], y_array: List[int]):
    c = 0
    n = len(x_array)
    for i in range(n):
        if (((y_array[i] <= y < y_array[i - 1]) or (y_array[i - 1] <= y < y_array[i])) and
                (x > (x_array[i - 1] - x_array[i]) * (y - y_array[i]) / (y_array[i - 1] - y_array[i]) + x_array[i])):
            c = 1 - c
    if c == 1:
        return "YES"
    return "NO"


def main():
    x, y = (int(i) for i in input().split())
    x_array = [int(i) for i in input().split()]
    y_array = [int(i) for i in input().split()]
    print(pip(x, y, x_array, y_array))

if __name__ == "__main__":
    main()