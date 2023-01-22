import heapq
from sys import stdin

def djkstra(st,end,bus):
    global ans,dist
    q=[]
    heapq.heappush(q,(0,st))
    while(len(q)!=0):
        nowW,nowN=heapq.heappop(q)
        if nowN==end:
            break
        if nowW>dist[nowN]:
            continue
        for nextW,nextN in bus[nowN]:
            distance=nowW+nextW
            if dist[nextN]>distance:
                heapq.heappush(q,(distance,nextN))
                dist[nextN]=distance


n=int(stdin.readline())

m=int(stdin.readline())

bus=[[] for _ in range(m+1)]
inf=999999999
dist=[inf]*(n+1)

for i in range(m):
    st,end,w=map(int,stdin.readline().split())
    bus[st].append((w,end)) #비용, 도착지 순 //st는 출발지
ans=0
st,end=map(int,stdin.readline().split())
djkstra(st,end,bus)
print(dist[end])
