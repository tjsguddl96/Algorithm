import heapq

def djkstra(st,end,arr,dist):
    global ans
    q=[]
    heapq.heappush(q,(0,0,st)) #w,dist,node순
    dist[st]=0
    while(q):
        nowW,distance,nowN=heapq.heappop(q)
        if nowN==end:
            ans=dist[nowN]
            break
        for node,weight in arr[nowN]:
            if dist[node]>distance+weight:
                dist[node]=distance+weight;
                heapq.heappush(q,(weight,distance+weight,node))



n,m=map(int,input().split())
arr=[[] for _ in range(n+1)]

for i in range(n-1):
    a1,a2,w=map(int,input().split())
    arr[a1].append((a2,w))
    arr[a2].append((a1,w))

arr2=[]
for i in range(m):
    a1,a2=map(int,input().split())
    arr2.append((a1,a2))
inf=999999999

for a1,a2 in arr2:
    dist=[inf]*(n+1)
    djkstra(a1,a2,arr,dist)
    print(dist[a2])