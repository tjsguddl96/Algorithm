#include <iostream>
#include <vector>
using namespace std;
int m ;
int n;
int t;
int k;
bool available[100][100] = { false };
bool check[100][100] = { false };
int answer = 0;
int dir[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
bool isIn(int x, int y) {
	if (x < 0 || y < 0 || x >= n || y >= m) {
		return false;
	}
	else {
		return true;
	}
}
void DFS(int x,int y) {
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int x_next = x + dir[i][0];
			int y_next = y + dir[i][1];
			if (isIn(x_next,y_next)&&available[x_next][y_next] && !check[x_next][y_next]) {
				DFS(x_next, y_next);
			}
		}
}
int main() {
	
	cin >> t;
	for (int i = 0; i < t; i++) {
		int temp;
		answer = 0;
		cin >> m >> n >> k;
		vector<vector<int>> cabbageAt(k,vector<int>(0));
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				available[i][j] = false;
				check[i][j] = false;
			}
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 2; j++) {
				cin >> temp;
				cabbageAt[i].push_back(temp);
			}

		}
		
		for (int i = 0; i < k; i++) {
			available[cabbageAt[i][1]][cabbageAt[i][0]] = true;
		}
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < m; j++) { 
				if (available[i][j] && !check[i][j]) {
					DFS(i,j);
					answer++;
				}
			}
		}
		cout << answer<<endl;
	}
	return 0;
}