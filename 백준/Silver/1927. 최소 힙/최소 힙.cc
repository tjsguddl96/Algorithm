#include <iostream>
#include <queue>
using namespace std;
 
 
int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n;
    cin >> n;
    priority_queue<int, vector<int>, greater<int> > pq;
 
    while (n--) {
        int x;
        cin >> x;
        if (!x) {
            if (!pq.empty()) {
                cout << pq.top()<<"\n";
                pq.pop();
            }
            else {
                cout << "0\n";
            }
        }
        else {
            pq.push(x);
            
        }
    }
    
    return 0;
}