from collections import deque
from sys import stdin

dx=[0,0,-1,1]
dy=[1,-1,0,0]

def BFS(stY,stX,arr,n,m,ch):
    global ans
    q=deque()
    q.append((stY,stX,0))
    while(len(q)!=0):
        nowY,nowX,dist=q.popleft()
        ch[nowY][nowX]=dist
        ans=max(ans,dist)
        for i in range(4):
            nextY=nowY+dy[i]
            nextX=nowX+dx[i]
            if (0<=nextY<n and 0<=nextX<m and arr[nextY][nextX]=='L' and ch[nextY][nextX]==-1):
                ch[nextY][nextX]=dist+1
                q.append((nextY,nextX,ch[nextY][nextX]))
    return ans


n,m=map(int,stdin.readline().split())

arr=[list(stdin.readline()) for _ in range(n)]
ans=0
answer=[]
for i in range(n):
    for j in range(m):
        if arr[i][j]=='W':
            continue
        ch = [[-1] * m for _ in range(n)]
        BFS(i,j,arr,n,m,ch)

print(ans)
