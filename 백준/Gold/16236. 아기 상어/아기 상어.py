from sys import stdin
from collections import deque
import heapq
ans=0
def bfs(startY,startX):
    global ch,nowSize,nowEat,flag,ans
    q=[]
    heapq.heappush(q,(0,startY,startX))

    while(len(q)!=0):
        #printCh()
        nowD,nowY,nowX=heapq.heappop(q)
        ch[nowY][nowX]=1
        #print(nowY,nowX,nowD,sep=' ')
        if(sea[nowY][nowX]>0 and sea[nowY][nowX]<nowSize):
            nowEat+=1
            sea[nowY][nowX]=0
            ans+=nowD
            #print("####",nowY, nowX, nowD, sep=' ')
            q.clear()
            heapq.heappush(q,(nowD,nowY,nowX))
            flag=1
        if(nowEat==nowSize):
            nowSize+=1
            nowEat=0
        if(flag==1):
            break
        for i in range(4):
            nextY=nowY+dy[i]
            nextX=nowX+dx[i]
            nextD=nowD+1
            if(0<=nextY<n and 0<=nextX<n and sea[nextY][nextX]<=nowSize and ch[nextY][nextX]==0):

                ch[nextY][nextX]=1
                if(nowEat==nowSize):
                    nowSize+=1
                    nowEat=0
                heapq.heappush(q,(nextD,nextY,nextX))
                #print(q)
                #printCh()


    initCh()
    if(len(q)!=0):
        nextSD,nextSY,nextSX=heapq.heappop(q)
        ch[nextSY][nextSX]=1
        flag=0
        bfs(nextSY,nextSX)



def printCh():
    for i in range(n):
        for j in range(n):
            print(ch[i][j],end=' ')
        print()
    print("---------------------")
def initCh():
    for i in range(n):
        for j in range(n):
            ch[i][j]=0

dx=[0,-1,1,0]
dy=[-1,0,0,1]

n=int(stdin.readline())

sea=[list(map(int,stdin.readline().split())) for _ in range(n)]
startY=0
startX=0
nowSize=2
nowEat=0
flag=0
ch=[[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if(sea[i][j]==9):
            startY=i
            startX=j
            sea[i][j]=0
bfs(startY,startX)
print(ans)