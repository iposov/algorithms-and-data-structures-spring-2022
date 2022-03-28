#include <iostream>

int main()
{
    int N, K;
    int* inArray = nullptr;
    int* found = nullptr;


    std::cin >> N;


    inArray = new int[N];
    for (int i = 0; i < N; i++)
        std::cin >> inArray[i];


    std::cin >> K;


    found = new int[K];
    for (int i = 0; i < K; i++)
        std::cin >> found[i];


    for (int i = 0; i < K; i++)
    {
        int LEFT = 0, RIGHT = N - 1, MIDDLE;

        while (true)
        {
            MIDDLE = (LEFT + RIGHT) / 2;

            if (inArray[MIDDLE] > found[i])
                RIGHT = MIDDLE - 1;
            if (inArray[MIDDLE] < found[i])
                LEFT = MIDDLE + 1;
            if (inArray[MIDDLE] == found[i])
            {
                std::cout << MIDDLE << std::endl;   //founded
                break;
            }
            if (LEFT > RIGHT)
            {
                std::cout << -1 << std::endl;       //not founded
                break;
            }
        }
    }


    delete[] inArray;
    delete[] found;


    return 0;
}