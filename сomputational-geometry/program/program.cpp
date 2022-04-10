#include <iostream>
#include <vector>
#include <iomanip>

int N;
int* X;
int* Y;

float countArea() {
    float area = 0.0f;

    for (int i = 0; i < N - 1; i++)
    {
        area += (X[i] - X[i + 1]) * (Y[i] + Y[i + 1]);
    }
    area += (X[N - 1] - X[0]) * (Y[N - 1] + Y[0]);

    area = abs(area / 2.0F);

    return area;
}

int main()
{
    std::cin >> N;
    X = new int[N];
    Y = new int[N];
    for (int i = 0; i < N; i++)
    {
        std::cin >> X[i] >> Y[i];
    }

    std::cout << std::fixed << std::setprecision(1) << countArea() << std::endl;
}