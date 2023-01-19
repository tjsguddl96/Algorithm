#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
#include <string>
using namespace std;
vector<int> answer;
string a;
int temp;
int N;
bool isPrime(int n) {
	if (n == 1 || n==0) {
		return false;
	}
	for (int i = 2; i <= sqrt(n); i++) {
		if (!(n%i)) {
			return false;
		}
	}
	return true;
}

void recur(string a) {
	string temp = a;
	for (int j = 0; j < 10; j++) {
		string b = to_string(j);
		
		a += b;
		int c = stoi(a);
		if (isPrime(c)) {
			if (a.length() == N) {
				answer.push_back(c);
			}
			else if (a.length() < N) {
				recur(a);
			}
		}
		else {
			a = temp;
		}

	}
}

int main() {
	
	cin >> N;
	if (N == 1) {
		for (int i = 1; i < 10; i++) {
			if (isPrime(i)) {
				answer.push_back(i);
			}
		}
	}
	else {
		for (int i = 1; i < 10; i++) {
			if (isPrime(i)) {
				a = to_string(i);

				recur(a);
			}
		}
	}
	sort(answer.begin(), answer.end());
	for (auto& a : answer) {
		cout << a << endl;
	}
	return 0;
}