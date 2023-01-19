#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

vector<int> rain;
int n;


bool isIn(int x, int y) {
	if (x < 0 || y < 0 || x >= n || y >= n) {
		return false;
	}
	return true;
}
vector<pair<int, int>> temp;
void DFS(int rain, int startX, int startY, vector<vector<int>>&arr, vector<vector<bool>>&check) {
	temp.push_back(make_pair(startX, startY));
	int x = temp.back().first;
	int y = temp.back().second;
	
	if (!check[y][x] && arr[y][x] <= rain) {
		check[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if (isIn(next_x, next_y) && !check[next_y][next_x] && arr[next_y][next_x] <= rain) {
				DFS(rain, next_x, next_y, arr, check);	
				
			}

		}
	}
	temp.pop_back();
}
vector<pair<int, int>>temp2;
vector<int>answer(10001, 0);

void DFS2(int num,int startX, int startY,vector<vector<bool>>&check) {

	temp2.push_back(make_pair(startX, startY));
	int x = temp2.back().first;
	int y = temp2.back().second;
	if (!check[y][x]) {
		
		check[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if (isIn(next_x, next_y) && !check[next_y][next_x]) {
				DFS2(num,next_x, next_y,check);
			}
		}
	}
	temp2.pop_back();
	
}
void initialize(vector<vector<bool>>&check) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			check[i][j] = false;
		}
	}
}

int main() {

	cin >> n;
	vector<vector<int>> arr(n);
	vector<vector<bool>> check(n);
	rain.push_back(0);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			check[i].push_back(false);
			int x;
			cin >> x;
			arr[i].push_back(x);
			rain.push_back(x);
			sort(rain.begin(), rain.end());
			rain.erase(unique(rain.begin(), rain.end()), rain.end());
		}
	}
	for (int i = 0; i < rain.size(); i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				DFS(rain[i], k, j, arr, check);
			}
		}
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (!check[j][k]) {
					answer[i]++;
				}
				DFS2(i, k, j, check);
			}
		}
		initialize(check);
	}
	
	sort(answer.begin(), answer.end(), greater<>());
	cout << answer[0];
	return 0;
}