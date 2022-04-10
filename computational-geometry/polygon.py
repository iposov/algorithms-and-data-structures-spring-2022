def get_area(coords):
    area = 0
    for i in range(len(coords)):
        area += coords[i-1][0] * coords[i][1]
        area -= coords[i][0] * coords[i-1][1]

    return abs(area / 2)

if __name__ == "__main__":
    n = int(input())

    coords = []
    for i in range(n):
        x, y = map(int, input().split())
        coords.append([x, y])

    print(get_area(coords))