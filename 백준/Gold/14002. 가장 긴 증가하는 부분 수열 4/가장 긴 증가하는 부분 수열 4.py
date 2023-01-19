n=int(input())

a=list(map(int,input().split()))

dp=[[] for _ in range(n)]
lenMax=0
answer=[]
for i in range(n):
    maxx=0
    for j in range(i):
        if max(dp[j])<a[i] and maxx<len(dp[j]):
            maxx=len(dp[j])
            dp[i]=[]
            dp[i]+=dp[j]
    dp[i].append(a[i])
    if lenMax<len(dp[i]):
        lenMax=len(dp[i])
        answer=dp[i]
print(lenMax)
for i in range(lenMax):
    print(answer[i],end=' ')