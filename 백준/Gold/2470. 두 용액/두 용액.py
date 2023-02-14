from sys import stdin

n=int(stdin.readline())
arr=list(map(int,stdin.readline().split()))

arr.sort()
left=0
right=len(arr)-1
ans=[0,0]
ans[0]=arr[left]
ans[1]=arr[right]
answer=999999999999
while(left<right):
    tmp=arr[left]+arr[right]
    if (abs(tmp)<answer):
        ans[0]=arr[left]
        ans[1]=arr[right]
        answer=abs(tmp)
      
    if(tmp<0):
        left+=1
    elif(tmp>0):
        right-=1
    else:
        break

ans.sort()
print(ans[0],ans[1],sep=" ")