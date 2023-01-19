#include <iostream>
#include <vector>
using namespace std;
int dx[8] = { 1,-1,0,0,1,1,-1,-1};
int dy[8] = { 0,0,1,-1,-1,1,-1,1 };
//오른쪽,왼쪽,위,아래 순으로 이동
int w, h; //w가 가로(x),h가 세로(y);
int answer = 0;
vector<pair<int, int>> tmp;
bool check[51][51] = { false };
void initialize(vector<vector<int>> island) {
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			check[i][j] = false;
		}
	}
	for (int i = 0; i < tmp.size(); i++) {
		tmp.pop_back();
	}
	for (int i = 0; i < island.size(); i++) {
		island.pop_back();
	}
	answer = 0;
}
bool isIn(int x, int y) {
	if (x < 0 || y < 0 || x >= w || y >= h) {
		return false;
	}
	return true;
}
void DFS(int startx,int starty, vector<pair<int,int>>& tmp,vector<vector<int>>&island) {
	tmp.push_back(make_pair(startx, starty));
	int x = tmp.back().first;
	int y = tmp.back().second;
	if (!check[y][x]) {
		check[y][x] = true;
		for (int i = 0; i < 8; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if (isIn(next_x, next_y) && !check[next_y][next_x] && island[next_y][next_x] !=0) {
				island[next_y][next_x]++;
				DFS(next_x, next_y,tmp,island);
				tmp.pop_back();
				
			}
		}
	}
	
}
int main() {
	while (1) {
		cin >> w >> h;
		if (w == 0 && h == 0)
			return 0;
		vector<vector<int>> island(h);
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int x;
				cin >> x;
				island[i].push_back(x);
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (island[i][j] == 1) {
					DFS(j, i, tmp, island);
					answer++;
				}
			}

		}

		cout << answer << endl;
		initialize(island);
	}
	
	return 0;
}