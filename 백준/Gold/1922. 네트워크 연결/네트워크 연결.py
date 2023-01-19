from collections import deque


def getParent(node,initParent):
    if initParent[node]!=node:
        initParent[node]=getParent(initParent[node],initParent)
    return initParent[node]

def unionParent(initParent,n1,n2):
    n1=getParent(n1,initParent)
    n2=getParent(n2,initParent)
    if n1<n2:  #작은 쪽으로 합친다
        initParent[n2]=n1
    else:
        initParent[n1]=n2

def findParent(initParent,n1,n2):
    n1=getParent(n1,initParent)
    n2=getParent(n2,initParent)
    if n1==n2:  #같은 부모를 갖는다. -> 사이클 발생
        return 1
    else:  #같은 부모 X
        return 0

answer=0
n=int(input())
m=int(input())
arr=[list(map(int,input().split())) for _ in range(m)]
arr.sort(key=lambda x:x[2]) #간선 정보 오름차순 정렬
q=deque()
initParent=[0]*(n+1)
for i in range(1,n+1):  #초기 : 부모가 자기 자신
    initParent[i]=i
for i in range(len(arr)): #간선 정보 오름차순으로 q에 삽입
    q.append(arr[i])

while(q):
    n1,n2,e=q.popleft()
    if findParent(initParent,n1,n2)==0:
        unionParent(initParent,n1,n2)
        answer+=e
print(answer)


