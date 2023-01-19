#include <iostream>
#include <queue>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int flag[101][101] = { 0 };
int available[101][101] = { 0 }; //0이면 못감, 1이면 갈수 있음
int answer = 0;
int dir[4][2] = { {0,1},{0,-1},{1,0}, {-1,0} };
int N, M;
bool isIn(int x, int y) {
	if (x<0 || y<0 || x>=M || y>=N) {
		return false;
	}
	else {
		return true;
	}
}
void BFS() {
	int x = 0, y = 0;
	queue<pair<int,int>> q;
	q.push(pair<int,int>(y,x));
	flag[y][x] = 1;
	while (!q.empty()) {
		x = q.front().second;
		y = q.front().first;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int x_next = x + dir[i][1];
			int y_next = y + dir[i][0];

			if (isIn(x_next,y_next)&&!flag[y_next][x_next] && available[y_next][x_next]) {
				flag[y_next][x_next] = flag[y][x]+1;
				q.push(pair<int, int>(y_next, x_next));
				
			}
		}
	}
	cout << flag[N - 1][M - 1];
}

int main() {
	
	cin >> N;
	cin >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			int b;
			scanf("%1d", &b);
			if (b == 1) {
				available[i][j] = 1;
			}
		}
	}
	BFS();
	return 0;
}
