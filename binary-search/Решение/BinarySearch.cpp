
#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;

    int* mass = new int[N];

    for (int i = 0; i < N; ++i) {
        cin >> mass[i];
    }

    int K;
    cin >> K;

    int x, left, right, middle, answer = 0;
    bool flag;

    while (K) {

        K--;
        cin >> x;

        flag = true;
        left = 0;
        right = N - 1;
        middle = (N - 1) / 2;

        while ((right - left > 1) && flag) {
            if (x < mass[middle]) {
                right = middle;
            }
            else {
                if (x > mass[middle]) {
                    left = middle;
                }
                else {
                    answer = middle;
                    flag = false;
                }
            }
            middle = (left + right) / 2;
        }

        if (flag) {
            if (x == mass[right]) {
                answer = right;
                cout << right << '\n';
            }
            else {
                if (x == mass[left]) {
                    answer = left;
                    cout << left << '\n';
                }
                else {
                    cout << -1 << '\n';
                }
            }
        }
        else {
            cout << answer << '\n';
        }
    }
}
