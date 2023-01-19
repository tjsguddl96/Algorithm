#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	vector<long long>card;
	for (int i = 0; i < n; i++) {
		long long x;
		cin >> x;
		card.push_back(x);
	}
	sort(card.begin(), card.end());

	for (int i = 0; i < m; i++) {
		long long sum = 0;
		sum += card[0] + card[1];
		card[0] = sum;
		card[1] = sum;
		sort(card.begin(), card.end());
	}
	long long answer = 0;
	for (int i = 0; i < n; i++) {
		answer += card[i];
	}
	cout << answer;
	return 0;
}