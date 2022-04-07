#include <iostream>

int binary_search(int* array, int left, int right, int find) {
    int middle = (left + right) / 2;
    
    if (array[middle] > find && middle > left)
        return binary_search(array, left, middle - 1, find);
    else if (array[middle] < find && middle < right)
        return binary_search(array, middle + 1, right, find);
    else if (array[middle] == find)
        return middle;
    else
        return -1;
}

int main() {
    int length;
    int amount;
    int find;
    std::cin >> length;
    int array[length];
    for (int i = 0; i < length; i++)
        std::cin >> array[i];
    std::cin >> amount;
    for (int i = 0; i < amount; i++) {
        std::cin >> find;
        std::cout << binary_search(array, 0, length, find) << "\n";
    }
    return 0;
}
