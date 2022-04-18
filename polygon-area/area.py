from typing import Tuple


def calculate_area(points: list[Tuple[int, int]]):
    """
    points: list of coordinates in clockwise order
    """
    res = 0
    for i in range(len(points)-1):
        component1 = points[i][0]*points[i+1][1]
        res += component1
    
    for i in range(len(points)-1):
        component2 = points[i+1][0]*points[i][1]
        res -= component2
    
    appendix1 = points[-1][0]*points[0][1]
    appendix2 = points[0][0]*points[-1][1]

    return abs(res + appendix1 - appendix2) / 2

def main():
    n = int(input())
    points = [
        tuple(map(lambda x: int(x), input().split(" ")))
        for _ in range(n)
    ]

    print(f"{calculate_area(points):.1f}")

if __name__ == "__main__":
    main()