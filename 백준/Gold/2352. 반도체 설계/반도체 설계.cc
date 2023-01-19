#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int>list;

int binarySearch(int left, int right, int target) {
	int mid = 0;
	while (left < right) {
		mid = (left + right) / 2;
		if (list[mid] < target) {
			left = mid+1;
		}
		else {
			right = mid ;
		}
	}
	return right;
}

int main() {
	int n;
	cin >> n;
	vector<int> port;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		port.push_back(x);
	}
	list.push_back(port[0]);
	int j = 0;
	int i = 1;
	while (i < n) {
		if (list[j] < port[i]) { //크면 그냥 뒤에 잡아넣어
			list.push_back(port[i]);
			j++;
		}
		else { //작다면 작은애의 인덱스를 이분탐색을 통해 찾은 위치에 잡아넣어 
			int idx = binarySearch(0, j, port[i]);
			list[idx] = port[i];
		}
		i++;
	}
	cout << j + 1;
	return 0;
}