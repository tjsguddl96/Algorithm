#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

int m, n;//m은 가로(x), n은 세로(y);
queue<pair<int, int>>q;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
//위,아래,오른쪽,왼쪽 순으로 이동
bool isIn(int x, int y) {
	if (x < 0 || y < 0 || x >= m || y >= n) {
		return false;
	}
	return true;
}
void BFS(vector<vector<int>>& tomato) {
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;

		q.pop();
		
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if (isIn(next_x, next_y)&&tomato[next_y][next_x]==0) {
				tomato[next_y][next_x] = tomato[y][x] + 1;
				q.push(make_pair(next_x, next_y));
			}
		}
	}
}
int main() {
	
	cin >> m >> n;
	vector<vector<int>> tomato(n);
	for (int i = 0; i < n; i++) {	
		for (int j = 0; j < m; j++) {		
			int x;
			cin >> x;
			tomato[i].push_back(x);	
			if (x == 1) {
				q.push(make_pair(j, i)); //x,y순
			}
		}
	}
	BFS(tomato);
	int max1 = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (tomato[i][j] == 0) {
				cout << "-1" << endl;
				return 0;
			}
			if (max1 < tomato[i][j]) {
				max1 = tomato[i][j];
			}
		}
	}
	cout << max1 - 1 << endl;
	return 0;
}