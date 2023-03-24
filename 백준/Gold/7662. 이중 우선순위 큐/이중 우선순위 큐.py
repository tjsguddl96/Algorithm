from sys import stdin
import heapq
from collections import Counter
answer=""
tc=int(stdin.readline())
for t in range(tc):
    k=int(stdin.readline())
    q=[] #최소힙을 위한 리스트
    d=dict()
    p=[] #최대힙을 위한 리스트

    for i in range(k):
        op,num=stdin.readline().split()
        if(op=='I'): #삽입=
            heapq.heappush(q,int(num))
            heapq.heappush(p,int(num)*(-1))
            if(int(num) not in d):
                d[int(num)]=1
            else:
                d[int(num)]+=1
        else:
            if(num=="-1"): #최소힙
                while (1):
                    if(len(q)==0):
                        break
                    tmpNum = heapq.heappop(q)
                    if (d[tmpNum] != 0):
                        d[tmpNum] -= 1
                        break

            else:

                while(1):
                    if(len(p)==0):
                        break
                    tmpNum=heapq.heappop(p)
                    if(d[-tmpNum]!=0):
                        d[-tmpNum]-=1
                        break
    
    maxx="undefined"
    minn="undefined"
    while(len(p)!=0):
        tmpNum=heapq.heappop(p)
        if(d[-tmpNum]!=0):
            maxx=-tmpNum
            break
    while(len(q)!=0):
        tmpNum=heapq.heappop(q)
        if(d[tmpNum]!=0):
            minn=tmpNum
            break
    if(maxx=="undefined" and minn=="undefined"):
        print("EMPTY")
    elif(maxx=="undefined" and minn!="undefined"):
        print(minn,minn)

    elif(maxx!="undefined" and minn=="undefined"):
        print(maxx,maxx)
    else:
        print(maxx,minn)

