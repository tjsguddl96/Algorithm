from sys import stdin
import math

n=int(stdin.readline())
arr=list(map(int,stdin.readline().split()))
v=int(stdin.readline())
ans=0
for num in arr:
    if(num==v):
        ans+=1
print(ans)