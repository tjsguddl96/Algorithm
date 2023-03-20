from sys import stdin
import heapq

def djkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    d1[start]=0
    while(len(q)!=0):
        nowC,nowN=heapq.heappop(q)
        if(d1[nowN]<nowC):
            continue
        for nextC,nextN in arr[nowN]:
            nextD=nowC+nextC
            if(nextD<d1[nextN]):
                d1[nextN]=nextD
                heapq.heappush(q,(d1[nextN],nextN))


n,e=map(int,stdin.readline().split())
ans1=0
ans2=0
arr=[[] for _ in range(n+1)]
inf=999999999
d1=[inf]*(n+1)

for i in range(e):
    v1,v2,c=map(int,stdin.readline().split())
    arr[v1].append((c,v2))
    arr[v2].append((c,v1))

u,v=map(int,stdin.readline().split())
djkstra(1)
du=d1[u]
dv=d1[v]

ans1+=du
d1=[inf]*(n+1)
djkstra(u)
ans1+=d1[v]
d1 = [inf] * (n + 1)
djkstra(v)
ans1+=d1[n]


ans2+=dv
d1 = [inf] * (n + 1)
djkstra(v)
ans2+=d1[u]
d1 = [inf] * (n + 1)
djkstra(u)
ans2+=d1[n]


answer=min(ans1,ans2)
if(answer>=inf):
    print(-1)
else:
    print(answer)

'''
// 예제 1
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

정답: 7

// # 2
4 5
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
2 3

정답: 8

// # 3
5 6
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
4 5 1
2 3

정답: 9

4 5
1 2 10
1 3 11
2 3 20
2 4 30
3 4 100
2 3
->61
'''