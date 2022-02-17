#include <iostream>

int binary_search(int* array, int length, int find) {
    int left = 0;
    int right = length - 1;
    int middle;
    int value;

    while (left < right - 1) {
        middle = (left + right) / 2;
        value = array[middle];
        if (value > find) {
            right = middle;
        } else if (value < find) {
            left = middle;
        } else {
            return middle;
        }
    }
    if (array[left] == find) {
        return left;
    } else if (array[right] == find) {
        return right;
    }
    return -1;
}

int main() {
    int length;
    int amount;
    int find;
    std::cin >> length;
    int array[length];
    for (int i = 0; i < length; i++) {
        std::cin >> array[i];
    }
    std::cin >> amount;
    for (int i = 0; i < amount; i++) {
        std::cin >> find;
        std::cout << binary_search(array, length, find) << "\n";
    }
    return 0;
}
