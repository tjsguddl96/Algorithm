#include <vector>
#include <queue>
#include <cstdio>
using namespace std;


struct compare {
	bool operator()(pair<int, int> a, pair<int, int> b) {
		return a.second > b.second;
	}
};
void dijkstra(int k,vector<vector<pair<int,int>>>&graph,vector<int>&d) {
	d[k] = 0;
	priority_queue<pair<int, int>,vector<pair<int,int>>,compare> pq;
	pq.push(make_pair(k, 0));
	while (!pq.empty()) {
		int current = pq.top().first;
		int distance = pq.top().second;
		pq.pop();
		if (d[current] < distance) continue;
		for (int i = 0; i < graph[current].size(); i++) {
			int next = graph[current][i].first;
			int nextDistance = distance + graph[current][i].second;
			if (nextDistance < d[next]) {
				d[next] = nextDistance;
				pq.push(make_pair(next, nextDistance));
			}
		}
	}
}
int main() {
	int v, e,k;
	scanf("%d %d %d",&v,&e,&k);//k는 시작 정점 넘버
	vector<vector<pair<int,int>>> graph(v+1);
	for (int i = 0; i < e; i++) {
		int u, v, w;
		scanf("%d %d %d", &u, &v,&w);
		graph[u].push_back(make_pair(v, w));
	}
	vector<int>d(v + 1, 1000000);
	dijkstra(k, graph,d);
	for (int i = 1; i <= v; i++) {
		if (d[i] >= 1000000) {
			printf("INF\n");
		}
		else {
			printf("%d\n", d[i]);
		}
	}
	return 0;
}