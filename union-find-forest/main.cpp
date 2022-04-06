#include <iostream>

int *parents = nullptr;
int *ranks = nullptr;

// Проход по дереву вверх до корня
int get(int x) {
    int root = x;
    while (parents[root] != root) {
        root = parents[root];
    }
    int i = x;
    while (parents[i] != i) {
        int j = parents[i];
        parents[i] = root;
        i = j;
    }
    return root;
}

// Объединение множеств ("подвешивание" корней деревьев)
bool Union(int x_in, int y_in) {
    int x, y;
    x = get(x_in);
    y = get(y_in);
    if (x == y) {
        return true;
    }

    if (ranks[x] == ranks[y]) {
        ranks[x]++;
    }
    if (ranks[x] < ranks[y]) {
        parents[x] = y;
    } else {
        parents[y] = x;
    }

    return false;
}

int main() {
    // Размер множества, количество операций объединения
    int n, k;
    std::cin >> n >> k;

    parents = new int[n];
    ranks = new int[n];
    for (int i = 0; i < n; ++i) {
        ranks[i] = 1;
        parents[i] = i;
    }

    // Очередные два числа
    int x, y;
    for (int i = 0; i < k; ++i) {
        std::cin >> x >> y;
        std::cout << (Union(x, y) ? "YES" : "NO") << std::endl;
    }

    delete[] parents;
    delete[] ranks;

    return 0;
}