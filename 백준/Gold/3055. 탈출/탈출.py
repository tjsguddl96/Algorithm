from collections import deque
from sys import stdin
input = stdin.readline
r,c=map(int,input().split()) #r은 세로, c는 가로


waterQ=deque()
positionQ=deque()

arr=[list(input()) for _ in range(r)]
inf=99999999
check=[[inf]*c for _ in range(r)]
dy=[0,0,1,-1]
dx=[1,-1,0,0]


for i in range(r):
    for j in range(c):
        if arr[i][j]=='S':
            startY=i
            startX=j
            positionQ.append((i,j))
            check[i][j]=0
            tmppLen=len(positionQ)

        elif arr[i][j]=='*':

            waterQ.append((i,j))
            check[i][j]=inf+1
            tmpLen = len(waterQ)

        elif arr[i][j]=='D':
            endY=i
            endX=j

def waterBFS(positionQ,waterQ,arr,check):
    global tmpLen,tmppLen
    while(waterQ or positionQ):
        if waterQ:
            for j in range(tmpLen):
                waterY,waterX=waterQ.popleft()
                for i in range(4):
                    waterNY,waterNX=waterY+dy[i],waterX+dx[i]
                    if 0<=waterNY<r and 0<=waterNX<c and check[waterNY][waterNX]==inf and arr[waterNY][waterNX]!='S' and  arr[waterNY][waterNX]!='D' and arr[waterNY][waterNX]!='X':
                        check[waterNY][waterNX]=inf+1
                        waterQ.append((waterNY,waterNX))
                        arr[waterNY][waterNX]='*'
            tmpLen=len(waterQ)

        if positionQ:
            for z in range(tmppLen):
                pY,pX=positionQ.popleft()
                if pY==endY and pX==endX:
                    return check[endY][endX]
                for k in range(4):
                    nextY,nextX=pY+dy[k],pX+dx[k]
                    if 0<=nextY<r and 0<=nextX<c and check[nextY][nextX]==inf and arr[nextY][nextX]!='*' and arr[nextY][nextX]!='X':
                        check[nextY][nextX]=check[pY][pX]+1
                        positionQ.append((nextY,nextX))
            tmppLen = len(positionQ)
        else:
            if check[endY][endX]>=inf:
                return "KAKTUS"



print(waterBFS(positionQ,waterQ,arr,check))

'''
3 3
DS.
*X.
...
'''