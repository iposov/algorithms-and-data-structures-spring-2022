#include <vector>
#include <iostream>

void coinsys(const std::vector<int> &coins, std::vector<bool>& f, int N, int k);

int main() {
    std::vector<int> arr;
    int count;
    std::cin >> count;
    int cost;
    for (int i = 0; i < count; ++i) {
        std::cin >> cost;
        arr.push_back(cost);
    }

    int sum;
    std::cin >> sum;

    std::vector<bool> f(sum + 1, false);
    f[0] = true;

    coinsys(arr, f, sum, count);

    if (f[sum]) {
        std::cout << "YES";
    } else {
        std::cout << "NO";
    }

    return 0;
}


void coinsys(const std::vector<int> &coins, std::vector<bool>& f, int N, int k) {
    for (int i = 0; i <= N; ++i) {
        for (int j = 0; j < k; ++j) {
            if (i - coins[j] >= 0) {
                if (f[i - coins[j]]) {
                    f[i] = true;
                }
            }
        }
    }
}
