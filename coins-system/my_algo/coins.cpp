#include "iostream"
using namespace std;
#define INFTY 10000000

int main(){
	int N, k;
	int *arr = NULL;

	cin >> k;
	arr = new int[k];

	for(int i = 0; i< k; i++)
		cin >> arr[i];

	cin >> N;

	int *f,*res,*coins;
	f = new int[N+1];
	res = new int[N+1];
	coins = new int[N+1];
	for(int i = 0; i < N+1; i++){
		f[i] = 0;
		res[i] = -1;
		coins[i] = 0;
	}

	for(int i = 1; i < N+1; i++){
		int w = INFTY;
		for(int j = 0; j < k; j++){
			if(i - arr[j] >= 0){
				if(f[i-arr[j]] < w && f[i-arr[j]] != -500){ //-500 - показатель недостижимости
					w = f[i-arr[j]];
					res[i] = i - arr[j];
				} 
			}
		}
		if(w != INFTY)
			f[i] = w + 1;
		else
			f[i] = -500;
	}

	if(res[N] != -1){
		int i = N;
        while(i > 0){
            for (int j; j < k; j++){
                if(arr[j] == i - res[i])
                    coins[j] += 1;
            }
            i = res[i];
        }
        for(int i = 0; i < k; i++)
            cout << coins[i] << endl;
	}
    else
        cout << -1 << endl;
	return 0;
}