#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
// mine -10 2 3 6 10
// yours 10 9 -5 2 3 4 5 -10
vector<int> mine;
vector<int> yours;
bool binarySearch(int left,int right, int target) {
	int mid = 0;
	while (left < right) {
		mid = (left + right) / 2;
		if (mine[mid] < target) {
			left = mid + 1;
		}
		else {
			right = mid;
		}
	}
	if (mine[right] == target) {
		return true;
	}
	else {
		return false;
	}
}

int main() {
	int n, m;
	cin >> n;
	
	vector<int> answer;

	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		mine.push_back(x);
	}
	cin >> m;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		yours.push_back(x);
		
	}
	sort(mine.begin(), mine.end());
	
	for (int i = 0; i < m; i++) {
		if (binarySearch(0, n - 1, yours[i])==true) {
			answer.push_back(1);
		}
		else {
			answer.push_back(0);
		}
	}
	for (auto& e : answer) {
		cout << e << " ";
	}
	return 0;
}