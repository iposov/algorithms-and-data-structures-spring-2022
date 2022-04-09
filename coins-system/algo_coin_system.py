def possible(coins,f,k,N):
    for i in range(N+1):
        for j in range(k):
            if (i - coins[j] >=0):
                if (f[i - coins[j]]):
                    f[i] = True
                    break


def main():
   k = int(input())
   #to use tests from git
   k = k - 4
   coins = [int(input()) for _ in range(k)]
   N = int(input())
   f = [False for _ in range(N+1)]
   f[0] = True
   possible(coins, f, k, N)
   if(f[N]):
       print("YES")
   else:
        print("NO")



if __name__ == "__main__":
    main()