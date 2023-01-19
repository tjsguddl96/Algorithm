#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N;
	int tempN;
	vector<int>answer;
	cin >> N;
	int temp1=N/5;
	int temp = 0;
	for (int i = temp1; i >= 0; i--) {
		tempN = 0;
		temp = N - 5 * i;
		if (temp % 3 == 0) {
			temp /= 3;
			tempN += temp + i;
			answer.push_back(tempN);
		}
	}
	if (answer.size() == 0) {
		cout << "-1";
		return 0;
	}
	sort(answer.begin(), answer.end());
	cout << answer.front();
	return 0;
}