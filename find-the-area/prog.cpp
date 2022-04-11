#include <iostream>
#include <vector>
#include <iomanip>
#include <cmath>

struct Point
{
    int64_t x;
    int64_t y;
};

int main()
{
    uint64_t N;
    std::vector<struct Point> points;
    double s = 0.;
    std::cin >> N;
    points.resize(N);
    for (size_t i = 0; i < N; i++) {
        std::cin >> points[i].x >> points[i].y;
    }
    for (size_t i = 0; i < N - 1; i++) {
        s += points[i].x * points[i + 1].y - points[i].y * points[i + 1].x;
    }
    s += points[N - 1].x * points[0].y - points[0].x * points[N - 1].y;
    s = fabs(s / 2);
    std::cout << std::setprecision(1) << std::fixed;
    std::cout << s << std::endl;
    return 0;
}