#include <iostream>

using namespace std;

int *arr;
int N, k;

//можно ли расставить k коров, если между ними расстояние X
int check_shuffle(int X){
    int total_cows = 0;
    int current_cow = arr[0];

    for(int i = 0; i < N; i++){
        if(arr[i] - current_cow >= X){
            total_cows+=1;
            current_cow = arr[i];
        }
    }

    return total_cows >= k;
}

int binary_search_by_answer(){
	int left = 0;
	int right = arr[N-1] - arr[0] + 1;
	int middle = 0;

	while(right - left > 1){
		middle = (left + right)/2; 
		if(check_shuffle(middle))
            left = middle;
        else
			right = middle;
    }
	return left;

}

int main(){  
    cin >> N;
    cin >> k;

    arr = new int[N];
    for(int i = 0; i < N; i++)
        cin >> arr[i];
    
    cout << binary_search_by_answer() << endl;
    
    delete[] arr;
    return 0;
}