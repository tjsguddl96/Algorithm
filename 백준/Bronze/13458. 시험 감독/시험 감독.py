n=int(input())
arr=list(map(int,input().split()))
a,b=map(int,input().split())

answer=0
for i in range(len(arr)):
    arr[i]-=a
    answer+=1
    if arr[i]>0:
        if arr[i]%b!=0:
            answer+=(arr[i]//b)+1
        else:
            answer+=(arr[i]//b)
print(answer)