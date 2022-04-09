def polygon_area(N,x, y):
    s = 0.0
    for i in range(N-1):
        s =s + (x[i] * y[i + 1] - x[i + 1] * y[i])
    s = s + (x[N - 1] * y[0] - x[0] * y[N - 1])
    s = abs(s / 2)
    return s
def check_point(N, x, y, x0, y0):
     s = 0.0
     for i in range(N-1):
        s =s + abs((x[i] - x0) * (y[i + 1] - y0) - (x[i + 1] - x0) * (y[i] - y0))
     s = s + abs((x[N - 1] - x0) * (y[0] - y0) - (x[0] - x0) * (y[N - 1] - y0))
     s = s / 2
     return s

def main():
    e = 1e-10
    x = []
    y = []
    N = int(input()) 
    for _ in range(N):
        string_list = input().split(" ")
        x.append(float(string_list[0]))
        y.append(float(string_list[1]))
    #for polygon_area (1.in file)
    #print(polygon_area(N, x, y))

    #for check point (1.check.in file)
    k = int(input()) 
    for _ in range(k):
        string_list = input().split(" ")
        x0 = float(string_list[0])
        y0 = float(string_list[1])
        if(abs(polygon_area(N, x, y) - check_point(N, x, y, x0, y0)) < e):
            print("IN")
        else:
            print("OUT")



if __name__ == "__main__":
    main()