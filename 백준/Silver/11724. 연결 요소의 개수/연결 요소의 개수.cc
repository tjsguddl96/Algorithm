#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m; //n은 정점 갯수,m은 간선 갯수
int answer = 0;
bool check[1001] = { false };
vector<int> arr[1001];

void BFS(int start) {
	queue<int> q;
	check[start] = true;
	q.push(start);
	while (!q.empty()) {
		int current = q.front();
		q.pop();
		int currentconntedsize = arr[current].size();
		for (int i = 0; i < currentconntedsize; i++) {
			int next = arr[current][i];
			if (!check[next]) {
				check[next] = true;
				q.push(next);
			}
		}
	}
}
int main() {
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		arr[x].push_back(y);
		arr[y].push_back(x);
	}
	for (int i = 1; i <= n; i++) {
		if (!check[i]) {
			answer++;
			BFS(i);
		}
	}
	cout << answer << endl;
	return 0;
}