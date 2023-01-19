import sys
input=sys.stdin.readline
n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
op=[list(map(int,input().split())) for _ in range(m)]

dp=[[0]*(n+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,n+1):
        dp[i][j]=arr[i-1][j-1]+dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]

for M in range(m):
    i,j,x,y=op[M]
    print(dp[x][y]-dp[x][j-1]-dp[i-1][y]+dp[i-1][j-1])