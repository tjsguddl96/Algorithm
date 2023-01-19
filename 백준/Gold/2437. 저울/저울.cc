#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 

int main() {
	int N;
	vector<int> weight;
	cin >> N;
	int sum = 0;
	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		weight.push_back(x);
	}
	sort(weight.begin(), weight.end());
	for (int i = 0; i < N; i++) {
		if (weight[i] > sum + 1) {
			break;
		}
		sum += weight[i];
	}
	cout << sum + 1;
	
	
	return 0;
}