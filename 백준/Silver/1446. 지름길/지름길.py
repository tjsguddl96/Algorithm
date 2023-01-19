n,d=map(int,input().split())

arr=list()

for i in range(n):
    s,e,dis=map(int,input().split()) #시작점, 도착점, 길이
    arr.append((s,e,dis))

inf=999999999
dp=[inf]*(d+1)

arr.sort(key=lambda x:x[1])
for i in range(len(dp)):
    dp[i]=i


for s,e,dis in arr:
    if e>d:
        continue

    val=min(e-s,dis)
    dp[e]=min(dp[e],dp[s]+val)
    # s부터d+1까지 dp값 업뎃
    for i in range(e, d + 1):
        dp[i]=dp[e]+(i-e)

ans=d
for s,e,dis in arr:
    if e>d:
        continue
    ans=min(ans,d-e+dp[e])
print(ans)