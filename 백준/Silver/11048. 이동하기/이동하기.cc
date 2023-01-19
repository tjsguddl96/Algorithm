#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, m;//n이 세로(y), m이 가로(x)


int main() {
	cin >> n >> m;

	
	vector<vector<int>> map1(n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int x;
			cin >> x;
			map1[i].push_back(x);
		}
	}

	int dp[1001][1001];
	dp[0][0] = map1[0][0];
	
	for (int j = 0; j < m-1; j++) {
		dp[0][j + 1] = dp[0][j] + map1[0][j + 1];
	}
	for (int i = 0; i < n - 1; i++) {
		dp[i + 1][0] = dp[i][0] + map1[i + 1][0];
	}
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < m; j++) {
			dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + map1[i][j];
		}
	}

	cout << dp[n-1][m-1];
	
	return 0;
}