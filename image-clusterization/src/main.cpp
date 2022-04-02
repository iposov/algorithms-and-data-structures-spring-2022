#include <iostream>
#include <vector>

template <typename T>
class Set {

public:

    Set(T size);

    ~Set() = default;

    T find(T a);

    bool check(T a, T b);

    void update(T a, T b);

    T count_single();

private:

    struct Elem {
        T parent;
        T rank;
    };

    T _size;
    std::vector<Elem> _elements;

};

template <typename T>
Set<T>::Set(T size) : _size(size) {
    _elements.reserve(_size);
    for (T i = 0; i < _size; i++)
        _elements.emplace_back(Elem {i, 0});
}

template <typename T>
T Set<T>::find(T a) {
    auto& parent = _elements[a].parent;
    if (a != parent)
        parent = find(parent);
    return parent;
}

template <typename T>
bool Set<T>::check(T a, T b) {
    return find(a) == find(b);
}

template <typename T>
void Set<T>::update(T a, T b) {
    auto& a_element = _elements[find(a)];
    auto& b_element = _elements[find(b)];

    if (a_element.rank > b_element.rank) {
        b_element.parent = a_element.parent;
    } else {
        a_element.parent = b_element.parent;
        if (a_element.rank == b_element.rank)
            b_element.rank++;
    }
}

template <typename T>
T Set<T>::count_single() {
    T count = 0;

    for (T i = 0; i < _size; i++)
        count += _elements[i].parent == i;

    return count;
}

namespace {

    template <typename T>
    std::tuple<std::vector<bool>, T, T> io_read() {
        T a, b;
        std::cin >> a >> b;
    
        std::string tmp;
        std::vector<bool> arr(a * b, false);
        for (T i = 0; i < a; i++) {
            std::cin >> tmp;
            for (T j = 0; j < b; j++)
                arr[i * b + j] = tmp[j] == '#';
        }
    
        return {arr, a, b};
    }

    template <typename T>
    void io_write(T count) {
        std::cout << count << std::endl;
    }

}

int main() {
    auto [array, a, b] = io_read<int32_t>();

    Set<int32_t> set(a * b);
    for (int32_t i = 0; i < a; i++) {
        for (int32_t j = 0; j < b; j++) {
            auto pos = i * b + j;
            if (!array[pos])
                continue;

            if (pos - 1 >= 0 && j && array[pos - 1])
                set.update(pos, pos - 1);

            if (pos - b >= 0 && array[pos - b])
                set.update(pos, pos - b);
        }
    }

    int32_t single = set.count_single();
    int32_t water = 0;
    for (auto val: array)
        water += !val;

    io_write(single - water);

    return 0;
}
