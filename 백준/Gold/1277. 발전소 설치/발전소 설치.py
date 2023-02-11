from sys import stdin
import heapq
import math

def get_dist(x1,y1,x2,y2):
    return math.sqrt(pow(x1-x2,2)+pow(y1-y2,2))
def djkstra():
    q=[]
    heapq.heappush(q,(0,0))
    while(len(q)!=0):
        nowD,nowN=heapq.heappop(q)
        if(nowD>dist[nowN]):
            continue
        for nextD,nextN in route[nowN]:
            d=nowD+nextD
            if (d<dist[nextN]):
                dist[nextN]=d
                heapq.heappush(q,(d,nextN))

n,w=map(int,stdin.readline().split())

m=float(stdin.readline())
position=[]

q=[]
route=[[] for _ in range(n)]
inf=999999999
dist=[inf]*n
dist[0]=0
for i in range(n):
    x,y=map(int,stdin.readline().split())
    position.append((x,y))

for i in range(n):
    for j in range(i+1,n):
        d=get_dist(position[i][0],position[i][1],position[j][0],position[j][1])
        if (d<=m):
            route[i].append((d,j))
            route[j].append((d,i))


for i in range(w):
    n1,n2=map(int,stdin.readline().split())
    route[n1-1].append((0,n2-1))
    route[n2-1].append((0, n1-1))
djkstra()
print(math.floor(dist[-1]*1000))