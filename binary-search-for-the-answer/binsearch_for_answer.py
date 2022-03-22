from typing import Optional
from typing import List

def compute_least_segments(a: List[int], n_segments: int) -> Optional[int]:
    l, r = 0, a[-1] - a[0]

    while l != r:
        m = int((l + r) / 2)
        if fits(a, n_segments, m):
            r = m
        else:
            l = m + 1

    return r

def fits(a: List[int], n_segments: int, seg_len: int) -> bool:
    if a is None:
        return False

    n_seg_to_cover = 1
    prev_point = a[0]

    for point in a:
        if point - prev_point > seg_len:
            prev_point = point
            n_seg_to_cover += 1
    
    return n_seg_to_cover <= n_segments

def main():
    array_size = int(input())
    array = []
    n_segments = int(input())
    for _ in range(array_size):
        array.append(int(input()))
    
    print(compute_least_segments(array, n_segments))


if __name__ == "__main__":
    main()