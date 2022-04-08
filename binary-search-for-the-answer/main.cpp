#include <QVector>
#include <iostream>

bool check(int x, int k, QVector<int> arr){
    int dots = 1;
    int rightestDot = arr.at(0);
    for (int i = 0; i < arr.size(); ++i){
        if (arr.at(i) - rightestDot >= x){
            ++dots;
            rightestDot = arr.at(i);
        }
    }
    if (dots >= k) return true;
    else return false;
}

int main()
{
    QVector<int> array;

    int N;
    std::cin >> N;
    int K;
    std::cin >> K;
    K++;

    for (int i = 0; i < N; ++i){
        int in;
        std::cin >> in;
        array.push_back(in);
    };

    int left = 0;
    int right = array.last() - array.first();
    if (!check(right, K, array)){
        while (right - left > 1){
            int mid  = (left + right)/2;
            if(check(mid, K, array)){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        std::cout << left;
    }
    else std::cout << right;
    return 0;
}
