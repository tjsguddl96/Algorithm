from sys import stdin

inf=99999999

n=int(stdin.readline())

arr=[list(map(int,stdin.readline().split())) for _ in range(n)]

ans=inf

for i in range(3): #첫 번째 집이 R 또는 G 또는 B일 경우를 다 알아야함
    dp=[[inf]*3 for _ in range(n)] #dp[몇 번째 집인지][R인지 G인지 B인지]
    dp[0][i]=arr[0][i]
    for j in range(1,n):
        dp[j][0]=arr[j][0]+min(dp[j-1][1],dp[j-1][2]) #지금 집을 R을 칠한다면 이전 집은 G또는 B를 칠해야함
        dp[j][1] = arr[j][1] + min(dp[j - 1][0], dp[j - 1][2])
        dp[j][2] = arr[j][2] + min(dp[j - 1][1], dp[j - 1][0])
    for j in range(3): #마지막 집은 첫번째 집과 다른 색을 칠해야함
        if (i!=j):
            ans=min(dp[-1][j],ans)
print(ans)