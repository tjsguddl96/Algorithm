#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
using namespace std;
vector<int> a;
bool binarySearch(int b) {
	int left = 0;
	int right = a.size() - 1;
	int mid = 0;
	while (left <= right) {
		mid = (left + right) / 2;
		if (b > a[mid]) { //b를 mid오른쪽에서 찾음됨
			left = mid + 1;
		}
		else if (b == a[mid]) {
			return true;
		}
		else {
			right = mid-1;
		}
	}
	return false;
}

int main() {
	int n;
	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) {
		int x;
		scanf("%d", &x);
		a.push_back(x);
	}
	int m;
	scanf("%d", &m);
	vector<int> b;
	for (int i = 0; i < m; i++) {
		int x;
		scanf("%d", &x);
		b.push_back(x);
	}
	sort(a.begin(), a.end());
	for (int i = 0; i < b.size(); i++) {
		printf("%d\n", binarySearch(b[i]));
	}

	return 0;
}