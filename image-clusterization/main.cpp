#include <iostream>

using namespace std;

void pass(bool** Arr, int i, int j, int m, int n) {
    if (i >= 0 && i < m && j >= 0 && j < n)
    {
        if (Arr[i][j]) {
            Arr[i][j] = false;
            pass(Arr,i+1,j,m,n);
            pass(Arr,i-1,j,m,n);
            pass(Arr,i,j+1,m,n);
            pass(Arr,i,j-1,m,n);
        }
    }
}

int main() {
    int m;
    cin >> m;

    int n;
    cin >> n;

    bool** Arr = new bool* [m];
    for (int i = 0; i < m; i++) {
        Arr[i] = new bool [n];
    }
    char c;
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            cin >> c;
            if (c == '.') Arr[i][j] = false;
            else if (c == '#') Arr[i][j] = true;
        }

    int count = 0;
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            if (Arr[i][j]) {
                Arr[i][j] = false;
                count++;
                pass(Arr,i+1,j,m,n);
                pass(Arr,i-1,j,m,n);
                pass(Arr,i,j+1,m,n);
                pass(Arr,i,j-1,m,n);
            }
        }
    cout << count << endl;

    return 0;
}