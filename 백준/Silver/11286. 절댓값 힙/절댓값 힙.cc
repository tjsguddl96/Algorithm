#include <iostream>
#include <queue>
#include <math.h>
#include <cmath>
using namespace std;
struct compare {
	bool operator()(vector<int> a, vector<int> b) {
		if (a.at(1)== b.at(1)) {
			return a.at(0) > b.at(0);
		}
		return a.at(1)> b.at(1);
	}
};
int main() {
	priority_queue<vector<int>,vector<vector<int>>,compare> pq;
	int n;
	cin >> n;
	vector<vector<int>> tmp(n);
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		if (x != 0) {
			tmp[i].push_back(x);
			tmp[i].push_back(abs(x));
			pq.push(tmp[i]);
		}
		else {
			if (pq.empty()) {
				cout << "0" << endl;
			}
			else {
				cout << pq.top().at(0) << endl;
				pq.pop();
			}
		}
	}
	return 0;
}