#include <iostream>
#include <set>

using namespace std;

static int* ufset = nullptr; //aka union find set
static int* rankk = nullptr;

static char* lake = nullptr;

int M, N;
 
int find_ (int v) {
    if (v == ufset[v])
        return v;
    return ufset[v] = find_ (ufset[v]);
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
        ufset[b] = a;
        rankk[a] += rankk[b];
    }

        
}

int clusterization(){
    for(int i = 0; i < M*N; i++){
        if(lake[i] == '#'){
            if( ((i - N) >= 0) && (lake[i-N] == '#') )
                union_(i, i-N);
            if( (i % N != 0) && (lake[i-1] == '#'))
                union_(i, i-1);
        }
    }

    set <int> lands;
    for(int i = 0; i < M*N; i++)
        if(lake[ufset[i]] == '#')
            lands.insert(find_(ufset[i]));

    return lands.size();
}

int main() {
    cin >> M >> N;
    ufset = new int[M*N];
    rankk = new int[M*N];
    lake = new char[M*N];

    for (int i = 0; i < M*N; i++) {
        ufset[i] = i;
        rankk[i] = 1;
    }

    for (int i = 0; i < M*N; i++){
        cin >> lake[i];
    }
    
    cout << clusterization() << endl;
    return 0;
}