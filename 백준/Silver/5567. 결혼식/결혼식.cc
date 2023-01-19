
#include <iostream>
	
using namespace std;
int N, M;
int isFriend[501][501] = { 0 };
int flag[501][501] = { 0 };
int answer = 0;
int temp = 0;

void countFriend(int x) {
	for (int i = 2; i <= N; i++) {
		if (!flag[x][i]&&!flag[i][x]&& isFriend[x][i]) {
			flag[x][i] = 1;
			flag[i][x] = 1;
			for (int j = 1; j <= N; j++) {
				if (isFriend[1][j]) {
					flag[j][i] = 1;
				}				
			}
			answer++;
			temp++;
			if (temp < 2) {
				countFriend(i);
			}
			temp--;
		}
	}

}

int main() {
	cin >> N;
	cin >> M;
	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		isFriend[x][y] = 1;
		isFriend[y][x] = 1;
	}
	countFriend(1);
	cout << answer;
	return 0;
}
