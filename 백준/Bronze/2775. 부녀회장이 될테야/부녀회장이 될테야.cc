#include <iostream>
#include <vector>
using namespace std;

int N;

int Cal(int x, int y) {
	if (x == 0) {
		return y;
	}
	else if (x < 0 || y < 0) {
		return 0;
	}
	else {
		return Cal(x - 1, y) + Cal(x, y - 1);
	}
}
int main() {
	cin >> N;
	int x, y;
	vector<int>answer;
	for (int i = 0; i < N; i++) {
		cin >> x;
		cin >> y;
		answer.push_back(Cal(x, y));
	}
	for (auto& a : answer) {
		cout << a << endl;
	}
	return 0;
}