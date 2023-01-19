#include <iostream>
#include <vector>
using namespace std;
int n, m;
bool available[101][101] = { false };
bool check[101][101] = { false };
int answer = 0;
bool isIn(vector<int>& tmp,int j) {
	for (int i = 0; i < tmp.size(); i++) {
		if (j == tmp[i]) {
			return true;
		}
	}
	return false;
}
void DFS(vector<int>& tmp,int start) {
	tmp.push_back(start);
	for (int i = 1; i <n+1 ; i++) {
		if (available[start][i] && available[i][start] && !check[start][i] && !check[i][start]) {
			check[start][i] = true;
			check[i][start] = true;
			
			if (isIn(tmp,i) == false) {
				DFS(tmp, i);
				tmp.pop_back();
				answer++;
			}
			
		}
		
	}
	
}
int main() {
	cin >> n >> m;
	vector<vector<int>> arr(m);
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < 2; j++) {
			int c;
			cin >> c;
			arr[i].push_back(c);
		}
	}
	for (int i = 0; i < m; i++) {
		available[arr[i][0]][arr[i][1]] = true;
		available[arr[i][1]][arr[i][0]] = true;
	}
	vector<int> tmp;
	DFS(tmp,1);
	
	cout << answer;
	return 0;
}