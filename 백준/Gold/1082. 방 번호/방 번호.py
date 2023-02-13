from sys import stdin

n=int(stdin.readline())
arr=list(map(int,stdin.readline().split()))

m=int(stdin.readline())

money=[0]*(m+1)
for i in range(n):
    if arr[i]>m:
        continue
    money[arr[i]]=i

for i in range(1,m+1):
    for j in range(len(arr)):
        if (i-arr[j]<0):
            continue
        money[i]=max(int(str(money[i-arr[j]])+str(money[arr[j]])),money[i])
print(max(money))