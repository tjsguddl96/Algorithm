from collections import deque
import sys

n,m=map(int,input().split())
q=deque()
arr=[list(map(int,sys.stdin.readline().split())) for _ in range(n)]
dx=[0,0,1,-1]
dy=[1,-1,0,0]
melted=[[0]*m for _ in range(n)]
ch=[[0]*m for _ in range(n)]

def melt(x,y):
    cnt=0
    for i in range(4):
        nexty=y+dy[i]
        nextx=x+dx[i]
        if 0<=nextx<m and 0<=nexty<n and arr[nexty][nextx]==0:
            cnt+=1
    melted[y][x]=cnt
answer=0
day=0
while(answer<2):
    answer=0
    for u in range(1,n-1):
        for v in range(1,m-1):
            if ch[u][v]!=0 or arr[u][v]==0:
                continue

            if ch[u][v]==0 and arr[u][v]!=0:
                answer+=1
                q.append((u,v)) #y,x순
                ch[u][v]=1
                while(q):
                    y,x=q.popleft()
                    for i in range(4):
                        nextx=x+dx[i]
                        nexty=y+dy[i]
                        if 0<=nextx<m and 0<=nexty<n and ch[nexty][nextx]==0 and arr[nexty][nextx]!=0:
                            ch[nexty][nextx]=1
                            q.append((nexty,nextx))
    if answer>=2:
        break
    #녹아서 arr에 저장
    for yy in range(1,n-1):
        for xx in range(1,m-1):
            if arr[yy][xx]!=0:
                melt(xx,yy)
            ch[yy][xx]=0

    for yyy in range(1,n-1):
        for xxx in range(1,m-1):
            if arr[yyy][xxx]-melted[yyy][xxx]<0:
                arr[yyy][xxx]=0
            else:
                arr[yyy][xxx]-=melted[yyy][xxx]

    #녹아서 arr에 저장

    day+=1

    if all(arr[i][j]==0 for i in range(1,n-1) for j in range(1,m-1)):
        day=0
        break

print(day)