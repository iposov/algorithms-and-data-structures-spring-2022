#include <QVector>
#include <iostream>

int main()
{
    QVector<int> array;

    int N;
    std::cin >> N;

    for (int i = 0; i < N; ++i){
        int in;
        std::cin >> in;
        array.push_back(in);
    };


    int K;
    std::cin >> K;

    for (int i = 0; i < K; ++i){
        int find;
        std::cin >> find;
        int left = 0;
        int right = N-1;
        bool found;
        int check;
        while (left <= right && !found) {
            check = (left + right)/2;
            if (array.at(check) == find) found = true;
            if (array.at(check) < find)
                left = check+1;
            else right = check-1;
        }
        if (found){
            std::cout << check << std::endl;
            found = false;
        }
        else{
            std::cout << -1 << std::endl;
            found = false;
        }
    }
    return 0;
}
