#include <iostream>
#include <string>
#include <set>

using namespace std;


int main() {
    int N, input;
    cin >> N;

    set <int> tree;

    for(int i = 0; i < N; i++){
        cin >> input;

        if (tree.find(input) == tree.end()) {
            tree.insert(input);
            cout << "-" << endl;
        }else{
            cout << "+" << endl;
        }
    }
    return 0;
}