from sys import stdin

def count(d,node,now):
    global ans

    if len(node[now])==0:
        ans+=1
        return
    for i in (node[now]):
        nextN=i
        count(d,node,nextN)
n=int(stdin.readline())

arr=list(map(int,stdin.readline().split()))

node=[[] for _ in range(n)]
ans=0
d=int(stdin.readline())
for i in range(n):

    if i==d or arr[i]==d:
        continue
    if arr[i] >= 0:
        node[arr[i]].append(i)
root=-1
for i in range(n):
    if arr[i]==-1:
        root=i
        break
if d==root:
    print(ans)
else:
    count(d,node,root)
    print(ans)