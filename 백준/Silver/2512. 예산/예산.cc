#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int Sum(vector<int>& budget, int mid) {
	int sum = 0;
	for (int i = 0; i < budget.size(); i++) {
		sum += min(budget[i], mid);
	}
	return sum;
}
int binarySearch(vector<int>&budget, int limit) {
	int left = 0;
	int right = budget[budget.size() - 1];
	int mid = 0;
	int max = 0;
	while (left <= right) {
		mid = (left + right) / 2;
		int sum = Sum(budget, mid);
		if (sum > limit) {
			right = mid-1;
		}
		else {
			if (max < mid) {
				max = mid;
			}
			left = mid + 1;
		}
	}
	return max;
}
int main() {
	int n,limit;
	cin >> n;
	vector<int> budget;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		budget.push_back(x);
	}
	sort(budget.begin(), budget.end());
	cin >> limit;
	cout << binarySearch(budget, limit);
	return 0;
}