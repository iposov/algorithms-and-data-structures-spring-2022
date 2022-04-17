#include <iostream>

int N, K;
int* A = nullptr;

bool check(int const x) 
{
    int cows = 1;
    int last_cow = A[0];

    for (int i = 0; i < N; i++)
    {
        if (A[i] - last_cow >= x) 
        {
            cows++;
            last_cow = A[i];
        }
    }

    return cows <= K;
}

int solve()
{
    int left = 0;
    int right = A[N - 1] - A[0] + 1;

    while (right - left > 1) 
    {
        int mid = (left + right) / 2;

        if (check(mid)) 
        {
            right = mid;
        }
        else 
        {
            left = mid;
        }
    }

    return left;
}

int main()
{
    std::cin >> N;
    std::cin >> K;

    A = new int[N];

    for (int i = 0; i < N; i++)
    {
        std::cin >> A[i];
    }

    std::cout << solve();

    delete(A);
    return 0;
}