#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n, m;
int relation[101][101] = { 0 };
int start, dest;
queue<int> q;
int cnt[101] = { 0 };
void BFS() {
	while (!q.empty()) {
		int now = q.front();
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (relation[now][i] != 0&&cnt[i]==0) {
				cnt[i] = cnt[now] + 1;
				q.push(i);
			}
		}
	}
}
int main() {
	cin >> n >> start >> dest >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		relation[x][y] = relation[y][x] = 1;
	}
	q.push(start);
	BFS();
	if (cnt[dest] == 0) {
		cout << "-1" << endl;
	}
	else {
		cout << cnt[dest] << endl;
	}
	return 0;
}