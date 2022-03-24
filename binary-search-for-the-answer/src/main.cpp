#include <iostream>
#include <vector>

namespace {

    template <typename T>
    std::pair<std::vector<T>, T> io_read() {
        T n, k;
        std::cin >> n;
        std::cin >> k;
    
        std::vector<T> arr(n, 0);
        for (T i = 0; i < n; i++)
            std::cin >> arr[i];
    
        return {arr, k};
    }
    
    template <typename T>
    void io_write(const T& val) {
        std::cout << val << std::endl;
    }

    template <typename T, typename V, typename F>
    T binary_search_impl(T begin, T end, const V& value, const F& fun) {
        auto dist = std::distance(begin, end);
        auto center = begin + dist / 2;

        if (begin == end)
            return begin;

        auto result = fun(*center);
        if (result <= value)
            return ::binary_search_impl<T, V>(begin, center, value, fun);

        return ::binary_search_impl<T, V>(center + 1, end, value, fun);
    }
    
    template <typename T, typename V, typename F>
    T binary_search(T begin, T end, const V& value, const F& fun) {
        return ::binary_search_impl<T, V, F>(begin, end, value, fun);
    }

    template <typename T, typename V>
    V solve(T begin, T end, V k) {
        int res = 1, dist = *begin + k;

        for (auto it = begin; it != end; it++) {
            if (*it <= dist) continue;

            dist = *it + k;
            res++;
        }

        return res;
    }

}

int main() {
    auto [points, k] = io_read<uint32_t>();

    std::vector<uint32_t> result(points.back() - points.front() + 1, 0);
    for (uint32_t i = 0; i < result.size(); i++)
        result[i] = i;

    auto it = ::binary_search(result.cbegin(), result.cend(), k,
        [p = &points](uint32_t val) -> uint32_t {
            return ::solve(p->cbegin(), p->cend(), val);
        } );

    io_write(*it);

    return 0;
}
