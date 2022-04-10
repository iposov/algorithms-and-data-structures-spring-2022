#include <iostream>

using namespace std;

static int* parent = nullptr;
static int* rankk = nullptr;

 
int find_ (int v) {
    if (v == parent[v])
        return v;
    return parent[v] = find_ (parent[v]);
}
 
void union_(int a, int b) {
    a = find_ (a);
    b = find_ (b);
    if (a != b){
        if(rankk[a] < rankk[b]){
            a = a^b;
            b = b^a;
            a = a^b; //xor swap just for fun
        
        }
        parent[b] = a;
        rankk[a] += rankk[b];
    }

        
}
 
int main() {
    int n = 0, k = 0;
    
    cin >> n >> k;
    parent = new int[n];
    rankk = new int[n];
    for (int i = 0; i < n; i++) {
        parent[i] = i;
        rankk[i] = 1;
    }

    for (int i = 0; i < k; i++){
        int a, b;
        cin >> a >> b;
        if(find_(a) == find_(b))
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
        union_(a, b);    
    }
    return 0;
}