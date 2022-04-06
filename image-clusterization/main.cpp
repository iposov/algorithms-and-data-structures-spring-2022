#include <iostream>
#include <stack>

// Вершина графа (точка на карте островов)
struct vertex {
    int x, y;
};

// Высота и ширина озера
int m, n;
// m строк по m символов с островами и водой
std::string *islandsMap;
// Количество островов
int islandCnt;

// Поиск в глубину на стеке
void depthFirstSearch(int i, int j) {
    std::stack<vertex> stack;
    // Первый элемент стека - переданная в dfs вершина
    stack.push({i, j});
    while (!stack.empty()) {
        i = stack.top().x;
        j = stack.top().y;
        // Пометка земли (вершины графа) посещенной
        islandsMap[i][j] = 'X';
        stack.pop();
        // Находим следующую вершину с землей и добавляем в стек
        if ((i + 1 < m) && (islandsMap[i + 1][j] == '#')) {
            stack.push({i + 1, j});
        }
        if ((j + 1 < n) && (islandsMap[i][j + 1] == '#')) {
            stack.push({i, j + 1});
        }
        if ((i - 1 >= 0) && (islandsMap[i - 1][j] == '#')) {
            stack.push({i - 1, j});
        }
        if ((j - 1 >= 0) && (islandsMap[i][j - 1] == '#')) {
            stack.push({i, j - 1});
        }
    }
}

// Подсчет островов
int countIslands() {
    islandCnt = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            // Если фрагмент земли, то помечаем остров
            if (islandsMap[i][j] == '#') {
                depthFirstSearch(i, j);
                islandCnt++;
            }
        }
    }

    return islandCnt;
}


int main() {
    std::cin >> m >> n;
    islandsMap = new std::string[m];

    for (int i = 0; i < m; i++) {
        std::cin >> islandsMap[i];
    }

    std::cout << countIslands();

    delete[] islandsMap;

    return 0;
}