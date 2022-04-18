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
    S = abs(S/2)

    k = int(input())
    for _ in range(k):
        SP = 0
        x0, y0 = map(int, input().split())
        for j in range(n - 1):
            SP += abs((coordinates[j][0]-x0) * (coordinates[j + 1][1]-y0) -
                      (coordinates[j][1]-y0) * (coordinates[j + 1][0]-x0))
        SP += abs((coordinates[n-1][0]-x0) * (coordinates[0][1]-y0) -
                  (coordinates[0][0]-x0) * (coordinates[n-1][1]-y0))
        SP = SP/2

        if abs(S - SP) < 1e-10:
            print("IN")
        else:
            print("OUT")

