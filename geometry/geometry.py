def shape_area(lst):
    area = 0
    for i in range(len(lst)):
        area += lst[i-1][0] * lst[i][1]
        area -= lst[i][0] * lst[i-1][1]
    return abs(area / 2)
if __name__ == "__main__":
    n = int(input())
    coordinats = []
    for i in range(n):
        x, y = map(int, input().split())
        coordinats.append([x, y])
    print(get_area(coordinats))