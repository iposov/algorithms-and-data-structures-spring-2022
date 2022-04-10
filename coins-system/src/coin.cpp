#include <iostream>
#include <vector>

int main() {
    int n, k;
    std::cin >> k;

    k -= 4; //ошибка в входных файлах

    std::vector<int> array(k, 0);
    for (int i = 0; i < k; i++)
        std::cin >> array[i];

    std::cin >> n;

    std::vector<std::pair<int, int>> mat(n + 1);
    for (int i = 0; i < array.size(); i++)
        if (array[i] <= n)
            mat[array[i]] = {1, i};

    for (int i = 1; i < n + 1; i++) {
        if (mat[i].first)
            continue;

        std::pair<int, int> min = {0, 0};
        for (int j = 0; j < array.size(); j++) {
            auto idx = i - array[j];
            if (idx <= 0 || !mat[idx].first)
                continue;

            auto [k, val] = mat[idx];
            if (!min.first || (k + 1) < min.first)
                min = {k + 1, j};
        }
        mat[i] = min;
    }

    std::vector<int> answer(array.size(), 0);
    if (mat[n].first)
        for (int i = n; i != 0; i -= array[mat[i].second])
            answer[mat[i].second]++;


    if (mat[n].first) 
        std::cout << mat[n].first << std::endl;
    else
        std::cout << "-1" << std::endl;

    for (const int& val: answer)
        std::cout << val << std::endl;

    return 0;
}