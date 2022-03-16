#include <iostream>

using namespace std;

int binary_search(int n, int* arr, int key){
	int left = 0;
	int right = n;
	int middle = 0;

	while(left < right){
		middle = (left + right)/2; //против переполнения на больших массивах

		if(key < arr[middle])
			right = middle;
		else
			left = middle+1;

		if(key == arr[middle]){
			return middle;
		}
	}
	return -1;
}

int main(){
	int N, K;
	int *arr;
	int idx, x_i;

	cin >> N;

	arr = new int[N];

	for(int i = 0; i < N; i++){
		cin >> arr[i];
	}
	
	cin >> K;
	for(int i = 0; i < K; i++){
		cin >> x_i;
		idx = binary_search(N, arr, x_i);
		cout << idx << endl;
	}
	delete[] arr;
	return 0;
}