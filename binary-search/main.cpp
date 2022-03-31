#include <iostream>
#include <vector>

void ReadArrayFromCin(std::vector<int>& empty_array);
int BinarySearch(const std::vector<int>& array, int element);

int main()
{
    std::vector<int> array;

    ReadArrayFromCin(array);

    int n;
    std::cin >> n;
    for (auto i = 0; i < n; i++) 
    {
        std::string task_str;
        std::cin >> task_str;
        std::cout << BinarySearch(array, std::stoi(task_str)) << std::endl;
    }

    return 0;
}

int BinarySearch(const std::vector<int>& array, int element)
{
    auto left = 0;
    auto right = array.size() - 1;

    if (array[left] > element || array[right] < element)
    {
        return -1;
    }

    while (right - left > 1)
    {
        auto middle = (left + right) / 2;

        if (array[middle] > element)
        {
            right = middle;
        }
        else
        {
            left = middle;
        }
    }
    
    if (array[left] == element) 
    {
        return left;
    }
    if (array[right] == element)
    {
        return right;
    }

    return -1;
}

void ReadArrayFromCin(std::vector<int> &empty_array)
{
    int n;
    std::cin >> n;

    for (auto i = 0; i < n; ++i)
    {
        std::string token;
        std::cin >> token;
        empty_array.push_back(std::stoi(token));
    }
}
