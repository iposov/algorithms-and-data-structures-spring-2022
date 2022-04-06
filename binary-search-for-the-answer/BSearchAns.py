def answer(array: list, N: int, k: int, length: int) -> bool:
    """
    Вспомагательная функция для проверки превышения необходимых отрезков
    :rtype: bool
    """
    counter = 1
    current_length = array[0] + length
    for i in range(1, N):
        if array[i] > current_length:
            counter += 1
            current_length = array[i] + length
    return counter > k


def binary_search_by_answer(array: list, N: int, k: int, left: int = 0, right: int = 0) -> int:
    """

    Бинарный поиск по ответу, выполненный по рекурсии
    :rtype: int
    """
    middle = (left + right) // 2
    if left == right:
        return right
    if answer(array, N, k, middle):
        return binary_search_by_answer(array, N, k, middle + 1, right)
    else:
        return binary_search_by_answer(array, N, k, left, middle)
