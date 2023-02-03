from sys import stdin
from collections import deque

t=int(stdin.readline())
for tc in range(t):
    n,m=map(int,stdin.readline().split()) #n은 문서의 갯수, m은 현재 q에 있는 문서의 몇번째인지 알고싶은 idx
    temp=list(map(int,stdin.readline().split()))
    priority=deque()
    ans=[]
    answer=-1
    for i in range(len(temp)):
        priority.append((i,temp[i])) #idx,중요도 순


    while(len(priority)!=0):
        if (max(priority,key=lambda x:x[1])[1]==priority[0][1]):
            ans.append(priority.popleft())

        else:
            priority.append(priority.popleft())

    for j in range(len(ans)):
        if ans[j][0]==m:
            answer=j+1
            break
    print(answer)