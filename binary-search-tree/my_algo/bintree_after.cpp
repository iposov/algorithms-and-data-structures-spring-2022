#include <iostream>
#include <string>
#include <iterator>
#include <set>

//STL's set class is typically implemented as a BST

using namespace std;


int main() {
    int N, input;
    cin >> N;
    set<int>::iterator it;
    set <int> tree;
    for(int i = 0; i < N; i++){
        cin >> input;

        it = tree.upper_bound(input);
        if (tree.find(input) == tree.end()) {
            if(*it == input)
                cout << "- -" << endl;
            else
                cout << "- " << *it << endl;

            tree.insert(input);
        }else{
            if(*it == input)
                cout << "+ -" << endl;
            else
                cout << "+ " << *it << endl;
        }
    }
    return 0;
}