def GetArea(coords):
    res = coords[-1][0]*coords[0][1]-coords[0][0]*coords[-1][1]
    for i in range(len(coords)-1):
        res += coords[i][0]*coords[i+1][1]-coords[i+1][0]*coords[i][1]
    return abs(res/2)

if __name__ == "__main__":
    amount = int(input())
    coords = []
    for x in range(amount):
        coord = input().split()
        coords.append((int(coord[0]), int(coord[1])))

    print(GetArea(coords))