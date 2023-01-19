#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int city;
	cin >> city;
	vector<int> dis;
	vector<int> price;
	for (int i = 0; i < city - 1; i++) {
		int x;
		cin >> x;
		dis.push_back(x);
	}
	for (int i = 0; i < city; i++) {
		int x;
		cin >> x;
		price.push_back(x);
	}
	int total = price[0] * dis[0];

	for (int i = 1; i < city-1; i++) {
		if (price[i] < price[i + 1]) {
			total += price[i] * dis[i];
			price[i + 1] = price[i];
		}
		else {
			total += price[i] * dis[i];
		}
	}
	cout << total;
	return 0;
}