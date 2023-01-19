#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N, L, W;
	bool check[1001] = { false };
	vector<int> temp;
	cin >> N >> L;
	for (int i = 0; i < N; i++) {
		cin >> W;
		check[W] = true;
		temp.push_back(W);
	}
	sort(temp.begin(), temp.end());
	int answer = 0;
	
	int i = temp[0];  // 4 5 : 1 4 5 9 ->2  0.5-5.5
	int cur = i;
	while (i <= temp[temp.size() - 1]) {
		if (check[i]) {
			answer++;
			cur = i+(L - 1);
			for (int j = i; j <= cur; j++) {
				check[j] = false;
			}
			i = cur;
		}
		else {
			i++;
		}
	}
	cout << answer;
	return 0;
}