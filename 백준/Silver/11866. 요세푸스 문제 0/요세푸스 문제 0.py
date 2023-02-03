from sys import stdin
from collections import deque
n,k=map(int,stdin.readline().split())
ans=[]
arr=deque()
for i in range(n):
    arr.append(i+1)

while(len(arr)!=0):
    for i in range(k-1):
        arr.append(arr.popleft())
    ans.append(arr.popleft())

if n==1:
    print("<",ans[0],">",sep='')
else:
    for i in range(len(ans)):
        if i==0:
            print("<",ans[i],end=", ",sep='')
        elif i==len(ans)-1:
            print(ans[i],end=">")
        else:
            print(ans[i],end=", ",sep='')