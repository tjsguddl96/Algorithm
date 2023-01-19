#include <iostream>
#include <vector>
#include <cstdio>
#include <algorithm>
#include <queue>
using namespace std;

int N;
int complex[1000];
vector<int> answer;
int available[25][25] = { 0 };
int flag[25][25] = { 0 };
int dir[4][2] = { {1,0},{-1,0},{0,-1},{0,1} }; //위 아래/y 왼쪽 오른쪽/x
int next_x = 0, next_y = 0;
int total = 0;

bool isIn(int x, int y) {
	if (x < 0 || y < 0 || x >= N || y >= N) {
		return false;
	}
	else {
		return true;
	}
}

void DFS(int x, int y,int n) {
	complex[n]++;
	if (!flag[x][y]) {
		flag[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			next_x = x + dir[i][1];
			next_y = y + dir[i][0];
			if (isIn(next_x, next_y) && !flag[next_x][next_y] && available[next_x][next_y]) {
				DFS(next_x, next_y,n);
			}
		}
	}
}

void searchArea() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (available[i][j]==1&&!flag[i][j]) {
				DFS(i, j,++total);
				
			}
			
		}
	}
	cout << total << endl;


}
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int x;
			scanf("%1d", &x);
			if (x == 1) {
				available[i][j] = 1;
			}
		}
	}
	searchArea();
	for (int i = 1; i <= total; i++) {
		answer.push_back(complex[i]);
	}
	sort(answer.begin(), answer.end());
	for (auto& a : answer) {
		cout << a << endl;
	}
	return 0;
}