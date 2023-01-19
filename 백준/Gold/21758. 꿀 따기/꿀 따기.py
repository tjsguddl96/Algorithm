from itertools import permutations

n=int(input())
arr=list(map(int,input().split()))
order=[]
tmp=[0]*(n+1)
answer=0

for i in range(1,n+1):
    tmp[i]=tmp[i-1]+arr[i-1]
    order.append(i)

maxx=0

answer=0

for com in permutations(order,3):
    answer=0
    bee1,bee2,house=com
    if bee1<house:
        answer+=tmp[house]-tmp[bee1]
        if bee1<bee2<house:
            answer-=arr[bee2-1]
    else:
        answer+=tmp[bee1-1]-tmp[house-1]
        if house<bee2<bee1:
            answer-=arr[bee2-1]
    if bee2 < house:
        answer += tmp[house] - tmp[bee2]
        if bee2<bee1<house:
            answer-=arr[bee1-1]
    else:
        answer += tmp[bee2 - 1] - tmp[house - 1]
        if house<bee1<bee2:
            answer-=arr[bee1-1]


    maxx=max(maxx,answer)
print(maxx)
