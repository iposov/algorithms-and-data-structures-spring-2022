#include <iostream>
#include <vector>
#include <iomanip>

int main()
{
    int N;

    std::vector<int> Xs;
    std::vector<int> Ys;

    float square = 0.0f;
    float answer;

    std::cin >> N;

    int x, y;

    for (int i = 0; i < N; i++)
    {
        std::cin >> x;
        std::cin >> y;
        Xs.push_back(x);
        Ys.push_back(y);
    }


    for (int i = 0; i < N - 1; i++)
    {
        x = Xs[i] - Xs[i + 1];
        y = Ys[i] + Ys[i + 1];
        square = square + (x * y);
    }

    x = Xs[N - 1] - Xs[0];
    y = Ys[N - 1] + Ys[0];
    square = square + (x * y);

    answer = abs(square / 2);

    std::cout << std::fixed << std::setprecision(1) << answer;

    return 0;
}