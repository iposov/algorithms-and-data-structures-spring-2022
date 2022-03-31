#include <iostream>

using namespace std;

void siftUp(int i, int* Arr) {
    while (Arr[i] < Arr[(i - 1) / 2]) {
        int c = Arr[i];
        Arr[i] = Arr[(i - 1) / 2];
        Arr[(i - 1) / 2] = c;
        i = (i - 1) / 2;
    }
}

int maxDelete(int* Arr, int N) {
    int index = 0;
    for (int i = 0; i < N; i++) {
        if (Arr[i] > Arr[index]) {
            index = i;
        }
    }
    int max = Arr[index];
    Arr[index] = 0;
    return max;
}

int main() {
    int N;
    cin >> N;

    int Arr[N];
    for (int i = 0; i < N; i++) {
        Arr[i] = 0;
    }
    string command;

    for (int i = 0, j = 0; i < N - j;) {
        cin >> command;
        if (command == "GET") {
            cout << maxDelete(Arr, N) << endl;
            j++;
        }
        else {
            Arr[i] = stoi(command);
            siftUp(i, Arr);
            i++;
        }
    }

    return 0;
}