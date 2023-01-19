#include <iostream>
#include <vector>
using namespace std;
vector<int> gate;
int do_find(int x) {
	if (x == gate[x]) {
		return gate[x];
	}
	else {
		return gate[x]=do_find(gate[x]);
	}
}
void do_union(int x, int y) {
	int a = do_find(x);
	int b = do_find(y);
	gate[a] = b;

}
int main() {
	int g, p, gi, answer = 0;
	cin >> g >> p;
	
	for (int i = 0; i <= g; i++) {
		gate.push_back(i);
	}
	for (int i = 0; i < p; i++) {
		cin >> gi;
		int parent = do_find(gi);
		if (parent == 0) {
			break;
		}
		else {
			answer++;
			do_union(parent, parent - 1);
		}
	}
	cout << answer;
	return 0;
}
