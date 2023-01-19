#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int m, n,k; //m은 세로(y),n은 가로(x),k는 네모 갯수
bool check[101][101] = { false };
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
//오른쪽, 왼쪽, 위, 아래 순
bool isIn(int x, int y) {
	if (x < 0 || y < 0 || x >= n || y >= m) {
		return false;
	}
	return true;
}
vector<pair<int,int>> tmp;
int answer[1000000] = { 0 };
int answersize = 0;
void DFS(vector<vector<int>>& available,int startX,int startY,vector<pair<int,int>>& tmp,int answersize) {
	tmp.push_back(make_pair(startX, startY));
	int x = tmp.back().first;
	int y = tmp.back().second;
	int next_x = x;
	int next_y = y;
	if (available[y][x]!=0&&!check[y][x]) {
		check[y][x] = true;
		for (int i = 0; i < 4; i++) {
			next_x = x + dx[i];
			next_y = y + dy[i];
			if (isIn(next_x, next_y) && !check[next_y][next_x] && available[next_y][next_x]!=0) {
				available[next_y][next_x] = available[y][x]+1;
				DFS(available, next_x, next_y, tmp,answersize);
				
			}
		}
	}
	answer[answersize]++;
	tmp.pop_back();
}

int main() {
	cin >> m >> n>>k;
	vector<vector<int>> available(m);
	vector<vector<int>> rec(k);
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			available[i].push_back(1);
		}
	}
	for (int i = 0; i < k; i++) {
		for (int j = 0; j < 4; j++) {
			int x;
			cin >> x;
			rec[i].push_back(x);
		}
		for (int p = (m - rec[i][3]); p < (m - rec[i][1]); p++) {
			for (int q = rec[i][0]; q  < rec[i][2]; q++) {
				available[p][q] = 0;
			}
		}
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (available[i][j] == 1) {
				DFS(available, j, i, tmp,answersize);
				answersize++;
			}
		}
	}

	vector<int> realanswer;
	for (int i = 0; i < answersize; i++) {
		realanswer.push_back(answer[i]);
	}
	sort(realanswer.begin(), realanswer.end());
	cout << answersize << endl;
	for (auto& a : realanswer) {
		cout << a << " ";
	}
	
	return 0;
}