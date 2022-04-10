#include <iostream>

int K, N;
int* A;
int* minCounts;

int main()
{
    int localMin;
    bool oneCoinNeeded;

    std::cin >> K;
    A = new int[K];
    for (int i = 0; i < K; i++)
        std::cin >> A[i];
    std::cin >> N;
    minCounts = new int[N + 1];
    for (int i = 0; i <= N; i++)
        minCounts[i] = -1;

    minCounts[0] = 0;
    for (int i = 1; i <= N; i++)
    {
        localMin = INT16_MAX;
        oneCoinNeeded = false;

        for (int j = 0; j < K; j++)
        {
            if (i - A[j] == 0)
            {
                oneCoinNeeded = true;
            }
            else if (i - A[j] > 0 && minCounts[i - A[j]] != -1)
            {
                int value = minCounts[i - A[j]];
                if (value < localMin)
                {
                    localMin = value;
                }
            }
        }

        if (oneCoinNeeded)
        {
            minCounts[i] = 1;
        }
        else if (localMin != INT16_MAX)
        {
            minCounts[i] = localMin + 1;
        }
    }

    std::cout << minCounts[N];
}