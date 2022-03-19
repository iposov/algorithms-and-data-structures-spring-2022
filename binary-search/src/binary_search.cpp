#include <iostream>

int bin_search(int x_i, int *array, int N) {
    int left = 0, 
        middle = 0,
        right = N;
        
    while (left <= right) {
        middle = (left + right) / 2;

        if (array[middle] > x_i) {
            right = middle - 1;
        } 
        else if (array[middle] < x_i) {
            left = middle + 1;
        } 
        else {
            return middle;
        }
    }

    return -1;
}

int main() {
    int K, N, x_i, index;
    int* array;

    std::cin >> N;
    array = new int[N];

    for (int i = 0; i < N; i++) {
        std::cin >> array[i];
    }

    std::cin >> K;

    for (int i = 0; i < K; i++) {
        std::cin >> x_i;
        std::cout << bin_search(x_i, array, N) << std::endl;
    }

    delete[] array;
    return 0;
}