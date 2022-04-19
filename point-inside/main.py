n = int(input())

coords = []

def calcAr(coords,point=[0,0],absMode=False):
    S = 0
    for i in range(len(coords)-1):
        crr = coords[i]   # current
        nxt = coords[i+1] # next one
        if not absMode:
            S+=(crr[0]-point[0])*(nxt[1]-point[1])
            S-=(crr[1]-point[1])*(nxt[0]-point[0])
        else:
            S+=abs((crr[0]-point[0])*(nxt[1]-point[1])-(crr[1]-point[1])*(nxt[0]-point[0]))

    crr = coords[-1]
    nxt = coords[0]
    if not absMode:
        S+=(crr[0]-point[0])*(nxt[1]-point[1])
        S-=(crr[1]-point[1])*(nxt[0]-point[0])
    else:
        S+=abs((crr[0]-point[0])*(nxt[1]-point[1])-(crr[1]-point[1])*(nxt[0]-point[0]))
    return abs(S/2)

for x in range(n):
    [pX,pY] = input().split(' ')
    coords.append([int(pX),int(pY)])

S = calcAr(coords)

k = int(input())
for x in range(k):
    p = 0
    [pX,pY] = input().split(' ')
    pX = int(pX)
    pY = int(pY)
    
    point = calcAr(coords,[pX,pY],True)
    if(abs(S-point)<1e-10):
        print("IN")
    else:
        print("OUT")