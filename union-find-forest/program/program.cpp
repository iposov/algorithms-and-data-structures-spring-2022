#include <iostream>

int* arr = nullptr;
int* rang = nullptr;

int Find(int x) 
{
    if (x == arr[x])
    {
        return x;
    }

    return (arr[x] = Find(arr[x]));
}

bool Union (int x, int y)
{
    int X, Y;
    if ((X = Find(x)) == (Y = Find(y)))
    {
        return true;
    }

    if (rang[X] < rang[Y]) 
    {
        arr[X] = Y;
    }
    else 
    {
        arr[Y] = X;
        if (rang[X] == rang[Y]) 
        {
            ++rang[X];
        }
    }

    return false;
}

int main()
{
    int N, K, a, b;
    std::cin >> N >> K;

    arr = new int[N];
    rang = new int[N];
    for (int i = 0; i < N; ++i) 
    {
        rang[i] = 1;
        arr[i] = i;
    }

    for (int i = 0; i < K; ++i) 
    {
        std::cin >> a >> b;
        std::cout << (Union(a, b) ? "YES" : "NO") << std::endl;
    }
}