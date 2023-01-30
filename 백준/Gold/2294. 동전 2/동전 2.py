import sys
n,k=map(int,sys.stdin.readline().split())
arr=[]
dp=[999999]*(k+1)
dp[0]=0
for z in range(n):
    tmp=int(sys.stdin.readline())
    arr.append(tmp)
    if tmp<=k:
        dp[tmp]=1

for j in range(1,k+1):
    for i in arr:
        if j-i>=0:
            dp[j]=min(dp[j],dp[j-i]+1)

for i in range(1,k+1):
    if dp[i]==999999:
        dp[i]=0

if dp[k]==0:
    print(-1)
else:
    print(dp[k])
