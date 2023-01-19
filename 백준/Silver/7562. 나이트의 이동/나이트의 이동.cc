#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int dirx[8] = { 1,2,2,1,-1,-2,-2,-1};
int diry[8] = { 2,1,-1,-2,-2,-1,1,2 };
bool check[301][301];

int l;
int arr[301][301];
bool isIn(int x, int y) {
	if (x < 0 || x >= l || y < 0 || y >= l) {
		return false;
	}
	return true;
}
void Initialize() {
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < l; j++) {
			check[i][j] = false;
			arr[i][j] = 0;
		}
	}
}

void BFS(vector<int> start,vector<int> dest) {
	queue<vector<int>> q;
	Initialize();
	q.push(start);
	check[q.front()[1]][q.front()[0]] = true;
	while (!q.empty()) {
		int x = q.front()[1];
		int y = q.front()[0];
		q.pop();
		if (x == dest[1] && y == dest[0]) {
			cout << arr[x][y] << endl;
			while (!q.empty()) {
				q.pop();
			}
			break;
		}
		for (int i = 0; i < 8; i++) {
			int next_x = x + dirx[i];
			int next_y = y + diry[i];
			if (isIn(next_x, next_y)&&!check[next_x][next_y]) {
				start[1] = next_x;
				start[0] = next_y;
				check[next_x][next_y] = true;
				q.push(start);
				arr[next_x][next_y] = arr[x][y] + 1;
			}
		}
	}
}
int main() {
	int t;
	cin >> t;
	
	for (int i = 0; i < t; i++) {
		cin >> l;
		vector<int>start;
		vector<int>dest;
		
		for (int i = 0; i < 2; i++) {
			int x;
			cin >> x;
			start.push_back(x);
		}
		for (int i = 0; i < 2; i++) {
			int x;
			cin >> x;
			dest.push_back(x);
		}
		BFS(start, dest);
	}
	return 0;
}