import sys
n,k=map(int,input().split())
arr=[]
dp=[999999]*(100000)
for z in range(n):
    tmp=int(sys.stdin.readline())
    arr.append(tmp)
    dp[tmp]=1

for i in range(1,k+1):
    for j in range(i-1,0,-1):
        if j<(i-j):
            continue
        dp[i]=min(dp[i],dp[j]+dp[i-j])

for i in range(1,k+1):
    if dp[i]==999999:
        dp[i]=0

if dp[k]==0:
    print(-1)
else:
    print(dp[k])
