#include <iostream>
#include <vector>

int binary_search(int number, int count, std::vector<int> numberArr){
    int left = 0;
    int right = count;
    int middle = 0;

    while (left < right){
        middle = (left+right)/2;
        if (number == numberArr[middle]){
            return middle;
        }

        if (number < numberArr[middle]){
            right = middle;
        } else {
            left = middle + 1;
        }
    }
    return -1;
}

int main() {
    int arrLength;
    std::cin >> arrLength;

    int tempNumber;
    std::vector<int> numbers;
    for (int i = 0; i < arrLength; ++i) {
        std::cin >> tempNumber;
        numbers.push_back(tempNumber);
    }

    int findCount;
    std::cin >> findCount;

    int number2find;
    for (int i = 0; i < findCount; ++i) {
        std::cin >> number2find;
        std::cout << binary_search(number2find, arrLength, numbers) << std::endl;
    }
    return 0;
}
