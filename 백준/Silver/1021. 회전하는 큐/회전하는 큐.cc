#include <iostream>
#include <queue>
#include <deque>
#include <math.h>
#include <algorithm>
#include <cmath>
using namespace std;

int rightShift(deque<int>& dq,int num) {
	int answer = 0;
	deque<int> tmp1 = dq;
	while (tmp1.front() != num) {
		int temp = tmp1.back();
		tmp1.push_front(temp);
		tmp1.pop_back();
		answer++;
	}
	return answer;
}
int leftShift(deque<int>& dq, int num) {
	int answer = 0;
	deque<int> tmp2 = dq;
	while(tmp2.front() != num) {
		int temp = tmp2.front();
		tmp2.push_back(temp);
		tmp2.pop_front();
		answer++;
	}
	return answer;
}
int main() {
	deque<int> dq;
	int answer = 0;
	int n;
	int m;
	cin >> n >> m;
	vector<int> num;
	for (int i = 0; i < n; i++) {
		dq.push_back(i + 1);
	}
	
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		num.push_back(x);
	}
	for (int i = 0; i < m; i++) {
		if (dq.front() == num[i]) {
			dq.pop_front();
			continue;
		}
		if (rightShift(dq, num[i]) > leftShift(dq, num[i])) {
			answer += leftShift(dq, num[i]);
			while (dq.front() != num[i]) {
				int temp = dq.front();
				dq.push_back(temp);
				dq.pop_front();
			}
			dq.pop_front();
			
		}
		else {
			answer += rightShift(dq, num[i]);
			while (dq.front() != num[i]) {
				int temp = dq.back();
				dq.push_front(temp);
				dq.pop_back();				
			}
			dq.pop_front();
		}

	}
	cout << answer;
	return 0;
}