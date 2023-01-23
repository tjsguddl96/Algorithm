from sys import stdin
n=int(stdin.readline())

arr=[]

for i in range(n):
    st,end=map(int,stdin.readline().split())
    arr.append((st,end))
arr.sort(key=lambda x:(x[1],x[0]))

now=arr[0][1]
ans=1
for i in range(1,n):
    if arr[i][0]>=now:
        ans+=1
        now=arr[i][1]
print(ans)