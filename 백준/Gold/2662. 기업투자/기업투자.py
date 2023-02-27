import copy
from sys import stdin


n,m=map(int,stdin.readline().split())

money=[[] for _ in range(n+1)]
money[0]=[0,0,0]
for i in range(1,n+1):
    temp=list(map(int,stdin.readline().split()))
    for j in range(len(temp)):
        money[i].append(temp[j])

dp=[0 for _ in range(n+1)]
path=[[] for i in range(n+1)]

for i in range(1,m+1) : #i = 기업
    for j in range(n,-1,-1) : # j = 금액
        add=0
        #dp[j]=max(dp[j],money[j][i])
        for k in range(1,j+1) :
            if (dp[j]<dp[j-k]+money[k][i]):
                dp[j]=dp[j-k]+money[k][i]
                path[j]=copy.deepcopy(path[j-k])
                add=k
        path[j].append(add)

print(dp[-1])

print(*path[-1])

'''
15
[0, 5, 6, 10, 15]
[[0, 0], [1, 0], [2, 0], [1, 2], [0, 4]]


4 3
1 5 1 3
2 6 5 5
3 7 9 7
4 10 12 10
'''