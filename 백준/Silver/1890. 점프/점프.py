from sys import stdin

n=int(stdin.readline())
arr=[list(map(int,stdin.readline().split())) for _ in range(n)]
dp=[[0]*n for _ in range(n)]
dp[0][0]=1
for i in range(n):
    for j in range(n):
        if(i==n-1 and j==n-1): #도착
            break
        nextY=i+arr[i][j]
        nextX=j+arr[i][j]

        if(0<=nextY<n):
            dp[nextY][j]+=dp[i][j]
        if(0<=nextX<n):
            dp[i][nextX]+=dp[i][j]

print(dp[n-1][n-1])