def cross_product(ax, ay, bx, by):
    return ax * by - ay * bx 


N = int(input())
verts = []
for i in range(N):
    verts.append([int(x) for x in input().split()])
k = int(input())
for i in range (k):
    x, y = [int(l) for l in input().split()]
    flag_a = False
    flag_b = False
    for j in range (N):
        ax, ay = verts[j]
        bx, by = verts[(j+1)%N]
        cp = cross_product(ax-x, ay-y, bx-x, by-y)
        if cp > 0:
            flag_a = True
        if cp < 0:
            flag_b = True
    if flag_a and flag_b:
        print ("OUT")
    else:
        print ("IN")

    

            
        