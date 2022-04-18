#include <iostream>

int main()
{
    int K, N;

    int* A;
    
    int* _minCounts;

    int result;

    int _localMinimum;

    bool _flagOneCoinNeeds;

    std::cin >> K;

    A = new int[K];

    for (int i = 0; i < K; i++) { std::cin >> A[i]; }

    std::cin >> N;

    _minCounts = new int[N + 1];

    for (int i = 0; i <= N; i++) { _minCounts[i] = -1; }

    _minCounts[0] = 0;

    for (int i = 1; i <= N; i++)
    {
        _localMinimum = 999999999;

        _flagOneCoinNeeds = false;

        for (int j = 0; j < K; j++)
        {
            if (i - A[j] == 0) { _flagOneCoinNeeds = true; }

            else if (i - A[j] > 0 && _minCounts[i - A[j]] != -1)
            {
                int value = _minCounts[i - A[j]];

                if (value < _localMinimum) { _localMinimum = value;}
            }
        }

        if (_flagOneCoinNeeds) { _minCounts[i] = 1; }

        else if (_localMinimum != 999999999) { _minCounts[i] = _localMinimum + 1; }
    }

    result = _minCounts[N];
    
    std::cout << result;

    return 0;
}