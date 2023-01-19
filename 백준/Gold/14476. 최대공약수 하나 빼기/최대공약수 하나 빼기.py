import sys
input=sys.stdin.readline
n=int(input())
arr=list(map(int,input().split()))

lGCD=[0]*n
rGCD=[0]*n
answer=0

def gcd(a,b):
    if a>b:
        a,b=b,a
    while b!=0:
        a,b=b,a%b
    return a


for i in range(n):
    if i==0:
        lGCD[0]=arr[0]
    else:
        lGCD[i]=gcd(lGCD[i-1],arr[i])
for i in range(n-1,-1,-1):
    if i==n-1:
        rGCD[i]=arr[i]
    else:
        rGCD[i]=gcd(rGCD[i+1],arr[i])
maxx=0
idx=0
tmp=0
for i in range(n):
    if i==0:
        tmp=rGCD[i+1]
    elif i==n-1:
        tmp=lGCD[i-1]
    else:
        tmp=gcd(lGCD[i-1],rGCD[i+1])
    if maxx<tmp:
        maxx=tmp
        idx=i

if arr[idx]%maxx!=0:
    print(maxx,arr[idx])
else:
    print("-1")
