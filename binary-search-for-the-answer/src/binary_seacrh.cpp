#include <iostream>

int check(int *array, int middle, int N) {
    int res = 1, 
        dist = array[0] + middle;

    for (int i = 1; i < N; i++) {
        if (array[i] <= dist) 
            continue;
        
        res++;
        dist = array[i] + middle;
    }

    return res;
}

int bin_search(int *array, int N, int k) {
    int left = 0, 
        middle = 0,
        right = array[N - 1] - array[0];
        
    while (left <= right) {
        middle = (left + right) / 2;

        if (check(array, middle, N) <= k) 
            right = middle - 1; 
        else 
            left = middle + 1;
    }

    return left;
}

int main() {
    int N, k;
    int *array;

    std::cin >> N >> k;
    array = new int[N];

    for (int i = 0; i < N; i++) {
        std::cin >> array[i];
    }

    std::cout << bin_search(array, N, k) << std::endl;

    delete[] array;
    return 0;
}