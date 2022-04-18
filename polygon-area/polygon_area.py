if __name__ == "__main__":
    n = int(input())
    coordinates = []
    for _ in range(n):
        x, y = map(int, input().split())
        coordinates.append([x, y])
    S = 0

    for i in range(len(coordinates) - 1):
        S += coordinates[i][0] * coordinates[i+1][1]
        S -= coordinates[i][1] * coordinates[i+1][0]
    S += coordinates[n-1][0]*coordinates[0][1]
    S -= coordinates[0][0]*coordinates[n-1][1]
    print(abs(S/2))
