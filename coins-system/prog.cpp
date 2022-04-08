#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

int dynamicalMagic(std::vector<int> const &coins, int * const completedWork, int N)
{
    int result = INT_MAX - 1, currentResult;
    if (N < 0) {
        return INT_MAX - 1;
    }
    if (N == 0) {
        return 0;
    }
    if (completedWork[N - 1] != INT_MAX - 1) {
        return completedWork[N - 1];
    }
    for (size_t i = 0; i < coins.size(); i++) {
        currentResult = dynamicalMagic(coins, completedWork, N - coins[i]) + 1;
        if (result > currentResult) {
            result = currentResult;
        }
    }
    completedWork[N - 1] = result;
    return result;
}

int main()
{
    int k, N;
    std::vector<int> coins;
    int* completedWork;
    std::cin >> k;
    // k -= 4;
    coins.resize(k);
    for (size_t i = 0; i < k; i++) {
        std::cin >> coins[i];
    }
    std::cin >> N;
    completedWork = new int[N]();
    for (size_t i = 0; i < N; i++) {
        completedWork[i] = INT_MAX - 1;
    }
    int result = dynamicalMagic(coins, completedWork, N);
    std::cout << (result == INT_MAX - 1 ? -1 : result) << std::endl;
    delete[] completedWork;
    return 0;
}
