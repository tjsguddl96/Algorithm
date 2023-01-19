#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
int flag[501][501] = { 0 };
int isTall[501][501] = { 0 };
int isSmall[501][501] = { 0 };
int temp[501] = { 0 };
int temp1[501] = { 0 };

void resetFlag() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			flag[i][j] = 0;
		}
	}
}
void countTall(int x,int y) {
	for (int i = 1; i <= N; i++) {
		if (!flag[x][i] && isTall[x][i]) {
			flag[x][i] = 1;
			for (int j = 1; j <= N; j++) {
				if (isSmall[i][j]) {
					flag[j][i] = 1;
				}
			}
			temp[y]++;
			countTall(i,y);
		}
	}
}
void countSmall(int x,int y) {
	for (int i = 1; i <= N; i++) {
		if (!flag[x][i] && isSmall[x][i]) {
			flag[x][i] = 1;
			for (int j = 1; j <= N; j++) {
				if (isTall[i][j]) {
					flag[j][i] = 1;
				}
			}
			temp1[y]++;
			countSmall(i, y);
		}
	}
}
int main() {
	int answer = 0;
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		isTall[x][y] = 1; //x는 y보다 키가작다.
		isSmall[y][x] = 1;//y는 x보다 키가크다.
	}
	for (int i = 1; i <= N; i++) {
		countTall(i, i);
		countSmall(i, i);
		if (temp[i] + temp1[i] == N - 1) {
			answer++;
		}
		resetFlag();
	}
	cout << answer;
	return 0;
}