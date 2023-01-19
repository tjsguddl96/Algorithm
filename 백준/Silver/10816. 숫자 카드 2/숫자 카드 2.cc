#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdio>
using namespace std;
//lower_bound와 upper_bound는 이분탐색(binary search)의 변형이라고 생각함
//lower_bound는 k이상인 첫 번째애 위치
//upper_bound는 k초과인 첫 번째애 위치
int main() {
	int n;
	cin >> n;
	vector<int> got;
	for (int i = 0; i < n; i++) {
		int x;
		scanf("%d",&x);
		got.push_back(x);
	}
	sort(got.begin(), got.end());
	int m;
	cin >> m;
    int answer=0;
	for (int i = 0; i < m; i++) {
		int x;
		scanf("%d",&x);

		//upper_bound(벡터(혹은배열)의 첫 시작주소,벡터(혹은배열)의 끝 주소,찾으려는 수,정렬(없으면오름차순기본)) --> 찾으려는 수를 초과하는 첫번째애의 위치
		//lower_bound(벡터(혹은배열)의 첫 시작주소,벡터(혹은배열)의 끝 주소,찾으려는 수,정렬(없으면오름차순기본)) --> 찾으려는 수 이상인 첫번째애의 위치

		answer = upper_bound(got.begin(), got.end(), x) - lower_bound(got.begin(), got.end(), x);
		printf("%d ",answer);
	}
	
	return 0;
}