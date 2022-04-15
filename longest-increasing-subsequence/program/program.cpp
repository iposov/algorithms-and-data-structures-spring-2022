#include <iostream>
#include <vector>

std::vector<int> findLIS_N2(std::vector<int> a)
{
    int n = a.size();                     //размер исходной последовательности
    int* prev;
    int* d;
    prev = new int[n];
    d = new int[n];

    for (int i = 0; i < n; i++)
    {
        d[i] = 1;
        prev[i] = -1;
        for (int j = 0; j < i; j++)
        {
            if (a[j] < a[i] && d[j] + 1 > d[i])
            {
                d[i] = d[j] + 1;
                prev[i] = j;
            }
        }
    }

    int pos = 0;                            // индекс последнего элемента НВП
    int length = d[0];                      // длина НВП
    for (int i = 0; i < n; i++)
    {
        if (d[i] > length)
        {
            pos = i;
            length = d[i];
        }
    }

    // восстановление ответа
    std::vector<int> answer;
    while (pos != -1)
    {
        answer.push_back(a[pos]);
        pos = prev[pos];
    }
    std::reverse(answer.begin(), answer.end());

    delete[] prev;
    delete[] d;
    return answer;
}

int main()
{
    int N, buf;
    std::vector<int> first, second;

    std::cin >> N;
    
    first.reserve(N);
    for (int i = 0; i < N; i++)
    {
        std::cin >> buf;
        first.push_back(buf);
    }

    second = findLIS_N2(first);

    std::cout << second.size() << std::endl;
    for (int i = 0; i < second.size(); i++)
    {
        std::cout << second[i] << std::endl;
    }

}
