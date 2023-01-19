#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
	int N, L;
	cin >> N;
	vector<int> loop;
	for (int i = 0; i < N; i++) {
		cin >> L;
		loop.push_back(L);
	}
	vector<int> answer;

	sort(loop.begin(), loop.end(), greater<>());
	answer.push_back(loop[0]);
	int max = loop[0];
    int sum=loop[0];
	for (int i = 1; i < N; i++) {
		sum+=loop[i];
        if(sum>loop[i]){
            sum=loop[i]*(i+1);
        }
        answer.push_back(sum);

	}
	sort(answer.begin(), answer.end(), greater<>());
	cout << answer[0];
	return 0;
}