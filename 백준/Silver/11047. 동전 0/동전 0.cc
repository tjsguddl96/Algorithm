#include <iostream>
#include <vector>
using namespace std;

int main(){
    int N,K,A;
    int answer=0;
    cin>>N>>K;
    vector<int> money;
    for(int i=0;i<N;i++){
        cin>>A;
        money.push_back(A);
    }
    for(int i=money.size()-1;i>=0;i--){
        if(K>=money[i]){
            answer+=K/money[i];
            K%=money[i];
        }
    }
    cout<<answer;
    return 0;
}