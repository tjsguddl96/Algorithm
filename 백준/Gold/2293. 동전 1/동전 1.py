from sys import stdin


n,k=map(int,stdin.readline().split())

coin=[]
for i in range(n):
    coin.append(int(stdin.readline()))


dp=[0]*(k+1)
dp[0]=1


# j원을 만들기 위해 동전 c가 얼마나 필요한지 dp에 더함 -> 결국 각 동전이 필요한 만큼 다 더해지니까 경우의 수 나옴.
for c in coin:
    for j in range(1,k+1):
        if j>=c:
            dp[j]+=dp[j-c]
print(dp[-1])