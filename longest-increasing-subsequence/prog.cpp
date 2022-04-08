#include <vector>
#include <algorithm>
#include <iostream>

void print(std::vector<int> const &p, std::vector<int> const &n, int currentIndex)
{
    if (currentIndex != INT_MIN) {
        print(p, n, p[currentIndex]);
        std::cout << n[currentIndex] << std::endl;
    }
}

int main()
{
    int N, currentIndex, answer = INT_MIN;
    std::vector<int> numbers, d, indexesOfLastNumber, parentsOfNumber;
    std::cin >> N;
    numbers.resize(N);
    indexesOfLastNumber.resize(N + 1);
    parentsOfNumber.resize(N);
    d.resize(N + 1);
    for (size_t i = 0; i < N; i++) {
        std::cin >> numbers[i];
        d[i] = INT_MAX;
        indexesOfLastNumber[i] = INT_MIN;
        parentsOfNumber[i] = i;
    }
    d[0] = INT_MIN;
    d[N] = INT_MAX;
    indexesOfLastNumber[N] = INT_MIN;
    for (size_t i = 0; i < N; i++) {
        currentIndex = std::upper_bound(d.cbegin(), d.cend(), numbers[i]) - d.cbegin();
        if (d[currentIndex - 1] < numbers[i] && numbers[i] < d[currentIndex]) {
            d[currentIndex] = numbers[i];
            parentsOfNumber[i] = indexesOfLastNumber[currentIndex - 1];
            indexesOfLastNumber[currentIndex] = i;
        }
    }
    for (size_t i = 0; i < N + 1; i++) {
        if (d[i] != INT_MAX) {
            answer = i;
        }
    }
    currentIndex = indexesOfLastNumber[answer];
    std::cout << answer << std::endl;
    print(parentsOfNumber, numbers, currentIndex);
    return 0;
}