#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int>score;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		score.push_back(x);
	}
	int answer = 0;
	for (int i = n - 2; i >= 0; i--) {
		while (score[i + 1] <= score[i]) {
			score[i]--;
			answer++;
		}
	}
	cout << answer;
	return 0;
}