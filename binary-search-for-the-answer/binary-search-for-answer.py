
def check(middle, k, array):
    segments = 0
    last_segment = array[0]

    for i in array:
        if i - last_segment >= middle:
            segments += 1
            last_segment = i

    return segments >= k


def binary_search_for_answer(array, k, n):
    left = 0
    right = array[n - 1] - array[0] + 1

    while right - left > 1:
        middle = (left + right) // 2
        if check(middle, k, array):
            left = middle
        else:
            right = middle

    return left


def main():
    array_count, segment_count = (int(input()) for _ in range(2))
    array = [int(input()) for _ in range(array_count)]
    print(binary_search_for_answer(array, segment_count, array_count))


if __name__ == '__main__':
    main()
