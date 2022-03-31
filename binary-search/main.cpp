#include <iostream>

using namespace std;

int binSearch(long number, long* Arr, int size) {
    int result = -1;
    int left, right, middle;
    left = 0;
    right = size - 1;
    while (true) {
        if (right - left <= 1) {
            if (number == Arr[left]) {
                result = left;
            }
            else if (number == Arr[right]) {
                result = right;
            }
            break;
        }
        middle = (left + right)/2;
        if (number == Arr[middle]) {
            result = middle;
            break;
        }
        else if (number > Arr[middle])
        {
            left = middle;
        }
        else {
            right = middle;
        }
    }

    return result;
}

int main() {
    int N;
    cin >> N;

    long Arr[N];
    for (int i = 0; i < N; i++) {
        cin >> Arr[i];
    }

    int K;
    cin >> K;

    long x_i[K];
    for (int i = 0; i < K; i++) {
        cin >> x_i[i];
    }

    for (int i = 0; i < K; i++) {
        cout << binSearch(x_i[i], Arr, N) << endl;
    }

    return 0;
}
