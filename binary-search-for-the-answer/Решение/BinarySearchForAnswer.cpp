// BinarySearchForAnswer.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>

bool check(int x, int* mass, int N, int k) {
    int segments = 1;
    int last_segment = mass[0];
    for (int i = 0; i < N; ++i) {
        if (mass[i] - last_segment > x) {
            segments++;
            last_segment = mass[i];
        }
    }
    return segments <= k;
}

int main()
{
    //Инициализация 
    int N = 0, k = 0;
    std::cin >> N;
    std::cin >> k;

    int* mass = new int[N];

    for (int i = 0; i < N; ++i) {
        std::cin >> mass[i];
    }

    //Алгоритм
    int left = 0;
    int right = mass[N - 1] - mass[0] + 1;
    while (right - left > 1) {
        int mid = (left + right) / 2;
        if (check(mid, mass, N, k)) {
            right = mid;
        }
        else {
            left = mid;
        }
    }

    std::cout << right;

}
