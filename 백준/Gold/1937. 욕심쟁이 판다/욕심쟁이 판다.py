#단순 BFS나 DFS로만 풀면 방문했던 곳도 계속 방문해서 시간 초과!!!
#따라서 DFS+dp 조합으로 풀자!
import sys
sys.setrecursionlimit(10**9)
n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
dp=[[-1]*n for _ in range(n)]
dx=[1,-1,0,0]
dy=[0,0,1,-1]

def DFS(x,y):
    if dp[y][x]!=-1:
        return dp[y][x]
    dp[y][x]=1
    for i in range(4):
        nexty=y+dy[i]
        nextx=x+dx[i]
        if 0<=nexty<n and 0<=nextx<n and arr[nexty][nextx]>arr[y][x]:
            dp[y][x]=max(dp[y][x],DFS(nextx,nexty)+1)
    return dp[y][x]

maxx=0
for i in range(n):
    for j in range(n):
        
        DFS(j,i)
        maxx=max(maxx,dp[i][j])
print(maxx)
