#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
using namespace std;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int r, c;//r: 세로(y), c: 가로(x)
bool check[21][21] = { false };
bool isIn(int x, int y) {
	if (x < 0 || y < 0 || x >= c || y >= r) {
		return false;
	}
	return true;
}


vector<pair<int, int>> tmp;

int answer = 0;
int flag[1000] = { 0 };
void DFS(int cnt, int startX, int startY, vector<vector<char>>&arr) {
	tmp.push_back(make_pair(startX, startY));
	answer = max(answer, cnt);
	int x = tmp.back().first;
	int y = tmp.back().second;
	if (!check[y][x] &&flag[arr[y][x]]<1) {
		flag[arr[y][x]]++;
		check[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if (!check[next_y][next_x] && isIn(next_x, next_y) && flag[arr[next_y][next_x]]<1) {
				DFS(cnt + 1, next_x, next_y, arr);
				check[next_y][next_x] = false;
				flag[arr[next_y][next_x]]--;
			}
		}
	}

	
	tmp.pop_back();
}
int main() {
	cin >> r >> c;
	vector<vector<char>> arr(r);
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			char x;
			cin >> x;
			arr[i].push_back(x);
		}
	}
	DFS(1, 0, 0, arr);
	cout << answer;

	return 0;
}