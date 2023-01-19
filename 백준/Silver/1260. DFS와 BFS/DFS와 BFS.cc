#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> node[1001];
vector<int>flag(1001,0);
vector<int>flag1(1001, 0);
void DFS(int start) {
	if (!flag1[start]) {
		flag1[start] = 1;
		cout << start << " ";
		for (int i = 0; i < node[start].size(); i++) {
			int x = node[start][i];
			DFS(x);
		}
	}
}
void BFS(int start) {
	queue<int> q;
	q.push(start);
	flag[start] = 1;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		cout << x << " ";
		for (int i = 0; i < node[x].size(); i++) {
			int y = node[x][i];
			if (!flag[y]) {
				q.push(y);
				flag[y] = 1;
			}
		}
	}
}
int main() {
	int N, M, V;
	cin >> N;
	cin >> M;
	cin >> V;
	for (int i = 0; i < M; i++) {
		int x;
		int y;
		int start;
		cin >> x;
		cin >> y;
		node[x].push_back(y);
		node[y].push_back(x);
		sort(node[x].begin(), node[x].end());
		sort(node[y].begin(), node[y].end());
	}
	DFS(V);
	cout << endl;
	BFS(V);
	return 0;
}
