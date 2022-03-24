#include <iostream>
#include <set>

int main() {
    int N;
    std::set<int> st;

    std::cin >> N;

    for (int i = 0; i < N; i++) {
        int tmp;
        std::cin >> tmp;
        
        auto result = st.insert(tmp);

        if (result.second)
            std::cout << "-" << std::endl;
        else
            std::cout << "+" << std::endl;
    }

    return 0;
}