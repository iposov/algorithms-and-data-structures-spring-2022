#include <iostream>
#include <vector>
#include <iomanip>

int main() {
    int n;
    std::cin >> n;

    std::vector<std::pair<int, int>> arr(n);
    for (int i = 0; i < n; i++) {
        std::cin >> arr[i].first >> arr[i].second;
    }

    int s = 0;
    for (int i = 0; i < n - 1; i++) {
        s += arr[i].first * arr[i + 1].second - arr[i + 1].first * arr[i].second;
    }

    s += arr[n - 1].first * arr[0].second - arr[0].first * arr[n - 1].second;

    std::cout << std::fixed << std::setprecision(1) << std::abs(s) / 2.0 << std::endl;

    return 0;
}