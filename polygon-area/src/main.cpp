#include <iostream>
#include <iomanip>
#include <vector>
#include <optional>

namespace {

    template <typename T>
    std::vector<std::pair<T, T>> io_read() {
        T n;
        std::cin >> n;
    
        std::vector<std::pair<T, T>> arr(n, {0, 0});
        for (T i = 0; i < n; i++)
            std::cin >> arr[i].first >> arr[i].second;
    
        return arr;
    }
    
    void io_write(double s) {
        std::cout << std::fixed << std::setprecision(1) << s << std::endl;
    }

}

int main() {
    auto array = io_read<int64_t>();
    array.emplace_back(array.front());

    int64_t s = 0;
    for (size_t i = 0; i < array.size(); i++) {
        s += array[i].first * array[i + 1].second -
             array[i + 1].first * array[i].second;
    }

    double res = static_cast<double>(std::abs(s)) / 2.0;
    io_write(res);

    return 0;
}
