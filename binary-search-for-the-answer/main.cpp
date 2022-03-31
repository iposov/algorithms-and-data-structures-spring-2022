#include <iostream>

using namespace std;

int binSearchAnswer(const long* Arr, int N, int K) {
    int result, left, right, middle;
    left = 0;
    right = ((N > K) ? int((Arr[N-1] - Arr[0])/K) : 0);
    while (true) {
        if (right - left <= 1) {
            result = right;
            break;
        }
        else {
            middle = (left + right)/2;
            int j = 0;
            for (int i = 0; (i < K) && (j < N); i++) {
                long passLeft = Arr[j];
                while ((Arr[j] <= passLeft + middle) && (j < N)) {
                    j++;
                }
            }
            if (j == N) {
                right = middle;
                }
            else {
                left = middle;
            }
        }

    }
    return result;
}

int main() {
    int N;
    cin >> N;

    int K;
    cin >> K;

    long Arr[N];
    for (int i = 0; i < N; i++) {
        cin >> Arr[i];
    }

    cout << binSearchAnswer(Arr, N, K) << endl;

    return 0;
}
