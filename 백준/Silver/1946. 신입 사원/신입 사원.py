t=int(input())


for tc in range(t):
    n=int(input())
    ans=1
    arr=[]
    for i in range(n):
        paper,meeting=map(int,input().split())
        arr.append((meeting,paper))  #서류,면접,인덱스 순
    arr.sort(key=lambda x:x[1])

    minn=arr[0][0]
    for i in range(1,n):
        if arr[i][0]<minn:
            ans+=1
            minn=arr[i][0]
    print(ans)
