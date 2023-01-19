#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> step;
	int dp[301];
	int answer = 0;
	step.push_back(0);
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		step.push_back(x);
	}
	dp[1] = step[1];
	dp[2] = step[1]+step[2];
	dp[3] = max(step[1] + step[3], step[2] + step[3]);
	for (int i = 4; i <= n; i++) {
		dp[i] = max(dp[i - 2] + step[i], dp[i - 3] + step[i-1]+step[i]);
	}
	cout << dp[n];
	return 0;
}