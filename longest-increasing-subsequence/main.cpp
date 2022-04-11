#include <iostream>
#include <vector>

using namespace std;

long binSearch(long number, const long* Arr, long size) {
    long result;
    long left, right, middle;
    left = 0;
    right = size - 1;
    while (true) {
        if (right - left <= 1) {
            result = right;
            break;
        }
        middle = (left + right) / 2;
        if (number == Arr[middle]) {
            result = middle;
            break;
        } else if (number > Arr[middle]) {
            left = middle;
        } else {
            right = middle;
        }
    }

    return result;
}

vector<long> findLIS(vector<long> a) {
    long n = (long)a.size();
    long d[n+1];
    long pos[n+1];
    long prev[n+1];
    long length = 0;

    for (auto i = 0; i < n + 1; i++) {
        d[i] = 1000000;
        pos[i] = -1;
        prev[i] = -1;
    }
    d[0] = -1;

    for (auto i = 1; i < n; i++) {
        auto j = binSearch(a[i], d, n);
        if (d[j - 1] < a[i] && a[i] < d[j]) {
            d[j] = a[i];
            pos[j] = i;
            prev[i] = pos[j - 1];
            length = max(length, j);
        }
    }

    vector<long> answer;
    long p = pos[length];
    while (p != -1) {
        answer.push_back(a[p]);
        p = prev[p];
    }

    return answer;
}

int main() {
    long N;
    cin >> N;

    vector<long> Arr;
    long num;
    for (auto i = 0; i < N; i++) {
        cin >> num;
        Arr.push_back(num);
    }

    vector<long> res;
    res = findLIS(Arr);
    cout << res.size() << endl;
    for (auto i = (long)res.size() - 1; i >= 0; i--) {
        cout << res[i] << endl;
    }

    return 0;
}