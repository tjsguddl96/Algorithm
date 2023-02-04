from sys import stdin

t=int(stdin.readline())
answer=[]
for tc in range(1,t+1):
    aS,bS=map(int,stdin.readline().split())

    a=list(map(int,stdin.readline().split()))
    b=list(map(int,stdin.readline().split()))

    #a=list(a)
    #b=list(b)
    a.sort()
    b.sort()
    ans=0

    for A in a:
        right = len(b)-1
        left = 0
        tmp=0
        if b[0]>=A:
            continue
        while(left<=right):
            mid=(right+left)//2
            if b[mid]>=A:
                right=mid-1
            else:
                left=mid+1
                tmp=mid

        tmp+=1
        ans+=tmp
    answer.append(ans)
for answe in answer:
    print(answe)