#include <iostream>
#include <set>
#include <iterator>

int main() {
    int count;
    int num;
    std::set<int>::iterator iterator;
    std::set<int> bst;

    std::cin >> count;

    for (int i = 0; i < count; i++) {
        std::cin >> num;
        iterator = bst.upper_bound(num);
        if (bst.find(num) == bst.end()) {
            if (iterator == bst.end())
                std::cout << "- -" << std::endl;
            else
                std::cout << "- " << *iterator << std::endl;
            bst.insert(num);
        } else {
            if (iterator == bst.end())
                std::cout << "+ -" << std::endl;
            else
                std::cout << "+ " << *iterator << std::endl;
        }
    }
    return 0;
}