#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;
	int dp[1001][3] = { 0 };
	vector<vector<int>> price(n);
	
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			int x;
			cin >> x;
			price[i].push_back(x);
		}
	}
	dp[0][0] = price[0][0];
	dp[0][1] = price[0][1];
	dp[0][2] = price[0][2];
	for (int i = 1; i < n; i++) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + price[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + price[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + price[i][2];
	}
	cout << min({ dp[n - 1][0],dp[n - 1][1],dp[n - 1][2] });

	
	return 0;
}