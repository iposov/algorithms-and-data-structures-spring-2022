def binary_search(array: list, val: int, left: int = 0, right: int = 0) -> int:
    """

    Бинарный поиск с помощью рекурсии
    :rtype: int
    """
    middle = (left + right) // 2
    if left > right:
        return -1
    if val < array[middle]:
        return binary_search(array, val, left, middle - 1)
    elif val > array[middle]:
        return binary_search(array, val, middle + 1, right)
    elif val == array[middle]:
        return middle


if __name__ == "__main__":
    print(binary_search([1, 2, 4, 6, 7, 9, 20], 4, 0, 7))
