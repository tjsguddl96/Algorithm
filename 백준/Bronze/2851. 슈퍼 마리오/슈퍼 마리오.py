arr=[0]*10
answer=[]
dp=[0]*11
for i in range(10):
    arr[i]=int(input())
min=99999999
for i in range(1,11):
    dp[i]=arr[i-1]+dp[i-1]
    if min>=abs(100-dp[i]):
        min=abs(100-dp[i])
        answer.append(dp[i])
print(answer[len(answer)-1])