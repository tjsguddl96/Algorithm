#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
bool cmp(vector<int> a, vector<int> b) {
	return a.at(0) < b.at(0);
}
struct compare {
	bool operator()(vector<int> a, vector<int> b) {
		return a.at(1) > b.at(1); //오름차순 후 우선순위 부여 --> 제일 작은애가 우선순위 최고
	}
};

int main() {
	int N, S;
	int answer = 1;
	cin >> N;
	vector<vector<int>> st(N,vector<int>(0));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 2; j++) {
			cin >> S;
			st[i].push_back(S);
		}
	}
	
	sort(st.begin(), st.end(),cmp);
	
	priority_queue<vector<int>, vector<vector<int>>, compare> pq;
	//1 2.2 3.3 4
	for (int i = 0; i < N; i++) {
		if (!pq.empty()) {
			if (st[i][0] < pq.top()[1]) {   // 2 3
				answer++;
				pq.push(st[i]);
			}
			else {
				pq.pop();
				pq.push(st[i]);
			}
		}
		else {
			pq.push(st[i]); 
		}

	}
	
	cout << answer;
	return 0;
}
