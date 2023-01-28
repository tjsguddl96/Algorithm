from sys import stdin
import math

C,N=map(int,stdin.readline().split())

cost=[]
tmp=1
limit=1101

for i in range(N):
    c,p=map(int,stdin.readline().split())
    cost.append((c,p))
    tmp=math.lcm(tmp,p)
'''
if (tmp<C):
    if (C%tmp==0):
        limit=(C//tmp)*tmp
    else:
        limit=((C//tmp)+1)*tmp
'''
        
inf=999999999
dp=[inf]*(limit+1)

for Cost,People in cost:

    t=2

    dp[People]=min(Cost,dp[People])

    while(People*t<limit+1):
        dp[People*t]=min(dp[People*t],Cost*t)
        t+=1

for i in range(1,limit+1):
    for j in range(1,i):
        dp[i]=min(dp[i],dp[j]+dp[i-j])

print(min(dp[C:limit+1]))


