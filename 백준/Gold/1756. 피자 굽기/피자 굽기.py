from collections import deque

d,n=map(int,input().split())

oven=list(map(int,input().split()))

pizza=deque(map(int,input().split()))

make_oven=[]
min=9999999999
for i in range(d):
    if (oven[i]<min):
        min=oven[i]
    make_oven.append(min)

tmp=d
ans=0
while(len(pizza)!=0):
    now=pizza.popleft()
    left=0
    right=tmp-1
    while(left<=right):
        mid=(left+right)//2
        if (now<=make_oven[mid]): #now가 크면 오른쪽
            left=mid+1
            tmp=mid
        else: #now가 작으면 왼쪽
            right=mid-1
            #tmp=mid
    if (right==-1):
        tmp=-1
        break
    #print(now," : ",tmp,right)
print(tmp+1)