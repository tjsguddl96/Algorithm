n=int(input())

arr=[]

for i in range(n):
    taketime,benefit=map(int,input().split())
    arr.append((i+1,i+1+taketime,benefit))

arr.sort(key=lambda x:x[1])

answer=0

dp=[0]*(n+2)


for start,end,benefit in arr:
    if end<=n+1:
        dp[end]=max(dp[end],dp[start]+benefit)
        for j in range(end,n+2):
            dp[j]=dp[end]
print(max(dp))