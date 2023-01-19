#include <iostream>
#include <string>
#include <vector>
using namespace std;
int N;
int Y = 0;
int D = 0;
vector<int> callDuration;
int Young(vector<int>callDuration) {
	for (int i = 0; i < callDuration.size(); i++) {
		int k = 0;
		k=callDuration[i] / 30 + 1;
		Y += k * 10;
	}
	return Y;
}
int Dong(vector<int>callDuration) {
	for (int i = 0; i < callDuration.size(); i++) {
		int k = 0;
		k = callDuration[i] / 60 + 1;
		D += k * 15;
	}
	return D;
}
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		callDuration.push_back(x);
	}
	Young(callDuration);
	Dong(callDuration);
	if (Y < D) {
		cout << "Y " << Y;
	}
	else if (D < Y) {
		cout << "M " << D;
	}
	else {
		cout << "Y M " << D;
	}
	return 0;
}