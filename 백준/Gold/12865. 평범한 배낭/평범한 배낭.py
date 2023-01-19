n,k=map(int,input().split())
arr=[[0,0]]
for i in range(n):
    arr.append(list(map(int,input().split())))

dp=[[0]*(k+1) for _ in range(n+1)]


for i in range(1,n+1):
    for j in range(1,k+1):
        w,v=arr[i]
        if w>j: #해당 idx가 담을수 있는 최대 무게보다 크다면 넣기 불가능
            dp[i][j]=dp[i-1][j]
        else:  #해당 idx의 물건을 넣던지 안넣던지 비교해서 큰걸로!
            dp[i][j]=max(dp[i-1][j],dp[i-1][j-w]+v)  #(안넣는 경우, 넣는 경우) 순

print(dp[-1][-1])