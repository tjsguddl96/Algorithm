from collections import deque
from sys import stdin
def BFS(arr,arrRoom,now):
    q=deque()
    q.append((now,arrRoom[now]))
    while(len(q)!=0):
        nowNode,nowRoom=q.popleft()

        for nextNode in arr[nowNode]:
            if arrRoom[nextNode]==arrRoom[nowNode]:
                return False
            if arrRoom[nextNode]==0:
                if arrRoom[nowNode]==1:
                    arrRoom[nextNode]=2
                else:
                    arrRoom[nextNode]=1
                q.append((nextNode, arrRoom[nextNode]))
    return True
k = int(stdin.readline())
for tc in range(k):

    v, e = map(int, stdin.readline().split())
    arrRoom=[0]*(v+1)
    ch = [0] * (v + 1)
    arr = [[] for _ in range(v + 1)]
    ans="YES"
    for i in range(e):
        n1,n2=map(int,stdin.readline().split())
        arr[n1].append(n2)
        arr[n2].append(n1)
    for i in range(1,v+1):
        if arrRoom[i]==0:
            arrRoom[i]=1
            if(BFS(arr,arrRoom,i)==False):
                ans="NO"
                break
    print(ans)
