from collections import deque
import sys

input=sys.stdin.readline

n,m=map(int,input().split())


graph=[[] for _ in range(n+1)]

for i in range(m):
    a,b=map(int,input().split())
    graph[b].append(a)

hackedNum=[0]*(n+1)

answer=[]

def bfs(idx,check,graph):
    q=deque()
    q.append(idx)
    cnt=0
    while(q):
        cur=q.popleft()
        check[cur]=1
        for i in graph[cur]:
            if check[i]==0:
                q.append(i)
                check[i]=1
                cnt+=1
    hackedNum[idx]=cnt

maxx=0

for i in range(1,n+1):
    check = [0] * (n + 1)
    bfs(i,check,graph)

    if maxx<=hackedNum[i]:
        if maxx==hackedNum[i]:
            answer.append(i)
        else:
            answer.clear()
            answer.append(i)
        maxx = hackedNum[i]

for i in answer:
    print(i,end=' ')