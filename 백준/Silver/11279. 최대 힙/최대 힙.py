from sys import stdin
import heapq

n=int(stdin.readline())
arr=[]
for i in range(n):
    x=int(stdin.readline())
    if (x!=0):
        heapq.heappush(arr,-x)
    else:
        if (len(arr)==0):
            print(0)
        else:
            print(-(heapq.heappop(arr)))