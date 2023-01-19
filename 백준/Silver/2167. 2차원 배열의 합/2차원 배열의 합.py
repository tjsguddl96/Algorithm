n,m=map(int,input().split()) #n이 세로,m이 가로
arr=[list(map(int,input().split())) for _ in range(n)]
k=int(input())
op=[list(map(int,input().split())) for _ in range(k)]

tmp=[[0]*(m+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,m+1):
        tmp[i][j]=arr[i-1][j-1]+tmp[i-1][j]+tmp[i][j-1]-tmp[i-1][j-1]


for idx in range(k):
    i,j,x,y=op[idx]
    print(tmp[x][y]-tmp[i-1][y]-tmp[x][j-1]+tmp[i-1][j-1])



