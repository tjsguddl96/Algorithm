from collections import deque
from itertools import permutations
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def virusBFS(arr,n,m,y,x,cnt,ch):
    q=deque()
    q.append((y,x))
    ch[y][x]=1
    cnt+=1
    while(q):
        nowY,nowX=q.popleft()
        for i in range(4):
            nexty=nowY+dy[i]
            nextx=nowX+dx[i]
            if 0<=nexty<n and 0<=nextx<m and ch[nexty][nextx]==0 and arr[nexty][nextx]==0:
                ch[nexty][nextx]=1
                arr[nexty][nextx]=2
                q.append((nexty,nextx))
                cnt+=1
    return cnt

n,m=map(int,input().split())

arr=[list(map(int,input().split())) for _ in range(n)] #2 is virus, 1 is wall, 0 is empty
answer=0
for u in range(n*m):
    for v in range(u+1,n*m):
        for w in range(v+1,n*m):
            tmp = [[0] * m for _ in range(n)]
            for i in range(n):
                for j in range(m):
                    tmp[i][j] = arr[i][j]
            if tmp[u // m][u % m] != 0 or tmp[v// m][v % m] != 0 or tmp[w // m][w % m] != 0:
                continue
            tmp[u // m][u % m] = 1
            tmp[v// m][v % m] =1
            tmp[w // m][w % m] =1
            chV = [[0] * m for _ in range(n)]
            cnt1 = 0
            cnt2 = 0

            for i in range(n):
                for j in range(m):
                    if tmp[i][j] == 2 and chV[i][j] == 0:
                        cnt = 0
                        cnt2 += virusBFS(tmp, n, m, i, j, cnt, chV)
                    if tmp[i][j] == 1:
                        cnt1 += 1
            answer = max(answer, n * m - cnt2 - cnt1)
print(answer)


'''
per=[i for i in range(n*m)]
answer=0
for p in permutations(per,3):
    tmp=[[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            tmp[i][j]=arr[i][j]
    can1=p[0]
    can2=p[1]
    can3=p[2]
    if tmp[can1//m][can1%m]!=0 or tmp[can2//m][can2%m]!=0 or tmp[can3//m][can3%m]!=0 :
        continue
    tmp[can1//m][can1%m]=1
    tmp[can2 // m][can2 % m] = 1
    tmp[can3 // m][can3 % m] = 1
    chV = [[0] * m for _ in range(n)]
    cnt1 = 0
    cnt2 = 0

    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 2 and chV[i][j] == 0:
                cnt = 0
                cnt2 += virusBFS(tmp, n, m, i, j, cnt, chV)
            if tmp[i][j] == 1:
                cnt1 += 1
    answer=max(answer,n * m - cnt2 - cnt1)
print(answer)
'''

'''
7 7
27 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
 ->virus : 7

4 6
0 0 0 0 1 0
1 0 0 1 0 2
1 1 1 0 0 2
0 0 0 1 0 2 ->virus: 8


8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0
0 0 1 0 0 0 0 0
'''