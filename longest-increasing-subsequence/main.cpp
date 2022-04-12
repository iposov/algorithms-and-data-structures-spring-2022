#include <vector>
#include <iostream>

int lis(std::vector<int> &arr) {
    std::vector<int> result;
    int n = arr.size();
    for (int i = 0; i < n; i++) {
        auto it
                = lower_bound(result.begin(), result.end(), arr[i]);
        if (it == result.end()) {
            result.push_back(arr[i]);
        } else {
            *it = arr[i];
        }
    }
    return result.size();
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
    std::cout << lis(arr);

    return 0;
}