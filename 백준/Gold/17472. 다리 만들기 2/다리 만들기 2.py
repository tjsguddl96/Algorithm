import sys
answer=0
n,m = map(int, sys.stdin.readline().rsplit())
arr = [list(map(int, sys.stdin.readline().rsplit())) for _ in range(n)]

dx=[1,-1,0,0]
dy=[0,0,1,-1]
check=[[0]*m for _ in range(n)]

def islandNumber(y,x,cnt):
    for i in range(4):
        nexty=y+dy[i]
        nextx=x+dx[i]
        if 0<=nexty<n and 0<=nextx<m and check[nexty][nextx]==0 and arr[nexty][nextx]!=0:
            check[nexty][nextx]=1
            arr[nexty][nextx]=cnt
            islandNumber(nexty,nextx,cnt)

CNT=1
for i in range(n):
    for j in range(m):
        if check[i][j]==0 and arr[i][j]==1:
            check[i][j]=1
            arr[i][j]=CNT
            islandNumber(i,j,CNT)
            CNT+=1

parent=[0]*(CNT) #인덱스 0은 제외해야함
for i in range(CNT):
    parent[i]=i

weightList=set()

for i in range(n):
    tmp=0
    cnt=0
    for j in range(m):
        if tmp==0 and arr[i][j]!=0:
            tmp=arr[i][j]
            cnt=0
        else:
            if arr[i][j]==tmp:
                cnt=0
            else:
                if arr[i][j]!=0 and tmp!=arr[i][j]:
                    if cnt>=2:
                        weightList.add((tmp,arr[i][j],cnt))
                    tmp=arr[i][j]
                    cnt=0
                elif arr[i][j]==0:
                    cnt+=1
for i in range(m):
    tmp=0
    cnt=0
    for j in range(n):
        if tmp==0 and arr[j][i]!=0:
            tmp=arr[j][i]
            cnt=0
        else:
            if arr[j][i]==tmp:
                cnt=0
            else:
                if arr[j][i]!=0 and tmp!=arr[j][i]:
                    if cnt>=2:
                        weightList.add((tmp,arr[j][i],cnt))
                    tmp=arr[j][i]
                    cnt=0
                elif arr[j][i]==0:
                    cnt+=1

weightList=list(weightList)
weightList.sort(key=lambda x:x[2])

def getParent(node,parent):
    if parent[node] != node:
        parent[node] = getParent(parent[node],parent)
    return parent[node]

def unionParent(node1,node2,parent):
    node1=getParent(node1,parent)
    node2=getParent(node2,parent)
    if node1<=node2:
        parent[node2]=node1
    else:
        parent[node1]=node2
        
        
flag=0
if len(weightList)<CNT-2:
    flag=1

for i in range(len(weightList)):
    a,b,c=weightList[i]
    if getParent(a,parent)!=getParent(b,parent):
        unionParent(a,b,parent)
        answer+=c

for i in range(2):
    for j in range(len(weightList)):
        parent[weightList[j][i]]=getParent(weightList[j][i],parent)
for i in range(1,CNT):
    if parent[i]!=1:
        flag=1
if flag==0:
    print(answer)
else:
    print(-1)