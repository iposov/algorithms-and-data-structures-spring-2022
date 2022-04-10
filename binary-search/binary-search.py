from typing import List


def binary_search(array: List[int], find_of: int):
    left_index = 0
    middle_index = None
    right_index = len(array)

    while left_index < right_index:
        middle_index = left_index + (right_index - left_index) // 2

        if middle_index in (left_index, right_index):
            break

        value = array[middle_index]

        if value == find_of:
            return middle_index

        elif find_of > value:
            left_index = middle_index

        elif find_of < value:
            right_index = middle_index

    return middle_index if find_of == array[middle_index] else -1



def main():
    array_count = int(input())
    array = [int(i) for i in input().split(" ")]
    assert len(array) == array_count

    test_count = int(input())
    for _ in range(test_count):
        print(binary_search(array, int(input())))

if __name__ == '__main__':
    main()