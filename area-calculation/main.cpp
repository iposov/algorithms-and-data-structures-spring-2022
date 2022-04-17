#include <iostream>
#include <QVector>
#include <QtMath>

struct coord{
    int x;
    int y;
};

int main()
{
    int n;
    QVector<coord> coords;
    std::cin >> n;
    for (int i = 0; i < n; ++i){
        int x;
        int y;
        std::cin >> x;
        std::cin >> y;
        coords.append({x,y});
    }
    float area = 0;
    for (int i = 0; i < n-1; ++i){
        area += coords.at(i).x*coords.at(i+1).y - coords.at(i+1).x*coords.at(i).y;
    }
    area += coords.at(n-1).x * coords.at(0).y - coords.at(0).x * coords.at(n-1).y;
    std::cout << qFabs(area/2);
    return 0;
}
