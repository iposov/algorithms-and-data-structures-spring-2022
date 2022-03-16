#include <iostream>
#include <string>
#include "heap.cpp"

using namespace std;


int main() {
    int N, a;
    string input;
    cin >> N;

    Heap heap(N);
    for(int i = 0; i < N; i++){
        cin >> input;
        if(input == "GET")
            cout << heap.getmax() << endl;
        else{
            a = stoi(input);
            heap.add(a);
        }
    }
    return 0;
}