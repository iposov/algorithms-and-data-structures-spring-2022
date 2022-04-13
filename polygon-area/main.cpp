#include <iostream>
#include <vector>

double polygonArea(const std::vector<std::pair<double,double>>& coords, int count) {
    double area = 0.0;

    for (int i = 0; i < count; i++) {
        area += coords[i].first * coords[i + 1].second - coords[i + 1].first * coords[i].second;
    }
    area += coords[count - 1].first * coords[0].second - coords[0].first * coords[count - 1].second;

    return std::abs(area / 2.0);
}

int main() {
    int count;
    std::cin >> count;

    std::vector<std::pair<double,double>> coords;

    double temp_x, temp_y;
    for (int i = 0; i < count; ++i) {
        std::cin >> temp_x >> temp_y;
        coords.emplace_back(temp_x,temp_y);
    }

    printf("%.1f",polygonArea(coords, count));

    return 0;
}