#include <iostream>

int binarySearch(int* A, int N, int x)
{
    int left, right, middle;

    left = 0;
    right = N - 1;

    while (true)
    {
        middle = (left + right) / 2;

        if (A[middle] > x)
        {
            right = middle - 1;
        }
        
        if (A[middle] < x)
        {
            left = middle + 1;
        }
        
        if (A[middle] == x)
        {
            return middle;
        }

        if (left > right)
        {
            return -1;
        }
    }
}

int main()
{
    int N, K;
    int* A = NULL;
    int* X = NULL;

    std::cin >> N;
    A = new int[N];
    for (int i = 0; i < N; i++)
    {
        std::cin >> A[i];
    }

    std::cin >> K;
    X = new int[K];
    for (int i = 0; i < K; i++)
    {
        std::cin >> X[i];
    }

    int y = -1;
    for (int i = 0; i < K; i++)
    {
        y = binarySearch(A, N, X[i]);
        std::cout << y << std::endl;
    }

    delete A;
    delete X;

    return 0;
}