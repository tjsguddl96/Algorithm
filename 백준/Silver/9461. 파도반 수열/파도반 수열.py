import sys
t=int(input())
tc=[]


for i in range(t):
    tc.append(int(sys.stdin.readline()))

dp=[0]*max(tc)
tmp=[1,1,1,2,2]
for i in range(5):
    dp[i]=tmp[i]

def P(x):
    if x<=4:
        return dp[x]
    else:
        for i in range(5,x+1):
            dp[i]=dp[i-1]+dp[i-5]

P(max(tc)-1)

for j in range(len(tc)):
    print(dp[tc[j]-1])