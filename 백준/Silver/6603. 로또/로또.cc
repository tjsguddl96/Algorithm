#include <iostream>
#include <vector>

using namespace std;
int R = 6;
vector<vector<int>>v(14, vector<int>(0));
int Select[50] = { 0 };
void setSelectzero() {
	for (int i = 0; i < 50; i++) {
		Select[i] = 0;

	}
}
void print(int k) {
	for (int i = 0; i < v[k].size(); i++) {
		if (Select[i]) {
			cout << v[k][i] << " ";
		}
	}
	cout << endl;
}
void DFS(int k, int idx, int cnt) {
	if (cnt == R) {
		print(k);

		return;
	}
	for (int i = idx; i < v[k].size(); i++) {
		if (Select[i]) continue;
		Select[i] = 1;
		DFS(k, i, cnt + 1);
		Select[i] = 0;
	}
}
int main() {
	int x = 1;
	int k = 0;
	while (x) {
		cin >> x;
		if (x == 0) continue;
		for (int i = 0; i < x; i++) {
			int y;
			cin >> y;
			v[k].push_back(y);
		}
		k++;
	}
	for (int i = 0; i < k; i++) {
		DFS(i, 0, 0);
		cout << endl;
		setSelectzero();
	}
	return 0;
}