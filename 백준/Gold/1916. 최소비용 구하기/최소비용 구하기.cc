#include <iostream>
#include <vector>
#include <queue>
using namespace std;
struct compare {
	bool operator()(pair<int, int>a, pair<int, int>b) {
		return a.second > b.second;
	}
};
void dijkstra(int start,vector<int>& d,vector<vector<pair<int,int>>> arr) {
	d[start] = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, compare>pq;
	pq.push(make_pair(start, 0));
	while (!pq.empty()) {
		int current = pq.top().first;
		int distance = pq.top().second;
		pq.pop();
		if (d[current] < distance) continue;
		for (int i = 0; i < arr[current].size(); i++) {
			int next = arr[current][i].first;
			int nextDistance = distance + arr[current][i].second;
			if (d[next] > nextDistance) {
				d[next] = nextDistance;
				pq.push(make_pair(next, nextDistance));
			}
		}
	}

}

int main() {
	int n, m;//n:도시갯수,m:버스갯수
	cin >> n >> m;
	vector<vector<pair<int, int>>> arr(n+1);
	vector<int>d(n+1, 987654321);

	for (int i = 0; i < m; i++) {
		int x, y, w;
		cin >> x >> y >> w;
		arr[x].push_back(make_pair(y, w));
	}
	int start, dest;
	cin >> start >> dest;
	dijkstra(start, d, arr);
	cout << d[dest] << endl;
	return 0;
}