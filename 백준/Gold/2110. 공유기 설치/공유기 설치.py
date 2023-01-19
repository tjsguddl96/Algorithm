import sys
n,c=map(int,input().split())
arr=[]
for i in range(n):
    arr.append(int(sys.stdin.readline()))
arr.sort()
left=0
right=arr[len(arr)-1]-arr[0]
mid=0
answer=0
while(left<=right):
    mid=(left+right)//2
    ch=arr[0]
    tmp=1
    for x in range(1,len(arr)):
        if mid<=arr[x]-ch:
            ch=arr[x]
            tmp+=1
        if tmp>=c:
            break
    if tmp<c:
        right=mid-1
    else:
        answer=mid
        left=mid+1
print(answer)
