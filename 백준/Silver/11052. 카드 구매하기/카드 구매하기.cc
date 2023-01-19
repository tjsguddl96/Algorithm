#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int>cards;
	int dp[1001];
	cards.push_back(0);
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		cards.push_back(x);
	}
	dp[0] = 0;
	dp[1] = cards[1];
	for (int i = 2; i <= n; i++) {
		int res = 0;
		for (int j = 1; j <= i; j++) {
			res = max(res, dp[i - j] + cards[j]);
		}
		dp[i] = res;
	}
	cout << dp[n] << endl;
	return 0;
}