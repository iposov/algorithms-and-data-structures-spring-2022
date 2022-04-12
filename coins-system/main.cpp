#include <vector>
#include <iostream>

void possible(const std::vector<int> &coins, std::vector<bool>& f, int N, int k) {
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

int main() {
    std::vector<int> arr;
    int count;
    std::cin >> count;
    int tmp;
    for (int i = 0; i < count; ++i) {
        std::cin >> tmp;
        arr.push_back(tmp);
    }

    int sum;
    std::cin >> sum;

    std::vector<bool> f(sum + 1, false);
    f[0] = true;

    possible(arr, f, sum, count);

    if (f[sum]) {
        std::cout << "YES";
    } else {
        std::cout << "NO";
    }

    return 0;
}


