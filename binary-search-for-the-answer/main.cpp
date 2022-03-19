#include <iostream>
#include <vector>

int N = 0;
int k = 0;
std::vector<int> points;

bool check(int x){
    int cows = 0;
    int last_cow = points[0];
    for (int i = 0; i < N; ++i) {
        if (points[i] - last_cow >= x) {
            cows++;
            last_cow = points[i];
        }
    }
    return cows >= k;
}

int binary_search_for_answer(){
    int left = 0;
    int right = points[N - 1] - points[0] + 1;
    int mid = 0;

    while (right - left > 1){
        mid = (left + right) / 2;
        if (check(mid)){
            left = mid;
        } else {
            right = mid;
        }
    }
    return left;
}

int main() {
    std::cin >> N;
    std::cin >> k;

    int tempPoint;

    for (int i = 0; i < N; ++i) {
        std::cin >> tempPoint;
        points.push_back(tempPoint);
    }

    std::cout << binary_search_for_answer();

    return 0;
}
