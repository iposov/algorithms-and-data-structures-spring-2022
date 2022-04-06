#include <iostream>
#include <vector>

int check(const std::vector<int> &vec, int middle) {
    int result{1};
    int distance{ vec.front() + middle };
    
    for (auto& elem: vec) {
        if (elem <= distance)
            continue;
        
        result++;
        distance = elem + middle;
    }
    
    return result;
}

int binarySearch(const std::vector<int> &vec, int k) {
    int left{0};
    int middle{0};
    int right{ vec.back() - vec.front() };
    
    while (left <= right) {
        middle = (left + right) / 2;
        
        if (check(vec, middle) <= k)
            right = middle - 1;
        else
            left = middle + 1;
    }
    
    return left;
}


int main() {
    
    int N{};
    int K{};
    std::vector<int> vec;
    
    std::cin >> N >> K;
    
    for (int i = 0; i < N; i++) {
        int element{};
        std::cin >> element;
        vec.push_back(element);
    }
    
    std::cout << binarySearch(vec, K) << std::endl;
    
    return 0;
}

