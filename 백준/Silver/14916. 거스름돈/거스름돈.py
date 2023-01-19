n=int(input())

answer=99999999

if n%5==0:
    answer=min(answer,n//5)

if n%2==0:
    answer=min(answer,n//2)

if n>=5 and n%5%2==0:
    answer=min(answer,n//5+n%5//2)
cnt=0

while n>=0:
    n-=5
    cnt+=1
    if n>=0 and n%2==0:
        answer=min(answer,cnt+(n//2))

if answer==99999999:
    print(-1)
else:
    print(answer)
