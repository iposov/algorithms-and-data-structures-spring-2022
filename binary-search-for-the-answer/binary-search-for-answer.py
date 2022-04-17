
def binary_search_for_answer(array, segment_count):
    left = 0
    right = coords[N-1] - coords[0] + 1
    while (right - left > 1):
        mid = (left + right) // 2
        if (check(mid, k, coords)):
         left = mid
        else:
         right = mid
    return left
    # for _ in range(array_count):
        # print(binary_search(array, int(input())))


def main():
    array_count = int(input())
    segment_count = int(input())
    array = [int(input()) for _ in range(array_count)]
    binary_search_for_answer(array, segment_count)

if __name__ == '__main__':
    binary_search_for_answer()